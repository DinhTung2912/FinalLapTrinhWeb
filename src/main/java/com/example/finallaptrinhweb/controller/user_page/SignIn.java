package com.example.finallaptrinhweb.controller.user_page;


import com.example.finallaptrinhweb.dao.UserDAO;
import com.example.finallaptrinhweb.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/user/signin")
public class SignIn extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        User user = null;

        boolean verifiedStatus;
        try {
            user = UserDAO.getInstance().CheckLogin(email, pass);
            verifiedStatus = UserDAO.getInstance().CheckVerifiedStatus(email);
        } catch (SQLException var8) {
            throw new RuntimeException(var8);
        }

        if (user != null) {
            if (verifiedStatus) {
                HttpSession session = request.getSession();
                session.setAttribute("auth", user);

                // Kiểm tra vai trò (role) của người dùng
                int roleId = user.getRoleId();

                if (roleId == 1) {
                    // Vai trò là 1, chuyển hướng đến trang home
                    response.sendRedirect(request.getContextPath() + "/user/home");
                } else if (roleId == 2) {
                    // Vai trò là 2, chuyển hướng đến trang admin
                    response.sendRedirect(request.getContextPath() + "/admin/dashboard");
                } else {
                    // Nếu có thêm các vai trò khác, xử lý tại đây
                    response.sendRedirect(request.getContextPath() + "user/error-404.html");
                }
            } else {
                request.setAttribute("wrongInfor", "Tài khoản chưa kích hoạt");
                request.getRequestDispatcher("./signIn.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("wrongInfor", "Đăng nhập thất bại");
            request.getRequestDispatcher("./signIn.jsp").forward(request, response);
        }
    }
}
