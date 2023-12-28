package com.example.finallaptrinhweb.dao;

import com.example.finallaptrinhweb.connection_pool.DBCPDataSource;
import com.example.finallaptrinhweb.model.ShippingInfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class ShipmentDAO {

    public static List<ShippingInfo> getAllShipments() {
        List<ShippingInfo> shipmentList = new ArrayList<>();
        try {
            String sql = "SELECT id, shippingCost, date_created, weight FROM shipping_info";
            PreparedStatement preparedStatement = DBCPDataSource.preparedStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ShippingInfo shipment = new ShippingInfo();
                shipment.setId(resultSet.getInt("id"));
                shipment.setShippingCost(resultSet.getBigDecimal("shippingCost"));
                shipment.setDateCreated(resultSet.getDate("date_created"));
                shipment.setWeight(resultSet.getDouble("weight"));
                shipmentList.add(shipment);
            }

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return shipmentList;
    }

    public static int addShipment(int typeWeight) {
        int id = getNextId();
        int updated = 0;
        double price = 0;

        // Sử dụng if-else thay thế cho switch với typeWeight
        if (typeWeight == 1) {
            price = 10000;
        } else if (typeWeight == 2) {
            price = 20000;
        } else if (typeWeight == 3) {
            price = 50000;
        } else if (typeWeight == 4) {
            price = 70000;
            String sql = "INSERT INTO shipping_info (shippingCost, date_created, weight, id) VALUES (?, ?, ?, ?)";
            try {
                PreparedStatement preparedStatement = DBCPDataSource.preparedStatement(sql);
                preparedStatement.setBigDecimal(1, BigDecimal.valueOf(price));
                preparedStatement.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
                preparedStatement.setDouble(3, price); // Thay thế price bằng weight nếu weight là giá trị cần lưu
                preparedStatement.setInt(4, id);

                synchronized (preparedStatement) {
                    updated = preparedStatement.executeUpdate();
                }

                preparedStatement.close();

                if (updated == 1) {
                    return id;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }

    public static int getNextId() {
        int nextId = 0;
        try {
            PreparedStatement preparedStatement = DBCPDataSource.preparedStatement("SELECT MAX(id) FROM shipping_info");
            synchronized (preparedStatement) {
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    nextId = resultSet.getInt(1) + 1;
                }
                resultSet.close();
            }
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return nextId;
    }
}
