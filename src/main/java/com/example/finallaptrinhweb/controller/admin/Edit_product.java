package com.example.finallaptrinhweb.controller.admin;

import com.example.finallaptrinhweb.dao.ProductDAO;
import com.example.finallaptrinhweb.model.Product;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/admin/edit-product")
public class Edit_product extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("current_page", "product");

        String type = request.getParameter("type");

        // Thêm điều kiện kiểm tra type không null
        if (type != null) {
            if ("enterEdit".equalsIgnoreCase(type)) {
                request.setAttribute("type", "edit");
                request.setAttribute("title", "Chỉnh sửa sản phẩm");
                int id = Integer.parseInt(request.getParameter("id"));
                Product product = ProductDAO.loadProductById(id);
                request.setAttribute("product", product);
                request.getRequestDispatcher("edit-products.jsp").forward(request, response);
                return;
            }
        }
        if ("edit".equalsIgnoreCase(type)) {
            request.setAttribute("type", "edit");
            request.setAttribute("title", "Chỉnh sửa");

            int id = 0;
            String idParam = request.getParameter("id");
            if (idParam != null && !idParam.isEmpty()) {
                id = Integer.parseInt(idParam);
            }
            double price = 0.0;
            String priceParam = request.getParameter("price");
            if (priceParam != null && !priceParam.isEmpty()) {
                price = Double.parseDouble(priceParam);
            }

            boolean active = false;
            String activeParam = request.getParameter("active");
            if (activeParam != null && !activeParam.isEmpty()) {
                active = Boolean.parseBoolean(activeParam);
            }
            String productName = request.getParameter("productName");
            int categoryId = Integer.parseInt(request.getParameter("categoryId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String purpose = request.getParameter("purpose");
            String contraindications = request.getParameter("contraindications");
            int stockQuantity = Integer.parseInt(request.getParameter("stockQuantity"));
            String ingredients = request.getParameter("ingredients");
            String dosage = request.getParameter("dosage");
            String instructions = request.getParameter("instructions");
            String warrantyPeriod = request.getParameter("warrantyPeriod");
            String storageCondition = request.getParameter("storageCondition");
            String productType = request.getParameter("productType");
            int supplierId = Integer.parseInt(request.getParameter("supplierId"));
            String imageUrl = request.getParameter("imageUrl");

            boolean isUpdate = ProductDAO.updateProduct(id, productName, categoryId, price, quantity,
                    purpose, contraindications, stockQuantity, ingredients, dosage,
                    instructions, warrantyPeriod, storageCondition, productType,
                    supplierId, imageUrl, active);

            // Load lại sản phẩm sau khi cập nhật
            Product product = ProductDAO.loadProductById(id);
            request.setAttribute("product", product);
            request.getRequestDispatcher("edit-products.jsp").forward(request, response);
        }

    }
}

