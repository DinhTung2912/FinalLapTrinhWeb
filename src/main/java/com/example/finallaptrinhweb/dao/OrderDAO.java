package com.example.finallaptrinhweb.dao;

import com.example.finallaptrinhweb.connection_pool.DBCPDataSource;
import com.example.finallaptrinhweb.model.Order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class OrderDAO {
    public static Order loadOrder_view(int order_id) {
        Order order = new Order();
        try {
            String query = "SELECT o.id, o.date_created, o.user_id, o.quantity, o.status, o.totalAmount, o.phone, o.detail_address, o.payment, o.date_created, o.total_pay, o.ship_price, o.name_product, o.number_product, " +
                    "u.username, (SUM(op.price * op.quantity) + s.shippingCost) AS total " +
                    "FROM orders o " +
                    "JOIN order_products op ON o.id = op.order_id " +
                    "JOIN shipping_info s ON o.id = s.order_id " +
                    "JOIN users u ON o.user_id = u.id " +
                    "WHERE o.id = ?";

            PreparedStatement preparedStatement = DBCPDataSource.preparedStatement(query);
            preparedStatement.setInt(1, order_id);

            synchronized (preparedStatement) {
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    order.setId(resultSet.getInt("id"));
                    order.setUserId(resultSet.getInt("user_id"));
                    order.setQuantity(resultSet.getInt("quantity"));
                    order.setStatus(resultSet.getString("status"));
                    order.setTotalAmount(resultSet.getDouble("totalAmount"));
                    order.setPhone(resultSet.getLong("phone"));
                    order.setDetailAddress(resultSet.getString("detail_address"));
                    order.setPayment(resultSet.getBoolean("payment"));
                    order.setDateCreated(resultSet.getTimestamp("date_created"));
                    order.setTotalPay(resultSet.getDouble("total_pay"));
                    order.setShipPrice(resultSet.getDouble("ship_price"));
                    order.setNameProduct(resultSet.getString("name_product"));
                    order.setNumberProduct(resultSet.getInt("number_product"));
                    order.setUsername(resultSet.getString("username"));
                    order.setTotalAmount(resultSet.getDouble("totalAmount"));
                }
                resultSet.close();
            }
            preparedStatement.close();
            return order;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return order;
    }
}
