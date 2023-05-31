package su.bnair.bpassword.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import su.bnair.bpassword.Instances;

public class DatabaseManager {

    private static Connection connection = null;
    
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(Instances.DATABASE_URL, Instances.USERNAME, Instances.PASSWORD);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
            connection = null;
        }
    }
}