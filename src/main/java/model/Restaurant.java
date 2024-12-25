package model;

public class Restaurant extends User {
    private String location;
    private double rating;
    private String description;

    public Restaurant(String username, String email, String phoneNumber, String name, double balance,
                      String location, double rating, String description, String type) {
        super(username, email, phoneNumber, name, balance, type); // Pass 'type' to the User constructor
        this.location = location;
        this.rating = rating;
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Override toString method to include 'type' and other restaurant details
    @Override
    public String toString() {
        return "Restaurant [Type=" + getType() + ", Name=" + getName() + ", Username=" + getUsername()
                + ", Email=" + getEmail() + ", Phone Number=" + getPhoneNumber() + ", Location=" + location
                + ", Rating=" + rating + ", Description=" + description + ", Balance=" + getBalance() + "]";
    }
}
