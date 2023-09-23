package com.example.myfairlady.SceneController.AdminControllers;

import com.example.myfairlady.DataTypes.User;
import com.example.myfairlady.Managers.UserManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminHomeController implements Initializable {

    @FXML
    private Label admin_clock_label;

    @FXML
    private ComboBox<String> account_level_combo_box;


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



        initializeAdminComboBox();


    }

    public void initializeAdminComboBox(){
        account_level_combo_box.setItems(FXCollections.observableArrayList("Admin","Fair Owner"));
    }

    public void intializeUserTable() throws SQLException {

        //setting the table to take in these values from the object
        id_table_column.setCellValueFactory(new PropertyValueFactory<>("id"));
        username_table_column.setCellValueFactory(new PropertyValueFactory<>("username"));
        password_table_column.setCellValueFactory(new PropertyValueFactory<>("password"));
        account_level_table_column.setCellValueFactory(new PropertyValueFactory<>("accountLevel"));

        ResultSet rs = UserManager.getUsers();
        ObservableList<User> users = FXCollections.observableArrayList();

        while(rs.next()){

            int id = rs.getInt("UserID");
            String username = rs.getString("Username");
            String password = rs.getString("Password");
            String account_level = rs.getString("AccountLevel");

            User u = new User(id,username,password,account_level);
            users.add(u);

        }
    }
}
