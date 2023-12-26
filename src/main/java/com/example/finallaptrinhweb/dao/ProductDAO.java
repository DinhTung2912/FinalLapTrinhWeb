package com.example.finallaptrinhweb.dao;

import com.example.finallaptrinhweb.connection_pool.DBCPDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    // Trong lớp ProductDAO
    public List<Product> searchProductsLimited(String searchTerm, int start, int pageSize) {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products WHERE productName LIKE ? LIMIT ?, ?";

        try (PreparedStatement preparedStatement = DBCPDataSource.preparedStatement(query)) {
            preparedStatement.setString(1, "%" + searchTerm + "%");
            preparedStatement.setInt(2, start);
            preparedStatement.setInt(3, pageSize);

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
    public int getTotalSearchResults(String searchTerm) {
        int total = 0;
        String query = "SELECT COUNT(*) FROM products WHERE productName LIKE ?";

        try (PreparedStatement preparedStatement = DBCPDataSource.preparedStatement(query)) {
            preparedStatement.setString(1, "%" + searchTerm + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    total = resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý ngoại lệ theo ý muốn
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

    public Map<String, Integer> getListObject() {
        Map<String, Integer> products = new HashMap<>();
        String query = "SELECT pc.productType, COUNT(p.id) AS productCount\n" +
                "FROM product_categories pc\n" +
                "LEFT JOIN products p ON pc.id = p.category_id\n" +
                "GROUP BY pc.productType";

        try (PreparedStatement preparedStatement = DBCPDataSource.preparedStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    products.put(resultSet.getString(1), resultSet.getInt(2));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý ngoại lệ theo ý của bạn
        }
        return products;
    }

    public List<Product> getProductByCategory(String object) {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products\n" +
                "JOIN product_categories ON products.category_id = product_categories.id\n" +
                "WHERE product_categories.productType = ?";

        try (PreparedStatement preparedStatement = DBCPDataSource.preparedStatement(query)) {
            preparedStatement.setString(1, object);
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


    public Map<String, Integer> getGroupListObject() {
        Map<String, Integer> groups = new HashMap<>();
        String query = "SELECT pg.groupName, COUNT(pc.id) AS productCount " +
                "FROM product_groups pg " +
                "LEFT JOIN product_categories pc ON pg.id = pc.group_id " +
                "GROUP BY pg.groupName";

        try (PreparedStatement preparedStatement = DBCPDataSource.preparedStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    groups.put(resultSet.getString(1), resultSet.getInt(2));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý ngoại lệ theo ý của bạn
        }
        return groups;
    }

    public List<Product> getProductByGroup(String groupName) {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products " +
                "JOIN product_categories ON products.category_id = product_categories.id " +
                "JOIN product_groups ON product_categories.group_id = product_groups.id " +
                "WHERE product_groups.groupName = ?";

        try (PreparedStatement preparedStatement = DBCPDataSource.preparedStatement(query)) {
            preparedStatement.setString(1, groupName);
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
