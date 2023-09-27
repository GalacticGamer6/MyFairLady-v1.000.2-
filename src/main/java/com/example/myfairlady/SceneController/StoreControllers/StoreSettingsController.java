package com.example.myfairlady.SceneController.StoreControllers;

import com.example.myfairlady.App;
import com.example.myfairlady.DataTypes.Fair;
import com.example.myfairlady.Managers.FairManager;
import com.example.myfairlady.Managers.StoreManager;
import com.example.myfairlady.UtilityClasses.ScreenGeneral;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableArrayList;

public class StoreSettingsController implements Initializable {

    @FXML
    private TextField updated_store_name_text_field;
    @FXML
    private Button update_store_name_button;

    @FXML
    private ComboBox<String> list_of_fairs_combo_box;
    @FXML
    private Button move_fair_button;

    @FXML
    private ComboBox<String> categories_combo_box;
    @FXML
    private Button switch_category_button;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {

            initializeCategoriesComboBox();
            initalizeFairsComboBox();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //control initializers
    public void initializeCategoriesComboBox() {
        categories_combo_box.setItems(observableArrayList("Food", "Clothing", "Electronics", "Music", "Books", "Services","Games","Security","Pets","Other"));
    }
    public void initalizeFairsComboBox() throws SQLException {
        ResultSet rs = FairManager.getFairs();
        ObservableList<String> fairs = FXCollections.observableArrayList();

        while(rs.next()){

            String FairName = rs.getString("FairName");
            fairs.add(FairName);
        }

        list_of_fairs_combo_box.setItems(fairs);
    }




    //button click handlerss
    public void updateCategoriesButtonClicked() throws IOException, SQLException {
        //check if anything is even selected
        if(categories_combo_box.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No Category Selected");
            alert.setContentText("Please select a category to switch to");
            alert.showAndWait();
        } else {
            StoreManager.updateStoreCategory(App.current_store.getStoreID(), categories_combo_box.getValue());
        }
    }

    public void moveFairButtonClicked() throws IOException, SQLException {

        //check if anything is even selected
        if(list_of_fairs_combo_box.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No Fair Selected");
            alert.setContentText("Please select a fair to move to");
            alert.showAndWait();
        } else {

            ResultSet rs = FairManager.getFairByName(list_of_fairs_combo_box.getValue());
            rs.next();
            String fairID = rs.getString("FairID");
            String fairName = rs.getString("FairName");
            String fairOwnerID = rs.getString("FairOwnerID");
            LocalDate StartDate = rs.getDate("StartDate").toLocalDate();
            LocalDate EndDate = rs.getDate("EndDate").toLocalDate();
            Double entranceFee = rs.getDouble("EntranceFee");
            Double TotalProfit = rs.getDouble("TotalProfit");

            Fair fair = new Fair(fairID, fairName, fairOwnerID, StartDate, EndDate, entranceFee, TotalProfit);

            StoreManager.changeFairs(App.current_store.getStoreID(), fair);

        }

    }
    public void backButtonClicked() throws IOException {
        ScreenGeneral.switchScreen(ScreenGeneral.StoreManagerMainScreenLocation);
    }
    public void changeStoreNameButtonClicked() throws IOException, SQLException {
        //check whether the text field is empty
        if(updated_store_name_text_field.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No Store Name Entered");
            alert.setContentText("Please enter a store name");
            alert.showAndWait();
        } else {
            //check whether the store name already exists
            ResultSet rs = StoreManager.getStoreByName(updated_store_name_text_field.getText());
            //if the store name already exists, show an error
            if(rs.next()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Store Name Already Exists");
                alert.setContentText("Please enter a different store name");
                alert.showAndWait();
            } else {
                //update the store name
                StoreManager.updateStoreName(App.current_store.getStoreID(),updated_store_name_text_field.getText());
            }
        }
    }

    public void resetStoreProfitButtonClicked() throws SQLException {

        //need to remove the profit from the fair
        FairManager.RemoveAStoresProfit(App.current_store);
        StoreManager.ResetStoreProfit(App.current_store.getStoreID());


    }
}
