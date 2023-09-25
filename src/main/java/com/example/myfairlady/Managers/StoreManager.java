package com.example.myfairlady.Managers;
import com.example.myfairlady.DataTypes.Fair;
import com.example.myfairlady.DataTypes.Store;
import com.example.myfairlady.UtilityClasses.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StoreManager {

    public static ResultSet getStores(String FairID) throws SQLException {

        String statement = "Select * from tblstores where FairID = '" + FairID + "'";
        return Database.query(statement);
    }


}
