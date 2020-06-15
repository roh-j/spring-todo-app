package com.example.demo;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/mydb?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PW = "root";

    @Test
    public void ConnectionTest() throws Exception {
        Class.forName(DRIVER);
        try (Connection conn = DriverManager.getConnection(URL, USER, PW)) {
            System.out.println(conn);
        }
    }
}