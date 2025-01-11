package model.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import model.exceptions.DatabaseConnectionException;

import java.sql.*;

public class DatabaseManager {
    private static volatile DatabaseManager instance;
    private static HikariDataSource dataSource;

    public DatabaseManager(String dbUrl) throws IllegalArgumentException, DatabaseConnectionException {
        if (dbUrl == null || dbUrl.isEmpty()) {
            throw new IllegalArgumentException("Database URL cannot be null or empty");
        }

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbUrl);
        config.setMaximumPoolSize(10); // Set the max pool size as needed
        config.setMinimumIdle(5); // Set the minimum idle connections

        dataSource = new HikariDataSource(config);
    }

    public static DatabaseManager getInstance(String dbUrl) {
        if (instance == null) {
            synchronized (DatabaseManager.class) {
                if (instance == null) {
                    instance = new DatabaseManager(dbUrl);
                }
            }
        }
        return instance;
    }

    // Public method to get the instance without specifying the URL
    public static DatabaseManager getInstance() {
        if (instance == null) {
            throw new IllegalStateException("DatabaseManager instance is not initialized. Call getInstance() first.");
        }
        return instance;
    }

    // Get a connection from the pool
    public Connection getConnection() throws SQLException {
        if (dataSource == null) {
            throw new IllegalStateException("DataSource is not initialized.");
        }
        return dataSource.getConnection();
    }

    public boolean isConnected() throws SQLException {
        try (Connection connection = getConnection()) {
            return connection != null && !connection.isClosed();
        }
    }
}