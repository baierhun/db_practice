package queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmQueries {

    public static void searchByTitle(Connection conn, String keyword)
            throws SQLException {
        PreparedStatement sql = null;
        try {
            sql = conn.prepareStatement("SELECT * FROM film WHERE title LIKE ? COLLATE NOCASE");
            String search = "%%%s%%".formatted(keyword);
            sql.setString(1, search);
            ResultSet rs = null;
            try {
                rs = sql.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("film_id");
                    String title = rs.getString("title");
                    String description = rs.getString("description");
                    System.out.println("%d: %s | %s".formatted(id, title, description.substring(0, 10) + "..."));
                }
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