package com.example.myfairlady.UtilityClasses;

import com.example.myfairlady.DataTypes.Fair;
import com.example.myfairlady.DataTypes.Product;
import com.example.myfairlady.DataTypes.Store;
import com.example.myfairlady.DataTypes.User;
import com.example.myfairlady.Managers.StoreManager;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

    public static void main(String[] args) throws SQLException {

        try {
            Database.initDB();
            ResultSet s = Database.query("SELECT * FROM tblstores WHERE category = 'Clothing Agent';");
            //print out the resultset
            while (s.next()){
                System.out.println(s.getString(2));
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        Fair f = new Fair("Murica", null, 10, 10, "Child Welfare", "Open");
//        Store S = new Store("The Can", "Buck", "Toys", null, null, "Murica", "Open");
//        Product p = new Product("Pokemon Booster Pack", "The Can", 75.0, 60.0, "collectibles", 50, 1);
//        StoreManager.addStore(S);

        //method to display all stores with categor clothing agnet




    }

}
