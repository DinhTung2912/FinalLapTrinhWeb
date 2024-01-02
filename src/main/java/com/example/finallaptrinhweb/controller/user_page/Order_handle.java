package com.example.finallaptrinhweb.controller.user_page;

import com.example.finallaptrinhweb.dao.OrderProductDAO;
import com.example.finallaptrinhweb.dao.OrderDAO;
import com.example.finallaptrinhweb.dao.UserDAOT;
import com.example.finallaptrinhweb.model.OrderProduct;
import com.example.finallaptrinhweb.model.Order;
import com.example.finallaptrinhweb.model.Cart;
import com.example.finallaptrinhweb.model.CartItem;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import com.example.finallaptrinhweb.model.Util;
import java.sql.SQLException;

@WebServlet("/user/order-handle")
public class Order_handle extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart != null && !cart.isEmpty()) {
            int userId;
            String phone;
            String address;

            if (session.getAttribute("user_id") != null) {
                userId = (int) session.getAttribute("user_id");
                phone = ""; // Lấy thông tin người dùng từ session
                address = ""; // Lấy thông tin người dùng từ session
            } else {
                String name = request.getParameter("username");
                phone = request.getParameter("phone");
                String email = request.getParameter("email");
                String province = request.getParameter("province");
                String district = request.getParameter("district");
                String sd = request.getParameter("sub-district");
                String da = request.getParameter("d-address");
                address = da + "," + sd + "," + district + "," + province;
                String password = "";
                if (request.getParameter("password") != null)
                    password = request.getParameter("password");

                boolean createNewUser = UserDAOT.insertUser(name, email, password, phone, new Timestamp(new Date().getTime()), address, "", "", "",
                        "", "verified", 1, new Timestamp(new Date().getTime()));

                if (!createNewUser) {
                    request.setAttribute("type", "err");
                    request.getRequestDispatcher("./checkout.jsp").forward(request, response);
                    return;
                }
                userId = UserDAOT.getMaxUserId();
            }

            double totalPrice = cart.getPriceSaled();

            // Sử dụng phương thức addOrder trực tiếp, giả sử nó xử lý cả việc thêm mới và cập nhật
            int orderId = OrderDAO.addOrder(userId, phone, address, 3, new Timestamp(new Date().getTime()), totalPrice);

            if (orderId != 0) {
                List<OrderProduct> orderProducts = cart.getOrderProducts();
                for (OrderProduct orderProduct : orderProducts) {
                    OrderProductDAO.addOrderProduct(orderId, orderProduct.getProductId(), orderProduct.getQuantity(), orderProduct.getPrice(), orderProduct.getTotal());
                }

                cart.clear();
                session.setAttribute("cart", cart);
                request.setAttribute("type", "suc");
                request.getRequestDispatcher("/user/checkout").forward(request, response);
                return;
            } else {
                System.out.println("Lỗi SQL khi thêm đơn hàng. Kiểm tra console để biết chi tiết.");
            }
        }
        request.setAttribute("type", "err");
        request.getRequestDispatcher("/user/checkout").forward(request, response);
    }
}