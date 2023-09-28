package com.example.myfairlady.SceneController.AdminControllers;

import com.example.myfairlady.App;
import com.example.myfairlady.DataTypes.User;
import com.example.myfairlady.Managers.UserManager;
import com.example.myfairlady.UtilityClasses.ScreenGeneral;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Screen;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AdminAccountsController implements Initializable {

    @FXML
    private Label admin_clock_label;
    @FXML
    private Label admin_name_label;
    @FXML
    private Label date_label;

    @FXML
    private TextField username_textfield;

    @FXML
    private TextField password_textfield;

    @FXML
    private ComboBox<String> account_level_combo_box;
    @FXML
    private ComboBox<String> column_to_be_ordered_combobox;
    @FXML
    private ComboBox<String> order_combobox;

    //linking the tableview and its tablecolumns from Scenebuilder
    @FXML
    private TableView<User> users_table;

        @FXML
        private TableColumn<User, String> id_table_column;
        @FXML
        private TableColumn<User, String> username_table_column;
        @FXML
        private TableColumn<User, String> password_table_column;
        @FXML
        private TableColumn<User, String> account_level_table_column;






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        try {

            admin_name_label.setText(App.current_user.getUsername());

            ScreenGeneral.setDate(date_label);
            ScreenGeneral.Clock(admin_clock_label);

//            order_combobox.setValue("ASC");
            initializeColumnOrderComboBox();
            initalizeOrderComboBox();
            initializeAdminComboBox();
            intializeUserTable(UserManager.getAdminAndFairUsers());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void initializeAdminComboBox(){
        account_level_combo_box.setItems(FXCollections.observableArrayList("Admin","Fair Owner"));
    }
    public void initializeColumnOrderComboBox(){
        column_to_be_ordered_combobox.setItems(FXCollections.observableArrayList("UserID","Username","AccountLevel"));
    }
    public void initalizeOrderComboBox(){
        order_combobox.setItems(FXCollections.observableArrayList("ASC","DESC"));
    }

    public void intializeUserTable(ResultSet in_rs) throws SQLException {

        //setting the table to take in these values from the object

        id_table_column.setCellValueFactory(new PropertyValueFactory<>("id"));
        username_table_column.setCellValueFactory(new PropertyValueFactory<>("username"));
        password_table_column.setCellValueFactory(new PropertyValueFactory<>("password"));
        account_level_table_column.setCellValueFactory(new PropertyValueFactory<>("Authoritylevel"));

        ResultSet rs = in_rs;
        ObservableList<User> users = FXCollections.observableArrayList();



        while(rs.next()){

            int id = rs.getInt("UserID");
            String username = rs.getString("Username");
            String password = rs.getString("Password");
            String account_level = rs.getString("AccountLevel");

            User u = new User(id + "",username,password,account_level);
            users.add(u);

        }

        users_table.setItems(users);
    }

    public void columnToBeOrderedComboboxSelected() throws SQLException {
        String column_to_be_ordered = column_to_be_ordered_combobox.getValue();
        String order = order_combobox.getValue();

        System.out.println("Column to be ordered: " + column_to_be_ordered);
        System.out.println("Order: " + order);
        intializeUserTable(UserManager.getAdminAndFairUsersSorted(column_to_be_ordered,order));
    }



    public void AddUserButtonClicked() throws SQLException {
        //check if both fields are filled in
        if(username_textfield.getText().isEmpty() || password_textfield.getText().isEmpty() || account_level_combo_box.getValue().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please fill in all fields");
            alert.setContentText("Please fill in all fields");
            alert.showAndWait();

            return;
        }

        String username = username_textfield.getText();
        String password = password_textfield.getText();
        String account_level = account_level_combo_box.getValue();

        if(UserManager.userExists(username,password)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("User already exists");
            alert.setContentText("Please enter a different username and password");
            alert.showAndWait();

            return;
        }
        else{
            UserManager.addUser(username,password,account_level);
            intializeUserTable(UserManager.getAdminAndFairUsers());
        }

        intializeUserTable(UserManager.getAdminAndFairUsers());
    }

    public void DeleteUserButtonClicked() throws SQLException {
        User user = users_table.getSelectionModel().getSelectedItem();
        UserManager.deleteUser(user.getId());
        intializeUserTable(UserManager.getAdminAndFairUsers());
    }

    public void FairManagerButtonClicked() throws IOException {
        System.out.println("We are in the Method for fair manage rbutton clicked");
        ScreenGeneral.switchScreen(ScreenGeneral.AdminFairScreenLocation);
    }

    public void LogoutButtonClicked() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.LoginScreenLocation);

    }
}
