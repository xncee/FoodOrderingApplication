package model.database;

import model.Order;
import model.database.repositories.UserRepository;
import model.users.Customer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DBFacade {
    private static DBFacade instance;

    public static DBFacade getInstance(UserRepository userRepo) {
        return instance;
    }
    public static DBFacade getInstance() {
        if (instance == null) {
            Logger.getLogger(DBFacade.class.getName()).log(Level.SEVERE, "Instance wasn't instantiated yet.");
        }
        return instance;
    }

    public boolean addCustomer(Customer customer) {
        // add common attributes to Users table.
        // add other attributes to Customers table.
        return false;
    }
    public boolean placeOrder(Order order) {
        //
        return false;
    }
}
