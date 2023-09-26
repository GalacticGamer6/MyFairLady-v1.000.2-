package com.example.myfairlady.SceneController.StoreControllers;

import com.example.myfairlady.UtilityClasses.ScreenGeneral;
import javafx.stage.FileChooser;

import java.io.IOException;

public class StoreSettingsController {

    public void backButtonClicked() throws IOException {
        ScreenGeneral.switchScreen(ScreenGeneral.StoreManagerMainScreenLocation);
    }


//    public void uploadPictureButtonClicked() throws IOException {
//        //open a file chooser
//        //upload the picture to the database
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Select the picture you want to upload");
//        fileChooser.getExtensionFilters().addAll(
//                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
//        fileChooser.showOpenDialog(ScreenGeneral.getStage());
//
//    }
}
