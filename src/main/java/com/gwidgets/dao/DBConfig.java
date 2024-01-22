package com.gwidgets.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {

    private Connection connection;

    public static Connection getConnection() throws ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = null;
        try {
            String DB_URL = "jdbc:mysql://localhost:3306/spring";
            String USER = "root";
            String PASS = "Naveen@10";
            con = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}