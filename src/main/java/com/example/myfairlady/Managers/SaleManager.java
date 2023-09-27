package com.example.myfairlady.Managers;

import com.example.myfairlady.DataTypes.Product;
import com.example.myfairlady.DataTypes.Sale;
import com.example.myfairlady.UtilityClasses.Database;
import javafx.scene.control.Alert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class SaleManager {

    //gonna have to join tables to keep things clean
    public ResultSet getSalesByStore(String store_id) throws SQLException {
        String statement = "SELECT * FROM tblsales and tblproducts WHERE tblsales.product_id = tblproducts.product_id AND tblproducts.store_id = " + store_id;
        ResultSet rs = Database.query(statement);
        return rs;
    }

    //takes in a product, which has a product_id
    public static void AddSale(Product p) throws SQLException {

        //firt we check if the is enough quantity of product to sell
        if(p.getQuantity() == 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("OUT OF STOCK");
            alert.setContentText("There is not enough quantity of this product to sell");
            alert.showAndWait();
            return;
        }
        else {
            String product_id = p.getProductID();
            //cause we only want the current date
            LocalDate date = LocalDate.now();

            System.out.println("Date sold" + date.toString());
            String statement = "INSERT INTO tblsales (ProductID, DateSold) VALUES (" + product_id + ", " + "'2023-09-26'" + ");";
            Database.update(statement);

            //when making a sale, the quantity of the profuct has to decrease by 1
            System.out.println("We break here");
            int quantity = p.getQuantity();
            quantity--;
            p.setQuantity(quantity);
            ProductManager.updateProductQuantity(p, quantity);
        }

    }



}
