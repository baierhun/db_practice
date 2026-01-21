import java.sql.SQLException;

/*
sakila/
 ├── Main.java
 ├── Database.java
 ├── App.java
 ├── util/
 │    └── ResultPrinter.java
 └── queries/
      ├── FilmQueries.java
      ├── ActorQueries.java
      ├── CustomerQueries.java
      ├── StoreQueries.java
      └── ReportQueries.java

 */

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlite:/Users/paulbaier/School/SoftwareEngineering/db/Sakila";
        Database db = new Database(url);
        db.connect();
        try {
            App.run(db.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
    }
}
