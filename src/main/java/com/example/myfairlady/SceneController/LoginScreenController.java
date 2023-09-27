package com.example.myfairlady.SceneController;

import com.example.myfairlady.App;
import com.example.myfairlady.DataTypes.Fair;
import com.example.myfairlady.DataTypes.Store;
import com.example.myfairlady.DataTypes.User;
import com.example.myfairlady.Managers.FairManager;
import com.example.myfairlady.Managers.StoreManager;
import com.example.myfairlady.Managers.UserManager;
import com.example.myfairlady.SceneController.StoreControllers.StoreManagerController;
import com.example.myfairlady.UtilityClasses.ScreenGeneral;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
            rs.next();
            String auth = rs.getString("AccountLevel");
            System.out.println(auth);

            User U = UserManager.returnUser(username,password);
            App.current_user = U;
            System.out.println("We have the user" + U.getId());

            //move to that screen
            switch(auth){
                case "Store Owner":
                    System.out.println("Store Owner");

                    Store s = StoreManager.ReturnStoreByOwnerID(U.getId());

                    App.current_store = s;

                    ScreenGeneral.switchScreen(ScreenGeneral.StoreManagerMainScreenLocation);
                    break;

                case "Fair Owner":
                    System.out.println("Fair Owner");

                    Fair f = FairManager.returnFairByOwnerID(String.valueOf(U.getId()));
                    App.current_fair = f;
                    ScreenGeneral.switchScreen(ScreenGeneral.FairEntranceScreenLocation);
                    break;

                case "Admin":
                    System.out.println("Admin");
                    ScreenGeneral.switchScreen(ScreenGeneral.AdminAccountScreenLocation);
                    break;


            }

        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Credentials");
            alert.setContentText("The username or password you entered is incorrect. Please try again.");
            alert.showAndWait();

        }

    }





}

