package com.example.myfairlady.SceneController.AdminControllers;

import com.example.myfairlady.SceneController.StoreControllers.ScreenGeneral;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminHomeController implements Initializable {

    @FXML
    private Label clock_label;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        System.out.println("This screen has been intialized!");

        try {
            ScreenGeneral.set_clock(clock_label);
        } catch (InterruptedException e) {
            System.out.println("Generic error displaying clock label");
        }

    }

    public void intializeTable(){
        //add handling code  here
    }

    //we need to makle a pretty ui
}
