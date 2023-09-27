package com.example.myfairlady.DataTypes;

import java.time.LocalDateTime;

public class Ticket {

    private String ticket_sale_number;
    private int num_tickets_to_sell;
    private String fair_id;
    private Double total_cost;
    private String date_time_sold;

    public Ticket(String ticket_sale_number, int num_tickets_to_sell, String fair_id, Double total_cost,String date_time_sold) {
        this.ticket_sale_number = ticket_sale_number;
        this.num_tickets_to_sell = num_tickets_to_sell;
        this.fair_id = fair_id;
        this.total_cost = total_cost;
        this.date_time_sold = date_time_sold;
    }

    public String getTicketSaleNumber() {
        return ticket_sale_number;
    }

    public int getNumTicketsToSell() {
        return num_tickets_to_sell;
    }

    public String getFairID() {
        return fair_id;
    }

    public Double getTotalCost() {
        return total_cost;
    }

    public String getDateTimeSold() {
        return date_time_sold;
    }

    //create a toString
    @Override
    public String toString() {
        return "Ticket{" +
                "ticket_sale_number='" + ticket_sale_number + '\'' +
                ", num_tickets_to_sell=" + num_tickets_to_sell +
                ", fair_id='" + fair_id + '\'' +
                ", total_cost=" + total_cost +
                ", date_time_sold=" + date_time_sold +
                '}';
    }
}

