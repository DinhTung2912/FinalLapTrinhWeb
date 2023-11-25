
package com.example.finallaptrinhweb.model;

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

    public Order() {
    }

    public Order(int id, String orderCode, int userId, int productId, int quantity, Timestamp orderDate, String status, int orderDiscountId, BigDecimal totalAmount) {
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

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderCode() {
        return this.orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Timestamp getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOrderDiscountId() {
        return this.orderDiscountId;
    }

    public void setOrderDiscountId(int orderDiscountId) {
        this.orderDiscountId = orderDiscountId;
    }

    public BigDecimal getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String toString() {
        return "Order{id=" + this.id + ", orderCode='" + this.orderCode + "', userId=" + this.userId + ", productId=" + this.productId + ", quantity=" + this.quantity + ", orderDate=" + this.orderDate + ", status='" + this.status + "', orderDiscountId=" + this.orderDiscountId + ", totalAmount=" + this.totalAmount + "}";
    }
}
