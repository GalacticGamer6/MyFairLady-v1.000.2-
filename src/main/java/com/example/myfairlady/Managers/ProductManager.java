package com.example.myfairlady.Managers;

import com.example.myfairlady.DataTypes.Product;
import com.example.myfairlady.UtilityClasses.Database;

import java.sql.SQLException;

public class ProductManager {

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

    public static void deleteProduct(Product p) throws SQLException {
        //primary key should be product name + store name + fair name
        String product_name = p.getProductName();
        String store_name = p.getStoreName();
        String fair_name = p.getFairName();

        Database.update("DELETE FROM tblproducts WHERE product_name = '" + product_name + "' AND store = '" + store_name + "' AND fair = '" + fair_name + "';");

    }

}
