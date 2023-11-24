package com.webbanthuocthuy.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Order {
    private int id;
    private String orderCode;
    private int userId;
    private int productId;
    private int quantity;
    private Timestamp orderDate;
    private String status;
    private int orderDiscountId;
    private BigDecimal totalAmount;

    // Constructor
    public Order(){

    }
    public Order(int id, String orderCode, int userId, int productId, int quantity, Timestamp orderDate,
                 String status, int orderDiscountId, BigDecimal totalAmount) {
        this.id = id;
        this.orderCode = orderCode;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.status = status;
        this.orderDiscountId = orderDiscountId;
        this.totalAmount = totalAmount;
    }

    // Các phương thức getter và setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOrderDiscountId() {
        return orderDiscountId;
    }

    public void setOrderDiscountId(int orderDiscountId) {
        this.orderDiscountId = orderDiscountId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderCode='" + orderCode + '\'' +
                ", userId=" + userId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                ", orderDiscountId=" + orderDiscountId +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
