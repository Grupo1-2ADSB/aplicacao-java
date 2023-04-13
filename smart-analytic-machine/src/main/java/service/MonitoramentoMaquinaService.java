/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author BELLA
 */
public class MonitoramentoMaquinaService {

    Looca looca = new Looca();

    /* o que o looca pega
    
       Sistema sistema;
       Memoria memoria;
       Processador processador;
       Temperatura temperatura;
       DiscoGrupo grupoDeDiscos;
       ServicoGrupo grupoDeServicos;
       ProcessoGrupo grupoDeProcessos;*/
    
    
    public void inserirDadosLeitura() {

        JdbcTemplate conexao = new JdbcTemplate();

        /*conexao.update(
                "insert into leitura values (?,?,?)",
                //dados , fk Config , fk Alerta             
                       
        );*/
    }

}
