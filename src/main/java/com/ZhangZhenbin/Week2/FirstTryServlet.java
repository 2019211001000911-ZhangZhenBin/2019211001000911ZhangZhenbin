package com.ZhangZhenbin.Week2;

import java.util.Date;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class FirstTryServlet extends HttpServlet{
    public void doGet(HttpServletRequest request , HttpServletResponse response)
    throws IOException{
       PrintWriter writer = response.getWriter();
       Date date=new Date(System.currentTimeMillis());
       writer.print("Name: ZhangZhenbin\n");
       writer.print("ID: 2019211001000911\n");
       writer.print("Date and Time: "+date+"\n");

    }

    public void doPost(HttpServletRequest request , HttpServletResponse response){

    }
}
