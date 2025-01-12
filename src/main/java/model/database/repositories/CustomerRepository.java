package model.database.repositories;

import model.*;
import model.database.DatabaseManager;
import model.users.Customer;
import model.users.User;

import java.sql.*;
import java.util.List;

public class CustomerRepository implements IRepository<Customer> {
    protected final DatabaseManager databaseManager = DatabaseManager.getInstance();
    //CRUD
    @Override
    public void save(Customer entity) {
        String sql = "INSERT INTO Users (username, fullName, email, phoneNumber, hashedPassword) VALUES (?, ?, ?, ?, ?)";
        // Execute the insert query for the user, then insert specific customer data
    }
    @Override
    public Customer getById(int id) {
        String sql = "SELECT * FROM Users u " +
                "JOIN Customers c ON u.id = c.userId " +
                "WHERE u.id = ?";
        try (Connection conn = databaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Retrieve common user fields from the Users table
                    //int id = rs.getInt("id");
                    String username = rs.getString("username");
                    String fullName = rs.getString("fullName");
                    String email = rs.getString("email");
                    String phoneNumber = rs.getString("phoneNumber");
                    String hashedPassword = rs.getString("hashedPassword");

                    // Retrieve specific customer fields from the Customers table
//                    CustomerPreferences preferences = getPreferences(rs.getString("preferencesId"));  // Assume this method retrieves preferences
//                    ShoppingCart shoppingCart = getShoppingCart(rs.getString("shoppingCartId"));  // Similarly, assume this method retrieves shopping cart
//                    List<Address> savedAddresses = getSavedAddresses(rs);  // And this one retrieves addresses
//                    List<CreditCard> creditCards = getCreditCards(rs);  // Retrieve the customer's credit cards
//                    List<Order> orderHistory = getOrderHistory(rs);  // Retrieve order history

                    // Use the builder to create and return the Customer object
                    return new Customer.CustomerBuilder(id, username, fullName, email, phoneNumber, hashedPassword)
                            .preferences(null)
                            .shoppingCart(null)
                            .savedAddresses(null)
                            .creditCards(null)
                            .orderHistory(null)
                            .build();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Handle SQL exceptions properly
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle database connection exceptions properly
        }

        return null;  // User Not Found
    }

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public void update(Customer entity) {
        String sql = "UPDATE Users SET username = ?, fullName = ?, email = ?, phoneNumber = ? WHERE id = ?";
        // Execute the update query for user, then update specific customer data if needed
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Customers WHERE userId = ?";
        // Execute delete from Customers table, then delete from Users
    }
}