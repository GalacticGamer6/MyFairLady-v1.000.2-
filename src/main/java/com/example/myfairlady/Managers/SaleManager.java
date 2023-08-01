package com.example.myfairlady.Managers;

import com.example.myfairlady.DataTypes.Product;
import com.example.myfairlady.UtilityClasses.Database;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SaleManager {

    public static void getSalesByStore(String storeName) throws SQLException {

        String statement = "SELECT * FROM tblsales WHERE store_name = '" + storeName + "';";
        System.out.println(Database.toString(Database.query(statement)));

    }

    public static String getSalesByStoreAndDate(String storeName, String date) throws SQLException {

        String statement = "SELECT * FROM tblsales WHERE storeName = '" + storeName + "' AND date = '" + date + "';";
        return Database.toString(Database.query(statement));

    }

    public static void addSale(Product p) throws SQLException {

        //prepping to get the current itme of the sale
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String time = formatter.format(now);

        String statement = "Insert into tbsales (product_name, store_name, fair_name, date) VALUES ('" + p.getProductName() + "', '" + p.getStoreName() + "', '" + p.getFairName() + "', '" + time + "');";
    }




}
