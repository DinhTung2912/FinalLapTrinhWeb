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
            String query = "SELECT p.id, p.productName, op.quantity,p.price, o.id, o.date_created, u.id, o.status, (SUM(p.price * op.quantity) + s.shippingCost) AS total, " +
                    "o.payment, o.detail_address, o.phone, u.username, s.shippingCost, p.discountPrice, p.imageUrl " +
                    "FROM orders o " +
                    "JOIN order_products op ON o.id = op.order_id " +
                    "JOIN shipping_info s ON s.id = o.ship_id " +
                    "JOIN users u ON u.id = o.user_id " +
                    "JOIN products p ON op.product_id = p.id " +
                    "WHERE o.id = ? " +
                    "GROUP BY o.id, o.date_created, u.id, o.status, o.payment, " +
                    "o.detail_address, o.phone, u.username, s.shippingCost, p.discountPrice, p.imageUrl;";

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
                    orderProduct.setDiscountsId(resultSet.getInt("discountPrice"));
                    orderProduct.setImageUrl(resultSet.getString("imageUrl"));
                    orderProduct.setSale(resultSet.getDouble("price"),resultSet.getInt("discountPrice"),resultSet.getInt("quantity"));
                    orderProduct.setTotal(resultSet.getDouble("price"),resultSet.getInt("discountPrice"),resultSet.getInt("quantity"));


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
    public static void main(String[] args) {
        System.out.println(loadOrderProductByOrderId(1));
    }
}