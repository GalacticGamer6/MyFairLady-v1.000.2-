package com.example.myfairlady.Managers;

import com.example.myfairlady.DataTypes.Fair;
import com.example.myfairlady.UtilityClasses.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class FairManager {

    //adds a fair object to the database by taking in everything except the fair ID
    public static void addFair(String fair_name, String fair_owner_id, LocalDate start_date, LocalDate end_date, double entrance_fee, double fair_profit) throws SQLException {
        String statement = "INSERT INTO tblfairs (fair_name, fair_owner, start_date, end_date, entrance_fee, fair_profit) VALUES ('" + fair_name + "', '" + fair_owner_id + "', '" + start_date + "', '" + end_date + "', '" + entrance_fee + "', '" + fair_profit + "');";
        Database.query(statement);
    }

    public static void deleteFair(String fair_id) throws SQLException {
        String statement = "Delete from tblfairs where FairID = '" + fair_id + "';";
    }

    //just gets all the fairs in the database
    public static ResultSet getFairs() throws SQLException {

        String statement  = "Select * from tblfairs;";
        return Database.query(statement);
    }

    //gets the list of fairs that were created by a specific owner
    public static ResultSet getFairsByOwner(String owner_username) throws SQLException {

        String statement  = "Select * from tblfairs WHERE fair_owner = '" + owner_username + "';";
        return Database.query(statement);
    }

    //gets the fair that is owned by the user that just signed in.
    public static ResultSet getCurrentFair(String username,String password) throws SQLException{
        //hehe used cool subquery so that i dont have to make an obejct out of the login details
        String statement = "Select * from tblfairs where FairOwnerID  = (Select UserID from tblusers where Username = '" + username + "' and Password = '" + password + "');";
        return Database.query(statement);
    }






}
