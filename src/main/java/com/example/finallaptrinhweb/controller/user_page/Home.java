package com.example.finallaptrinhweb.controller.user_page;

import com.example.finallaptrinhweb.dao.ProductDAO;
import com.example.finallaptrinhweb.model.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/user/home")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Danh sách sản phẩm
        ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.getAllProducts(0, 3);
        request.setAttribute("products", products);

        //Danh sách banner

        //Danh sách thương hiệu

        request.getRequestDispatcher("./index.jsp").forward(request, response);
    }
}
