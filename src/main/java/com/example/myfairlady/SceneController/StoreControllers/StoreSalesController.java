package com.example.myfairlady.SceneController.StoreControllers;

import com.example.myfairlady.App;
import com.example.myfairlady.DataTypes.Fair;
import com.example.myfairlady.DataTypes.Product;
import com.example.myfairlady.DataTypes.Store;
import com.example.myfairlady.Managers.ProductManager;
import com.example.myfairlady.Managers.SaleManager;
import com.example.myfairlady.Managers.StoreManager;
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

public class StoreSalesController implements Initializable {

    ObservableList<Product> products = FXCollections.observableArrayList();

    @FXML
    private Button sell_button;

    @FXML
    private Label total_cost_label;
    @FXML
    private TableView<Product> sales_table;
    @FXML
    private TableColumn<Product, Double> cost_price_column;
    @FXML
    private TableColumn<Product,String> product_id_column;
    @FXML
    private TableColumn<Product, String> product_name_column;


    //this is for the available products to sell table
    @FXML
    private TableColumn<Product, String> products_column;
    @FXML
    private TableView<Product> products_to_sell_table;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            initialize_products_to_sell_table();
            initalizeSalesTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void initialize_products_to_sell_table() throws SQLException {

        products_column.setCellValueFactory(new PropertyValueFactory<>("ProductName"));

        ResultSet rs = ProductManager.getProductsByStore(App.current_store.getStoreID());

        ObservableList<Product> products = FXCollections.observableArrayList();
        while(rs.next()){
            String product_id = rs.getString("ProductID");
            String product_name = rs.getString("ProductName");
            String store_id = rs.getString("StoreID");
            Double selling_price = rs.getDouble("SellingPrice");
            Double cost_price = rs.getDouble("CostPrice");
            String description = rs.getString("Description");
            String category = rs.getString("Category");
            int quantity = rs.getInt("Quantity");

            Product P = new Product(product_id,product_name,store_id,selling_price,cost_price,description,category,quantity);
            products.add(P);
        }

        products_to_sell_table.setItems(products);

    }

    public void rowSelected() throws SQLException {
        //first we need to check if we have enough quantity of the product to sell
        //if we dont have enough quantity, we need to tell the user that we dont have enough quantity
        //if we do have enough quantity, we need to add the product to the sales table

        Product selected_product = products_to_sell_table.getSelectionModel().getSelectedItem();

        if(selected_product.getQuantity() > 0){

            //add it to the other table
            sales_table.getItems().add(selected_product);

        }
        else{
            //we need to tell the user that we dont have enough quantity
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Not enough quantity");
            alert.setContentText("There is not enough quantity of this product to sell");
            alert.showAndWait();
            ProductManager.deleteProduct(selected_product);
        }
        initalizeSalesTable();
    }


    public void initalizeSalesTable(){

        product_id_column.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
        product_name_column.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        cost_price_column.setCellValueFactory(new PropertyValueFactory<>("SellingPrice"));

        sales_table.setItems(products);
        total_cost_label.setText(countTotalSellingPrice() + "");
    }

    //gets the selected product in the row, removes it from the table and updates the price
    public void deleteRow() throws SQLException {
        Product selected_product = sales_table.getSelectionModel().getSelectedItem();
        sales_table.getItems().remove(selected_product);
        initalizeSalesTable();
        total_cost_label.setText(countTotalSellingPrice() + "");
    }

    public double countTotalSellingPrice(){

        Double cost = 0.0;

        for(int i = 0 ; i < sales_table.getItems().size(); i++){
            cost += sales_table.getItems().get(i).getSellingPrice();
        }
        return cost;
    }

    public double countTotalCostPrice(){

        Double cost = 0.0;

        for(int i = 0 ; i < sales_table.getItems().size(); i++){
            cost += sales_table.getItems().get(i).getCostPrice();
        }
        return cost;
    }

    public void sellButtonClicked() throws SQLException {

        //first we ask if theyre sure that they want to sell the products


        //first sell each item in the table and add to the database
        for(int i = 0;i<sales_table.getItems().size();i++){

            Product p = sales_table.getItems().get(i);
            SaleManager.AddSale(p);

        }
        //then we update the profit of the store

        Double profit = countTotalSellingPrice() - countTotalCostPrice();
        StoreManager.updateStoreProfit(App.current_store, profit);

        //then we clear the table
        sales_table.getItems().clear();

        //then we update the total cost
        total_cost_label.setText(countTotalSellingPrice() + "");


    }

    public void LogoutButtonClicked() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.LoginScreenLocation);

    }


}
