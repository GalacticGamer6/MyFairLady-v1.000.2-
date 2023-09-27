package com.example.myfairlady.Managers;

import com.example.myfairlady.DataTypes.Ticket;
import com.example.myfairlady.UtilityClasses.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class TicketManager {

    public static ResultSet getTicketsByFair(String fair_id) throws SQLException {
        String statement = "SELECT * FROM tbltickets WHERE FairID = " + fair_id;
        return Database.query(statement);
    }

    public static void sellTickets(int tickts_to_sell, String fair_id, double total_cost, String formatteddateTime) throws SQLException {

        String statement = "INSERT INTO tbltickets (NumTicketsToSell, FairID, TotalCost, DateTimeSold) VALUES (" + tickts_to_sell + ", " + fair_id + ", " + total_cost + ", " + formatteddateTime + ")";
        Database.update(statement);

        //then we need to increase the fairs profit by the total cost of the tickets sold
        FairManager.increaseProfit(total_cost, fair_id);
    }



}
