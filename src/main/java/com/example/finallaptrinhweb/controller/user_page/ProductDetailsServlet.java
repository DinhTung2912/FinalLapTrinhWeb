package com.example.finallaptrinhweb.controller.user_page;

import com.example.finallaptrinhweb.controller.user_page.ImageService.Service;
import com.example.finallaptrinhweb.dao.ProductDAO;
import com.example.finallaptrinhweb.model.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;


@WebServlet("/user/product")
public class ProductDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy ID sản phẩm từ request
        String idParameter = request.getParameter("id");

        if (idParameter != null && !idParameter.isEmpty()) {
            try {
                int productId = Integer.parseInt(idParameter);

                // Tạo một đối tượng ProductDAO
                ProductDAO productDAO = new ProductDAO();

                // Gọi phương thức getProductById để lấy chi tiết sản phẩm
                Product product = productDAO.getProductById(productId);

                // Sản phẩm tương tự
                List<Product> products = productDAO.getAllProductsLimited(0, 4);

                // Hình ảnh sản phẩm
                String folderUrl = getServletContext().getRealPath("data\\sp_") + idParameter;
                List<String> imgUrl = Service.getImgUrlById(folderUrl);

                if (product != null) {
                    // Đặt đối tượng Product vào request để hiển thị trên trang JSP
                    request.setAttribute("product", product);
                    request.setAttribute("products", products);
                    request.setAttribute("listImg", imgUrl);

                    // Chuyển hướng đến trang product-detail.jsp
                    RequestDispatcher dispatcher = request.getRequestDispatcher("./product_detail.jsp");
                    dispatcher.forward(request, response);
                } else {
                    // Nếu không tìm thấy sản phẩm, hiển thị thông báo
                    response.getWriter().println("Product not found");
                }
            } catch (NumberFormatException e) {
                // Xử lý khi giá trị id không hợp lệ hoặc không thể chuyển đổi thành số nguyên
                response.getWriter().println("Invalid product ID");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Xử lý khi giá trị id là null hoặc rỗng
            response.getWriter().println("Product ID is missing");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Do nothing or add POST-specific logic if needed
        response.getWriter().println("POST method not allowed for this servlet");
    }

}
