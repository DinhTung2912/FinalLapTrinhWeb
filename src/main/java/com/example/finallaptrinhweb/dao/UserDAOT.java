package com.example.finallaptrinhweb.dao;


import com.example.finallaptrinhweb.connection_pool.DBCPDataSource;
import com.example.finallaptrinhweb.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class UserDAOT {
    public static User getUser(ResultSet rs){
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
            return  user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public static List<User>loadUserFromSql(String sql){
        List<User>list = new ArrayList<User>();
        try {
            Statement statement = DBCPDataSource.getStatement();
            synchronized (statement){
                ResultSet rs = statement.executeQuery(sql);
                while(rs.next()){
                    list.add(getUser(rs));
                }
                rs.close();
            }
            statement.close();
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
