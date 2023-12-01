package com.example.finallaptrinhweb.dao;

import com.example.finallaptrinhweb.model.Product;
import java.util.List;

public class ProductDAOTest {
    public static void main(String[] args) {
        // Tạo một đối tượng ProductDAO
        int pageNumber = 1; // Trang đầu tiên
        int pageSize = 10;  // 10 sản phẩm mỗi trang

        ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.getAllProducts((pageNumber - 1) * pageSize, pageSize);


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
