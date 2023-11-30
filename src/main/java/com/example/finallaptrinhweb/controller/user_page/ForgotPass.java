package com.example.finallaptrinhweb.controller.user_page;


import com.example.finallaptrinhweb.controller.user_page.MailService.SendEmail;
import com.example.finallaptrinhweb.dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/user/forgotpassword")
public class ForgotPass extends HttpServlet {
    public ForgotPass() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        SendEmail send = new SendEmail();

        try {
            if (UserDAO.getInstance().CheckExistUser(email)) {
                String pass = UserDAO.getInstance().GetPassword(email);
                if (send.sendPassword(email, pass)) {
                    response.sendRedirect("./signIn.jsp");
                }
            } else {
                request.setAttribute("wrongInfor", "Tài khoản không tồn tại !");
                request.getRequestDispatcher("./forgotPass.jsp").forward(request, response);
            }

        } catch (SQLException var6) {
            throw new RuntimeException(var6);
        }
    }
}

