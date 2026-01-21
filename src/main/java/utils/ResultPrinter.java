package utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultPrinter {
    public static void print(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        String separater = "-".repeat(12 * columnCount + columnCount - 1);
        for (int i = 1; i <= columnCount; i++) {
            System.out.print("%-10.10s | ".formatted(metaData.getColumnName(i)));
        }
        System.out.println();
        System.out.println(separater);
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print("%-10.10s | ".formatted(rs.getString(i)));
            }
            System.out.println();
        }
        System.out.println(separater);
    }
}
