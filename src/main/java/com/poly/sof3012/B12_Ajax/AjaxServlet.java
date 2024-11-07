package com.poly.sof3012.B12_Ajax;

import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AjaxServlet", value = "/api/greet")
public class AjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Tạo đối tượng User
        User user = new User("John Doe", 30);

        // Chuyển đổi đối tượng User thành JSON
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(user);

        // Đặt kiểu dữ liệu trả về là JSON
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        // Gửi dữ liệu JSON về client
        out.print(jsonResponse);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
