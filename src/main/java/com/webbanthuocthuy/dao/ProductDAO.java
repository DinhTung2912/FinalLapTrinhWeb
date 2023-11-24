package com.webbanthuocthuy.dao;

import com.webbanthuocthuy.model.Product;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private DataSource dataSource;

    public ProductDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            // Tạo truy vấn SQL
            String sql = "SELECT * FROM products";

            // Tạo đối tượng PreparedStatement
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Thực hiện truy vấn
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Duyệt qua kết quả và tạo đối tượng Product từ mỗi bản ghi
                    while (resultSet.next()) {
                        Product product = new Product(
                                resultSet.getInt("id"),
                                resultSet.getString("productCode"),
                                resultSet.getString("productName"),
                                resultSet.getInt("category_id"),
                                resultSet.getBigDecimal("price"),
                                resultSet.getBigDecimal("discountPrice"),
                                resultSet.getInt("quantity"),
                                resultSet.getInt("stockQuantity"),
                                resultSet.getString("ingredients"),
                                resultSet.getString("dosage"),
                                resultSet.getString("instructions"),
                                resultSet.getInt("warrantyPeriod"),
                                resultSet.getString("productType"),
                                resultSet.getInt("supplier_id"),
                                resultSet.getString("imageUrl"),
                                resultSet.getBoolean("active")
                        );
                        productList.add(product);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }


}
