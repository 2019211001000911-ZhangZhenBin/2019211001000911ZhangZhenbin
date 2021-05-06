package com.ZhangZhenbin.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "HelloFilter",urlPatterns ={"/hello"})


//T1:/hello
//T2:/*
//T3: 3 url
public class HelloFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("i am in HelloFilter-->init()");
    }

    public void destroy() {
        System.out.println("i am in HelloFilter-->destroy()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        System.out.println("i am in HelloFilter-->doFilter()-before servlet (request come here)");

        chain.doFilter(request, response);//call next filter -no-->then go to servlet

        //response come back here
        System.out.println("i am in HelloFilter-->doFilter()-after servlet (response come here)");
    }
}
