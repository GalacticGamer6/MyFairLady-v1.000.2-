package com.example.myfairlady.DataTypes;

import java.time.LocalDate;

public class Fair {

    private String fair_id;
    private String fair_name;
    private String fair_owner_id;
    private LocalDate start_date;
    private LocalDate end_date;
    private double entrance_fee;
    private double fair_profit;

    //create a constructor for the fair class
    public Fair(String fair_id, String fair_name, String fair_owner_id, LocalDate start_date, LocalDate end_date, double entrance_fee, double fair_profit) {
        this.fair_id = fair_id;
        this.fair_name = fair_name;
        this.fair_owner_id = fair_owner_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.entrance_fee = entrance_fee;
        this.fair_profit = fair_profit;
    }

    //create getters for the fair class
    public String getFairID() {
        return fair_id;
    }
    public String getFairName() {
        return fair_name;
    }
    public String getFairOwnerId() {
        return fair_owner_id;
    }
    public LocalDate getStartDate() {
        return start_date;
    }
    public LocalDate getEndDate() {
        return end_date;
    }
    public double getEntranceFee() {
        return entrance_fee;
    }
    public double getFairProfit() {
        return fair_profit;
    }

    @Override
    public String toString() {
        return "Fair{" +
                "fair_id='" + fair_id + '\'' +
                ", fair_name='" + fair_name + '\'' +
                ", fair_owner_id='" + fair_owner_id + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", entrance_fee=" + entrance_fee +
                ", fair_profit=" + fair_profit +
                '}';
    }


}
