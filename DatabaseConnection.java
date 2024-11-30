package main;
import java.sql.*;


public class DatabaseConnection {
	 public static Connection getConnection() {
       try {
           String url = "jdbc:mysql://localhost:3306/SuiteSpotDB";
           String user = "root"; // Your MySQL username
           String password = ""; // Your MySQL password
           return DriverManager.getConnection(url, user, password);
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }
       
       
   }

}
	

