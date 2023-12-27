package com.example.finallaptrinhweb.model;

public class ProductGroups {
    private int id;
    private String groupName;
    private String description;
    private boolean active;

    public ProductGroups(int id, String groupName, String description, boolean active) {
        this.id = id;
        this.groupName = groupName;
        this.description = description;
        this.active = active;
    }

    public ProductGroups() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "ProductGroups{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
                '}';
    }
}
