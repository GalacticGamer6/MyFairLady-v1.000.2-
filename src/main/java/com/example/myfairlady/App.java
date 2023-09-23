package com.example.myfairlady;

import com.example.myfairlady.UtilityClasses.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class App extends Application{
    //we'll be saving the stage in this to be used across the app.
    private static Stage primaryStage;

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InterruptedException {


        Database.initDB();
        launch();






    }


    //main entry point into the app
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MyFairLady v1.000.2");
        primaryStage.getIcons().add(new javafx.scene.image.Image("file:src/main/resources/Login Images And Icons/Ferris Wheel 256x.png"));
        primaryStage.show();

    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }


}
