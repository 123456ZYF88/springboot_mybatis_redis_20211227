package com.aaa.sbm.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ fileName:CharEncodingFilter
 * @ description:
 * @ author:zhz
 * @ createTime:2021/12/14 11:13
 * @ version:1.0.0
 */
//@WebFilter
public class CharEncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }
}
