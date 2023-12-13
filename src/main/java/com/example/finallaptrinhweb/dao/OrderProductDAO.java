package com.example.finallaptrinhweb.dao;

import com.example.finallaptrinhweb.connection_pool.DBCPDataSource;
import com.example.finallaptrinhweb.model.OrderProduct;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderProductDAO {

    public static List<OrderProduct> loadOrderProductByOrderId(int orderId) {
        List<OrderProduct> productList = new ArrayList<>();
        try {
            String query = "SELECT p.id, p.productName, op.quantity, p.price, p.discountPrice, p.imageUrl " +
                    "FROM orders o " +
                    "JOIN order_products op ON o.id = op.order_id " +
                    "JOIN products p ON op.product_id = p.id " +
                    "WHERE o.id = ?";
            PreparedStatement preparedStatement = DBCPDataSource.preparedStatement(query);
            preparedStatement.setInt(1, orderId);

            synchronized (preparedStatement) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    OrderProduct orderProduct = new OrderProduct();
                    orderProduct.setProductId(resultSet.getInt("id"));
                    orderProduct.setProductName(resultSet.getString("productName"));
                    orderProduct.setQuantity(resultSet.getInt("quantity"));
                    orderProduct.setPrice(resultSet.getDouble("price"));
                    orderProduct.setSale(resultSet.getDouble("sale"));
                    orderProduct.setImageUrl(resultSet.getString("imageUrl"));

                    productList.add(orderProduct);
                }
                resultSet.close();
            }
            preparedStatement.close();
            return productList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }


}
