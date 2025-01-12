package model.users;

import model.Item;
import model.enums.UserType;

import java.util.List;

public class Restaurant extends User {
    public static class RestaurantBuilder extends UserBuilder<RestaurantBuilder> {
        private String restaurantName;
        private String location;
        private List<Item> menuItems;
        private double rating;

        public RestaurantBuilder(int id, String username, String fullName, String email, String phoneNumber, String hashedPassword) {
            super(UserType.RESTAURANT, id, username, fullName, email, phoneNumber, hashedPassword);
        }

        public RestaurantBuilder restaurantName(String restaurantName) {
            this.restaurantName = restaurantName;
            return this;
        }
        public RestaurantBuilder location(String location) {
            this.location = location;
            return this;
        }
        public RestaurantBuilder menuItems(List<Item> menuItems) {
            this.menuItems = menuItems;
            return this;
        }
        public RestaurantBuilder rating(double rating) {
            this.rating = rating;
            return this;
        }

        @Override
        protected RestaurantBuilder self() {
            return this;
        }

        @Override
        public Restaurant build() {
            return new Restaurant(this);
        }
    }

    private String restaurantName;
    private String location;
    private List<Item> menuItems;
    private double rating;

    private Restaurant(RestaurantBuilder builder) {
        super(builder);
        this.restaurantName = builder.restaurantName;
        this.location = builder.location;
        this.menuItems = builder.menuItems;
        this.rating = builder.rating;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Item> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<Item> menuItems) {
        this.menuItems = menuItems;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return super.toString()+"\nRestaurant{" +
                "restaurantName='" + restaurantName + '\'' +
                ", location='" + location + '\'' +
                ", menuItems=" + menuItems +
                ", rating=" + rating +
                '}';
    }
}
