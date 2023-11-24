package com.webbanthuocthuy.dao;


import com.webbanthuocthuy.model.Users;
import com.webbanthuocthuy.connection_pool.DBCPDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO {
    public UsersDAO() {
    }

    // Phương thức để lấy danh sách tất cả người dùng từ CSDL
    public List<Users> getAllUsers() {
        List<Users> usersList = new ArrayList<>();
        Connection connection = null;

        try {
            // Lấy kết nối từ connection pool
            connection = DBCPDataSource.getConnection();

            String query = "SELECT * FROM users";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    Users user = new Users(
                            resultSet.getInt("id"),
                            resultSet.getString("username"),
                            resultSet.getString("email"),
                            resultSet.getString("passwordHash"),
                            resultSet.getString("fullName"),
                            resultSet.getDate("dateOfBirth"),
                            resultSet.getString("address"),
                            resultSet.getString("phone"),
                            resultSet.getString("verify_status"),
                            resultSet.getInt("role_id")
                    );

                    usersList.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {

                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return usersList;
    }


}
