package com.example.myfairlady.SceneController.AdminControllers;

import com.example.myfairlady.DataTypes.Fair;
import com.example.myfairlady.Managers.FairManager;
import com.example.myfairlady.UtilityClasses.ScreenGeneral;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AdminFairController implements Initializable {

    @FXML
    private Label admin_clock_label;

    @FXML
    private Label admin_name_label;

    @FXML
    private Label date_label;

    @FXML
    private TableView<Fair> tblfairs;
        @FXML
        private TableColumn<Fair, String> fair_id_column;
        @FXML
        private TableColumn<Fair, String> fair_name_column;
        @FXML
        private TableColumn<Fair, String> owner_id_column;
        //these suye JAVA.SQL.DATE
        @FXML
        private TableColumn<Fair, Date> start_date_column;
        @FXML
        private TableColumn<Fair, Date> end_date_column;

        //had to use the wrapper class because tabelcolumn doesnt take in primitive tyoes
        @FXML
        private TableColumn<Fair, Double> entrance_fee_column;
        @FXML
        private TableColumn<Fair, Double> total_profit_column;






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {

            initializeFairsTable();

            ScreenGeneral.setDate(date_label);
            ScreenGeneral.Clock(admin_clock_label);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void initializeFairsTable() throws SQLException {

    //set the cell value factory of each tablecolumn. This tells the tablecolumn what to display in each cell. It takes in the getter method of the datatype that the tablecolumn is displaying but without the get prefix
        fair_id_column.setCellValueFactory(new PropertyValueFactory<>("FairID"));
        fair_name_column.setCellValueFactory(new PropertyValueFactory<>("FairName"));
        owner_id_column.setCellValueFactory(new PropertyValueFactory<>("FairOwnerId"));
        start_date_column.setCellValueFactory(new PropertyValueFactory<>("StartDate"));
        end_date_column.setCellValueFactory(new PropertyValueFactory<>("EndDate"));
        entrance_fee_column.setCellValueFactory(new PropertyValueFactory<>("EntranceFee"));
        total_profit_column.setCellValueFactory(new PropertyValueFactory<>("FairProfit"));


        ResultSet rs = FairManager.getFairs();
        ObservableList<Fair> fairs = FXCollections.observableArrayList();

        //loop trhough th result set, create a fair object and add it to the fairs observable list
        while(rs.next()){

            String fair_id = rs.getString("FairID");
            String fair_name = rs.getString("FairName");
            String owner_id = rs.getString("FairOwnerID");
            LocalDate start_date = rs.getDate("StartDate").toLocalDate();
            LocalDate end_date = rs.getDate("EndDate").toLocalDate();
            double entrance_fee = rs.getDouble("EntranceFee");
            double total_profit = rs.getDouble("TotalProfit");



            Fair current_fair = new Fair(fair_id, fair_name, owner_id, start_date, end_date, entrance_fee, total_profit);

            fairs.add(current_fair);
        }

        tblfairs.setItems(fairs);
    }

    public void AccountsManagerButtonClicked() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.AdminAccountScreenLocation);

    }
}
