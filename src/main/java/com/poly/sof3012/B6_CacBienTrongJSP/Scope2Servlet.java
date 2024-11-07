package com.poly.sof3012.B6_CacBienTrongJSP;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Scope2Servlet", value = "/Scope2Servlet")
public class Scope2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = getServletContext();
        String a = (String) application.getAttribute("a");
        request.setAttribute("a1",a);
        request.getRequestDispatcher("/view/buoi6/demo2.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
