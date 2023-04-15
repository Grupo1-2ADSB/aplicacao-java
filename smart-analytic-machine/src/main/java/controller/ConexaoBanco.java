/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Leo
 */
public class ConexaoBanco {

    private JdbcTemplate connection;

    public ConexaoBanco() {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource​.setDriverClassName("com.mysql.cj.jdbc.Driver");

        dataSource​.setUrl("jdbc:mysql://localhost:3306/sam?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        
        dataSource​.setUsername("teste");

        dataSource​.setPassword("teste123");

        this.connection = new JdbcTemplate(dataSource);

    }

    public JdbcTemplate getConnection() {
        return connection;
    }

}
