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
        int pageSize = 9;
        int pageNumber = Integer.parseInt(request.getParameter("page") != null ? request.getParameter("page") : "1");
        int start = (pageNumber - 1) * pageSize;

        ProductDAO productDAO = new ProductDAO();
        List<Product> products;
        int totalProducts = 0;

        String searchTerm = request.getParameter("searchTerm");
        String object = request.getParameter("category");
        String group = request.getParameter("group");
        String productType = request.getParameter("type");

        if (searchTerm != null) {
            products = productDAO.searchProductsLimited(searchTerm, start, pageSize);
            totalProducts = productDAO.getTotalSearchResults(searchTerm);
            if (products.isEmpty()) {
                request.setAttribute("noProductsFound", true);
            }
        } else if (object != null) {
            products = productDAO.getProductByCategory(object);
        } else if (group != null) {
            products = productDAO.getProductByGroup(group);
        } else if (productType != null) {
            products = productDAO.getProductByType(productType);
        } else {
            products = productDAO.getAllProductsLimited(start, pageSize);
            totalProducts = productDAO.getTotalProducts();
        }

        int totalPages = (int) Math.ceil((double) totalProducts / pageSize);

        Map<String, Integer> listObject = productDAO.getListObject();
        Map<String, Integer> listProductType = productDAO.getListProductType();
        Map<String, Integer> listGroups = productDAO.getGroupListObject();

        request.setAttribute("product", products);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", pageNumber);
        request.setAttribute("objects", listObject.entrySet());
        request.setAttribute("proTypes", listProductType.entrySet());
        request.setAttribute("groups", listGroups.entrySet());
        request.setAttribute("searchTerm", searchTerm);
        request.setAttribute("isSearchPage", searchTerm != null);

        String decodedQueryString = buildQueryString(request, object, group, productType , searchTerm);

        String contextPath = request.getContextPath();
        if (decodedQueryString.startsWith(contextPath)) {
            decodedQueryString = decodedQueryString.substring(contextPath.length());
        }

        String url = decodedQueryString.substring(decodedQueryString.indexOf("=") + 1);
        request.setAttribute("url", url);

        request.getRequestDispatcher("./product.jsp").forward(request, response);
    }

    private String buildQueryString(HttpServletRequest request, String object, String group, String productType, String searchTerm) {
        StringBuilder urlBuilder = new StringBuilder(request.getContextPath());

        if (object != null) {
            urlBuilder.append("&category=").append(object);
        }

        if (group != null) {
            urlBuilder.append("&group=").append(group);
        }

        if (searchTerm != null) {
            urlBuilder.append("&searchTerm=").append(searchTerm);
        }

        if (productType != null) {
            urlBuilder.append("&productType=").append(productType);
        }

        return urlBuilder.toString();
    }
}
