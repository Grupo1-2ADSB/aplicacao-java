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
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
;
import model.LeituraModel;
import org.springframework.jdbc.core.JdbcTemplate;
import model.LeituraModel;
import org.springframework.jdbc.core.JdbcTemplate;
import model.LeituraModel;
import org.springframework.jdbc.core.JdbcTemplate;
import model.LeituraModel;
import org.springframework.jdbc.core.JdbcTemplate;
import model.LeituraModel;
import org.springframework.jdbc.core.JdbcTemplate;
import model.LeituraModel;
import org.springframework.jdbc.core.JdbcTemplate;
import model.LeituraModel;
import org.springframework.jdbc.core.JdbcTemplate;
import model.LeituraModel;
import org.springframework.jdbc.core.JdbcTemplate;
import model.LeituraModel;
import org.springframework.jdbc.core.JdbcTemplate;
import model.LeituraModel;
import org.springframework.jdbc.core.JdbcTemplate;
import model.LeituraModel;
import org.springframework.jdbc.core.JdbcTemplate;
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

        //inserindo leitura de rede
        
        System.out.println("----------Rede----------");
        System.out.println(looca.getRede().getGrupoDeInterfaces().getInterfaces());
        System.out.println(looca.getRede().getParametros().getHostName());

        //inserindo leitura de disco
        System.out.println("----------Disco----------");
        System.out.println(looca.getGrupoDeDiscos().getDiscos());
        System.out.println(looca.getGrupoDeDiscos().getQuantidadeDeDiscos());
        //System.out.println("----------fim disco-------");

        Double[] teste = new Double[8];
        List<Double> teste0 = new ArrayList<>();
        List<Double> teste1 = new ArrayList<>();
        List<Double> teste2 = new ArrayList<>();
        List<Double> teste3 = new ArrayList<>();
        List<Double> teste4 = new ArrayList<>();
        List<Double> teste5 = new ArrayList<>();
        List<Double> teste6 = new ArrayList<>();
        List<Double> teste7 = new ArrayList<>();

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Double teste55 = looca.getProcessador().getUso();
                Integer teste25 = Integer.valueOf(teste55.toString().substring(0, 1));

                System.out.println(teste25.TYPE);

                switch (teste25) {
                    case 0:
                        teste0.add(Double.valueOf(teste25));
                        break;
                    case 1:
                        teste1.add(Double.valueOf(teste25));
                        break;
                    case 2:
                        teste2.add(Double.valueOf(teste25));
                        break;
                    case 3:
                        teste3.add(Double.valueOf(teste25));
                        break;
                    case 4:
                        teste4.add(Double.valueOf(teste25));
                        break;
                    case 5:
                        teste5.add(Double.valueOf(teste25));
                        break;
                    case 6:
                        teste6.add(Double.valueOf(teste25));
                        break;
                    case 7:
                        teste7.add(Double.valueOf(teste25));
                        break;
                    default:
                        throw new AssertionError();
                }

                System.out.println(teste0);
                System.out.println(teste1);
                System.out.println(teste2);
                System.out.println(teste3);
                System.out.println(teste4);
                System.out.println(teste5);
                System.out.println(teste6);
                System.out.println(teste7);
            }
        }, 0, 1000);
    }
}
