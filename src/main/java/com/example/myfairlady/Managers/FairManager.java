package com.example.myfairlady.Managers;

import com.example.myfairlady.DataTypes.Fair;
import com.example.myfairlady.UtilityClasses.Database;

import java.sql.ResultSet;
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

        //if we delete a fair, we should also delete all the stores associated with that fair
        StoreManager.deleteStoresByFair(f);

    }

    public static ResultSet getFairs() throws SQLException {

        String statement  = "Select * from tblfairs;";
        return Database.query(statement);
    }

    public static ResultSet getFairsByOwner(String owner_username) throws SQLException {

        String statement  = "Select * from tblfairs WHERE fair_owner = '" + owner_username + "';";
        return Database.query(statement);
    }

    public static ResultSet getFairsByStatus(String status) throws SQLException {

        String statement  = "Select * from tblfairs WHERE status = '" + status + "';";
        return Database.query(statement);
    }





}
