package com.example.finallaptrinhweb.dao;

import com.example.finallaptrinhweb.db.JDBIConnector;
import com.example.finallaptrinhweb.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class UserDAO {
    private static UserDAO instance;

    public UserDAO() {
    }

    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }

        return instance;
    }

    public User CheckLogin(String email, String password) throws SQLException {
        List<User> users = JDBIConnector.me().get().withHandle((handle) -> {
            return handle.createQuery("SELECT * FROM users WHERE email = ?")
                    .bind(0, email)
                    .mapToBean(User.class)
                    .collect(Collectors.toList());
        });
        if (users.size() != 1) {
            return null;
        } else {
            User user = (User) users.get(0);
            return email.equals(user.getEmail()) && password.equals(user.getPassword()) ? user : null;
        }
    }

    public boolean CheckExistUser(String email) throws SQLException {
        List<User> users = JDBIConnector.me().get().withHandle((handle) -> {
            return handle.createQuery("SELECT * FROM users WHERE email = ?")
                    .bind(0, email)
                    .mapToBean(User.class)
                    .collect(Collectors.toList());
        });
        return !users.isEmpty();
    }

    public boolean CheckVerifiedStatus(String email) throws SQLException {
        List<User> users = JDBIConnector.me().get().withHandle((handle) -> {
            return handle.createQuery("SELECT * FROM users WHERE email = ? && verify_status = ?")
                    .bind(0, email)
                    .bind(1, "verified")
                    .mapToBean(User.class)
                    .collect(Collectors.toList());
        });
        return !users.isEmpty();
    }

    public int GetId() throws SQLException {
        List<User> users = JDBIConnector.me().get().withHandle((handle) -> {
            return handle.createQuery("SELECT * FROM users WHERE id = (SELECT MAX(id) FROM users)")
                    .mapToBean(User.class)
                    .collect(Collectors.toList());
        });
        return users.get(0).getId();
    }

    public User GetInfor(String email) throws SQLException {
        List<User> users = JDBIConnector.me().get().withHandle((handle) -> {
            return handle.createQuery("SELECT * FROM users WHERE email = ?")
                    .bind(0, email)
                    .mapToBean(User.class)
                    .collect(Collectors.toList());
        });
        return users.get(0);
    }

    public void SignUp(String username, String email, String password, String code) throws SQLException {
        JDBIConnector.me().get().withHandle((handle) -> {
            return handle.createUpdate("INSERT INTO users (id, username, email, password, verify_status, role_id) VALUES ( ?, ?, ?, ?, ?, 1)")
                    .bind(0, this.GetId() + 1)
                    .bind(1, username)
                    .bind(2, email)
                    .bind(3, password).
                    bind(4, code).execute();
        });
    }

    public void SetVerifiedStatus(String authcode) throws SQLException {
        JDBIConnector.me().get().useHandle((handle) -> {
            handle.createUpdate("UPDATE users SET verify_status = 'verified' WHERE verify_status = ?")
                    .bind(0, authcode)
                    .execute();
        });
    }

    public String GetPassword(String email) throws SQLException {
        List<User> users = JDBIConnector.me().get().withHandle((handle) -> {
            return handle.createQuery("SELECT password FROM users WHERE email = ?").bind(0, email)
                    .mapToBean(User.class)
                    .collect(Collectors.toList());
        });
        return users.get(0).getPassword();
    }

    public void updateUserInfor(String email, String fullName, String birthday, String city, String district, String ward, String detail_address, String phone) throws SQLException {
        JDBIConnector.me().get().useHandle((handle) -> {
            handle.createUpdate("UPDATE users SET fullName = ?, dateOfBirth = DATE(?), city = ?, district = ?, ward = ?, detail_address = ?, phone = ? WHERE email = ?")
                    .bind(0, fullName)
                    .bind(1, birthday)
                    .bind(2, city)
                    .bind(3, district)
                    .bind(4, ward)
                    .bind(5, detail_address)
                    .bind(6, phone)
                    .bind(7, email)
                    .execute();
        });
    }
}
