
package com.example.finallaptrinhweb.model;

import java.sql.Date;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private String fullName;
    private Date dateOfBirth;
    private String address;
    private String phone;
    private String verifyStatus;
    private int roleId;

    public User() {
    }

    public User(int id, String username, String email, String password, String fullName, Date dateOfBirth, String address, String phone, String verifyStatus, int roleId) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phone = phone;
        this.verifyStatus = verifyStatus;
        this.roleId = roleId;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String passwordHash) {
        this.password = passwordHash;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVerifyStatus() {
        return this.verifyStatus;
    }

    public void setVerifyStatus(String verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public int getRoleId() {
        return this.roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String toString() {
        return "Users{id=" + this.id + ", username='" + this.username + "', email='" + this.email + "', password='" + this.password + "', fullName='" + this.fullName + "', dateOfBirth=" + this.dateOfBirth + ", address='" + this.address + "', phone='" + this.phone + "', verifyStatus='" + this.verifyStatus + "', roleId=" + this.roleId + "}";
    }
}