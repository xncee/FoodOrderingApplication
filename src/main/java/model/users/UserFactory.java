package model.users;

public interface UserFactory {
    UserBuilder<?> create(String id, String username, String fullName, String email, String phoneNumber, String hashedPassword);
}