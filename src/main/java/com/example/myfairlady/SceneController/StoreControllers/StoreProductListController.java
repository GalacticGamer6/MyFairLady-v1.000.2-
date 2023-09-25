package com.example.myfairlady.SceneController.StoreControllers;

import com.example.myfairlady.DataTypes.Product;
import com.example.myfairlady.Managers.ProductManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StoreProductListController implements Initializable {

    @FXML
    private Button products_list_button;


    @FXML
    private TableView<Product> products_list_table;

    @FXML
    private TableColumn<Product, String> product_number_tablecolumn;
        @FXML
        private TableColumn<Product, String> product_name_tablecolumn;
        @FXML
        private TableColumn<Product, Double> selling_price_tablecolumn;
        @FXML
        private TableColumn<Product, Double> cost_price_tablecolumn;
        @FXML
        private TableColumn<Product, String> description_table_column;
        @FXML
        private TableColumn<Product,String> category_table_column;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        try {
            setProductsListTable();









        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //need to display and populate the table
    public void setProductsListTable() throws SQLException {

        //this is which part so the objecet the table will actually show
//        category_table_column.setCellValueFactory(new PropertyValueFactory<>("category"));
//        cost_price_tablecolumn.setCellValueFactory(new PropertyValueFactory<>("cost_price"));
//        description_table_column.setCellValueFactory(new PropertyValueFactory<>("description"));
//        product_name_tablecolumn.setCellValueFactory(new PropertyValueFactory<>("product_name"));
//        product_number_tablecolumn.setCellValueFactory(new PropertyValueFactory<>("product_number"));
//        selling_price_tablecolumn.setCellValueFactory(new PropertyValueFactory<>("selling_price"));

        product_number_tablecolumn.setCellValueFactory(new PropertyValueFactory<>("productNumber"));
        product_name_tablecolumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        selling_price_tablecolumn.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
        cost_price_tablecolumn.setCellValueFactory(new PropertyValueFactory<>("costPrice"));
        description_table_column.setCellValueFactory(new PropertyValueFactory<>("description"));
        category_table_column.setCellValueFactory(new PropertyValueFactory<>("productCategory"));



        ResultSet pl = ProductManager.searchProductByStoreName("Ramsays Eat Street");

        ObservableList<Product> products = FXCollections.observableArrayList();

        //turn products list resultset into an array if objects to be put into the observable list
        while(pl.next()){

            String product_number = pl.getString("ProductID");
            String product_name = pl.getString("ProductName");
            String store_name = pl.getString("StoreID");
            String fair_name = pl.getString("FairID");
            double selling_price = pl.getDouble("SellingPrice");
            double cost_price = pl.getDouble("CostPrice");
            String description = pl.getString("Description");
            String category = pl.getString("Category");
            int quantity = pl.getInt("Quantity");
            Product p = new Product(product_number,product_name,store_name,fair_name,selling_price,cost_price,description,category,quantity);

            products.add(p);

        }

        products_list_table.setItems(products);
    }


}
