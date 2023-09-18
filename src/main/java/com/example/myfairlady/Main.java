package com.example.myfairlady;

import com.example.myfairlady.DataTypes.Fair;
import com.example.myfairlady.DataTypes.User;
import com.example.myfairlady.Managers.FairManager;
import com.example.myfairlady.Managers.SaleManager;
import com.example.myfairlady.Managers.UserManager;
import com.example.myfairlady.SceneController.StoreControllers.ScreenGeneral;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main extends Application{

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InterruptedException {

        launch();





    }


    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MyFairLady v1.000.2");
        primaryStage.getIcons().add(new javafx.scene.image.Image("file:src/main/resources/Login Images And Icons/Ferris Wheel 256x.png"));
        primaryStage.show();

    }


}
