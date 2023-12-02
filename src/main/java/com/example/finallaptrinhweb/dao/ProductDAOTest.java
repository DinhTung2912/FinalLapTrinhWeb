package com.example.finallaptrinhweb.dao;

import com.example.finallaptrinhweb.model.Product;
import java.util.List;

public class ProductDAOTest {
    public static void main(String[] args) {
        // Thay thế 1 bằng id sản phẩm mà bạn muốn kiểm thử
        int productIdToTest = 1;

        // Tạo một đối tượng ProductDAO
        ProductDAO productDAO = new ProductDAO();

        // Gọi phương thức để lấy chi tiết sản phẩm theo id
        Product product = productDAO.getProductById(productIdToTest);

        // In thông tin sản phẩm
        if (product != null) {
            System.out.println("Thông tin sản phẩm có ID " + productIdToTest + ":");
            System.out.println("ID: " + product.getId());
            System.out.println("Tên sản phẩm: " + product.getProductName());
            System.out.println("Giá: " + product.getPrice());
            // In thêm thông tin khác nếu cần
        } else {
            System.out.println("Không tìm thấy sản phẩm có ID " + productIdToTest);
        }
    }
}
