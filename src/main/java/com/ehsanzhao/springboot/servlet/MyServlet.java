package com.ehsanzhao.springboot.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 原生Servlet
 * 需要添加注解@ServletComponentScan(basePackages = "com.ehsanzhao.springboot")
 * @WebServlet(urlPatterns = "/my")
 * 直接响应，没有spring的拦截器
 * @author zhaoyuan
 * @date 2023/2/16
 */
//@WebServlet(urlPatterns = "/my")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("666");
    }
}
