
package com.example.finallaptrinhweb.model;

public class Supplier {
    private int id;
    private String supplierName;
    private String contactName;
    private String email;
    private String phone;
    private String address;
    private int productId;

    public Supplier() {
    }

    public Supplier(int id, String supplierName, String contactName, String email, String phone, String address, int productId) {
        this.id = id;
        this.supplierName = supplierName;
        this.contactName = contactName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.productId = productId;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSupplierName() {
        return this.supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getContactName() {
        return this.contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String toString() {
        return "Supplier{id=" + this.id + ", supplierName='" + this.supplierName + "', contactName='" + this.contactName + "', email='" + this.email + "', phone='" + this.phone + "', address='" + this.address + "', productId=" + this.productId + "}";
    }
}
