package com.example.myfairlady;

import com.example.myfairlady.UtilityClasses.Database;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.text.Font;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main extends Application{

    public static void main(String[] args) {
        launch();

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

    }


    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MyFairLady v1.000.2");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }


}
