package com.example.finallaptrinhweb.dao;

import java.util.List;
import com.example.finallaptrinhweb.model.User;
public class UserDAOTTest {
    public static void main(String[] args) {
        // Thực hiện một truy vấn SQL đơn giản để lấy danh sách người dùng
        String sql = "SELECT * FROM users";
        List<User> userList = UserDAOT.loadUserFromSql(sql);

        // Hiển thị thông tin người dùng ra màn hình
        if (userList != null && !userList.isEmpty()) {
            System.out.println("User List:");
            for (User user : userList) {
                System.out.println("ID: " + user.getId());
                System.out.println("Username: " + user.getUsername());
                System.out.println("Email: " + user.getEmail());
                System.out.println("Ngày tạo: " + user.getDate_created());
                // Hiển thị các thông tin khác của người dùng
                System.out.println("--------------");
            }
        } else {
            System.out.println("No users found.");
        }
    }
}
