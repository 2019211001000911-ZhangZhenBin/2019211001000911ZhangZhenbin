package com.ZhangZhenbin.Week3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get parameter from request
        String Username = request.getParameter("username");//name of input
        String Password = request.getParameter("password");//
        String Email = request.getParameter("email");//
        String Gander = request.getParameter("gander");//
        String Birthdate = request.getParameter("birthdate");//

        //response
        PrintWriter writer = response.getWriter();
        writer.println("<br>Username :"+Username);
        writer.println("<br>Password :"+Password);
        writer.println("<br>Email :"+Email);
        writer.println("<br>Gander :"+Gander);
        writer.println("<br>Birthdate :"+Birthdate);
        writer.close();
        }
}
