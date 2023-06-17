package com.example.myfairlady.DataTypes;


public class Store {

    private String store_name;
    private String category;
    private Product[] list_of_products;
    private Sale [] list_of_sales;
    private String fair_name;
    private String status;

    private String store_owner;

    public Store(String store_name,String store_owner, String category, Product[] list_of_products, Sale[] list_of_sales, String fair_name, String status){
        this.store_name = store_name;
        this.category = category;
        this.list_of_products = list_of_products;
        this.list_of_sales = list_of_sales;
        this.fair_name = fair_name;
        this.status = status;
        this.store_owner = store_owner;
    }

    public String getStore_name() {
        return store_name;
    }

    public String getCategory() {
        return category;
    }

    public Product[] getList_of_products() {
        return list_of_products;
    }

    public Sale[] getList_of_sales() {
        return list_of_sales;
    }

    public String getFair_name() {
        return fair_name;
    }

    public String getStatus() {
        return status;
    }

    public String getStore_owner() {
        return store_owner;
    }
}
