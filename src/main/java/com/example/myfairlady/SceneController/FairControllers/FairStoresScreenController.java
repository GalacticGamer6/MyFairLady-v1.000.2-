package com.example.myfairlady.SceneController.FairControllers;

import com.example.myfairlady.App;
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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class FairStoresScreenController implements Initializable {

    @FXML
    private ComboBox<String> category_combo_box;
    @FXML
    private ComboBox<String> status_combo_box;
    @FXML
    private TextField store_name_field;
    @FXML
    private TextField username_field;
    @FXML
    private TextField password_field;


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

    public void initializeStoresTable() throws SQLException {
        System.out.println("We are in the initialize stores table method");
        //set the cell value factories for each column
        store_id_column.setCellValueFactory(new PropertyValueFactory<>("StoreID"));
        store_name_column.setCellValueFactory(new PropertyValueFactory<>("StoreName"));
        owner_id_column.setCellValueFactory(new PropertyValueFactory<>("OwnerID"));
        category_column.setCellValueFactory(new PropertyValueFactory<>("Category"));
        status_column.setCellValueFactory(new PropertyValueFactory<>("Status"));
        profit_column.setCellValueFactory(new PropertyValueFactory<>("Profit"));

       ResultSet rs = StoreManager.getStores(App.current_fair.getFairID());
        System.out.println(App.current_fair.toString());

       ObservableList<Store> stores = FXCollections.observableArrayList();

       while(rs.next()){

           String storeID = rs.getString("StoreID");
           String storeName = rs.getString("StoreName");
           String ownerID = rs.getString("OwnerID");
           String FairID = rs.getString("FairID");
           String category = rs.getString("category");
           String status = rs.getString("Status");
           double profit = rs.getDouble("Profit");

           Store s = new Store(storeID,storeName,ownerID,FairID,category,status,profit);
           System.out.println(s.toString());
           stores.add(s);


       }
       stores_table.setItems(stores);

    }

    public void LogoutButtonClicked() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.LoginScreenLocation);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        try {
            initializeStoresTable();
            InitializeComboBoxes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addStore() throws SQLException {

        //make sure all the fields and combo boxes are filled
        if (store_name_field.getText().isEmpty() || username_field.getText().isEmpty() || password_field.getText().isEmpty() || category_combo_box.getValue() == null || status_combo_box.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
        } else {

            //start setting up the user object
            String username = username_field.getText();
            String password = password_field.getText();
            String account_level = "Store Owner";
            UserManager.addUser(username, password, account_level);

            //now we can just grab the user ID from the DB
            ResultSet rs = UserManager.searchUser(username, password);
            rs.next();
            String userID = rs.getString("UserID");

            //now we can add the store

            String store_name = store_name_field.getText();
            String FairID = App.current_fair.getFairID();
            String category = category_combo_box.getValue();
            String status = status_combo_box.getValue();
            Double profit = 0.0;

            StoreManager.addStore(store_name, userID, FairID, category, status, profit);
            initializeStoresTable();

        }
    }

    public void InitializeComboBoxes() {

        ObservableList<String> category_list = FXCollections.observableArrayList("Food", "Clothing", "Electronics", "music", "sports", "house", "e-commcerce");
        category_combo_box.setItems(category_list);

        ObservableList<String> status_list = FXCollections.observableArrayList("Open", "Closed", "Help Wanted");
        status_combo_box.setItems(status_list);
    }

    public void SwitchToFairSettingsScreen() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.FairSettingsScreenLocation);

    }

    public void DeleteStore(){

        Store s = stores_table.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Delete Store");
        alert.setContentText("Are you sure you want to delete this store?");
        alert.showAndWait();

        //check if they said okay
        if(alert.getResult() == ButtonType.OK){

            try {
                StoreManager.DeleteStore(s);
                UserManager.deleteUser(s.getOwnerID());
                initializeStoresTable();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }


}