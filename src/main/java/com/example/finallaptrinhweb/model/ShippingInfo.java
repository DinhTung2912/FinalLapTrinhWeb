package com.example.finallaptrinhweb.model;

import java.math.BigDecimal;
import java.sql.Date;

public class ShippingInfo {
    private int id;
    private BigDecimal shippingCost;
    private Date dateCreated;
    private double weight;

    public ShippingInfo() {
    }

    public ShippingInfo(int id, BigDecimal shippingCost, Date dateCreated, double weight) {
        this.id = id;
        this.shippingCost = shippingCost;
        this.dateCreated = dateCreated;
        this.weight = weight;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getShippingCost() {
        return this.shippingCost;
    }

    public void setShippingCost(BigDecimal shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "ShippingInfo{id=" + this.id + ", shippingCost=" + this.shippingCost + ", dateCreated=" + this.dateCreated + ", weight=" + this.weight + "}";
    }
}
