package com.example.myfairlady.SceneController;

import com.example.myfairlady.App;
import com.example.myfairlady.Managers.UserManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginScreenController {

    @FXML
    private Button login_button;

    @FXML
    private TextField password_field;

    @FXML
    private Label title_label;

    @FXML
    private TextField username_field;


    @FXML
    public void switchToStoreManagerScreen() throws IOException {

        //create a url from the file path
        File fxml_file = new File("src/main/resources/com/example/myfairlady/StoreScreens/StoreManagerMain.fxml");
        URL url = fxml_file.toURI().toURL();

        //load the url into the fxml loader
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        Scene scene = new Scene(root);

        App.getPrimaryStage().setScene(scene);
        App.getPrimaryStage().show();


    }

    public void switchToAdminManagerScreen() throws IOException {

        File fxml_file = new File("src/main/resources/com/example/myfairlady/AdminScreens/AdminHomeScreen.fxml");
        URL url = fxml_file.toURI().toURL();

        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        Scene scene = new Scene(root);

        App.getPrimaryStage().setScene(scene);
        App.getPrimaryStage().show();

    }

    public void LoginButtonClicked() throws IOException, SQLException {

        //get the username and password from the text fields
        String username = username_field.getText();
        String password = password_field.getText();

        //perform the login sequence
        performLoginSequence(username, password);

    }

    public void performLoginSequence(String username, String password) throws SQLException, IOException {

        if(UserManager.authenitcateUser(username, password)){
            System.out.println("User Authenticated");
            //search the current user in the database and get the account level
            ResultSet rs = UserManager.searchUser(username,password);
            System.out.println("WE have the result set");
            rs.next();
            String auth = rs.getString("AccountLevel");
            System.out.println(auth);

            //move to that screen
            switch(auth){
                case "Store Owner":
                    System.out.println("Store Owner");
                    switchToStoreManagerScreen();
                    break;
                case "Fair Owner":
                    System.out.println("Store Manager");
                    break;
                case "Admin":
                    System.out.println("Admin");
                    switchToAdminManagerScreen();
                    break;


            }

        }
        else{
            System.out.println("User Not Authenticated");
        }

    }



}

