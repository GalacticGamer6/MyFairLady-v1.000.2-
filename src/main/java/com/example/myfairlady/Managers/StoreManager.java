package com.example.myfairlady.Managers;
import com.example.myfairlady.DataTypes.Fair;
import com.example.myfairlady.DataTypes.Store;
import com.example.myfairlady.UtilityClasses.ChatGPT;
import com.example.myfairlady.UtilityClasses.Database;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StoreManager {

    public static ResultSet getStores(String FairID) throws SQLException {

        String statement = "Select * from tblstores where FairID = '" + FairID + "'";
        return Database.query(statement);
    }

    public static Store ReturnStoreByOwnerID(String OwnerID) throws SQLException {

        String statement = "Select * from tblstores where OwnerID = '" + OwnerID + "'";
        ResultSet rs = Database.query(statement);

        //turn the resultset into a store object
        rs.next();
        String StoreID = rs.getString("StoreID");
        String StoreName = rs.getString("StoreName");
        String current_owner_id = rs.getString("OwnerID");
        String FairID = rs.getString("FairID");
        String category = rs.getString("Category");
        String status = rs.getString("Status");
        Double profit = rs.getDouble("Profit");

        Store s = new Store(StoreID,StoreName,current_owner_id,FairID,category,status,profit);
        return s;
    }

    public static void updateStoreProfit(Store s, Double profit) throws SQLException {
        String statement = "UPDATE tblstores SET Profit = " + (s.getProfit() + profit) + " WHERE StoreID = '" + s.getStoreID() + "'";
        Database.update(statement);
    }

    public static String generateMotivationalquote() throws IOException {

        return ChatGPT.askChatBot("Generate a random motivational quote in the style of a successful business person giving advice to a novice store owner limit your response to 30 words or less");


    }






}
