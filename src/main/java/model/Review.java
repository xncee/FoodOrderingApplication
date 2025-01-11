package model;

import java.time.LocalDateTime;

public class Review {
    private String reviewId;
    private String orderId;
    private String comment;
    private double rating;
    private LocalDateTime createdAt;

    public Review(String reviewId, String orderId, String comment, double rating, LocalDateTime createdAt) {
        this.reviewId = reviewId;
        this.orderId = orderId;
        this.comment = comment;
        this.rating = rating;
        this.createdAt = createdAt;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
