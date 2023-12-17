package com.example.finallaptrinhweb.dao;

import com.example.finallaptrinhweb.model.Product;
import java.util.List;

public class ProductDAOTest {
        public static void main(String[] args) {
            // Khởi tạo đối tượng ProductDAO
            ProductDAO productDAO = new ProductDAO();

            try {
                // Gọi hàm để lấy danh sách sản phẩm từ cơ sở dữ liệu
                List<Product> products = productDAO.getAllProducts();

                // Hiển thị thông tin các sản phẩm
                for (Product product : products) {
                    System.out.println("ID: " + product.getId());
                    System.out.println("Product Name: " + product.getProductName());
                    System.out.println("Price: " + product.getPrice());
                    // Thêm thông tin khác nếu cần
                    System.out.println("------------------------------");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
