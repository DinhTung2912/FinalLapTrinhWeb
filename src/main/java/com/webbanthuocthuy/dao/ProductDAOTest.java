package com.webbanthuocthuy.dao;

import com.webbanthuocthuy.connection_pool.DBCPDataSource;
import com.webbanthuocthuy.model.Product;

import javax.sql.DataSource;
import java.util.List;

public class ProductDAOTest {
    public static void main(String[] args) {
        // Khởi tạo DataSource từ connection pool configuration
        DataSource dataSource = DBCPDataSource.getDataSource();

        // Khởi tạo ProductDAO với DataSource
        ProductDAO productDAO = new ProductDAO(dataSource);

        // Gọi phương thức getAllProducts để lấy danh sách sản phẩm
        List<Product> productList = productDAO.getAllProducts();

        // In thông tin của các sản phẩm ra màn hình
        for (Product product : productList) {
            System.out.println(product);
        }
    }
}
