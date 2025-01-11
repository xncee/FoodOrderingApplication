package model.users;

import model.*;
import model.enums.UserType;

import java.util.List;

public class Customer extends User {
    public static class CustomerBuilder extends UserBuilder<CustomerBuilder> {
        // customer specific fields
        private CustomerPreferences preferences;
        private ShoppingCart shoppingCart;
        private List<Address> savedAddresses;
        private List<CreditCard> creditCards;
        private List<Order> orderHistory;

        public CustomerBuilder(String id, String username, String fullName, String email, String phoneNumber, String hashedPassword) {
            super(UserType.CUSTOMER, id, username, fullName, email, phoneNumber, hashedPassword);
        }

        public CustomerBuilder preferences(CustomerPreferences preferences) {
            this.preferences = preferences;
            return this;
        }

        public CustomerBuilder shoppingCart(ShoppingCart shoppingCart) {
            this.shoppingCart = shoppingCart;
            return this;
        }

        public CustomerBuilder savedAddresses(List<Address> savedAddresses) {
            this.savedAddresses = savedAddresses;
            return this;
        }

        public CustomerBuilder creditCards(List<CreditCard> creditCards) {
            this.creditCards = creditCards;
            return this;
        }

        public CustomerBuilder orderHistory(List<Order> orderHistory) {
            this.orderHistory = orderHistory;
            return this;
        }

        @Override
        protected CustomerBuilder self() {
            return this;
        }

        @Override
        public Customer build() {
            return new Customer(this);
        }
    }

    private CustomerPreferences preferences;
    private ShoppingCart shoppingCart;
    private List<Address> savedAddresses;
    private List<CreditCard> creditCards;
    private List<Order> orderHistory;

    public Customer(CustomerBuilder customerBuilder) {
        super(customerBuilder);
        this.preferences = customerBuilder.preferences;
        this.shoppingCart = customerBuilder.shoppingCart;
        this.savedAddresses = customerBuilder.savedAddresses;
        this.creditCards = customerBuilder.creditCards;
        this.orderHistory = customerBuilder.orderHistory;
    }

    public CustomerPreferences getPreferences() {
        return preferences;
    }

    public void setPreferences(CustomerPreferences preferences) {
        this.preferences = preferences;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public List<Address> getSavedAddresses() {
        return savedAddresses;
    }

    public void setSavedAddresses(List<Address> savedAddresses) {
        this.savedAddresses = savedAddresses;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(List<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }

    @Override
    public String toString() {
        return super.toString()+"\nCustomer{" +
                "preferences=" + preferences +
                ", shoppingCart=" + shoppingCart +
                ", savedAddresses=" + savedAddresses +
                ", creditCards=" + creditCards +
                ", orderHistory=" + orderHistory +
                '}';
    }
}