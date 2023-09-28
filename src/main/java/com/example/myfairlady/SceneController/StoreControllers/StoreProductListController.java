package com.example.myfairlady.SceneController.StoreControllers;

import com.example.myfairlady.App;
import com.example.myfairlady.DataTypes.Product;
import com.example.myfairlady.Managers.ProductManager;
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

public class StoreProductListController implements Initializable {

    //add product section of the screen
    @FXML
    private TextField product_name_textfield;
    @FXML
    private Spinner <Double> selling_price_spinner;
    @FXML
    private Spinner <Double> cost_price_spinner;
    @FXML
    private TextArea description_text_area;
    @FXML
    private ComboBox<String> category_combo_box;
    @FXML
    private Spinner<Integer> quantity_spinner;
    @FXML
    private Button add_product_button;
    @FXML
    private Button products_list_button;


    //view produts part of the screen
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
        @FXML
        private TableColumn<Product,Integer> quantity_table_column;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        try {

            setProductsListTable();

            //initialize the spinners
            SpinnerValueFactory<Double> selling_price_value_factory = new SpinnerValueFactory.DoubleSpinnerValueFactory(0.00,100000.00,0.00,0.50);
            selling_price_spinner.setValueFactory(selling_price_value_factory);

            SpinnerValueFactory<Double> cost_price_value_factory = new SpinnerValueFactory.DoubleSpinnerValueFactory(0.00,100000.00,0.00,0.50);
            cost_price_spinner.setValueFactory(cost_price_value_factory);

            SpinnerValueFactory<Integer> quantity_value_factory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100000,0,1);
            quantity_spinner.setValueFactory(quantity_value_factory);

            //initialize the category combobox
            ObservableList<String> categories = FXCollections.observableArrayList("Food","Clothing","Electronics","Toys","Books","Services","Music","Drink","travel");
            category_combo_box.setItems(categories);





        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //need to display and populate the table
    public void setProductsListTable() throws SQLException {

        //this is which part so the objecet the table will actually show

        product_number_tablecolumn.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
        product_name_tablecolumn.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        selling_price_tablecolumn.setCellValueFactory(new PropertyValueFactory<>("SellingPrice"));
        cost_price_tablecolumn.setCellValueFactory(new PropertyValueFactory<>("CostPrice"));
        description_table_column.setCellValueFactory(new PropertyValueFactory<>("Description"));
        category_table_column.setCellValueFactory(new PropertyValueFactory<>("ProductCategory"));
        quantity_table_column.setCellValueFactory(new PropertyValueFactory<>("Quantity"));



        ResultSet pl = ProductManager.getProductsByStore(App.current_store.getStoreID());

        ObservableList<Product> products = FXCollections.observableArrayList();

        //turn products list resultset into an array if objects to be put into the observable list
        while(pl.next()){

            String product_number = pl.getString("ProductID");
            String product_name = pl.getString("ProductName");
            String store_name = pl.getString("StoreID");
            double selling_price = pl.getDouble("SellingPrice");
            double cost_price = pl.getDouble("CostPrice");
            String description = pl.getString("Description");
            String category = pl.getString("Category");
            int quantity = pl.getInt("Quantity");

            Product p = new Product(product_number,product_name,store_name,selling_price,cost_price,description,category,quantity);
            System.out.println(p.toString());
            products.add(p);

        }

        products_list_table.setItems(products);
    }

    public void addProductButtonClicked() throws SQLException {
        //check if all the values are entered
        if(product_name_textfield.getText().isEmpty() || description_text_area.getText().isEmpty() || category_combo_box.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please fill in all the fields");
            alert.showAndWait();
        } else {
            //get the values from the text fields and spinners
            String product_name = product_name_textfield.getText();
            double selling_price = selling_price_spinner.getValue();
            double cost_price = cost_price_spinner.getValue();
            String description = description_text_area.getText();
            String category = category_combo_box.getValue();
            int quantity = quantity_spinner.getValue();
            String StoreID = App.current_store.getStoreID();

            ProductManager.addProduct(product_name, StoreID, selling_price, cost_price, description, category, quantity);

            setProductsListTable();
        }
    }

    public void backButtonClicked() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.StoreManagerMainScreenLocation);

    }

    public void deleteButtonClicked() throws SQLException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Product");
        alert.setHeaderText("Are you sure you want to delete this product?");
        alert.setContentText("This action cannot be undone");
        alert.showAndWait();

        if(alert.getResult() == ButtonType.OK){
            Product p = products_list_table.getSelectionModel().getSelectedItem();
            ProductManager.deleteProduct(p);
            setProductsListTable();
        }

    }



}
