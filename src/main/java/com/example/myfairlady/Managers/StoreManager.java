package com.example.myfairlady.Managers;
import com.example.myfairlady.DataTypes.Fair;
import com.example.myfairlady.DataTypes.Store;
import com.example.myfairlady.UtilityClasses.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StoreManager {

    public static void addStore(Store s) throws SQLException, SQLException {

        String store_name = s.getStore_name();
        String category = s.getCategory();
        String fair_name = s.getFair_name();
        String status = s.getStatus();
        String store_owner = s.getStore_owner();

        Database.update("INSERT INTO tblstores (store_name, category, fair, status, owner) VALUES ('" + store_name + "', '" + category + "', '" + fair_name + "', '" + status + "', '" + store_owner + "');");

    }

    public static void deleteStore(Store s) throws SQLException {

        //primary key can be store name + fair_name + store_owner

        String store_name = s.getStore_name();
        String fair_name = s.getFair_name();

        Database.update("DELETE FROM tblstores WHERE store_name = '" + store_name + "' AND fair = '" + fair_name  + "';");

    }

    public static void deleteStoresByFair(Fair f){

        String fair_name = f.getFair_name();
        String statement = "DELETE FROM tblstores WHERE fair = '" + fair_name + "';";

    }

    public void searchStoresByNames(String store_name,String fair_name) throws SQLException {

        ResultSet s = Database.query("SELECT * FROM tblstores WHERE store_name = '" + store_name + "';");

    }

    public void searchStoresByNamesAndFair(String store_name,String fair_name) throws SQLException {

        ResultSet s = Database.query("SELECT * FROM tblstores WHERE store_name = '" + store_name + "';");

    }

    public void searchStoresByCategory(String category,String fair_name) throws SQLException {

        ResultSet s = Database.query("SELECT * FROM tblstores WHERE category = '" + category + "';");

    }

    public void searchStoresByOwner(String owner_username,String fair_name)throws SQLException{

        ResultSet s = Database.query("SELECT * FROM tblstores WHERE owner = '" + owner_username + "';");

    }

    public void searchStoresByStatus(String status,String fair_name)throws SQLException{

        ResultSet s = Database.query("SELECT * FROM tblstores WHERE status = '" + status + "';");

    }




}
