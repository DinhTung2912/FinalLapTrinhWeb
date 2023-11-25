package com.example.finallaptrinhweb.dao;

import com.example.finallaptrinhweb.db.JDBIConnector;
import com.example.finallaptrinhweb.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import org.jdbi.v3.core.statement.Query;
import org.jdbi.v3.core.statement.Update;


import com.example.finallaptrinhweb.db.JDBIConnector;
import com.example.finallaptrinhweb.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import org.jdbi.v3.core.statement.Query;
import org.jdbi.v3.core.statement.Update;

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
        JDBIConnector.me();
        List<User> users = (List) JDBIConnector.get().withHandle((handle) -> {
            return (List) ((Query) handle.createQuery("SELECT * FROM users WHERE email = ?").bind(0, email)).mapToBean(User.class).collect(Collectors.toList());
        });
        if (users.size() != 1) {
            return null;
        } else {
            User user = (User) users.get(0);
            return email.equals(user.getEmail()) && password.equals(user.getPassword()) ? user : null;
        }
    }

    public boolean CheckExistUser(String email) throws SQLException {
        JDBIConnector.me();
        List<User> users = (List) JDBIConnector.get().withHandle((handle) -> {
            return (List) ((Query) handle.createQuery("SELECT * FROM users WHERE email = ?").bind(0, email)).mapToBean(User.class).collect(Collectors.toList());
        });
        return !users.isEmpty();
    }

    public boolean CheckVerifiedStatus(String email) throws SQLException {
        JDBIConnector.me();
        List<User> users = (List) JDBIConnector.get().withHandle((handle) -> {
            return (List) ((Query) ((Query) handle.createQuery("SELECT * FROM users WHERE email = ? && verify_status = ?").bind(0, email)).bind(1, "verified")).mapToBean(User.class).collect(Collectors.toList());
        });
        return !users.isEmpty();
    }

    public int GetId() throws SQLException {
        JDBIConnector.me();
        List<User> users = (List) JDBIConnector.get().withHandle((handle) -> {
            return (List) handle.createQuery("SELECT * FROM users WHERE id = (SELECT MAX(id) FROM users)").mapToBean(User.class).collect(Collectors.toList());
        });
        return ((User) users.get(0)).getId();
    }

    public void SignUp(String username, String email, String password, String code) throws SQLException {
        JDBIConnector.me();
        JDBIConnector.get().withHandle((handle) -> {
            return ((Update) ((Update) ((Update) ((Update) ((Update) handle.createUpdate("INSERT INTO users (id, username, email, password, verify_status, role_id) VALUES ( ?, ?, ?, ?, ?, 1)").bind(0, this.GetId() + 1)).bind(1, username)).bind(2, email)).bind(3, password)).bind(4, code)).execute();
        });
    }

    public void SetVerifiedStatus(String authcode) throws SQLException {
        JDBIConnector.me();
        JDBIConnector.get().useHandle((handle) -> {
            ((Update) handle.createUpdate("UPDATE users SET verify_status = 'verified' WHERE verify_status = ?").bind(0, authcode)).execute();
        });
    }

    public String GetPassword(String email) throws SQLException {
        JDBIConnector.me();
        List<User> users = (List) JDBIConnector.get().withHandle((handle) -> {
            return (List) ((Query) handle.createQuery("SELECT password FROM users WHERE email = ?").bind(0, email)).mapToBean(User.class).collect(Collectors.toList());
        });
        return ((User) users.get(0)).getPassword();
    }
}
