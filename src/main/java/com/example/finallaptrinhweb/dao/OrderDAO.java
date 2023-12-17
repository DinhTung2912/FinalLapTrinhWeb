package com.example.finallaptrinhweb.dao;

import com.example.finallaptrinhweb.connection_pool.DBCPDataSource;
import com.example.finallaptrinhweb.model.Order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {


    public static List<Order> loadOrderByUserId(int user_id) {
        List<Order> orderList = new ArrayList<>();
        try {
            String query = "SELECT * FROM `orders` WHERE user_id = ?";

            try (PreparedStatement preparedStatement = DBCPDataSource.preparedStatement(query)) {
                preparedStatement.setInt(1, user_id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Order order = getOrder(resultSet);
                        orderList.add(order);
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orderList;
    }
    private static Order getOrder(ResultSet resultSet) {
        if (resultSet == null)
            return null;
        Order order = new Order();
        try {
            order.setId(resultSet.getInt("id"));
            order.setUserId(resultSet.getInt("user_id"));
            order.setDiscountsId(resultSet.getInt("discounts_id"));
            order.setShipId(resultSet.getInt("ship_id"));
            order.setPayment(resultSet.getInt("payment") == 1 );
            order.setPhone(resultSet.getLong("phone"));
            order.setDetailAddress(resultSet.getString("detail_address"));
            order.setStatus(resultSet.getString("status"));
            order.setDateCreated(resultSet.getTimestamp("date_created"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }


    public static Order loadOrder_view(int order_id) {
        Order order = new Order();
        try {
            String query = "SELECT o.id, o.date_created, u.id AS user_id, o.quantity, o.status, o.totalAmount, o.phone, o.detail_address, o.payment, o.date_created AS order_date, o.total_pay, o.ship_price, o.name_product, o.number_product, " +
                    "u.username, (SUM(p.price * op.quantity) + s.shippingCost) AS total " +
                    "FROM orders o " +
                    "JOIN order_products op ON o.id = op.order_id " +
                    "JOIN shipping_info s ON s.id = o.ship_id " +
                    "JOIN users u ON o.user_id = u.id " +
                    "JOIN products p ON op.product_id = p.id " +
                    "WHERE o.id = ?";

            try (PreparedStatement preparedStatement = DBCPDataSource.preparedStatement(query)) {
                preparedStatement.setInt(1, order_id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        order.setId(resultSet.getInt("id"));
                        order.setDateCreated(resultSet.getTimestamp("date_created"));
                        order.setStatus(resultSet.getString("status"));
                        order.setTotalPay(resultSet.getDouble("total"));
                        order.setPayment(resultSet.getBoolean("payment"));
                        order.setDetailAddress(resultSet.getString("detail_address"));
                        order.setPhone(resultSet.getLong("phone"));
                        order.setUsername(resultSet.getString("username"));
                        order.setShipPrice(resultSet.getDouble("ship_price"));

                        // Thêm thông tin sản phẩm
                        order.setNameProduct(resultSet.getString("name_product"));
                        order.setNumberProduct(resultSet.getInt("number_product"));
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return order;
    }

    public static void main(String[] args) {
        System.out.println(loadOrderByUserId(1));

    }
}
