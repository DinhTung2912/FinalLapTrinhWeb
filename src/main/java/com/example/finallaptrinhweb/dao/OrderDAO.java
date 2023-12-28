package com.example.finallaptrinhweb.dao;

import com.example.finallaptrinhweb.connection_pool.DBCPDataSource;
import com.example.finallaptrinhweb.model.Order;
import com.example.finallaptrinhweb.model.ShippingInfo;
import com.example.finallaptrinhweb.model.OrderProduct;
import com.example.finallaptrinhweb.dao.ShipmentDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {


    public static List<Order> loadOderByUserId(int user_id) {
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
            order.setPayment(resultSet.getInt("payment") == 1);
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

    // Bổ sung phương thức để tải danh sách đơn hàng dựa trên trạng thái
    public static List<Order> loadOrderByStatus(String status, String from_date, String to_date) {
        List<Order> orderList = new ArrayList<>();
        try {
            String query = "SELECT o.id, o.date_created, u.username, o.status, " +
                    "(SUM(p.price * op.quantity) + s.shippingCost) AS total, COUNT(o.id) AS countOr " +
                    "FROM orders o " +
                    "JOIN order_products op ON o.id = op.order_id " +
                    "JOIN shipping_info s ON s.id = o.ship_id " +
                    "JOIN users u ON o.user_id = u.id " +
                    "JOIN products p ON op.product_id = p.id " +
                    "WHERE o.status LIKE ? AND o.date_created BETWEEN ? AND ? " +
                    "GROUP BY o.id, o.date_created, u.username, o.status";

            try (PreparedStatement preparedStatement = DBCPDataSource.preparedStatement(query)) {
                preparedStatement.setString(1, status);
                preparedStatement.setString(2, from_date);
                preparedStatement.setString(3, to_date);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Order order = new Order();
                        order.setId(resultSet.getInt("id"));
                        order.setDateCreated(resultSet.getTimestamp("date_created"));
                        order.setUsername(resultSet.getString("username"));
                        order.setStatus(resultSet.getString("status"));
                        order.setTotalPay(resultSet.getDouble("total"));
                        order.setCountId(resultSet.getInt("countOr"));
                        orderList.add(order);
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orderList;
    }

    public static List<Order> loadOrderByIdUser(int idUser) {
        List<Order> orderList = new ArrayList<>();
        try {
            String query = "SELECT DISTINCT op.order_id id, p.productName, od.date_created, SUM(op.quantity) soluong " +
                    "FROM order_product op " +
                    "JOIN product p ON op.pro_id = p.id " +
                    "JOIN `order` od ON od.id = op.order_id " +
                    "JOIN `user` us ON us.id = od.user_id " +
                    "WHERE us.id = ? " +
                    "GROUP BY p.name, op.order_id, od.date_created";

            try (PreparedStatement preparedStatement = DBCPDataSource.preparedStatement(query)) {
                preparedStatement.setInt(1, idUser);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Order order = new Order();
                        order.setId(resultSet.getInt("id"));
                        order.setNameProduct(resultSet.getString("productName"));
                        order.setDateCreated(resultSet.getTimestamp("date_created"));
                        order.setCountId(resultSet.getInt("soluong"));
                        orderList.add(order);
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orderList;
    }

    public static List<Order> loadOrderStatusByIdUser(int idUser) {
        List<Order> orderList = new ArrayList<>();
        try {
            String query = "SELECT p.id, p.productName, o.`status`, (SUM(p.price * op.quantity)) AS total, o.date_created " +
                    "FROM product p " +
                    "JOIN order_product op ON p.id = op.pro_id " +
                    "JOIN `order` o ON o.id = op.order_id " +
                    "JOIN `user` u ON u.id = o.user_id " +
                    "WHERE u.id = ? " +
                    "GROUP BY p.id, p.name, o.`status`, o.date_created";

            try (PreparedStatement preparedStatement = DBCPDataSource.preparedStatement(query)) {
                preparedStatement.setInt(1, idUser);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Order order = new Order();
                        order.setId(resultSet.getInt("id"));
                        order.setNameProduct(resultSet.getString("productName"));
                        order.setStatus(resultSet.getString("status"));
                        order.setTotalPay(resultSet.getDouble("total"));
                        order.setDateCreated(resultSet.getTimestamp("date_created"));
                        orderList.add(order);
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orderList;
    }

    public static List<Order> loadOrderByUserId(int user_id) {
        List<Order> orderList = new ArrayList<>();
        try {
            String query = "SELECT o.id, o.date_created, u.username, o.status, " +
                    "(SUM(p.price * op.quantity) + s.shippingCost) AS total, COUNT(o.id) AS countOr " +
                    "FROM orders o " +
                    "JOIN order_products op ON o.id = op.order_id " +
                    "JOIN shipping_info s ON s.id = o.ship_id " +
                    "JOIN users u ON o.user_id = u.id " +
                    "JOIN products p ON op.product_id = p.id " +
                    "WHERE o.user_id = ? " +
                    "GROUP BY o.id, o.date_created, o.user_id, o.status";


            try (PreparedStatement preparedStatement = DBCPDataSource.preparedStatement(query)) {
                preparedStatement.setInt(1, user_id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Order order = new Order();
                        order.setId(resultSet.getInt("id"));
                        order.setDateCreated(resultSet.getTimestamp("date_created"));
                        order.setUsername(resultSet.getString("username"));
                        order.setStatus(resultSet.getString("status"));
                        order.setTotalPay(resultSet.getDouble("total"));
                        orderList.add(order);

                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orderList;
    }

    public static boolean updateStatusById(int order_id, String status) {
        try {
            String query = "UPDATE `orders` SET `status` = ? WHERE id=?";
            try (PreparedStatement preparedStatement = DBCPDataSource.preparedStatement(query)) {
                preparedStatement.setString(1, status);
                preparedStatement.setInt(2, order_id);
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


    public static void main(String[] args) {
        int userId = 1; // Đặt user_id tương ứng với người dùng bạn muốn tìm đơn hàng
        List<Order> orders = loadOrderByUserId(userId);
        System.out.println(orders);
    }
    public static int addOrder(int user_id,String phone,
                               String address, int status, String date_created, double total_price) {
        int updated = 0;
        int id = getNextOrderId();
        String sql = "INSERT INTO `orders` (user_id,payment, phone, detail_address, status, date_created, total_pay, id) VALUES ( ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = DBCPDataSource.preparedStatement(sql);
            preparedStatement.setInt(1, user_id);
            preparedStatement.setInt(2, 0);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, address);
            preparedStatement.setInt(5, status);
            preparedStatement.setString(6, date_created);
            preparedStatement.setDouble(7, total_price);
            preparedStatement.setInt(8, id);

            synchronized (preparedStatement) {
                updated = preparedStatement.executeUpdate();
            }

            preparedStatement.close();
            if (updated == 1)
                return id;
            else
                return 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public static int getNextOrderId() {
        int result = 0;
        try {
            String query = "SELECT MAX(id) FROM `orders`";
            try (PreparedStatement preparedStatement = DBCPDataSource.preparedStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next())
                    result = resultSet.getInt(1) + 1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }


}
