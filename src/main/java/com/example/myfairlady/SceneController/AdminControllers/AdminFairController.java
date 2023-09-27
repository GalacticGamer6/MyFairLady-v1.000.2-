package com.example.myfairlady.SceneController.AdminControllers;

import com.example.myfairlady.App;
import com.example.myfairlady.DataTypes.Fair;
import com.example.myfairlady.DataTypes.User;
import com.example.myfairlady.Managers.FairManager;
import com.example.myfairlady.Managers.UserManager;
import com.example.myfairlady.UtilityClasses.ScreenGeneral;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
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

    @FXML
    private TextField fair_name_text_field;
    @FXML
    private ComboBox<String> fair_owner_combo_box;
    @FXML
    private DatePicker start_date_picker;
    @FXML
    private DatePicker end_date_picker;
    @FXML
    private Spinner<Double> entrance_fee_spinner;
    @FXML
    private TextArea themes_box;

    public void initializeEntranceFeeSpinner(){

        SpinnerValueFactory<Double> valueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 1000000, 0, .50);
        entrance_fee_spinner.setValueFactory(valueFactory);

    }

    public void initializeFairOwnersCombobox() throws SQLException {

        ObservableList<String> fair_owners = FXCollections.observableArrayList();
        ResultSet rs = UserManager.getUserByAccountLevel("Fair Owner");

        while(rs.next()){
            fair_owners.add(rs.getString("Username"));
        }

        fair_owner_combo_box.setItems(fair_owners);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            admin_name_label.setText(App.current_user.getUsername());
            initializeEntranceFeeSpinner();
            initializeFairsTable();
            initializeFairOwnersCombobox();

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



            Fair current_fair = new Fair(fair_id,fair_name, owner_id, start_date, end_date, entrance_fee, total_profit);

            fairs.add(current_fair);
        }

        tblfairs.setItems(fairs);
    }

    public void AccountsManagerButtonClicked() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.AdminAccountScreenLocation);

    }

    public void AddFairButtonClicked() throws SQLException {

        if(fair_name_text_field.getText().isEmpty() || fair_owner_combo_box.getValue().isEmpty() || start_date_picker.getValue() == null || end_date_picker.getValue() == null || entrance_fee_spinner.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please fill in all the fields");
            alert.showAndWait();
            return;
        }
        String fair_name = fair_name_text_field.getText();
        String fair_owner_name = fair_owner_combo_box.getValue();

        ResultSet rs = UserManager.getUserByUsername(fair_owner_name);
        rs.next();
        String owner_id = rs.getString("UserID");

        LocalDate start_date = start_date_picker.getValue();
        LocalDate end_date = end_date_picker.getValue();

        double entrance_fee = Double.parseDouble(entrance_fee_spinner.getValue().toString());
        double total_profit = 0;

        FairManager.addFair(fair_name, owner_id, start_date, end_date, entrance_fee, total_profit);
        initializeFairsTable();
    }

    public void generateFairNameButtonClicked() throws SQLException, IOException {
        String themes = themes_box.getText();
        String generated_fair_name = FairManager.generateName(themes);
        fair_name_text_field.setText(generated_fair_name);
    }

    public void DeleteFair() throws SQLException {

        Fair f = tblfairs.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirmation");
        alert.setContentText("Are you sure you want to delete this fair?");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK){
            FairManager.deleteFair(f.getFairID());
            try {
                initializeFairsTable();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void LogoutButtonClicked() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.LoginScreenLocation);

    }


}
