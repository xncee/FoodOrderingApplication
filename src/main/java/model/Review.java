package model;

import java.time.LocalDateTime;

public class Review {
    private String orderId;
    private String restaurantId;
    private String reviewText;
    private double rating;
    private LocalDateTime createdDate;

    public Review(String orderId, String restaurantId, String reviewText, double rating, LocalDateTime createdDate) {
        this.orderId = orderId;
        this.restaurantId = restaurantId;
        this.reviewText = reviewText;
        this.rating = rating;
        this.createdDate = createdDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}