/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import service.ConexaoBancoLocal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import model.UsuarioModel;
import model.LeituraModel;
import model.LeituraUsuario;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import service.ConexaoBancoNuvem;

/**
 *
 * @author BELLA
 */
public class Controller {

    //Instanciando conexao Banco Local
    ConexaoBancoLocal connectionLocal = new ConexaoBancoLocal();
    JdbcTemplate con = connectionLocal.getConnection();

    //Instanciando conexao Banco
    ConexaoBancoNuvem connectionNuvem = new ConexaoBancoNuvem();
    JdbcTemplate conNuvem = connectionNuvem.getConnection();

    // Instanciando Looca + Classes monitoradas
    Looca looca = new Looca();

    // Instanciando Model de leitura - dados que vêm do looca
    LeituraModel leituraModel = new LeituraModel();

    //Grupo de discos
    List<Volume> listaDiscos = new ArrayList(looca.getGrupoDeDiscos().getVolumes());

    //Grupo de redes internet e wi-fi
    List<RedeInterface> listaRedes = new ArrayList(looca.getRede().getGrupoDeInterfaces().getInterfaces());

    public List<UsuarioModel> selectDadosUsuario(String usuario, String senha) {

        List<UsuarioModel> listaUsuario = new ArrayList();

        listaUsuario = con.query("SELECT * FROM tbUsuario WHERE nomeUsuario = ? AND senhaUsuario = ?",
                new BeanPropertyRowMapper(UsuarioModel.class), usuario, senha);

        return listaUsuario;
    }

    public List<UsuarioModel> selectDadosUsuarioNuvem(String usuario, String senha) {

        List<UsuarioModel> listaUsuarioNuvem = new ArrayList();

        listaUsuarioNuvem = conNuvem.query("SELECT * FROM tbUsuario WHERE nomeUsuario = ? AND senhaUsuario = ?",
                new BeanPropertyRowMapper(UsuarioModel.class), usuario, senha);

        return listaUsuarioNuvem;
    }

    /*-----------------------------------------------------------------------------------*/
    public List<LeituraUsuario> selectLeituraUsuario(String usuario, String senha) {

        List<LeituraUsuario> listaLeituraUsuario = new ArrayList();

        listaLeituraUsuario = con.query("select idLeitura , fkConfig, fkAlertaComponente , c.fkMaquina, fkComponente , nSerie ,  nomeUsuario from tbLeitura as l"
                + " join tbConfig as c on l.fkConfig = c.idConfig join tbMaquina as m on m.idMaquina = c.fkMaquina "
                + "join tbUsuario as u on u.fkMaquina = m.idMaquina where nomeUsuario = ? and senhaUsuario = ? order by idLeitura desc limit 1 ;",
                new BeanPropertyRowMapper(LeituraUsuario.class), usuario, senha);

        return listaLeituraUsuario;
    }

    public List<LeituraUsuario> selectLeituraUsuarioNuvem(String usuario, String senha) {

        List<LeituraUsuario> listaLeituraUsuarioNuvem = new ArrayList();

        listaLeituraUsuarioNuvem = conNuvem.query(
                "select top 1 idLeitura, fkConfig, fkAlertaComponente ,c.fkMaquina, fkComponente ,nSerie , nomeUsuario"
                + " from tbLeitura as l join tbConfig as c on l.fkConfig = c.idConfig join tbMaquina as m on m.idMaquina = c.fkMaquina join tbUsuario as u on u.fkMaquina = m.idMaquina where nomeUsuario = ? and senhaUsuario = ? order by idLeitura desc ;",
                new BeanPropertyRowMapper(LeituraUsuario.class), usuario, senha);

        return listaLeituraUsuarioNuvem;
    }

    /*----------------------------------------------------------------------------*/
    public void insertTbLeituraLocal(Integer fkConfig, Integer fkAlertaComponente) {

        con.update("insert into tbLeitura values (?, ? ,? , ?, ?)",
                null, leituraModel.getLeitura(), leituraModel.getDataHoraLeitura(),
                fkConfig, fkAlertaComponente);
    }

    public void insertTbLeituraNuvem(Integer fkConfig, Integer fkAlertaComponente) {

        conNuvem.update("insert into tbLeitura(leitura, dataHoraLeitura , fkConfig, fkAlertaComponente) values (? ,? , ?, ?)",
                leituraModel.getLeitura(), leituraModel.getDataHoraLeitura(),
                fkConfig, fkAlertaComponente);
    }

    /*--------------------------------------------------------------------------------*/
    public void inserirNoBanco(Integer fkConfig, Integer fkAlertaComponente) {

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                //data e hora 
                leituraModel.setDataHoraLeitura(LocalDateTime.now());

                //Uso memória
                leituraModel.setLeitura(looca.getMemoria().getEmUso().doubleValue());

                System.out.println("Memória em uso: " + leituraModel.getLeitura());

                insertTbLeituraLocal(fkConfig, fkAlertaComponente);
                insertTbLeituraNuvem(fkConfig, fkAlertaComponente);

                //---------------------------------------------------------------------------//
                //Discos em uso
                for (Volume disco : listaDiscos) {

                    leituraModel.setLeitura(disco.getTotal().doubleValue()
                            - disco.getDisponivel().doubleValue());

                    System.out.println("Em uso do disco " + disco.getNome() + " "
                            + leituraModel.getLeitura());

                    insertTbLeituraLocal(fkConfig, fkAlertaComponente);
                    insertTbLeituraNuvem(fkConfig, fkAlertaComponente);

                }

                //Redes em uso internet e wi-fi
                for (int i = 4; i > 2; i--) {

                    leituraModel.setLeitura(listaRedes.get(i).getBytesRecebidos().doubleValue());

                    System.out.println("Em uso da rede: " + listaRedes.get(i).getNome() + " : "
                            + leituraModel.getLeitura());

                    insertTbLeituraLocal(fkConfig, fkAlertaComponente);
                    insertTbLeituraNuvem(fkConfig, fkAlertaComponente);

                }

                //---------------------------------------------------------------------------//
                //Uso processador
                leituraModel.setLeitura(looca.getProcessador().getUso().doubleValue());

                System.out.println("Processador em uso: " + leituraModel.getLeitura());

                insertTbLeituraLocal(fkConfig, fkAlertaComponente);
                insertTbLeituraNuvem(fkConfig, fkAlertaComponente);
                
               

            }
        }, 0, 100000);
    }
}
