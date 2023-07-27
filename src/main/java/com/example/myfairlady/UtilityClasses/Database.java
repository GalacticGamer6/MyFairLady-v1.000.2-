package com.example.myfairlady.UtilityClasses;
import javax.xml.transform.Result;
import java.sql.*;

public class Database{



    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://102.130.115.69:3306/neeraavrDB";
    private static final String username = "neeraavr";
    private static final String password = "Reddam2021";

        private static PreparedStatement statement;
        private static ResultSet result;
        private static Connection connection;

        public static void initDB() throws ClassNotFoundException, SQLException {
            //remember to add the mysql-connector-java library to the dependency list
            Class.forName(driver);
            System.out.println("DB: Database driver loaded");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("DB: Database connection established");
        }

        public static void update(String update) throws SQLException {
            statement = connection.prepareStatement(update);
            statement.executeUpdate();
            statement.close();
        }

        public static ResultSet query(String stmt) throws SQLException {
            statement = connection.prepareStatement(stmt);
            result = statement.executeQuery();
            return result;
        }

        //Mr B's print method
        public static String toString(ResultSet rs) {
            String temp = "";
            try {
                ResultSetMetaData meta = rs.getMetaData();
                int size = meta.getColumnCount();

                while (rs.next()) {
                    for (int i = 1; i <= size; i++) {
                        Object value = rs.getObject(i);
                        temp += " | " + value;
                    }
                    temp += " |";
                    temp += "\n";

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return temp;
        }



}
