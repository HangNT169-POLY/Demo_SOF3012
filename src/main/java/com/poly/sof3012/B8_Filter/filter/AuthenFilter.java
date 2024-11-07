package com.poly.sof3012.B8_Filter.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author hangnt169
 */
//@WebFilter(filterName = "AuthenFilter", value =
//        {"/sinh-vien/hien-thi","/sinh-vien/view-add"
//        })
@WebFilter({"/product/*", "/CategoryServlet", "/category/*"})
public class AuthenFilter implements Filter {

    // Khoi tao => Chay 1 lan duy nhat khi chuong trinh bat dau restart
    public void init(FilterConfig config) throws ServletException {
        Filter.super.init(config);
        System.out.println("Khi init");
    }

    // Khi chuong trinh ket thuc => Goi 1 lan duy nhat
    public void destroy() {
        Filter.super.destroy();
        System.out.println("Khi destroy ");
    }

    // Moi request gui den deu chay vao do filter => xuat hien nhieu lan
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("Do Filter Before ");
        // B1: Ep kieu
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession httpSession = req.getSession();
        String name = (String) httpSession.getAttribute("uname");
        String role = (String) httpSession.getAttribute("role");
        String requestURI = req.getRequestURI();

        if (name == null) {
            // Khi filter that  bai
            res.sendRedirect("/Login14Servlet");
        } else {
            if ("admin".equalsIgnoreCase(role)) {
                // Admin có quyền truy cập tất cả các trang
                chain.doFilter(request, response);
            } else if ("user".equalsIgnoreCase(role)) {
                // User chỉ có quyền truy cập vào các trang liên quan đến sản phẩm
                if (requestURI.startsWith("/product/")) {
                    chain.doFilter(request, response);
                } else {
                    // User không có quyền truy cập vào trang này
                    res.sendRedirect("/noPermission.jsp"); // Chuyển hướng đến trang không có quyền
                }
            } else {
                // Vai trò không hợp lệ
                res.sendRedirect("/Login14Servlet");
            }
        }
        System.out.println("Do Filter After ");
    }
}
