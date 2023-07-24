package com.example.myfairlady.Managers;

import com.example.myfairlady.DataTypes.User;
import com.example.myfairlady.UtilityClasses.Database;

import java.sql.SQLException;

public class UserManager {

    public static void deleteUser(String username, String password) {

        String query = "SELECT * FROM tblusers WHERE username = '" + username + "' AND password = '" + password + "';";

    }

    public static void addUser(User u) throws SQLException {

        String username = u.getUsername();
        String password = u.getPassword();
        String account_level = u.getAuthoritylevel();

        String query = "INSERT INTO tblusers (username, password, AccountLevel) VALUES ('" + username + "', '" + password + "', '" + account_level + "');";
        Database.update(query);

    }


}
