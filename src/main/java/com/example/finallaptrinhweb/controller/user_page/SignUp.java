package com.example.finallaptrinhweb.controller.user_page;


import com.example.finallaptrinhweb.controller.user_page.MailService.SendEmail;
import com.example.finallaptrinhweb.dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/user/signup"
)
public class SignUp extends HttpServlet {
    public SignUp() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String repass = request.getParameter("repassword");
        SendEmail send = new SendEmail();
        String code = send.getRandomVerifyCode();
        if (repass.equals(pass)) {
            try {
                if (!UserDAO.getInstance().CheckExistUser(email) ) {
                    UserDAO.getInstance().SignUp(name, email, pass, code);
                    if (send.sendVerifyCode(email, code)) {
                        HttpSession session = request.getSession();
                        session.setAttribute("authcode", code);
                        response.sendRedirect("./verify.jsp");
                    }
                } else {
                    request.setAttribute("wrongInfor", "Tài khoản đã tồn tại !");
                    request.getRequestDispatcher("./signUp.jsp").forward(request, response);
                }
            } catch (SQLException var10) {
                throw new RuntimeException(var10);
            }
        } else {
            request.setAttribute("wrongInfor", "Mật khẩu không trùng khớp !");
            request.getRequestDispatcher("./signUp.jsp").forward(request, response);
        }

    }
}

