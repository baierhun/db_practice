import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:/Users/paulbaier/School/SoftwareEngineering/db/Sakila";
        try {
            DriverManager.getConnection(url);
            System.out.println("Connected to SQLite!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
