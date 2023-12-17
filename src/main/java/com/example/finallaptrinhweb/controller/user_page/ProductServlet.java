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
        int totalProducts = 0;

        // Lấy danh sách đối tượng
        Map<String, Integer> listObject = productDAO.getListObject();
        Set<Map.Entry<String, Integer>> objects = listObject.entrySet();
        // Thực hiện tìm kiếm với phân trang
        if (searchTerm != null) {
            int totalSearchResults = productDAO.getTotalSearchResults(searchTerm);
            int totalPagesSearch = (int) Math.ceil((double) totalSearchResults / pageSize);
            // Nếu có searchTerm, sử dụng phân trang
            products = productDAO.searchProductsLimited(searchTerm, start, pageSize);
            // Cập nhật tổng số sản phẩm cho phân trang
            totalProducts = totalSearchResults;
            // Thêm thông báo khi không tìm thấy sản phẩm
            if (products.isEmpty()) {
                request.setAttribute("noProductsFound", true);
            }
        } else {
            // Nếu không có searchTerm, sử dụng phân trang như cũ
            products = productDAO.getAllProductsLimited(start, pageSize);
            totalProducts = productDAO.getTotalProducts(); // Cập nhật totalProducts ở đây
        }

        if (object != null) {
            products = productDAO.getProductByCategory(object);
        } else if (searchTerm != null) {
            products = productDAO.searchProducts(searchTerm);
        } else {
            products = productDAO.getAllProductsLimited(start, pageSize);
        }
        // Chuyển danh sách sản phẩm và thông tin phân trang đến trang JSP
        request.setAttribute("product", products);



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
