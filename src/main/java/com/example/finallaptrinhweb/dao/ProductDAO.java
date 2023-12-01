package com.example.finallaptrinhweb.dao;

import com.example.finallaptrinhweb.connection_pool.DBCPDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.finallaptrinhweb.model.Product;

public class ProductDAO {
    private static Connection connection = null;

    public ProductDAO() {
        // Không cần thiết lập kết nối ở đây, sử dụng getConnection khi cần
    }
    public List<Product> getAllProducts(int start, int limit) {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products LIMIT ?, ?";

        try (PreparedStatement preparedStatement = DBCPDataSource.preparedStatement(query)) {
            preparedStatement.setInt(1, start);
            preparedStatement.setInt(2, limit);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Product product = mapResultSetToProduct(resultSet);
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý ngoại lệ theo ý của bạn
        }

        return products;
    }
    public int getTotalProducts() {
        int total = 0;
        String query = "SELECT COUNT(*) FROM products";

        try (PreparedStatement preparedStatement = DBCPDataSource.preparedStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                total = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý ngoại lệ theo ý của bạn
        }

        return total;
    }



    public List<Product> getAllProductsByCategory(int categoryId) {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products WHERE category_id = ?";

        try (PreparedStatement preparedStatement = DBCPDataSource.preparedStatement(query)) {
            preparedStatement.setInt(1, categoryId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Product product = mapResultSetToProduct(resultSet);
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý ngoại lệ theo ý của bạn
        }

        return products;
    }

    private Product mapResultSetToProduct(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getInt("id"));
        product.setProductCode(resultSet.getString("productCode"));
        product.setProductName(resultSet.getString("productName"));
        product.setCategoryId(resultSet.getInt("category_id"));
        product.setPrice(resultSet.getBigDecimal("price"));
        product.setDiscountPrice(resultSet.getBigDecimal("discountPrice"));
        product.setImageUrl(resultSet.getString("imageUrl"));


        return product;
    }
}
