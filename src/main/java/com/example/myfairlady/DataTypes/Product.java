package com.example.myfairlady.DataTypes;

public class Product {

    private String product_number;
    private String name;
    private String store_id;
    private String fair_id;
    private double selling_price;
    private double cost_price;
    public String descrption;
    private String category;
    private int quantity;

//create a constructor which takes in all the fields
    public Product(String product_number, String name, String store_id, String fair_id, double selling_price, double cost_price, String descrption, String category, int quantity) {
        this.product_number = product_number;
        this.name = name;
        this.store_id = store_id;
        this.fair_id = fair_id;
        this.selling_price = selling_price;
        this.cost_price = cost_price;
        this.descrption = descrption;
        this.category = category;
        this.quantity = quantity;
    }


    public String getProductName() {
        return name;
    }

    public String getStoreID() {
        return store_id;
    }

    public String getFairID() {
        return fair_id;
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
    public String getProductNumber() {
        return product_number;
    }
    public int getQuantity() {
        return quantity;
    }

}
