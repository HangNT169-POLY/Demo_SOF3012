package com.poly.sof3012.B8_Filter.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "Login14Servlet", value = "/Login14Servlet")
public class Login14Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/buoi8/dang-nhap14.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check dang nhap => Dang nhap thanh cong => ket qua.jsp
        // Fail => quay lai man hinh dang nhap
        // PhongTT35, 123456
        //  B1: Lấy dữ liệu từ form
        String user = request.getParameter("uname");
        String pass = request.getParameter("psw");
        //check dang nhap
        if ((user.equalsIgnoreCase("PhongTT35") && pass.equals("123456"))
                ||
                (user.equalsIgnoreCase("HangNT169") && pass.equals("123456")
                )) {
            //dang nhap thanh cong
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("uname", user);
            if (user.equalsIgnoreCase("PhongTT35")) {
                httpSession.setAttribute("role", "User");
            } else {
                httpSession.setAttribute("role", "Admin");
            }
            request.getRequestDispatcher("/view/buoi8/ket-qua.jsp").forward(request, response);
        } else {
            //dang nhap that bat=>hien thi lai man hinh dang nhap
            request.setAttribute("loi", "Loi dang nhap");
//            response.sendRedirect("/Login14Servlet");
            request.getRequestDispatcher("/view/buoi8/dang-nhap14.jsp").forward(request, response);
        }
    }
}
