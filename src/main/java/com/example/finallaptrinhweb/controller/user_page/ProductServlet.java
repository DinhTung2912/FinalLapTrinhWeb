package com.example.finallaptrinhweb.controller.user_page;

import com.example.finallaptrinhweb.dao.ProductDAO;
import com.example.finallaptrinhweb.model.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/products")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy số trang hiện tại từ tham số yêu cầu (nếu không có, mặc định là trang đầu tiên)
        int pageNumber = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;

        // Số sản phẩm mỗi trang
        int pageSize = 9;

        //get search term
        String searchTerm = request.getParameter("searchTerm");

        // Tính vị trí bắt đầu của trang hiện tại
        int start = (pageNumber - 1) * pageSize;

        // Lấy danh sách sản phẩm từ ProductDAO
        ProductDAO productDAO = new ProductDAO();
        List<Product> products;

        if (searchTerm == null || searchTerm.isEmpty()) {
            products = productDAO.getAllProductsLimited(start, pageSize);
        } else {
            products = productDAO.searchProducts(searchTerm);
        }
        //cái này anh tý nữa xử lý phân trang lại nhé, sau khi search nó cũng cần phân trang
        //lấy đc ra r đó anh
        // Chuyển danh sách sản phẩm và thông tin phân trang đến trang JSP
        request.setAttribute("product", products);

        // Tổng số sản phẩm (cần để tính toán số trang)
        int totalProducts = productDAO.getTotalProducts();

        // Tổng số trang
        int totalPages = (int) Math.ceil((double) totalProducts / pageSize);

        // Truyền thông tin phân trang đến trang JSP
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", pageNumber);




        // Chuyển hướng đến trang JSP để hiển thị danh sách và phân trang
        request.getRequestDispatcher("./product.jsp").forward(request, response);
    }
}
