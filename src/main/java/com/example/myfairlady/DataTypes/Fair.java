package com.example.myfairlady.DataTypes;

public class Fair {


    private String fair_name;
    private Store[] list_of_stores;
    private int entrance_fee;
    private int duration;
    private String fair_owner_username;
    private String status;

    public Fair(String fair_name, Store[] list_of_stores , int entrance_fee, int duration, String fair_owner_username, String status) {
        this.fair_name = fair_name;
        this.list_of_stores = list_of_stores;
        this.entrance_fee = entrance_fee;
        this.duration = duration;
        this.fair_owner_username = fair_owner_username;
        this.status = status;
    }

    public String getFair_name() {
        return this.fair_name;
    }

    public Store[] getList_of_stores() {
        return list_of_stores;
    }

    public int getEntrance_fee() {
        return entrance_fee;
    }

    public int getDuration() {
        return duration;
    }

    public String getFair_owner_username() {
        return fair_owner_username;
    }

    public String getStatus() {
        return status;
    }
}
