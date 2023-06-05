package br.com.sistemacontrolejsp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private ConnectionFactory(){}

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistema_autorizacao", "postgres", "123");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
