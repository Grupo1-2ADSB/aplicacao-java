/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

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
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.util.Conversor;
import static com.github.britooo.looca.api.util.Conversor.formatarBytes;
import java.util.ArrayList;
import java.util.List;
import model.LeituraModel;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author BELLA
 */
public class TesteConexaoComBanco {

    public static void main(String[] args) {
       
        //Instanciando conexao Banco
        ConexaoBanco conexao = new ConexaoBanco();
        JdbcTemplate con = conexao.getConnection();
        
        // Instanciando Looca + Classes monitoradas
        Looca looca = new Looca();
        Conversor cnvs = new Conversor();
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
        LeituraModel leitura = new LeituraModel();
 
        //inserindo a leitura a memoria em uso do looca
        leitura.setLeitura(looca.getProcessador().getUso().doubleValue());
        con.update("insert into tbLeitura values (?, ?)", null, memoria.getTotal());

        System.out.println("Memoria");
        System.out.println("-------------------------------------------------------------------");
        System.out.println(formatarBytes(memoria.getDisponivel()));
        System.out.println(memoria.getEmUso());
        System.out.println(memoria.getTotal());
        System.out.println("-------------------------------------------------------------------");
    }
}
