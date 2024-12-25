package model;

public class Driver extends User {
    private String licenseNumber;

    // Constructor that extends the User constructor
    public Driver(String username, String email, String phoneNumber, String name, double balance, String licenseNumber, String type) {
        super(username, email, phoneNumber, name, balance, type); // Pass 'type' to the User constructor
        this.licenseNumber = licenseNumber;
    }

    // Getter and setter for licenseNumber
    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    // Override toString method to include 'type' and provide meaningful driver information
    @Override
    public String toString() {
        return "Driver [Type=" + getType() + ", Name=" + getName() + ", Username=" + getUsername() + ", Email=" + getEmail()
                + ", Phone Number=" + getPhoneNumber() + ", License Number=" + licenseNumber + ", Balance=" + getBalance() + "]";
    }
}