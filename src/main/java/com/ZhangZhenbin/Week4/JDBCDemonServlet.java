package com.ZhangZhenbin.Week4;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

// Try to use @Webservlet
@WebServlet(
        urlPatterns={"/jdbc"},
        initParams= {
                @WebInitParam(name = "driver", value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name = "url", value = "jdbc:sqlserver://localhost;databaseName=userdb"),
                @WebInitParam(name = "username", value = "sa"),
                @WebInitParam(name = "password", value = "123456789")
        },loadOnStartup = 1
)


public class JDBCDemonServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {

        /*

        //one time but not easy to change the information like password --> bad

        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://localhost;databaseName=userdb";
        String username="sa";
        String password="123456789";
         */
        
        ServletConfig config=getServletConfig();
        String driver = config.getInitParameter("driver");
        String url = config.getInitParameter("url");
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");

        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con);//ok--ok--ok
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //many times --> bad

        System.out.println("I am in doGet()");
        String sql="select * from usertable";
        try {
            ResultSet re = con.createStatement().executeQuery(sql);
            while(re.next()){



            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy(){
        super.destroy();
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
