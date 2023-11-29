package com.example.finallaptrinhweb.controller.user;

import com.example.finallaptrinhweb.dao.UserDAO;
import com.example.finallaptrinhweb.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

@WebServlet(name = "ResetPass", value = "/resetpassword")
public class ResetPass extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String pass = request.getParameter("pass");
        String newpass = request.getParameter("newpass");
        String renewpass = request.getParameter("renewpass");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("auth");

        try {
            if (!UserDAO.getInstance().GetPassword(user.getEmail()).equals(pass)) {
                request.setAttribute("wrongInfor", "Mật khẩu cũ không trùng khớp !");
                request.getRequestDispatcher("./user_info.jsp").forward(request, response);

            } else if (!renewpass.equals(newpass)) {
                request.setAttribute("wrongInfor", "Mật khẩu không trùng khớp !");
                request.getRequestDispatcher("./user_info.jsp").forward(request, response);

            } else {
                UserDAO.getInstance().updatePassword(user.getEmail(), newpass);
                request.setAttribute("wrongInfor", "Mật khẩu đã được thay đổi");
                request.getRequestDispatcher("./user_info.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
