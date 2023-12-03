package com.example.finallaptrinhweb.controller.user_page;

import com.example.finallaptrinhweb.model.Cart;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/user/addtocart")
public class AddToCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("id"));

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        // If the cart doesn't exist, create a new one
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        cart.add(productId);

        session.setAttribute("cart", cart);
        response.sendRedirect("./cart");
    }
}
