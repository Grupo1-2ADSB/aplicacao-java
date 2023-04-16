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
;
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

        //inserindo a leitura a memoria em uso do looca
        leituraModel.setLeitura(looca.getMemoria().getEmUso().doubleValue());

        con.update("insert into tbLeitura values (?, ? ,?)",
                null, leituraModel.getLeitura(), leituraModel.getDataHoraLeitura());

        System.out.println("----------Memoria----------");
        System.out.println(leituraModel.getLeitura());
        
        
        //inserindo a leitura processador
        leituraModel.setLeitura(looca.getProcessador().getFrequencia().doubleValue());

        con.update("insert into tbLeitura values (?, ? ,?)",
                null, leituraModel.getLeitura(), leituraModel.getDataHoraLeitura());

        System.out.println("----------Processador----------");
        System.out.println(leituraModel.getLeitura());
        
       
    }
}
