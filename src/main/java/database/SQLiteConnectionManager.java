package database;

import java.sql.*;
import java.util.Map;

public class SQLiteConnectionManager {
    Connection conn;

    SQLiteConnectionManager(String dbUrl) {
        try (Connection conn = DriverManager.getConnection(dbUrl)) {
            if (conn != null) {
                System.out.println("Connection to SQLite has been established.");
            }
        }
        catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }

    public int insert(String table, Map<String, Object> colValMap) throws SQLException {
        StringBuilder columns = new StringBuilder();
        StringBuilder values = new StringBuilder();

        for (Map.Entry<String, Object> entry : colValMap.entrySet()) {
            columns.append(entry.getKey()).append(",");
            values.append("'").append(entry.getValue()).append("',");
        }

        // Remove trailing commas
        columns.setLength(columns.length() - 1);
        values.setLength(values.length() - 1);

        String query = "INSERT INTO " + table + " (" + columns + ") VALUES (" + values + ")";
        Statement stmt = conn.createStatement();
        return stmt.executeUpdate(query);
    }
    private void execute(Connection conn, String sql) throws SQLException {
        if (sql.toUpperCase().startsWith("SELECT")) {
            query(conn, sql);
        }
        else {
            Statement statement = conn.createStatement();
            statement.execute(sql);
        }
    }

    private void query(Connection conn, String q) throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(q);

        // Get ResultSet metadata to dynamically handle columns
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();


        while (resultSet.next()) {
            // Loop through all columns in the current row
            for (int i = 1; i <= columnCount; i++) {
                // Get the column name dynamically
                String columnName = metaData.getColumnName(i);
                // Get the value of the current column dynamically
                String columnValue = resultSet.getString(i);

                // Print column name and value
                System.out.println(columnName + ": " + columnValue);
            }
            System.out.println("--------------------------");
        }
    }
}
