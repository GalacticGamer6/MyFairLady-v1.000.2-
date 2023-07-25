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

    public static User getUserByUsername(String usernameToSearch) throws SQLException {
        String query = "Select * from tblusers where username = '" + usernameToSearch + "';";

        ResultSet rs = Database.query(query);
        rs.next();
        String username = rs.getString("username");
        String password = rs.getString("password");
        String account_level = rs.getString("AccountLevel");
        User u = new User(username, password, account_level);
        System.out.println(u.toString());

        return u;

    }

    public static ResultSet getUserByAccountLevel(String desired_authority_level) throws SQLException {

        String query = "Select * from tblusers where AccountLevel = '" + desired_authority_level + "';";
        return Database.query(query);

    }
}
