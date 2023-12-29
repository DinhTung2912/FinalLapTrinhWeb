package com.example.finallaptrinhweb.controller.user_page;

import com.example.finallaptrinhweb.dao.OrderProductDAO;
import com.example.finallaptrinhweb.dao.OrderDAO;
import com.example.finallaptrinhweb.dao.UserDAO;
import com.example.finallaptrinhweb.model.OrderProduct;
import com.example.finallaptrinhweb.model.Order;
import com.example.finallaptrinhweb.model.Cart;
import com.example.finallaptrinhweb.model.CartItem;
import com.example.finallaptrinhweb.dao.UserDAOT;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.sql.Timestamp;

@WebServlet("/user/order-handle")
public class Order_handle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin người dùng từ form
        int userId = Integer.parseInt(request.getParameter("userId"));
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        // Lấy thông tin giỏ hàng từ session
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        // Tạo đơn hàng mới
        Order newOrder = new Order();
        newOrder.setUserId(userId);
        newOrder.setPhone(Long.parseLong(phone));
        newOrder.setDetailAddress(address);
        newOrder.setStatus("0"); // Trạng thái đơn hàng mới
        newOrder.setTotalAmount(cart.getPriceSaled()); // Sử dụng giá đã giảm giá

        // Chuyển đổi từ java.util.Date sang java.sql.Timestamp
        Timestamp timestamp = new Timestamp(new Date().getTime());
        newOrder.setDateCreated(timestamp);

        // Thêm đơn hàng vào cơ sở dữ liệu
        // Sau khi sửa
        int orderId = OrderDAO.addOrder(newOrder.getUserId(), String.valueOf(newOrder.getPhone()), newOrder.getDetailAddress(), Integer.parseInt(newOrder.getStatus()), newOrder.getDateCreated().toString(), newOrder.getTotalAmount());

        // Thêm các sản phẩm trong giỏ hàng vào bảng order_products
        for (CartItem cartItem : cart.getProducts().values()) {
            OrderProduct orderProduct = cartItem.toOrderProduct();
            orderProduct.setOrderId(orderId);

            // Thêm sản phẩm vào cơ sở dữ liệu
            OrderProductDAO.addOrderProduct(orderProduct.getOrderId(), orderProduct.getProductId(), orderProduct.getQuantity(), orderProduct.getPrice(), orderProduct.getTotal());
        }

        // Xóa giỏ hàng sau khi đã đặt hàng thành công
        session.removeAttribute("cart");

        // Chuyển hướng đến trang thông báo đặt hàng thành công
        response.sendRedirect(request.getContextPath() + "/user/order-success.jsp");
    }
}