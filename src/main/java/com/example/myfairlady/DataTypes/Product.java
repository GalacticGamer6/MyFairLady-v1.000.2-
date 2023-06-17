package com.example.myfairlady.DataTypes;

public class Product {

    private String name;
    private String store;
    private String fair;
    private double selling_price;
    private double cost_price;
    public String descrption;
    private String category;

    public Product(String name, String store, String fair, double selling_price, double cost_price, String descrption, String category) {
        this.name = name;
        this.store = store;
        this.fair = fair;
        this.selling_price = selling_price;
        this.cost_price = cost_price;
        this.category = category;
        this.descrption = descrption;
    }


    public String getProductName() {
        return name;
    }

    public String getStoreName() {
        return store;
    }

    public String getFairName() {
        return fair;
    }
    public double getSellingPrice() {
        return selling_price;
    }

    public double getCostPrice() {
        return cost_price;
    }

    public String getDescription() {
        return descrption;
    }
    public String getProductCategory() {
        return category;
    }

    public String toString(){

            return ("Product Name: " + this.name + " Store Name: " + this.store + " Fair Name: " + this.fair + " Selling Price: " + this.selling_price + " Cost Price: " + this.cost_price + " Description: " + this.descrption + " Category: " + this.category);
    }
}
