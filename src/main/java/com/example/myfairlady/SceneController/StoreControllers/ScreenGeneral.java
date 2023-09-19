package com.example.myfairlady.SceneController.StoreControllers;

import javafx.scene.control.Label;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ScreenGeneral {

    public static void set_clock(Label label) throws InterruptedException {

        while(true){
            LocalTime time = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String current_time = time.format(formatter);
            Thread.sleep(1000);
            label.setText(current_time);

        }


    }


}
