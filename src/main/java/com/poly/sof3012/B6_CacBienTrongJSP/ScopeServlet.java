package com.poly.sof3012.B6_CacBienTrongJSP;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "ScopeServlet", value = "/ScopeServlet")
public class ScopeServlet extends HttpServlet {
//    Application (ServletContext) được sử dụng để chia sẻ dữ liệu cho tất cả mọi request của tất cả mọi user với mọi thời điểm.
//    Attribute chia sẻ qua application chỉ bị giải phóng khi ứng dụng web bị shutdown
//Session (HttpSession) được sử dụng để chia sẻ dữ liệu giữa các request hoạt động trong cùng một phiên làm việc.
//    Khi session timeout (hết hạn) thì các attribute sẽ bị giải phóng

    //    https://stackjava.com/jsp-servlet/cac-scope-trong-servlet-application-request-session-va-page-scope.html
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext application = getServletContext();
        application.setAttribute("a","aa");
        request.getRequestDispatcher("/view/buoi6/demo.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
