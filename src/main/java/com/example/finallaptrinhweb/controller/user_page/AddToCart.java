package com.example.finallaptrinhweb.controller.user_page;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashMap;

@WebServlet("/user/addtocart")
public class AddToCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int productId = Integer.parseInt(request.getParameter("id"));

        HttpSession session = request.getSession();
        HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>) session.getAttribute("cart");

        // If the cart doesn't exist, create a new one
        if (cart == null) {
            cart = new HashMap<>();
            session.setAttribute("cart", cart);
        }

        // Check if the product is already in the cart
        if (cart.containsKey(productId)) {
            // If yes, increment the quantity
            cart.put(productId, cart.get(productId) + 1);
        } else {
            // If not, add a new item to the cart
            cart.put(productId, 1);
        }

        session.setAttribute("cart", cart);
        response.sendRedirect("./shoppingcart");
    }
}
