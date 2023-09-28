package com.example.myfairlady.SceneController.StoreControllers;

import com.example.myfairlady.App;
import com.example.myfairlady.DataTypes.Product;
import com.example.myfairlady.DataTypes.Sale;
import com.example.myfairlady.Managers.ProductManager;
import com.example.myfairlady.Managers.SaleManager;
import com.example.myfairlady.Managers.StoreManager;
import com.example.myfairlady.UtilityClasses.ScreenGeneral;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class StoreStatsController implements Initializable {

    @FXML
    private TextField cost_text_field;

    @FXML
    private TextField most_popular_date_text_field;

    @FXML
    private TextField most_popular_product_text_field;

    @FXML
    private TextField num_sales_text_field;

    @FXML
    private TextField product_name_text_field;

    @FXML
    private TextField sp_text_field;

    @FXML
    private TextField store_profit_field;
    @FXML
    private TableView<Sale> sales_table;
    @FXML
    private TableColumn<Sale, LocalDate> date_column;

    @FXML
    private TableColumn<Sale, String> id_column;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            initializeSalesTable();

            //settings the important info fields
            ResultSet rs = StoreManager.getStoreByID(App.current_store.getStoreID());
            if(rs.next()) {
//                rs.next();
                store_profit_field.setText(rs.getString("Profit"));
            }
            else{
                return;
            }

            //get most popular date
            ResultSet rs2 = SaleManager.getDateOfMostSalesByStore(App.current_store.getStoreID());
            if(rs2.next()) {
//                rs2.next();
                LocalDate most_popular_date = rs2.getDate("DateSold").toLocalDate();
                most_popular_date_text_field.setText(most_popular_date.toString());
            }
            else{
                return;
            }
            //get most popular product
            ResultSet rs3 = SaleManager.getMostPopularProductOfAStore(App.current_store.getStoreID());
            if(rs3.next()) {
//                rs3.next();
                String most_popular_product = rs3.getString("ProductName");
                most_popular_product_text_field.setText(most_popular_product);
            }
            else{
                return;
            }

            //get number of sales
            ResultSet rs4 = SaleManager.getNumberOfSalesOfAStore(App.current_store.getStoreID());
            if(rs4.next()) {
//                rs4.next();
                int num_sales = rs4.getInt("COUNT(*)");
                num_sales_text_field.setText(Integer.toString(num_sales));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void initializeSalesTable() throws SQLException {

        id_column.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
        date_column.setCellValueFactory(new PropertyValueFactory<>("Date"));

        ResultSet rs = SaleManager.getSalesByStore(App.current_store.getStoreID());
        if(rs.next()) {
            ObservableList sales = FXCollections.observableArrayList();

            while (rs.next()) {

                String SaleID = rs.getString("SaleID");
                String ProductID = rs.getString("ProductID");
                LocalDate Date = rs.getDate("DateSold").toLocalDate();

                Sale s = new Sale(SaleID, ProductID, Date);
                sales.add(s);

            }

            sales_table.setItems(sales);
        }
        else{
            return;
        }
    }

    public void backButtonClicked() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.StoreManagerMainScreenLocation);

    }
    //we use this everytime an item in the table is selected
    public void DisplayProductInfo() throws SQLException {

        //get the sale object selected from the table
        Sale selected_sale = sales_table.getSelectionModel().getSelectedItem();
        String id = selected_sale.getProductID();
        ResultSet rs = ProductManager.getProductByID(id);
        rs.next();
        String product_name = rs.getString("ProductName");
        Double cost = rs.getDouble("CostPrice");
        Double sp = rs.getDouble("SellingPrice");

        product_name_text_field.setText(product_name);
        cost_text_field.setText(Double.toString(cost));
        sp_text_field.setText(Double.toString(sp));
    }
}
