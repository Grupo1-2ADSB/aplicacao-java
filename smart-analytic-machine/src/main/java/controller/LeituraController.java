/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.github.britooo.looca.api.core.Looca;
import service.ConexaoBancoService;
import java.time.LocalDateTime;
import com.github.britooo.looca.api.util.Conversor;
import static com.github.britooo.looca.api.util.Conversor.formatarBytes;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.rede.Rede;
import com.github.britooo.looca.api.group.servicos.Servico;
import com.github.britooo.looca.api.group.servicos.ServicoGrupo;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import model.LeituraModel;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author BELLA
 */
public class LeituraController {

    public static void main(String[] args) {

        //Instanciando conexao Banco
        ConexaoBancoService conexao = new ConexaoBancoService();
        JdbcTemplate con = conexao.getConnection();

        // Instanciando Looca + Classes monitoradas
        Looca looca = new Looca();

        Conversor conversor = new Conversor();

        Sistema sistema = new Sistema();
        Memoria memoria = new Memoria();
        Processador processador = new Processador();
        ProcessoGrupo processoGrupo = new ProcessoGrupo();
        Temperatura temperatura = new Temperatura();
        List<Disco> listaDisco = new ArrayList();
        DiscoGrupo discoGrupo = new DiscoGrupo();
        List<Rede> rede = new ArrayList();
        List<ServicoGrupo> redeInterface = new ArrayList();
        List<Servico> servico = new ArrayList();

        // Instanciando Model de leitura - dados que vêm do looca
        LeituraModel leituraModel = new LeituraModel();

        //data e hora 
        leituraModel.setDataHoraLeitura(LocalDateTime.now());

        //inserindo a leitura da memoria em uso do looca
        System.out.println("----------Memoria----------");

        //Uso memória
        leituraModel.setLeitura(looca.getMemoria().getEmUso().doubleValue());
        con.update("insert into tbLeitura values (?, ? ,?)",
                null, leituraModel.getLeitura(), leituraModel.getDataHoraLeitura());

        System.out.println("Memória em uso: " + leituraModel.getLeitura());
        
        //Memória disponível
        leituraModel.setLeitura(looca.getMemoria().getDisponivel().doubleValue());
        con.update("insert into tbLeitura values (?, ? ,?)",
                null, leituraModel.getLeitura(), leituraModel.getDataHoraLeitura());

        System.out.println("Memória Disponível: " + leituraModel.getLeitura());
        
        //Memória total
        leituraModel.setLeitura(looca.getMemoria().getTotal().doubleValue());
        con.update("insert into tbLeitura values (?, ? ,?)",
                null, leituraModel.getLeitura(), leituraModel.getDataHoraLeitura());

        System.out.println("Memória Total: " + leituraModel.getLeitura());
        //---------------------------------------------------------------------------//
        //inserindo a leitura processador
        System.out.println("----------Processador----------");

        //Frequência processador
        leituraModel.setLeitura(looca.getProcessador().getFrequencia().doubleValue());
        con.update("insert into tbLeitura values (?, ? ,?)",
                null, leituraModel.getLeitura(), leituraModel.getDataHoraLeitura());
        System.out.println("Frequência do processador: " + leituraModel.getLeitura());

        //Uso processador
        leituraModel.setLeitura(looca.getProcessador().getUso().doubleValue());
        con.update("insert into tbLeitura values (?, ? ,?)",
                null, leituraModel.getLeitura(), leituraModel.getDataHoraLeitura());
        System.out.println("Processador em uso" + leituraModel.getLeitura());
        
        //---------------------------------------------------------------------------//
        // leitura rede
        System.out.println("----------Rede----------");

        System.out.println(looca.getRede().getGrupoDeInterfaces().getInterfaces());
        System.out.println(looca.getRede().getParametros().getHostName());

        //---------------------------------------------------------------------------//
        //inserindo leitura de disco
        System.out.println("----------Disco----------");

        //Tamanho total disco
        leituraModel.setLeitura(looca.getGrupoDeDiscos().getTamanhoTotal().doubleValue());
        con.update("insert into tbLeitura values (?, ? ,?)",
                null, leituraModel.getLeitura(), leituraModel.getDataHoraLeitura());
        System.out.println("Tamanho total do disco: " + looca.getGrupoDeDiscos().getTamanhoTotal());
        //---------------------------------------------------------------------------//
        

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

            }
        }, 0, 1000);
    }
}
