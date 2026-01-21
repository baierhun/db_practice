import queries.FilmQueries;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
    public static void run(Connection conn) throws SQLException {
        String input;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Search for a movie title> ");
            input = in.nextLine();
            if (input.equals("exit")) break;
            FilmQueries.searchByTitle(conn, input);
        }
    }
}
