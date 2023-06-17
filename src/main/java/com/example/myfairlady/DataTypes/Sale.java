package com.example.myfairlady.DataTypes;

import java.util.Date;

public class Sale {

    private Product[] items_sold;
    private Date date_of_sale;
    private Store store;

    public Sale(Product[] items_sold, Date date_of_sale, Store store) {
        this.items_sold = items_sold;
        this.date_of_sale = date_of_sale;
        this.store = store;
    }

    public Product[] getItems_sold() {
        return items_sold;
    }

    public Date getDate_of_sale() {
        return date_of_sale;
    }

    public Store getStore() {
        return store;
    }
}
