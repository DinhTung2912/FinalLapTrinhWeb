package com.example.finallaptrinhweb.controller.user_page;

import com.example.finallaptrinhweb.dao.ProductDAO;
import com.example.finallaptrinhweb.model.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.util.List;
import java.io.IOException;

@WebServlet("/user/product")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy danh sách sản phẩm từ ProductDAO
        ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.getAllProductsByCategory(1);

        // Chuyển danh sách sản phẩm đến trang JSP
        request.setAttribute("product", products);
        request.getRequestDispatcher("./product.jsp").forward(request, response);
    }
}
