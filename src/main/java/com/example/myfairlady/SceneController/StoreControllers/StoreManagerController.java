package com.example.myfairlady.SceneController.StoreControllers;

import com.example.myfairlady.App;
import com.example.myfairlady.DataTypes.Store;
import com.example.myfairlady.DataTypes.User;
import com.example.myfairlady.Managers.StoreManager;
import com.example.myfairlady.Managers.UserManager;
import com.example.myfairlady.UtilityClasses.ChatGPT;
import com.example.myfairlady.UtilityClasses.ScreenGeneral;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class StoreManagerController implements Initializable{

    public static Store current_store;

    @FXML
    private Label motivational_quote_label;
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


    public void switchToStoreProductListScreen() throws IOException {
        ScreenGeneral.switchScreen(ScreenGeneral.StoreProductsListScreenLocation);
    }

    public void switchToSalesScreen() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.StoreSalesScreenLocation);
    }

    public void switchToStoreStatsScreen() throws IOException {

    ScreenGeneral.switchScreen(ScreenGeneral.StoreStatsScreenLocation);
    }



    public void switchToStoreSettingsScreen() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.StoreSettingsScreenLocation);

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

        try {
            motivational_quote_label.setText(StoreManager.generateMotivationalquote());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
