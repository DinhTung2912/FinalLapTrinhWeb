package com.example.finallaptrinhweb.controller.user;

import com.example.finallaptrinhweb.dao.UserDAO;
import com.example.finallaptrinhweb.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdateInfoUser", value = "/updateinfouser")
public class UpdateInfoUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String birthday = request.getParameter("birthday");
        String phone = request.getParameter("phone");
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        String ward = request.getParameter("ward");
        String detail_address = request.getParameter("address");


        try {
            UserDAO.getInstance().updateUserInfor(request.getParameter("email"), fullName, birthday, city, district, ward, detail_address, phone);
            response.sendRedirect("user_info.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
