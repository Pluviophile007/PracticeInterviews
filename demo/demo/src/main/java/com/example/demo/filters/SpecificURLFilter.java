package com.example.demo.filters;

import jakarta.servlet.*;

import java.io.IOException;

public class SpecificURLFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Specific URL Filter Working");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
