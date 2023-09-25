package com.example.myfairlady.SceneController.StoreControllers;

import com.example.myfairlady.App;
import com.example.myfairlady.DataTypes.Product;
import com.example.myfairlady.Managers.ProductManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StoreSalesController implements Initializable {


    @FXML
    private TableColumn<Product , String> products_column;

    @FXML
    private TableView<Product> products_to_sell_table;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            initialize_products_to_sell_table();
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
            String fair_id = rs.getString("FairID");
            Double selling_price = rs.getDouble("SellingPrice");
            Double cost_price = rs.getDouble("CostPrice");
            String description = rs.getString("Description");
            String category = rs.getString("Category");
            int quantity = rs.getInt("Quantity");

            Product P = new Product(product_id,product_name,store_id,fair_id,selling_price,cost_price,description,category,quantity);
            products.add(P);
        }

        products_to_sell_table.setItems(products);

    }
}
