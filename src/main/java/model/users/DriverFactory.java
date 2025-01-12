package model.users;

public class DriverFactory implements UserFactory {
    @Override
    public Driver.DriverBuilder create(Integer id, String username, String fullName, String email, String phoneNumber, String hashedPassword) {
        return new Driver.DriverBuilder(id, username, fullName, email, phoneNumber, hashedPassword);
    }
}
