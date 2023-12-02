package com.example.finallaptrinhweb.controller.user_page;

import com.example.finallaptrinhweb.dao.ProductDAO;
import com.example.finallaptrinhweb.model.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.*;

@WebServlet("/user/shoppingcart")
public class Cart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>) session.getAttribute("cart");
        ProductDAO productDAO = new ProductDAO();
        List<Product> products = new ArrayList<>();
        Product product = null;
        double totalAmount = 0.0;
        int totalAItem = 0;

        Set<Integer> keys = cart.keySet();

        // Iterate over the keys and get the corresponding values
        for (Integer key : keys) {
            product = productDAO.getProductById(key);
            products.add(product);
            int quantity = cart.get(key);

            totalAItem += 1;
            totalAmount += quantity * product.getPrice();
        }

        System.out.println(cart);
        // Set totalAmount in session
        session.setAttribute("totalAmount", totalAmount);
        session.setAttribute("totalItem", totalAItem);

        // Set products in request attribute
        request.setAttribute("items", products);
        request.getRequestDispatcher("./cart.jsp").forward(request, response);
    }

}
