package com.JDBCExample;


import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        DatabaseMetaData meta;

        MySQLDataSource myDataSource = new MySQLDataSource();
        Connection connection = myDataSource.getConnection();
        // Getting database info
        try {
            meta = connection.getMetaData();
            System.out.println("Server name: "
                    + meta.getDatabaseProductName());
            System.out.println("Server version: "
                    + meta.getDatabaseProductVersion());
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Exception: " + e.getMessage());
                }
            }
        }
        System.out.println();
        System.out.println("*******************");

        //*** example of using Apache dataSource using ***
////        PreparedStatement statement = null;
//        ResultSet resultSet = null;
        try {
            BasicDataSource bds = ApacheDataSource.getInstance().getBds();
            connection = bds.getConnection();

            meta = connection.getMetaData();
            System.out.println("Server name: "
                    + meta.getDatabaseProductName());
            System.out.println("Server version: "
                    + meta.getDatabaseProductVersion());

        }catch (SQLException e){
            System.err.println("Exception: " + e.getMessage());
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Exception: " + e.getMessage());
                }
            }
        }
    }
}
