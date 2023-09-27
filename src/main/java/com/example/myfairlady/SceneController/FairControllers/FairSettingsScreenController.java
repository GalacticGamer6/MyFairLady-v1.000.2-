package com.example.myfairlady.SceneController.FairControllers;

import com.example.myfairlady.App;
import com.example.myfairlady.Managers.FairManager;
import com.example.myfairlady.Managers.UserManager;
import com.example.myfairlady.UtilityClasses.Database;
import com.example.myfairlady.UtilityClasses.ScreenGeneral;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class FairSettingsScreenController implements Initializable {

    public TableColumn profit_column;
    @FXML
    private TextField username_field;
    @FXML
    private TextField password_field;
    @FXML
    private TextField fair_name_field;
    @FXML
    private Spinner<Double> entrance_fee_spinner;


    public void intializeEntranceFeeSpinner(){

        SpinnerValueFactory<Double> valueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 1000, 0, 0.5);
        entrance_fee_spinner.setValueFactory(valueFactory);

    }


    public void AddUserButtonIsClicked() throws IOException, SQLException {

        //first check whether both fields are filled
        if(username_field.getText().isEmpty() || password_field.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please fill in both fields");
            alert.showAndWait();
        }
        else{
            //check whether the account exists
            if(UserManager.userExists(username_field.getText(),password_field.getText())){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("This account already exists, please use a different username and password");
                alert.showAndWait();
            }
            else{

                //now we ddd the user to the database
                UserManager.addUser(username_field.getText(),password_field.getText(),"Store Owner");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Success");
                alert.setContentText("User added successfully");
                alert.showAndWait();
            }
        }

    }

    public void changeFairName() throws SQLException {
        //check if empty first
        if(fair_name_field.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please fill in the fair name");
            alert.showAndWait();
        }
        else{
            //now we change the fair name
            FairManager.updateFairName(fair_name_field.getText(),App.current_fair.getFairID());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Success");
            alert.setContentText("Fair name changed successfully");
            alert.showAndWait();
        }

    }

    public void changeEntranceFee() throws SQLException, ClassNotFoundException {
        //check if its empty first
        if(entrance_fee_spinner.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please fill in the entrance fee");
            alert.showAndWait();

        } else {
            FairManager.updateEntranceFee(App.current_fair.getFairID(), entrance_fee_spinner.getValue());
            //so that the current fair object is updated
            App.current_fair.setEntrance_fee(entrance_fee_spinner.getValue());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Success");
            alert.setContentText("Entrance fee changed successfully");
            alert.showAndWait();
        }

    }



    public void StoreManagementButtonIsClicked() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.FairStoresScreenLocation);

    }



    public void EntranceManagementButtonIsClicked() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.FairEntranceScreenLocation);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        intializeEntranceFeeSpinner();
    }

    public void LogoutButtonClicked() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.LoginScreenLocation);

    }
}
