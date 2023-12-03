package com.example.finallaptrinhweb.controller.user_page;

import com.example.finallaptrinhweb.model.Cart;
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

        String action = request.getParameter("action");
        int productId = Integer.parseInt(request.getParameter("id"));

        Cart cart = (Cart) session.getAttribute("cart");
        // Ensure the product is in the cart
        if (cart.getProducts().containsKey(productId)) {
            int quantity = cart.getProducts().get(productId).getQuantity();

            // Perform the requested action
            switch (action) {
                case "increment":
                    cart.getProducts().get(productId).setQuantity(quantity + 1);
                    break;
                case "decrement":
                    if (quantity > 1) {
                        cart.getProducts().get(productId).setQuantity(quantity - 1);
                    } else {
                        cart.getProducts().remove(productId);
                    }
                    break;
                case "delete":
                    cart.getProducts().remove(productId);
                    break;
            }

            // Update the session with the modified cart
            session.setAttribute("cart", cart);
        }

        // Redirect back to the cart page
        request.getRequestDispatcher("./cart.jsp").forward(request, response);
    }

}
