package model;

import model.enums.ItemCategory;
import model.users.Restaurant;

import java.util.List;

public class Item {
    private String itemId;
    private Restaurant restaurant;
    private ItemCategory category;
    private List<String> tags;
    private String image;
    private String title;
    private String description;
    private List<String> customizations;
    private double price;
    private double discount;
    private double finalPrice;
    private boolean isAvailable;

    public Item(String itemId, Restaurant restaurant, ItemCategory category, List<String> tags, String image, String title, String description, List<String> customizations, double price, double discount, double finalPrice, boolean isAvailable) {
        this.itemId = itemId;
        this.restaurant = restaurant;
        this.category = category;
        this.tags = tags;
        this.image = image;
        this.title = title;
        this.description = description;
        this.customizations = customizations;
        this.price = price;
        this.discount = discount;
        this.finalPrice = finalPrice;
        this.isAvailable = isAvailable;
    }
}
