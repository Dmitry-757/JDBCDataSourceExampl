package com.JDBCExample;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class MySQLDataSource {
    private final String username = "root";
    private final String password = "dingo1975";
//    private final String server = "localhost";
//    private final int port = 3306;
//    private final String dbName = "proselyte_developers_db";
    private final String URL = "jdbc:mysql://localhost:3306/proselyte_developers_db";
    //для подключения  mySQL версии выше 8.0 используем драйвер "com.mysql.cj.jdbc.Driver", а ниже "com.mysql.jdbc.Driver"
//    private final String driver = "com.mysql.cj.jdbc.Driver";
    private Connection connection = null;

    MysqlDataSource ds = new MysqlDataSource();

    public MySQLDataSource() {
        try {
//            ds.setServerName(server);
//            ds.setPortNumber(port);
//            ds.setDatabaseName(dbName);
            ds.setURL(URL);
            ds.setUser(username);
            ds.setPassword(password);
            connection = ds.getConnection();
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public Connection getConnection(){
        return this.connection;
    }
}
