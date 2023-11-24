package com.webbanthuocthuy.controller;

// UserServlet.java
import com.webbanthuocthuy.dao.UsersDAO;
import com.webbanthuocthuy.model.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// Import các gói khác cần thiết

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Thực hiện lấy danh sách người dùng
        List<Users> usersList = new UsersDAO().getAllUsers();

        // Lưu danh sách người dùng vào request attribute
        request.setAttribute("usersList", usersList);

        // Chuyển hướng (forward) đến trang JSP để hiển thị thông tin
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/userList.jsp");
        dispatcher.forward(request, response);
    }
}
