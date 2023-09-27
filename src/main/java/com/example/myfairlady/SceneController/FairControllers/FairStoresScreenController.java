package com.example.myfairlady.SceneController.FairControllers;

import com.example.myfairlady.DataTypes.Fair;
import com.example.myfairlady.DataTypes.Store;
import com.example.myfairlady.Managers.FairManager;
import com.example.myfairlady.Managers.StoreManager;
import com.example.myfairlady.Managers.UserManager;
import com.example.myfairlady.UtilityClasses.ScreenGeneral;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class FairStoresScreenController implements Initializable {

    @FXML
    private ComboBox <String> store_owners_combo_box;
    @FXML
    private ComboBox <String> category_combo_box;
    @FXML
    private ComboBox <String> status_combo_box;
    @FXML
    private TextField store_name_textfield;

    @FXML
    private TableView<Store> stores_table;
        @FXML
        private TableColumn<Store, String> store_id_column;
        @FXML
        private TableColumn<Store, String> store_name_column;
        @FXML
        private TableColumn<Store, String> owner_id_column;
        @FXML
        private TableColumn<Store, String> category_column;
        @FXML
        private TableColumn<Store, String> status_column;
        @FXML
        private TableColumn<Store, Double> profit_column;



    public void SettingsButtonIsClicked() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.FairSettingsScreenLocation);

    }

    public void EntranceManagementButtonIsClicked() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.FairEntranceScreenLocation);

    }

    public void initializeStoresTable(){

        //set the cell value factories for each column
        store_id_column.setCellValueFactory(new PropertyValueFactory<>("StoreID"));
        store_name_column.setCellValueFactory(new PropertyValueFactory<>("StoreName"));
        owner_id_column.setCellValueFactory(new PropertyValueFactory<>("OwnerID"));
        category_column.setCellValueFactory(new PropertyValueFactory<>("category"));
        status_column.setCellValueFactory(new PropertyValueFactory<>("Status"));
        profit_column.setCellValueFactory(new PropertyValueFactory<>("profit"));

//        ResultSet rs = StoreManager.getStores(currentFair.getFairID());

    }

    public void LogoutButtonClicked() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.LoginScreenLocation);

    }

    public void initalizeStoreOwnersComboBox() throws SQLException {

        ObservableList <String> storeOwners = FXCollections.observableArrayList();

        ResultSet rs = UserManager.getStoreOwnersWithoutAStore();

        while(rs.next()){

            storeOwners.add(rs.getString("Username"));

        }

        store_owners_combo_box.setItems(storeOwners);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            initializeStoresTable();
            initalizeStoreOwnersComboBox();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
