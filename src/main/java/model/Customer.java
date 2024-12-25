package model;

public class Customer extends User {

    public Customer(String username, String email, String phoneNumber, String name, double balance, String type) {
        super(username, email, phoneNumber, name, balance, type); // Pass 'type' to the User constructor
    }

    @Override
    public String toString() {
        return "Customer [Type=" + getType() + ", Name=" + getName() + ", Username=" + getUsername()
                + ", Email=" + getEmail() + ", Phone Number=" + getPhoneNumber() + ", Balance=" + getBalance() + "]";
    }
}
