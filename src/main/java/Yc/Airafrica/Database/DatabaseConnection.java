package Yc.Airafrica.Database;
import org.jboss.jdeparser.JTry;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;


    private DatabaseConnection() {

        try {
            Class.forName("org.postgresql.Driver");
            String dburl = "jdbc:postgresql://localhost:5432/AirAfrica";
            String username = "postgres";
            String password = "";
            this.connection = DriverManager.getConnection(dburl, username, password);
            System.out.println("Connected to the database");
        } catch (ClassNotFoundException | SQLException  e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
