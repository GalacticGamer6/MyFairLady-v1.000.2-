package com.example.myfairlady.DataTypes;

import java.util.Date;

public class Sale {

    private Product item_sold;
    private Date date_of_sale;
    private Store store;
    private Fair fair;


    public Sale(Product item_sold, Date date_of_sale, Store store,Fair fair) {
        this.item_sold = item_sold;
        this.date_of_sale = date_of_sale;
        this.store = store;
        this.fair = fair;
    }

    public Product getItem_sold() {
        return item_sold;
    }

    public Date getDate_of_sale() {
        return date_of_sale;
    }

    public Store getStore() {
        return store;
    }

    public Fair getFair() { return fair; }
}
