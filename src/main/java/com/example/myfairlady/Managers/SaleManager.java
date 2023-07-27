package com.example.myfairlady.Managers;

public class SaleManager {

    public void getSalesByStore(String storeName) {

        String statement = "SELECT * FROM tblsales WHERE storeName = '" + storeName + "';";

    }

    public void getSalesByStoreAndDate(String storeName, String date) {
        String statement = "SELECT * FROM tblsales WHERE storeName = '" + storeName + "' AND date = '" + date + "';";
    }

}
