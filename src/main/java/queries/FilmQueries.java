package queries;

import utils.ResultPrinter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmQueries {

    public static void searchByTitle(Connection conn, String keyword)
            throws SQLException {
        PreparedStatement sql = null;
        try {
            sql = conn.prepareStatement("SELECT film_id, title, description FROM film WHERE title LIKE ? COLLATE " +
                    "NOCASE");
            String search = "%%%s%%".formatted(keyword);
            sql.setString(1, search);
            ResultSet rs = null;
            try {
                rs = sql.executeQuery();
                ResultPrinter.print(rs);
            } finally {
                if (rs != null) rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (sql != null) sql.close();
        }
    }
}