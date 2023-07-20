package com.example.myfairlady.Managers;

import com.example.myfairlady.DataTypes.Fair;
import com.example.myfairlady.UtilityClasses.Database;

import java.sql.SQLException;

public class FairManager {

    public static void addFair(Fair f) throws SQLException {

    String fair_name = f.getFair_name();
    String fair_owner_username = f.getFair_owner_username();
    int entrance_fee = f.getEntrance_fee();
    int duration = f.getDuration();
    String status = f.getStatus();

    Database.update("INSERT INTO tblfairs (fair_name, fair_owner, entrance_fee, duration, status) VALUES ('" + fair_name + "', '" + fair_owner_username + "', '" + entrance_fee + "', '" + duration + "', '" + status + "');");
    System.out.println(f.toString());

    }

    public static void deleteFair(Fair f) throws SQLException {

        String fair_name = f.getFair_name();
        String fair_owner_username = f.getFair_owner_username();

        Database.update("DELETE FROM tblfairs WHERE fair_name = '" + fair_name + "' AND fair_owner = '" + fair_owner_username + "';");

    }

    public void getFairProfit(){

//        Database.query("SELECT Sum() ;");

    }



}
