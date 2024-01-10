package com.example.finallaptrinhweb.controller.admin;


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

@WebServlet("/admin/signin")
public class SignIn extends HttpServlet {
    public SignIn() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        User user = null;

        boolean VerifiedStatus;
        try {
            user = UserDAO.getInstance().CheckLogin(email, pass);
            VerifiedStatus = UserDAO.getInstance().CheckVerifiedStatus(email);
        } catch (SQLException var8) {
            throw new RuntimeException(var8);
        }

        if (user != null) {
            if (VerifiedStatus) {
                HttpSession session = request.getSession();
                session.setAttribute("auth", user);
                response.sendRedirect("./dashboard.jsp");
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
