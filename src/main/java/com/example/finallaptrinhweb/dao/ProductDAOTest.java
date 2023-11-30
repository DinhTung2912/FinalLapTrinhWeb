package com.example.finallaptrinhweb.dao;

import com.example.finallaptrinhweb.model.Product;
import java.util.List;

public class ProductDAOTest {
    public static void main(String[] args) {
        // Tạo một đối tượng ProductDAO
        ProductDAO productDAO = new ProductDAO();

        // Lấy danh sách sản phẩm cho một danh mục cụ thể (ví dụ: categoryId = 1)
        List<Product> products = productDAO.getAllProductsByCategory(1);

        // Hiển thị thông tin các sản phẩm
        for (Product product : products) {
            System.out.println("ProductServlet ID: " + product.getId());
            System.out.println("ProductServlet Code: " + product.getProductCode());
            System.out.println("ProductServlet Name: " + product.getProductName());
            System.out.println("Category ID: " + product.getCategoryId());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Discount Price: " + product.getDiscountPrice());
            System.out.println("Image URL: " + product.getImageUrl());


            System.out.println("---------------------------------------");
        }
    }
}
