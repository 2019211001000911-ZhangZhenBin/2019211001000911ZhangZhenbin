package com.ZhangZhenbin.Week5;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Objects;

@WebServlet (name="LoginServlet" , value="/Login")

public class LoginServlet extends HttpServlet {

    Connection con = null;
    String driver;
    String url;
    String username;
    String password;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();
        driver = context.getInitParameter("driver");
        url = context.getInitParameter("url");
        username = context.getInitParameter("username");
        password = context.getInitParameter("password");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get parameter from request

        String Username = request.getParameter("username");
        String Password = request.getParameter("password");

        //response
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {

            Statement st = con.createStatement();
            String user = "select * from usertable where username=" + "'" + username + "'" + "and password='" + password + "'";
            ResultSet rs = st.executeQuery(user);
            if (rs.next()) {
                writer.println("Login Success!!!</br>");
                writer.println("Welcome" + username);
            } else {
                writer.println("Username or Password error");
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}