package su.bnair.bpassword.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import su.bnair.bpassword.Instances;
import su.bnair.bpassword.models.StoredInformation;

public class DatabaseUtils 
{
	public static void createInformationTable() {
		try (Connection connection = DatabaseManager.getConnection();
			Statement statement = connection.createStatement()) {
			String createTableQuery = "CREATE TABLE IF NOT EXISTS bpassword (" +
	                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
	                    "name VARCHAR(50), " +
	                    "url VARCHAR(255), " +
	                    "user VARCHAR(50), " +
	                    "password VARCHAR(64)" +
	                    ")";
	            statement.executeUpdate(createTableQuery);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void getEveryStoredInformations() {
        Connection connection = null;
        try {
            connection = DatabaseManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM bpassword;");            
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
            	int id = rs.getInt("id");
            	String name = rs.getString("name");
            	String url = rs.getString("url");
            	String user = rs.getString("user");
            	String password = rs.getString("password");
            	StoredInformation si = new StoredInformation(name, url, user, password);
            	Instances.addElementToIdList(si);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public static void addStoredInformation(StoredInformation si) {
		if(si != null) {
			Connection connection = null;
	        try {
	            connection = DatabaseManager.getConnection();
	            PreparedStatement statement = connection.prepareStatement("INSERT INTO bpassword (name, url, user, password) VALUES (?, ?, ?, ?)"); 
	            statement.setString(1, si.getName());
	            statement.setString(2, si.getUrl());
	            statement.setString(3, si.getUser());
	            statement.setString(4, si.getPassword());
	            statement.executeUpdate();
	            System.out.println("Insertion réussie !");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}
    }
}
