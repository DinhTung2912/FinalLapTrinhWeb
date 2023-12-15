package com.example.finallaptrinhweb.controller.user_page;

import com.example.finallaptrinhweb.dao.ProductDAO;
import com.example.finallaptrinhweb.model.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

        //object category
        String object = request.getParameter("category");

        // Tính vị trí bắt đầu của trang hiện tại
        int start = (pageNumber - 1) * pageSize;

        // Lấy danh sách sản phẩm từ ProductDAO
        ProductDAO productDAO = new ProductDAO();
        List<Product> products;

        // Lấy danh sách đối tượng
        Map<String, Integer> listObject = productDAO.getListObject();
        Set<Map.Entry<String, Integer>> objects = listObject.entrySet();


        if (object != null) {
            products = productDAO.getProductByCategory(object);
        } else if (searchTerm != null) {
            products = productDAO.searchProducts(searchTerm);
        } else {
            products = productDAO.getAllProductsLimited(start, pageSize);
        }
        // Chuyển danh sách sản phẩm và thông tin phân trang đến trang JSP
        request.setAttribute("product", products);

        // Tổng số sản phẩm (cần để tính toán số trang)
        int totalProducts = productDAO.getTotalProducts();

        // Tổng số trang
        int totalPages = (int) Math.ceil((double) totalProducts / pageSize);

        //Lấy đường dẫn hiện tại
        String encoded;
        String decodedQueryString = null;
        if (object != null) {
            encoded = object;
        } else if (searchTerm != null) {
            encoded = searchTerm;
        } else {
            encoded = null;
        }

        if (encoded != null) {
            decodedQueryString = URLDecoder.decode(encoded, StandardCharsets.UTF_8);
        }

        // Truyền thông tin phân trang đến trang JSP
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", pageNumber);
        request.setAttribute("objects", objects);
        request.setAttribute("url", decodedQueryString);

        // Chuyển hướng đến trang JSP để hiển thị danh sách và phân trang
        request.getRequestDispatcher("./product.jsp").forward(request, response);
    }
}
