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

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products";

        try (PreparedStatement preparedStatement = DBCPDataSource.preparedStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Product product = mapResultSetToProduct(resultSet);
                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý ngoại lệ theo ý của bạn
        }

        return products;
    }

    public List<Product> getAllProductsLimited(int start, int limit) {
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

    public Product getProductById(int productId) {
        Product product = null;
        String query = "SELECT * FROM products WHERE id = ?";

        try (PreparedStatement preparedStatement = DBCPDataSource.preparedStatement(query)) {
            preparedStatement.setInt(1, productId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    product = mapResultSetToProduct(resultSet);
                }
            }
        } catch (SQLException e) {

            e.printStackTrace(); // Xử lý ngoại lệ theo ý của bạn

        }

        return product;
    }

    public List<Product> searchProducts(String searchTerm) {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products WHERE productName LIKE ?";

        try (PreparedStatement preparedStatement = DBCPDataSource.preparedStatement(query)) {
            preparedStatement.setString(1, "%" + searchTerm + "%");

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
        product.setPrice(resultSet.getDouble("price"));
        product.setDiscountPrice(resultSet.getBigDecimal("discountPrice"));
        product.setQuantity(resultSet.getInt("quantity"));
        product.setPurpose(resultSet.getString("purpose"));
        product.setContraindications(resultSet.getString("contraindications"));
        product.setStockQuantity(resultSet.getInt("stockQuantity"));
        product.setIngredients(resultSet.getString("ingredients"));
        product.setDosage(resultSet.getString("dosage"));
        product.setInstructions(resultSet.getString("instructions"));
        product.setWarrantyPeriod(resultSet.getString("warrantyPeriod"));
        product.setProductType(resultSet.getString("productType"));
        product.setSupplierId(resultSet.getInt("supplier_id"));
        product.setImageUrl(resultSet.getString("imageUrl"));
        product.setActive(resultSet.getBoolean("active"));


        // Bổ sung các trường thông tin khác nếu cần

        return product;
    }

}
