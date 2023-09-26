package com.example.myfairlady.DataTypes;

import java.sql.Date;
import java.time.LocalDate;

public class Sale{

    private String sale_id;
    private String product_id;
    private LocalDate date;

    public Sale(String sale_id, String product_id, LocalDate date){
        this.sale_id = sale_id;
        this.product_id = product_id;
        this.date = date;
    }

    public String getSaleID(){
        return sale_id;
    }
    public String getProductID(){
        return product_id;
    }
    public LocalDate getDate(){
        return date;
    }


}