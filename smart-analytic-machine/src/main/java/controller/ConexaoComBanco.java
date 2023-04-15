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
public class ConexaoComBanco {
    
    Looca looca = new Looca();
    
    private JdbcTemplate conexaoComBanco;
    
    public void ConexaoComBanco (){
        
        BasicDataSource dataSource = new BasicDataSource();
        
         dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

         dataSource​.setUrl("jdbc:mysql://localhost:3306/sam?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
       
         dataSource.setUsername("teste"); 
      
         dataSource.setPassword("teste"); 

        this.conexaoComBanco = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getConexaoComBanco() {
        return conexaoComBanco;
    }
        
    }
        
        /*MysqlDataSource conexao = new MysqlDataSource();
        
        String driverName = "com.mysql.jdbc.Driver";

        String serverName = "localhost"; 

        String mydatabase = "sam";   
        
        String url = "jdbc:mysql://localhost/sam";

        String username = "teste";

        String password = "teste"; 

        conexao = DriverManager.getConnection(url, username, password);

        this.conexaoComBanco = new JdbcTemplate(conexao);
    }

    public JdbcTemplate getConexaoComBanco() {
        return conexaoComBanco;
    }*/
    

