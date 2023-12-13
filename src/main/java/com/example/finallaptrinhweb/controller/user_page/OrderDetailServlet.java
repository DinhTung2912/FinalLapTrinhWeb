package com.example.finallaptrinhweb.controller.user_page;

import com.example.finallaptrinhweb.dao.OrderProductDAO;
import com.example.finallaptrinhweb.dao.OrderDAO;
import com.example.finallaptrinhweb.model.OrderProduct;
import com.example.finallaptrinhweb.model.Order;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
@WebServlet(urlPatterns = "/user/order_detail")
public class OrderDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int order_id = Integer.parseInt(request.getParameter("id"));
        Order order = OrderDAO.loadOrder_view(order_id);
        request.setAttribute("order", order);
        List<OrderProduct> productList = OrderProductDAO.loadOrderProductByOrderId(order_id);
        double sum = 0;
        for (OrderProduct o : productList) {
            sum += o.getTotal();
        }
        double ship = order.getShipPrice();
        double total_money = sum + ship;
        request.setAttribute("sum", sum);
        request.setAttribute("ship", ship);
        request.setAttribute("total_money", total_money);
        request.setAttribute("p_list", productList);
        request.getRequestDispatcher("./order-detail.jsp").forward(request, response);
    }
}
