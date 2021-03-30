package com.ZhangZhenbin.Week4;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(
        urlPatterns = {"/Config"},
        initParams = {
                @WebInitParam(name = "Name",value = "ZhangZhenbin"),
                @WebInitParam(name = "ID",value = "2019211001000911"),
        },loadOnStartup = 1
)


public class ConfigDemonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        String Name = config.getInitParameter("Name");
        String ID = config.getInitParameter("ID");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println("Name : "+Name+"<br>");
        writer.println("ID : "+ID+"<br>");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}