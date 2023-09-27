package com.example.myfairlady.Managers;

import com.example.myfairlady.DataTypes.Product;
import com.example.myfairlady.UtilityClasses.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductManager {

    //add a product to the database
    public static void addProduct(String product_name,String store_id,Double selling_price, Double cost_price,String description,String category,int quantity) throws SQLException {

        String statement = "INSERT INTO tblproducts (ProductName,StoreID,SellingPrice,CostPrice,Description,Category,Quantity) VALUES ('" + product_name + "','" + store_id + "'," + selling_price + "," + cost_price + ",'" + description + "','" + category + "'," + quantity + ");";
        Database.update(statement);

    }

    //takes in object from the observable list
    public static void deleteProduct(Product p) throws SQLException {

        String statement = "DELETE FROM tblproducts WHERE ProductID = " + p.getProductID();
        Database.update(statement);

    }


    public static ResultSet getProductsByStore(String store_id) throws SQLException {

        String statement = "Select * from tblproducts where StoreID = '" + store_id + "'";
        ResultSet rs = Database.query(statement);
        return rs;
    }

    public static void updateProductQuantity(Product p, int updated_quantity) throws SQLException {

        String statement = "UPDATE tblproducts SET quantity = " + updated_quantity + " WHERE ProductID = " + p.getProductID();
        Database.update(statement);

    }

    public static ResultSet getProductByID(String product_id) throws SQLException {

        String statement = "Select * from tblproducts where ProductID = '" + product_id + "'";
        ResultSet rs = Database.query(statement);
        return rs;
    }







}
