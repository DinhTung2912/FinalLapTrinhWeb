package com.example.finallaptrinhweb.dao;

import com.example.finallaptrinhweb.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class ProductDAO {
    private DataSource dataSource;

    public ProductDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList();

        try {
            Connection connection = this.dataSource.getConnection();

            try {
                String sql = "SELECT * FROM products";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                try {
                    ResultSet resultSet = preparedStatement.executeQuery();

                    try {
                        while (resultSet.next()) {
                            Product product = new Product(resultSet.getInt("id"), resultSet.getString("productCode"), resultSet.getString("productName"), resultSet.getInt("category_id"), resultSet.getBigDecimal("price"), resultSet.getBigDecimal("discountPrice"), resultSet.getInt("quantity"), resultSet.getInt("stockQuantity"), resultSet.getString("ingredients"), resultSet.getString("dosage"), resultSet.getString("instructions"), resultSet.getInt("warrantyPeriod"), resultSet.getString("productType"), resultSet.getInt("supplier_id"), resultSet.getString("imageUrl"), resultSet.getBoolean("active"));
                            productList.add(product);
                        }
                    } catch (Throwable var11) {
                        if (resultSet != null) {
                            try {
                                resultSet.close();
                            } catch (Throwable var10) {
                                var11.addSuppressed(var10);
                            }
                        }

                        throw var11;
                    }

                    if (resultSet != null) {
                        resultSet.close();
                    }
                } catch (Throwable var12) {
                    if (preparedStatement != null) {
                        try {
                            preparedStatement.close();
                        } catch (Throwable var9) {
                            var12.addSuppressed(var9);
                        }
                    }

                    throw var12;
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Throwable var13) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var8) {
                        var13.addSuppressed(var8);
                    }
                }

                throw var13;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var14) {
            var14.printStackTrace();
        }

        return productList;
    }
}
