package com.MyVideoStore.Services;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class ConnectionManager implements DisposableBean {

    // change to your user, if necessary
    private static final String DEFAULT_USER = "joaoabaptista";

    // change to your password, if necessary
    private static final String DEFAULT_PASS = "qwerty";

    private static final String DEFAULT_HOST = "localhost";

    // change to the name of your database, if necessary
    private static final String DEFAULT_DB = "my_videostore";

    private static final String DEFAULT_PORT = "5432";

    private static final String CONNECTOR = "jdbc:postgresql:";

    private String dbUrl;
    private String user;
    private String pass;
    private Connection connection;

    public ConnectionManager(String user, String pass, String host, String port, String database) {
        this.user = user;
        this.pass = pass;
        this.dbUrl = CONNECTOR + "//" + host + ":" + port + "/" + database;
    }

    public ConnectionManager() {
        this(DEFAULT_USER, DEFAULT_PASS, DEFAULT_HOST, DEFAULT_PORT, DEFAULT_DB);
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(dbUrl, user, pass);
            }
        } catch (SQLException ex) {
            System.err.println("Failure to connect to database: " + ex.getMessage());
            throw new RuntimeException("Failed to establish a connection with the database", ex);
        }

        if (connection == null) {
            throw new RuntimeException("Database connection is null.");
        }

        return connection;
    }


    public void close() {
        try {

            if (connection != null) {
                connection.close();
            }

        } catch (SQLException ex) {
            System.out.println("Failure to close database connections: " + ex.getMessage());
        }
    }

    // Closes the connection with the database after the application un-deploys
    @Override
    public void destroy() throws Exception {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}