package com.kitri.springbasicboot.lesson.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;


@Slf4j
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("log message : init()");
    }

    @Override
    public void destroy() {
        log.info("log message : destroy()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("log message : doFilter()");
        chain.doFilter(request,response);
    }
}
