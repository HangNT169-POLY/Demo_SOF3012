package com.poly.sof3012.B6_CacBienTrongJSP;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.nio.file.Files;

@WebServlet(name = "PageScopeExampleServlet", value = "/PageScopeExampleServlet")
public class PageScopeExampleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//// Lưu trữ dữ liệu vào Page Scope
//        pageContext.setAttribute("username", "john_doe");
//
//        // Chuyển hướng đến trang JSP
//        request.getRequestDispatcher("/pageScope.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
