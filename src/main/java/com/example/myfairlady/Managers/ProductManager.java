package com.example.myfairlady.Managers;

import com.example.myfairlady.DataTypes.Product;
import com.example.myfairlady.UtilityClasses.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductManager {

    //adds a product object to the database
    public static void addProduct(Product product) throws SQLException {

        String product_name = product.getProductName();
        String store_name = product.getStoreName();
        String fair_name = product.getFairName();
        double selling_price = product.getSellingPrice();
        double cost_price = product.getCostPrice();
        String description = product.getDescription();
        String category = product.getProductCategory();

        Database.update("INSERT INTO tblproducts (product_name, store, fair, selling_price, cost_price, description, category) VALUES ('" + product_name + "', '" + store_name + "', '" + fair_name + "', '" + selling_price + "', '" + cost_price + "', '" + description + "', '" + category + "')");

    }

    //deletes a product object from the database
    public static void deleteProduct(Product p) throws SQLException {
        //primary key should be product name + store name + fair name
        String product_name = p.getProductName();
        String store_name = p.getStoreName();
        String fair_name = p.getFairName();

        Database.update("DELETE FROM tblproducts WHERE product_name = '" + product_name + "' AND store = '" + store_name + "' AND fair = '" + fair_name + "';");

    }

    //gets all the products of a particular store , takes in the store name (Should rather take in the store object)
    public static ResultSet searchProductByStoreName(String store_name) throws SQLException {

        ResultSet s = Database.query("SELECT * FROM tblproducts WHERE store = '" + store_name + "';");

        return s;
    }
    //takes in the store name and a dedicated category(From UI) that will be used to search for products in that category in that store
    public static void searchProductByCategoryAndStore(String product_category,String store_name) throws SQLException {

        String statement = "Select * FROM tblproducts WHERE category = '" + product_category + "' AND store = '" + store_name + "';";

    }

    public static void searchproductByPriceASC(String store_name, String fair_name) throws SQLException {

        ResultSet s = Database.query("SELECT * FROM tblproducts WHERE store = '" + store_name + "' AND fair = '" + fair_name + "' ORDER BY selling_price ASC;");
    }

    //lists the products in a descending order based on price in a particular store
    public static void searchproductByPriceDESC(String store_name, String fair_name) throws SQLException {

        ResultSet s = Database.query("SELECT * FROM tblproducts WHERE store = '" + store_name + "' AND fair = '" + fair_name + "' ORDER BY selling_price DESC;");
    }





}
