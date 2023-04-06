package com.example.myfairlady.DataTypes;

public class Product {

    private String name;
    private String store;
    private double selling_price;
    private double cost_price;
    private String category;
    private int quantity;
    private int num_sold;

    public String getProductName() {
        return name;
    }

    public void setProductName(String name) {
        this.name = name;
    }

    public String getStoreName() {
        return store;
    }

    public void setStoreName(String store) {
        this.store = store;
    }

    public double getSellingPrice() {
        return selling_price;
    }

    public void setSellingPrice(double selling_price) {
        this.selling_price = selling_price;
    }

    public double getCostPrice() {
        return cost_price;
    }

    public void setCostPrice(double cost_price) {
        this.cost_price = cost_price;
    }

    public String getProductCategory() {
        return category;
    }

    public void setProductCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getNumSold() {
        return num_sold;
    }

    public void setNumSold(int num_sold) {
        this.num_sold = num_sold;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", store='" + store + '\'' +
                ", selling_price=" + selling_price +
                ", cost_price=" + cost_price +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                ", num_sold=" + num_sold +
                '}';
    }
}
