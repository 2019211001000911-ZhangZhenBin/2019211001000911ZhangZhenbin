package com.ZhangZhenbin.Week4;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {
    public static void main(String[] a) throws SQLException, ClassNotFoundException {

        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://localhost;databaseName=userdb";
        String username = "sa";
        String password = "123456789";
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println(con);
    }
}