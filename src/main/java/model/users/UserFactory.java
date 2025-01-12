package model.users;

public interface UserFactory {
    UserBuilder<?> create(Integer id, String username, String fullName, String email, String phoneNumber, String hashedPassword);
}