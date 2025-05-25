package org.vivaplus.model.bean;

import org.vivaplus.model.enums.Prescription;

import java.util.Date;

public class Drug {
    private String id;
    private String product;
    private int quantity;
    private Double price;
    private Prescription prescription;
    private String batch;
    private Date expiration_date;
    private int last_modified;
    private User user; // Chave estrangeira para User

    public Drug(String id, String product, int quantity, Double price, Prescription prescription, String batch, Date expiration_date, int last_modified, User user) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.prescription = prescription;
        this.batch = batch;
        this.expiration_date = expiration_date;
        this.last_modified = last_modified;
        this.user = user;
    }

    public Drug() {

    }

    // Getters e Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    public int getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(int last_modified) {
        this.last_modified = last_modified;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
