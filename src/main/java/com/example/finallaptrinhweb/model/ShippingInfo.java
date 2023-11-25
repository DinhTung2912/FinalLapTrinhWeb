
package com.example.finallaptrinhweb.model;

import java.math.BigDecimal;
import java.sql.Date;

public class ShippingInfo {
    private int id;
    private int orderId;
    private String trackingNumber;
    private String shippingMethod;
    private BigDecimal shippingCost;
    private String deliveryAddress;
    private Date expectedDeliveryDate;
    private Date shippedDate;
    private Date receivedDate;
    private String status;

    public ShippingInfo() {
    }

    public ShippingInfo(int id, int orderId, String trackingNumber, String shippingMethod, BigDecimal shippingCost, String deliveryAddress, Date expectedDeliveryDate, Date shippedDate, Date receivedDate, String status) {
        this.id = id;
        this.orderId = orderId;
        this.trackingNumber = trackingNumber;
        this.shippingMethod = shippingMethod;
        this.shippingCost = shippingCost;
        this.deliveryAddress = deliveryAddress;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.shippedDate = shippedDate;
        this.receivedDate = receivedDate;
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

    public String getTrackingNumber() {
        return this.trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getShippingMethod() {
        return this.shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public BigDecimal getShippingCost() {
        return this.shippingCost;
    }

    public void setShippingCost(BigDecimal shippingCost) {
        this.shippingCost = shippingCost;
    }

    public String getDeliveryAddress() {
        return this.deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Date getExpectedDeliveryDate() {
        return this.expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public Date getShippedDate() {
        return this.shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Date getReceivedDate() {
        return this.receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return "ShippingInfo{id=" + this.id + ", orderId=" + this.orderId + ", trackingNumber='" + this.trackingNumber + "', shippingMethod='" + this.shippingMethod + "', shippingCost=" + this.shippingCost + ", deliveryAddress='" + this.deliveryAddress + "', expectedDeliveryDate=" + this.expectedDeliveryDate + ", shippedDate=" + this.shippedDate + ", receivedDate=" + this.receivedDate + ", status='" + this.status + "'}";
    }
}
