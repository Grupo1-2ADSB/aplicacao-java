/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.github.britooo.looca.api.core.Looca;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author BELLA
 */
public class MonitoramentoMaquinaConexao {
    
    Looca looca = new Looca();
    
    private JdbcTemplate conexaoDoBanco;
    
    public void PegarDadosLooca (){
    
        BasicDataSource dataSource = new BasicDataSource();
        
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        
        dataSource.setUrl("jdbc:mysql://localhost:3333/sam"); // trocar o localhost:3306 pelo endereço do banco e o tecflix pelo nome do banco
        
        dataSource.setUsername("teste"); //Usuario do banco
        
        dataSource.setPassword("teste"); //Senha do banco

        this.conexaoDoBanco = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getConexaoDoBanco() {
        return conexaoDoBanco;
    }
    
}
