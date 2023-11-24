package com.webbanthuocthuy.model;

import java.sql.Timestamp;

public class ProductReview {
    private int id;
    private int userId;
    private int rating;
    private int orderId;
    private String reviewText;
    private Timestamp reviewDate;
    private String imageUrl;

    // Constructor
    public ProductReview(){

    }
    public ProductReview(int id, int userId, int rating, int orderId, String reviewText,
                         Timestamp reviewDate, String imageUrl) {
        this.id = id;
        this.userId = userId;
        this.rating = rating;
        this.orderId = orderId;
        this.reviewText = reviewText;
        this.reviewDate = reviewDate;
        this.imageUrl = imageUrl;
    }

    // Các phương thức getter và setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Timestamp getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Timestamp reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "ProductReview{" +
                "id=" + id +
                ", userId=" + userId +
                ", rating=" + rating +
                ", orderId=" + orderId +
                ", reviewText='" + reviewText + '\'' +
                ", reviewDate=" + reviewDate +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
