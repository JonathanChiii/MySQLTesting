package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DBLogic {
    static Connection conn = null;
    public static Connection getConnection(){
        // 1. Load driver
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 2. Open the connection
        String url = "jdbc:mysql://localhost:3306/batch63";
        String userName = "root";
        String password = "0000";

        try{
            conn = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e){
            e.printStackTrace();
        }

        return conn;
    }
}
