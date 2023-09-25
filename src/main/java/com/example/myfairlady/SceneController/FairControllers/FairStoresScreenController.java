package com.example.myfairlady.SceneController.FairControllers;

import com.example.myfairlady.DataTypes.Fair;
import com.example.myfairlady.DataTypes.Store;
import com.example.myfairlady.Managers.FairManager;
import com.example.myfairlady.Managers.StoreManager;
import com.example.myfairlady.UtilityClasses.ScreenGeneral;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.ResultSet;

public class FairStoresScreenController {



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


    public void StatsButtonIsClicked() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.FairStatsScreenLocation);

    }

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
}
