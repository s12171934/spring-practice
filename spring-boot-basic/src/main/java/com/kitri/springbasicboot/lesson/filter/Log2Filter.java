package com.kitri.springbasicboot.lesson.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;


@Slf4j
public class Log2Filter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("log message : init()");
    }

    @Override
    public void destroy() {
        log.info("log message : de     stroy()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("log message : do2Filter()");
        chain.doFilter(request,response);
    }
}
