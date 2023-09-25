package com.example.myfairlady.DataTypes;


public class Store {

//make private fields StoreID,StoreName,OwnerID,FairID,category,Status and profit

    private String StoreID;
    private String StoreName;
    private String OwnerID;
    private String FairID;
    private String category;
    private String Status;
    private Double profit;

    //make constructor for this class
    public Store(String StoreID, String StoreName, String OwnerID, String FairID, String category, String Status, Double profit) {
        this.StoreID = StoreID;
        this.StoreName = StoreName;
        this.OwnerID = OwnerID;
        this.FairID = FairID;
        this.category = category;
        this.Status = Status;
        this.profit = profit;
    }

    //make getters and setters for all fields
    public String getStoreID() {
        return StoreID;
    }
    public String getStoreName() {
        return StoreName;
    }
    public String getOwnerID() {
        return OwnerID;
    }
    public String getFairID() {
        return FairID;
    }
    public String getCategory() {
        return category;
    }
    public String getStatus() {
        return Status;
    }
    public Double getProfit() {
        return profit;
    }


}
