package com.example.chadi.androideatitserver.Model;

public class Order {

    private String productId;
    private String productName;
    private String quantity;
    private String discount;
    private String price;

    public Order(String productId, String productName, String quantity, String discount, String price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.discount = discount;
        this.price = price;
    }
    public Order(){}

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
