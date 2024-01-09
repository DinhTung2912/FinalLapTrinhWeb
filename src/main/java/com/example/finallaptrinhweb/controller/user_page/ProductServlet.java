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

    // Lấy danh sách danh mục sản phẩm
            Map<String, Integer> listGroups = productDAO.getGroupListObject();
            Set<Map.Entry<String, Integer>> groups = listGroups.entrySet();

    // Lấy danh mục sản phẩm từ tham số yêu cầu
            String group = request.getParameter("group");

    // Kiểm tra xem có tham số group không
            if (group != null) {
                // Nếu có, gọi phương thức getProductByGroup từ ProductDAO
                products = productDAO.getProductByGroup(group);
            } else if (searchTerm != null) {
                    products = productDAO.searchProducts(searchTerm);
            } else {
                // Nếu không có, sử dụng phương thức hiện tại (ví dụ: getAllProductsLimited)
                products = productDAO.getAllProductsLimited(start, pageSize);
            }
            request.setAttribute("product", products);


            // Tổng số trang
            int totalPages = (int) Math.ceil((double) totalProducts / pageSize);

            // Lấy đường dẫn hiện tại
            String decodedQueryString = buildQueryString(request, object, group, searchTerm);

// Truyền thông tin phân trang đến trang JSP

            request.setAttribute("totalPages", totalPages);
            request.setAttribute("currentPage", pageNumber);
            request.setAttribute("objects", objects);
            request.setAttribute("groups", groups);
            request.setAttribute("searchTerm", searchTerm);
            request.setAttribute("isSearchPage", searchTerm != null);

            String contextPath = request.getContextPath();
            if (decodedQueryString.startsWith(contextPath)) {
                decodedQueryString = decodedQueryString.substring(contextPath.length());
            }

            request.setAttribute("url", decodedQueryString);


            // Chuyển hướng đến trang JSP để hiển thị danh sách và phân trang
            request.getRequestDispatcher("./product.jsp").forward(request, response);
        }

        private String buildQueryString(HttpServletRequest request, String object, String group, String searchTerm) {
            StringBuilder urlBuilder = new StringBuilder();
            urlBuilder.append(request.getContextPath()).append("");

            if (object != null) {
                urlBuilder.append(object);
            }

            if (group != null) {
                urlBuilder.append(group);
            }

            if (searchTerm != null) {
                urlBuilder.append(searchTerm);
            }

            if (urlBuilder.charAt(urlBuilder.length() - 1) == '&') {
                urlBuilder.deleteCharAt(urlBuilder.length() - 1);
            }

            return urlBuilder.toString();
        }


    }
