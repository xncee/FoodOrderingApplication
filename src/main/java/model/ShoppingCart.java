package model;

import java.util.List;

public class ShoppingCart {
    private String customerId;
    private String restaurantId; // if the cart should only contain items from a specific restaurant.
    private List<OrderItem> items;

    public ShoppingCart(String customerId, String restaurantId, List<OrderItem> items) {
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.items = items;
    }

    public double getTotal() {
        // Dynamically calculate total based on the items list
        return items.stream().mapToDouble(cartItem -> cartItem.getPrice() * cartItem.getQuantity()).sum();
    }
}
