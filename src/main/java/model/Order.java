package model;

import model.Customer;

import java.util.List;

public class Order {
    private String orderId;
    private Customer customer;
    private Restaurant restaurant;
    private Driver driver;
    private List<Item> items;  // List of Item objects representing the items in the order
    private double totalPrice;
    private String status;
    private String orderDate;

    // Constructor to initialize order details
    public Order(String orderId, Customer customer, Restaurant restaurant, Driver driver, List<Item> items, double totalPrice, String status, String orderDate) {
        this.orderId = orderId;
        this.customer = customer;
        this.driver = driver;
        this.restaurant = restaurant;
        this.items = items;
        this.totalPrice = totalPrice;
        this.status = status;
        this.orderDate = orderDate;
    }

    // Getters and setters for the attributes
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order [Order ID=" + orderId + ", Customer=" + customer.getName() + ", Items=" + items
                + ", Total Price=" + totalPrice + ", Status=" + status + ", Order Date=" + orderDate + "]";
    }
}
