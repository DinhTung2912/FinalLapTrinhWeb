package com.example.finallaptrinhweb.controller.user_page;

import com.example.finallaptrinhweb.model.Address;
import com.example.finallaptrinhweb.dao.LoadfooterDao;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/loadAddress", loadOnStartup = 1)
public class LoadAddress extends HttpServlet {

    public void init() throws ServletException {
        // Gọi hàm để load thông tin địa chỉ và đặt vào application scope
        List<Address> addresses = LoadfooterDao.loadAddresses();
        getServletContext().setAttribute("address", addresses);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Có thể thực hiện các hành động khác nếu cần
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Có thể thực hiện các hành động khác nếu cần
    }
}
