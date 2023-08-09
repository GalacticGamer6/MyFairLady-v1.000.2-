package com.example.myfairlady.SceneController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StoreManagerController implements Initializable{

    @FXML
    private Circle store_image_circle;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String store_logo_file_path = "C:\\Users\\Neeraav Ranjit\\IdeaProjects\\MyFairLady-v1.000.2-\\src\\main\\resources\\StoreManagerMainScreen\\the_body_shop_example.png";
        Image store_image = new Image(store_logo_file_path,false);
        store_image_circle.setFill(new ImagePattern(store_image));


    }

//    public void switchToStoreProductListScreen(ActionEvent e) throws IOException {
//
//        //create a url from the file path
//        File fxml_file = new File("src/main/resources/com/example/myfairlady/StoreProductListScreen.fxml");
//        URL url = fxml_file.toURI().toURL();
//
//        //load the url into the fxml loader
//        FXMLLoader loader = new FXMLLoader(url);
//        Parent root = loader.load();
//        Scene scene = new Scene(root);
//
//        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();
//    }
}
