package com.example.demo.filters;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.LogRecord;

@Component
public class RequestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    System.out.println("RequestFilter Working");
    filterChain.doFilter(servletRequest,servletResponse);
    }
}
