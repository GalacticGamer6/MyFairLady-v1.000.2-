package com.example.myfairlady.SceneController.FairControllers;

import com.example.myfairlady.App;
import com.example.myfairlady.DataTypes.Ticket;
import com.example.myfairlady.Managers.TicketManager;
import com.example.myfairlady.UtilityClasses.ScreenGeneral;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class FairEntranceScreenController implements Initializable {

    @FXML
    private Spinner<Integer> num_tickets_to_sell_spinner;
    @FXML
    private TableView <Ticket> tickets_table;
    @FXML
    private TableColumn <Ticket, Integer> num_sold_column;
    @FXML
    private TableColumn <Ticket, Integer> total_cost_column;
    @FXML
    private TableColumn <Ticket, Integer> date_time_column;




    //initializers
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            initializeNumTicketsToSellSpinner();
            initializeTicketsSoldTable();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void initializeTicketsSoldTable() throws SQLException {

        num_sold_column.setCellValueFactory(new PropertyValueFactory<>("NumTicketsToSell"));
        total_cost_column.setCellValueFactory(new PropertyValueFactory<>("TotalCost"));
        date_time_column.setCellValueFactory(new PropertyValueFactory<>("DateTimeSold"));

        ResultSet rs = TicketManager.getTicketsByFair(App.current_fair.getFairID());
        ObservableList<Ticket> tickets = FXCollections.observableArrayList();

        while(rs.next()){

            String ticket_sale_number = rs.getString("TicketSaleNumber");
            int num_tickets_to_sell = rs.getInt("NumTicketsToSell");
            String FairID = rs.getString("FairID");
            Double total_cost = rs.getDouble("TotalCost");
            LocalDateTime date_time_sold = rs.getTimestamp("DateTimeSold").toLocalDateTime();

            Ticket t = new Ticket(ticket_sale_number, num_tickets_to_sell, FairID, total_cost, date_time_sold);
            System.out.println(t.toString());
            tickets.add(t);
        }

        tickets_table.setItems(tickets);
    }

    public void initializeNumTicketsToSellSpinner(){

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000000, 0, 1);
        num_tickets_to_sell_spinner.setValueFactory(valueFactory);

    }

    public void sellTicket() throws SQLException {
        int num_tickets_to_sell = num_tickets_to_sell_spinner.getValue();
        String current_fair_id = App.current_fair.getFairID();
        double total_cost = num_tickets_to_sell * App.current_fair.getEntranceFee();
        LocalDateTime date_time_sold = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatted_date_time_sold = date_time_sold.format(formatter);


        TicketManager.sellTickets(num_tickets_to_sell, current_fair_id, total_cost, formatted_date_time_sold);
        num_tickets_to_sell_spinner.getValueFactory().setValue(0);
        initializeTicketsSoldTable();
    }










    //button handling methods
    public void StoreManagementButtonIsClicked() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.FairStoresScreenLocation);

    }

    public void StatsButtonIsClicked() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.FairStatsScreenLocation);

    }

    public void SettingsButtonIsClicked() throws IOException {

        ScreenGeneral.switchScreen(ScreenGeneral.FairSettingsScreenLocation);

    }



}
