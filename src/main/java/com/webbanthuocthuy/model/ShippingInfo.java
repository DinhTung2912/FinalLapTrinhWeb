package com.webbanthuocthuy.model;

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

    // Constructor
    public ShippingInfo(){

    }
    public ShippingInfo(int id, int orderId, String trackingNumber, String shippingMethod,
                        BigDecimal shippingCost, String deliveryAddress, Date expectedDeliveryDate,
                        Date shippedDate, Date receivedDate, String status) {
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
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public BigDecimal getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(BigDecimal shippingCost) {
        this.shippingCost = shippingCost;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Date getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ShippingInfo{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", shippingMethod='" + shippingMethod + '\'' +
                ", shippingCost=" + shippingCost +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", expectedDeliveryDate=" + expectedDeliveryDate +
                ", shippedDate=" + shippedDate +
                ", receivedDate=" + receivedDate +
                ", status='" + status + '\'' +
                '}';
    }
}
