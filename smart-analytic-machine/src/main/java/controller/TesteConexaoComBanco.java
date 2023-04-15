/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.github.britooo.looca.api.core.Looca;
import model.LeituraModel;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author BELLA
 */
public class TesteConexaoComBanco {

    public static void main(String[] args) {
        
        Looca looca = new Looca();

        ConexaoComBanco conexao = new ConexaoComBanco();

        JdbcTemplate con = conexao.getConexaoComBanco();

        LeituraModel leitura = new LeituraModel();
        
        //inserindo a leitura a memoria em uso do looca
        leitura.setLeitura(looca.getMemoria().getEmUso().doubleValue());
        
        con.update("insert into tbLeitura values (?)",leitura.getLeitura());

    }
}
