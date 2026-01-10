import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlite:/Users/paulbaier/School/SoftwareEngineering/db/Sakila";
        Connection conn = null;
        PreparedStatement sql = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connected to SQLite!");
            sql = conn.prepareStatement("SELECT * FROM actor");
            ResultSet rs = null;
            try {
                rs = sql.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("actor_id");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    System.out.println("%d: %s %s".formatted(id, firstName, lastName));
                }
            } finally {
                if (rs != null) rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (sql != null) sql.close();
            if (conn != null) conn.close();
        }
    }
}
