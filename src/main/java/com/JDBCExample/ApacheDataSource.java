package com.JDBCExample;

import org.apache.commons.dbcp2.BasicDataSource;

public class ApacheDataSource {

    private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/proselyte_developers_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "dingo1975";
    private static final int CONN_POOL_SIZE = 5;

    private final BasicDataSource bds = new BasicDataSource();

    public ApacheDataSource() {
        bds.setDriverClassName(DRIVER_CLASS_NAME);
        bds.setUrl(DB_URL);
        bds.setUsername(DB_USER);
        bds.setPassword(DB_PASSWORD);
        //Set the connection pool size
        bds.setInitialSize(CONN_POOL_SIZE);
    }
    private static class DataSourceHolder {
        private static final ApacheDataSource INSTANCE = new ApacheDataSource();
    }

    public static ApacheDataSource getInstance() {
        return DataSourceHolder.INSTANCE;
    }

    public BasicDataSource getBds() {
        return bds;
    }

}
