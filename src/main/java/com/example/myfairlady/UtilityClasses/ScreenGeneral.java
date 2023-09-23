package com.example.myfairlady.UtilityClasses;

import com.example.myfairlady.App;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class ScreenGeneral {

    //String path for all the store related fxml files
    public static String StoreManagerMainScreenLocation = "src/main/resources/com/example/myfairlady/StoreScreens/StoreManagerMain.fxml";
    public static String StoreProductsListScreenLocation = "src/main/resources/com/example/myfairlady/StoreScreens/StoreProductListScreen.fxml";
    public static String StoreSalesScreenLocation = "src/main/resources/com/example/myfairlady/StoreScreens/StoreSalesScreen.fxml";
    public static String StoreStatsScreenLocation = "src/main/resources/com/example/myfairlady/StoreScreens/StoreStatsScreen.fxml";
    public static String StoreSettingsScreenLocation = "src/main/resources/com/example/myfairlady/StoreScreens/StoreSettingsScreen.fxml";

    //String path for all the admin related Store Screens
    public static String AdminAccountScreenLocation = "src/main/resources/com/example/myfairlady/AdminScreens/AdminAccountScreen.fxml";

    public static void Clock(Label label){

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                Platform.runLater(() -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    LocalTime time = LocalTime.now();
                    label.setText(formatter.format(time));
                });
            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000);


    }

    public static void switchScreen(String file_path) throws IOException {

        //create a url from the file path
        File fxml_file = new File(file_path);
        URL url = fxml_file.toURI().toURL();

        //load the url into the fxml loader
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        Scene scene = new Scene(root);

        App.getPrimaryStage().setScene(scene);
        App.getPrimaryStage().show();

    }




}
