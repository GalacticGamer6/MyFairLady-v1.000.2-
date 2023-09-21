package com.example.myfairlady.Managers;

import com.example.myfairlady.DataTypes.User;
import com.example.myfairlady.UtilityClasses.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserManager {



    public static void addUser(User u) throws SQLException {

        String username = u.getUsername();
        String password = u.getPassword();
        String account_level = u.getAuthoritylevel();

        String query = "INSERT INTO tblusers (username, password, AccountLevel) VALUES ('" + username + "', '" + password + "', '" + account_level + "');";
        Database.update(query);

    }


    public static void deleteUser(User u) throws SQLException {

        String username = u.getUsername();
        String password = u.getPassword();
        String account_level = u.getAuthoritylevel();

        String query = "Delete from tblusers where username = '" + username + "' and password = '" + password + "' and AccountLevel = '" + account_level + "';";

        Database.update(query);
        System.out.println("Successfully Deleted " + u.toString());
    }

    public static ResultSet getUsers() throws SQLException {

        String query = "Select * from tblusers;";
        return Database.query(query);

    }

    public static ResultSet getUserByUsername(String usernameToSearch) throws SQLException {

        String query = "Select * from tblusers where username = '" + usernameToSearch + "';";
        return Database.query(query);

    }

    public static ResultSet getUserByAccountLevel(String desired_authority_level) throws SQLException {

        String query = "Select * from tblusers where AccountLevel = '" + desired_authority_level + "';";
        return Database.query(query);

    }

    public static boolean authenitcateUser(String username, String password) throws SQLException {

        String statment = "Select * from tblusers where Username = '" + username + "' and Password = '" + password + "';";
        System.out.println(statment);
        //check if the resultset is empty
        if(Database.query(statment).next()){
            System.out.println("User exists");
            return true;
        }
        else{
            System.out.println("User does not exist");
            return false;
        }
    }

    public static ResultSet searchUser(String username, String password) throws SQLException {

        String query = "Select * from tblusers where Username = '" + username + "' and Password = '" + password + "';";
        System.out.println(query);
        return Database.query(query);

    }
}
