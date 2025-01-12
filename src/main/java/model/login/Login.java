package model.login;

import model.database.repositories.CustomerRepository;
import model.database.repositories.UserRepository;
import model.exceptions.DatabaseConnectionException;
import model.exceptions.DatabaseOperationException;
import model.users.Customer;
import model.users.CustomerFactory;
import model.users.User;
import model.users.UserFactory;
import model.utils.Hashing;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login {
    private static final UserRepository userRepository = new UserRepository();
    private static final CustomerRepository customerRepository = new CustomerRepository();
    public static Login instance = null;
    public User user;

    // to prevent direct initialization.
    private Login() {}

    public static Login getInstance() {
        if (instance == null) {
            instance = new Login();
        }
        return instance;
    }

    public boolean signIn(String username_or_email, String password) {
        try {
            return userRepository.authUser(username_or_email, password);
        }
        catch (DatabaseConnectionException databaseConnectionException) {
            return false;
        }
    }
    public boolean signUp(String username, String email, String phoneNumber, String fullName, String password) {
        String hashedPassword;
        try {
            hashedPassword = Hashing.hash(password);
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, "An error occurred while hashing password in 'singUp' method.", e);
            return false;
        }

        UserFactory customerFactory = new CustomerFactory();
        Customer.CustomerBuilder customerBuilder = (Customer.CustomerBuilder) customerFactory.create(null, username, fullName, email, phoneNumber, hashedPassword);
        Customer customer = customerBuilder.build();
        try {
            customerRepository.save(customer);
            return true;
        }
        catch (DatabaseOperationException e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, "SignUp failed.", e);
        }

        return false;
    }
    public void logout() {
        this.user = null;
    }

    public User getUser() {
        return user;
    }
}
