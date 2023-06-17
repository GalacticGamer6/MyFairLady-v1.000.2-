//package com.example.myfairlady;
//
//import com.example.myfairlady.UtilityClasses.Database;
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.scene.layout.AnchorPane;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.net.URL;
//import java.sql.SQLException;
//
//public class Main extends Application {
//
//
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//
//        Database.initDB();
//
//        launch(args);
//    }
//    @Override
//    public void start(Stage stage) throws IOException, SQLException {
//
//        URL location = getClass().getResource("LoginScreen.fxml");
//        System.out.println(location);
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//
//    }
//
//}
