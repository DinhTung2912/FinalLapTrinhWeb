package com.example.finallaptrinhweb.controller.user_page;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashMap;

@WebServlet("/user/updatecart")
public class UpdateCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>) session.getAttribute("cart");

        String action = request.getParameter("action");
        int productId = Integer.parseInt(request.getParameter("id"));
        System.out.println(action);
        System.out.println(productId);


        // Ensure the product is in the cart
        if (cart.containsKey(productId)) {
            int quantity = cart.get(productId);

            // Perform the requested action
            switch (action) {
                case "increment":
                    cart.put(productId, quantity + 1);
                    break;
                case "decrement":
                    if (quantity > 1) {
                        cart.put(productId, quantity - 1);
                    } else {
                        cart.remove(productId);
                    }
                    break;
                case "delete":
                    cart.remove(productId);
                    break;
            }

            // Update the session with the modified cart
            session.setAttribute("cart", cart);
        }

        // Redirect back to the cart page
        response.sendRedirect(request.getContextPath() + "/user/shoppingcart");
    }

}
