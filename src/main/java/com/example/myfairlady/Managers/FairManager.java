package com.example.myfairlady.Managers;

import com.example.myfairlady.DataTypes.Fair;
import com.example.myfairlady.DataTypes.Store;
import com.example.myfairlady.UtilityClasses.ChatGPT;
import com.example.myfairlady.UtilityClasses.Database;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static com.example.myfairlady.UtilityClasses.ChatGPT.askChatBot;

public class FairManager {

    //adds a fair object to the database by taking in everything except the fair ID
    public static void addFair(String fair_name, String fair_owner_id, LocalDate start_date, LocalDate end_date, double entrance_fee, double fair_profit) throws SQLException {
        String statement = "INSERT INTO tblfairs (FairName, FairOwnerID, StartDate, EndDate, EntranceFee, TotalProfit) VALUES ('" + fair_name + "', '" + fair_owner_id + "', '" + start_date + "', '" + end_date + "', '" + entrance_fee + "', '" + fair_profit + "');";
        Database.update(statement);
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

    public static Fair returnFairByOwnerID(String OwnerID) throws SQLException {

        String statement = "Select * from tblfairs where FairOwnerID = '" + OwnerID + "'";
        ResultSet rs = Database.query(statement);

        //turn the restultset into a fair object
        rs.next();
        int FairID = rs.getInt("FairID");
        String FairName = rs.getString("FairName");
        String FairOwnerID = rs.getString("FairOwnerID");
        LocalDate StartDate = rs.getDate("StartDate").toLocalDate();
        LocalDate EndDate = rs.getDate("EndDate").toLocalDate();
        double EntranceFee = rs.getDouble("EntranceFee");
        double FairProfit = rs.getDouble("TotalProfit");

        Fair F = new Fair(FairID + "",FairName,FairOwnerID,StartDate,EndDate,EntranceFee,FairProfit);
        return F;
        }

        public static ResultSet getFairByName(String fair_name) throws SQLException {
            String statement = "Select * from tblfairs where FairName = '" + fair_name + "'";
            return Database.query(statement);

        }

        public static void RemoveAStoresProfit(Store s){

            String statement = "Update tblfairs set FairProfit = FairProfit - " + s.getProfit() + " where FairID = '" + s.getFairID() + "';";

        }

        public static String generateName(String themes) throws IOException {

            String query = "Hey chabot, can you generate a name for a fair that revolves around the themes of " + themes + "?";
            return(ChatGPT.askChatBot(query));

        }

        public static void increaseProfit(double increased_amount,String fair_id) throws SQLException {

            String statement = "Update tblfairs set TotalProfit = TotalProfit + " + increased_amount + " where FairID = '" + fair_id + "';";
            Database.update(statement);
        }

        public static void updateFairName(String Fairname, String FairID) throws SQLException {
            String statement = "Update tblfairs set FairName = '" + Fairname + "' where FairID = '" + FairID + "';";
            Database.update(statement);
        }

    public static void updateEntranceFee(String fairID, Double value) {

        String statement = "Update tblfairs set EntranceFee = " + value + " where FairID = '" + fairID + "';";
        try {
            Database.update(statement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}







