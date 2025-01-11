package model.users;

public class CustomerFactory implements UserFactory {

    @Override
    public Customer.CustomerBuilder create(String id, String username, String fullName, String email, String phoneNumber, String hashedPassword) {
        return new Customer.CustomerBuilder(id, username, fullName, email, phoneNumber, hashedPassword);
    }
}
