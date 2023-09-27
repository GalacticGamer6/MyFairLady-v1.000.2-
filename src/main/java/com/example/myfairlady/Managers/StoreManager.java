package com.example.myfairlady.Managers;
import com.example.myfairlady.DataTypes.Fair;
import com.example.myfairlady.DataTypes.Store;
import com.example.myfairlady.UtilityClasses.ChatGPT;
import com.example.myfairlady.UtilityClasses.Database;

import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StoreManager {

    public static ResultSet getStores(String FairID) throws SQLException {

        String statement = "Select * from tblstores where FairID = '" + FairID + "'";
        System.out.println(statement);
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
        String statement = "UPDATE tblstores SET Profit = Profit  + " + (profit) + " WHERE StoreID = '" + s.getStoreID() + "'";
        Database.update(statement);

        //we then need to increase the fair profit
        String statment = "UPDATE tblfairs SET TotalProfit = TotalProfit + " + (profit) + " WHERE FairID = '" + s.getFairID() + "'";
    }

    public static String generateMotivationalquote() throws IOException {

        return ChatGPT.askChatBot("Generate a random motivational quote in the style of a successful business person giving advice to a novice store owner limit your response to 30 words or less");


    }
    public static ResultSet getStoreByID(String storeID) throws SQLException {

        String statement = "Select * from tblstores where StoreID = '" + storeID + "'";
        return Database.query(statement);

    }

    public static void updateStoreName(String storeID, String updated_name) throws SQLException {

        String statement = "Update tblstores set StoreName = '" + updated_name + "' where StoreID = '" + storeID + "'";
        Database.update(statement);

    }

    public static void changeFairs(String storeID,Fair new_fair) throws SQLException {

        String statement = "Update tblstores set FairID = '" + new_fair.getFairID() + "' where StoreID = '" + storeID + "'";
        Database.update(statement);
    }

    public static void updateStoreCategory(String storeID, String updated_category) throws SQLException {

        String statement = "Update tblstores set category = '" + updated_category + "' where StoreID = '" + storeID + "'";
        Database.update(statement);

    }

    public static ResultSet getStoreByName(String store_name) throws SQLException {

        String statement = "Select * from tblstores where StoreName = '" + store_name + "'";
        return Database.query(statement);

    }

    public static void ResetStoreProfit(String storeID) throws SQLException {

        String statement = "Update tblstores set Profit = 0 where StoreID = '" + storeID + "'";
        Database.update(statement);

    }

    public static void DeleteStore(Store s){

        String statement = "DELETE FROM tblstores WHERE StoreID = '" + s.getStoreID() + "'";


    }

    public static void addStore(String store_name, String ownerID, String fairID, String category, String status, Double profit) throws SQLException {

        String statement = "INSERT INTO tblstores (StoreName, OwnerID, FairID, Category, Status, Profit) VALUES ('" + store_name + "','" + ownerID + "','" + fairID + "','" + category + "','" + status + "',0)";
        Database.update(statement);

    }





}
