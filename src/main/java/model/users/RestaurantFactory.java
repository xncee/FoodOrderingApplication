package model.users;

public class RestaurantFactory implements UserFactory {
    @Override
    public Restaurant.RestaurantBuilder create(String id, String username, String fullName, String email, String phoneNumber, String hashedPassword) {
        return new Restaurant.RestaurantBuilder(id, username, fullName, email, phoneNumber, hashedPassword);
    }
}
