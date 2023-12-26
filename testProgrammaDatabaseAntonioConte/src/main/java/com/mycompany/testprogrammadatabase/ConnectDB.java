package com.mycompany.testprogrammadatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Errore durante il caricamento del driver Oracle JDBC", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        Config appConfig = new Config();

        String jdbcUrl = appConfig.getProperty("db.url");
        String username = appConfig.getProperty("db.user");
        String password = appConfig.getProperty("db.password");

        return DriverManager.getConnection(jdbcUrl, username, password);
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
