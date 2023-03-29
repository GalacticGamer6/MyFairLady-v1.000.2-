package com.example.myfairlady.SceneController;

import com.example.myfairlady.HelloApplication;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginScreenController extends Application {

    Image icon = new Image("MyFairLadyIcon.png");

    @FXML
    private Pane right_pane;

    //To start the actual app
    public static void main(String[] args) {
        launch();
    }

    //fetches the fxml login file and sets it up
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoginScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.getIcons().add(icon);
        stage.setTitle("MyFairLady v1.000.2");
        stage.setScene(scene);
        stage.show();
    }


}

