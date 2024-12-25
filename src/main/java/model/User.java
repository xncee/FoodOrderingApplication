package model;

public class User {
    private String username;
    private String email;
    private String phoneNumber;
    private String name;
    private double balance;
    private String type;

    protected User(String username, String email, String phoneNumber, String name, double balance, String type) {
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.balance = balance;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User [Username=" + username + ", Email=" + email + ", Phone Number=" + phoneNumber + ", Name=" + name + ", Balance=" + balance + ", Type=" + type + "]";
    }
}