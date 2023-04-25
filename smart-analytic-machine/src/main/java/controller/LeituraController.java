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

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

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

                System.out.println("Processador em uso: " + leituraModel.getLeitura());

                //---------------------------------------------------------------------------//
                // leitura rede
                System.out.println("----------Rede----------");

                System.out.println("Interfaces da rede: " + looca.getRede().getGrupoDeInterfaces().getInterfaces());
                System.out.println("HostName: " + looca.getRede().getParametros().getHostName());

                //---------------------------------------------------------------------------//
                //inserindo leitura de disco
                System.out.println("----------Disco----------");

                //Tamanho total disco
                leituraModel.setLeitura(looca.getGrupoDeDiscos().getTamanhoTotal().doubleValue());
                con.update("insert into tbLeitura values (?, ? ,?)",
                        null, leituraModel.getLeitura(), leituraModel.getDataHoraLeitura());
                System.out.println("Tamanho total do disco: " + leituraModel.getLeitura());
                //---------------------------------------------------------------------------//

                // Listagem de Hardware
                System.out.println("\n\nListagem de hardware:");

                System.out.println("------------------Memória---------------------------");
                System.out.println("Memória total: " + looca.getMemoria().getTotal());

                System.out.println("------------------Processador---------------------------");
                System.out.println("Número de cpus Físicas: " + looca.getProcessador().getNumeroCpusFisicas());
                System.out.println("Número de cpus Lógicas: " + looca.getProcessador().getNumeroCpusLogicas());

                System.out.println("------------------Disco---------------------------");
                System.out.println("Discos: " + looca.getGrupoDeDiscos().getDiscos());
                System.out.println("Quantidade de discos: " + looca.getGrupoDeDiscos().getQuantidadeDeDiscos());

                System.out.println("------------------Rede---------------------------");
                System.out.println("Paramêtros da rede: " + looca.getRede().getParametros());

                System.out.println("---------------------Sistema Operacional------------------------");
                System.out.println("Sistema Operacional: " + looca.getSistema().getSistemaOperacional());
                System.out.println("Arquitetura do sistema operacional: " + looca.getSistema().getArquitetura());

                //---------------------------------------------------------------------------//
                System.out.println("-----------------Janelas----------------------------");
                System.out.println("Total de janelas visíveis: " + looca.getGrupoDeJanelas().getTotalJanelasVisiveis());

                System.out.println("------------------Serviços---------------------------");
                System.out.println("Serviços ativos: " + looca.getGrupoDeServicos().getServicosAtivos());
                
                System.out.println("---------------------Listagem de Processos------------------------");
                System.out.println("Processsos: " + looca.getGrupoDeProcessos().getProcessos());
                //---------------------------------------------------------------------------//
            }
        }, 0, 10000);

    }
}
