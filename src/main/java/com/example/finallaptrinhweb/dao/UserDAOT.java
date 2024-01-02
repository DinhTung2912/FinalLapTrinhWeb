package com.example.finallaptrinhweb.dao;

import com.example.finallaptrinhweb.connection_pool.DBCPDataSource;
import com.example.finallaptrinhweb.model.User;
import com.example.finallaptrinhweb.model.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDAOT {

    public static User getUser(ResultSet rs) {
        if (rs == null)
            return null;
        User user = new User();
        try {
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setFullName(rs.getString("fullName"));
            user.setDateOfBirth(rs.getDate("dateOfBirth"));
            user.setCity(rs.getString("city"));
            user.setDistrict(rs.getString("district"));
            user.setWard(rs.getString("ward"));
            user.setDetail_address(rs.getString("detail_address"));
            user.setPhone(rs.getString("phone"));
            user.setRoleId(rs.getInt("role_id"));
            user.setDate_created(rs.getDate("date_created"));
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static List<User> loadUserFromSql(String sql) {
        List<User> list = new ArrayList<>();
        try (Statement statement = DBCPDataSource.getStatement()) {
            synchronized (statement) {
                try (ResultSet rs = statement.executeQuery(sql)) {
                    while (rs.next()) {
                        list.add(getUser(rs));
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static int getMaxUserId() {
        int id = 0;
        try (Statement statement = DBCPDataSource.getStatement()) {
            synchronized (statement) {
                try (ResultSet resultSet = statement.executeQuery("SELECT MAX(id) FROM users")) {
                    if (resultSet.next())
                        id = resultSet.getInt(1);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return id;
    }

    public static boolean insertUser(String username, String email, String password, String fullName,
                                     Date dateOfBirth, String city, String district, String ward,
                                     String detailAddress, String phone, String verifyStatus,
                                     int roleId, Timestamp dateCreated) {
        int isInserted = 0;
        String sql = "INSERT INTO users (username, email, password, fullName, dateOfBirth, city, district, ward, " +
                "detail_address, phone, verify_status, role_id, date_created) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBCPDataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // Lấy ID mới từ ResultSet sau khi thêm mới
            int id;
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    id = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Failed to get the new user ID.");
                }
            }

            long passKey = id * (email != null ? email.hashCode() : 1) * (password != null ? password.hashCode() : 1);

            peSetAttribute(preparedStatement, id, username, email, password, fullName, dateOfBirth,
                    city, district, ward, detailAddress, phone, verifyStatus, roleId,
                    dateCreated, passKey);

            // Thực hiện cập nhật và kiểm tra số bản ghi được cập nhật
            synchronized (preparedStatement) {
                isInserted = preparedStatement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return isInserted == 1;
    }

    private static void peSetAttribute(PreparedStatement preparedStatement, int id, String username, String email,
                                       String password, String fullName, Date dateOfBirth, String city,
                                       String district, String ward, String detailAddress, String phone,
                                       String verifyStatus, int roleId, Timestamp dateCreated, long passKey) {
        try {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, fullName);
            preparedStatement.setDate(5, new java.sql.Date(dateOfBirth.getTime()));
            preparedStatement.setString(6, city);
            preparedStatement.setString(7, district);
            preparedStatement.setString(8, ward);
            preparedStatement.setString(9, detailAddress);
            preparedStatement.setString(10, phone);
            preparedStatement.setString(11, verifyStatus);
            preparedStatement.setInt(12, roleId);
            preparedStatement.setTimestamp(13, new java.sql.Timestamp(dateCreated.getTime()));
            preparedStatement.setLong(14, passKey);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
