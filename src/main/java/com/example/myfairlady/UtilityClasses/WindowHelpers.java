package com.example.myfairlady.UtilityClasses;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class WindowHelpers {

    public Scene getScene(String file_path) throws IOException {

        //create a url from the file path
        File fxml_file = new File(file_path);
        URL url = fxml_file.toURI().toURL();

        //load the url into the fxml loader
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        Scene scene = new Scene(root);

        return scene;
    }

}
