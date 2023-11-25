
package com.example.finallaptrinhweb.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Bill {
    private int id;
    private int orderId;
    private String paymentMethod;
    private BigDecimal totalAmount;
    private String paymentStatus;
    private Timestamp paymentDate;
    private String status;

    public Bill() {
    }

    public Bill(int id, int orderId, String paymentMethod, BigDecimal totalAmount, String paymentStatus, Timestamp paymentDate, String status) {
        this.id = id;
        this.orderId = orderId;
        this.paymentMethod = paymentMethod;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDate;
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentStatus() {
        return this.paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Timestamp getPaymentDate() {
        return this.paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return "Bill{id=" + this.id + ", orderId=" + this.orderId + ", paymentMethod='" + this.paymentMethod + "', totalAmount=" + this.totalAmount + ", paymentStatus='" + this.paymentStatus + "', paymentDate=" + this.paymentDate + ", status='" + this.status + "'}";
    }
}
