package com.example.myfairlady.UtilityClasses;

import com.example.myfairlady.DataTypes.User;

import java.sql.SQLException;

public class Test {

    public static void main(String[] args) {

        try {
            Database.initDB();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        fair f = new fair()

    }

}
