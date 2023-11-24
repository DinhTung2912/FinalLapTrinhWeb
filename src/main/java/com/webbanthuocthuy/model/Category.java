package com.webbanthuocthuy.model;

public class Category {
    private int id;
    private String categoryName;
    private boolean active;

    // Constructor
    public Category(){

    }
    public Category(int id, String categoryName, boolean active) {
        this.id = id;
        this.categoryName = categoryName;
        this.active = active;
    }

    // Các phương thức getter và setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", active=" + active +
                '}';
    }
}
