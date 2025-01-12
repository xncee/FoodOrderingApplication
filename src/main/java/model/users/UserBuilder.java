package model.users;

import model.enums.UserType;

public abstract class UserBuilder<T> {
    protected final UserType userType;
    protected final Integer id;
    protected final String username;
    protected final String fullName;
    protected final String email;
    protected final String phoneNumber;
    protected final String hashedPassword;
    protected double balance;

    public UserBuilder(UserType userType, Integer id, String username, String fullName, String email, String phoneNumber, String hashedPassword) {
        this.userType = userType;
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hashedPassword = hashedPassword;
    }

    public T balance(double balance) {
        this.balance = balance;
        return self();
    }

    protected abstract T self();
    public abstract User build();
}