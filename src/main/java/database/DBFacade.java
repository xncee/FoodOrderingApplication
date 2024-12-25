package database;

import model.Item;
import model.Restaurant;
import model.User;

import java.sql.SQLException;
import java.util.Map;

public class DBFacade {
    String USERS_TABLE = "users";
    SQLiteConnectionManager conn;
    public DBFacade(String dbUrl) {
        conn = new SQLiteConnectionManager(dbUrl);
    }

    public boolean addUser(User user) throws SQLException {
        Map<String, Object> map = Map.of(
                "username", user.getUsername(),
                "email", user.getEmail(),
                "phone_number", user.getPhoneNumber(),
                "name", user.getName()
        );
        return conn.insert(USERS_TABLE, map) > 0;
    }

    public boolean addRestaurant(Restaurant restaurant) {
        return true;
    }

    public boolean addOrder(Restaurant restaurant) {
        return true;
    }

    public boolean addItem(Item item) {
        return true;
    }
}
