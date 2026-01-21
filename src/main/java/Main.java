import queries.FilmQueries;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlite:/Users/paulbaier/School/SoftwareEngineering/db/Sakila";
        Database db = new Database(url);
        db.connect();
        String input = null;
        Scanner in = new Scanner(System.in);
        try {
            while (true) {
                System.out.print("Search for a movie title> ");
                input = in.nextLine();
                if (input.equals("exit")) break;
                FilmQueries.searchByTitle(db.getConnection(), input);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
    }
}
