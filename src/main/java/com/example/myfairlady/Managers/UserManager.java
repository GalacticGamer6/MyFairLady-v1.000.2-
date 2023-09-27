package com.example.myfairlady.Managers;

import com.example.myfairlady.DataTypes.User;
import com.example.myfairlady.UtilityClasses.Database;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserManager {

    //check if user to be added already exists take in username and pasword
    public static boolean userExists(String username,String password) throws SQLException {

            String query = "Select * from tblusers where Username = '" + username + "' and Password = '" + password + "';";
            System.out.println(query);

            //check if the resultset is empty
            if(Database.query(query).next()){
                return true;
            }
            else{
                return false;
            }
    }

    public static User returnUser(String username, String password) throws SQLException {

        ResultSet rs = searchUser(username,password);

        //fill up a user boject with the data from the resultset
        rs.next();
        int UserID = rs.getInt("UserID");
        String current_username = rs.getString("Username");
        String current_password = rs.getString("Password");
        String accountLevel = rs.getString("AccountLevel");

        User u = new User(UserID + "",current_username,current_password,accountLevel);
        return u;

    }

    public static void addUser(String username,String password,String account_level) throws SQLException {


        String query = "INSERT INTO tblusers (username, password, AccountLevel) VALUES ('" + username + "', '" + password + "', '" + account_level + "');";
        Database.update(query);

    }

    //kust use the userID primary key()
    public static void deleteUser(String userID) throws SQLException {


        String query = "Delete from tblusers where UserID = '" + userID + "';";

        Database.update(query);
    }

    public static ResultSet getUsers() throws SQLException {

        String query = "Select * from tblusers;";
        return Database.query(query);

    }

    public static ResultSet getAdminAndFairUsers() throws SQLException {

        String statement = "Select * from tblusers where AccountLevel = 'Fair Owner' or AccountLevel = 'Admin';";
        return Database.query(statement);

    }

    public static ResultSet getAdminAndFairUsersSorted(String sorted_by,String order) throws SQLException {

        String statement = "Select * from tblusers where AccountLevel = 'Fair Owner' or AccountLevel = 'Admin' order by " + sorted_by + " " + order + ";";
        return Database.query(statement);
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
