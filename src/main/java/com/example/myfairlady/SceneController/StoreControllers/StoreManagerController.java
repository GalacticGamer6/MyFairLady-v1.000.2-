package com.example.myfairlady.SceneController.StoreControllers;

import com.example.myfairlady.App;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class StoreManagerController implements Initializable{

    @FXML
    private Button products_list_button;

    @FXML
    private Button sales_button;

    @FXML
    private Button stats_button;

    @FXML
    private Button alerts_button;

    @FXML
    private Button store_settings_button;


    @FXML
    private Label clock_label;


    public void ButtoSaleButtonPressed() throws IOException {
        System.out.println("Sale button pressed");
        switchToSalesScreen();
    }

    public void switchToStoreProductListScreen() throws IOException {

        //create a url from the file path
        File fxml_file = new File("src/main/resources/com/example/myfairlady/StoreScreens/StoreProductListScreen.fxml");
        URL url = fxml_file.toURI().toURL();

        //load the url into the fxml loader
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        Scene scene = new Scene(root);

        App.getPrimaryStage().setScene(scene);
        App.getPrimaryStage().show();
    }

    public void switchToSalesScreen() throws IOException {

        //create a url from the file path
        File fxml_file = new File("src/main/resources/com/example/myfairlady/StoreScreens/StoreSalesScreen.fxml");
        URL url = fxml_file.toURI().toURL();

        //load the url into the fxml loader
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        Scene scene = new Scene(root);

        App.getPrimaryStage().setScene(scene);
        App.getPrimaryStage().show();
    }

    public void switchToStoreStatsScreen(ActionEvent e) throws IOException {

        //create a url from the file path
        File fxml_file = new File("src/main/resources/com/example/myfairlady/StoreScreens/StoreStatsScreen.fxml");
        URL url = fxml_file.toURI().toURL();

        //load the url into the fxml loader
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void switchToStoreAlertsScreen(ActionEvent e) throws IOException {

        //create a url from the file path
        File fxml_file = new File("src/main/resources/com/example/myfairlady/StoreScreens/StoreAlertsScreen.fxml");
        URL url = fxml_file.toURI().toURL();

        //load the url into the fxml loader
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void switchToStoreSettingsScreen(ActionEvent e) throws IOException {

        //create a url from the file path
        File fxml_file = new File("src/main/resources/com/example/myfairlady/StoreScreens/StoreSettingsScreen.fxml");
        URL url = fxml_file.toURI().toURL();

        //load the url into the fxml loader
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //ChatGPT's Code
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                Platform.runLater(() -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    LocalTime time = LocalTime.now();
                    clock_label.setText(formatter.format(time));
                });
            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000);

    }
}
