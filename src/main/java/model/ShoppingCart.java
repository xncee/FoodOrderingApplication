package model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ShoppingCart {
    private String customerId;
    private String restaurantId; // if the cart should only contain items from a specific restaurant.
    private List<CartItem> items;
    private LocalDate expiryDate;

    public ShoppingCart(String customerId, String restaurantId, List<CartItem> items, LocalDate expiryDate) {
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.items = items;
        this.expiryDate = expiryDate;
    }

    public double getTotal() {
        // Dynamically calculate total based on the items list
        return items.stream().mapToDouble(cartItem -> cartItem.getPrice() * cartItem.getQuantity()).sum();
    }
}
