package model;

import java.util.Date;

public class Review {
    private User reviewer;
    private String reviewText; // The review text or comment
    private double rating; // 1-5
    private Date date;
    private String reviewedEntity; // The entity being reviewed (e.g., Restaurant or Driver)

    public Review(User reviewer, String reviewText, double rating, String reviewedEntity) {
        this.reviewer = reviewer;
        this.reviewText = reviewText;
        this.rating = rating;
        this.date = new Date(); // Set the current date by default
        this.reviewedEntity = reviewedEntity;
    }

    // Getter and setter methods
    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReviewedEntity() {
        return reviewedEntity;
    }

    public void setReviewedEntity(String reviewedEntity) {
        this.reviewedEntity = reviewedEntity;
    }

    @Override
    public String toString() {
        return "Review [Reviewer=" + reviewer.getName() + ", Rating=" + rating + ", Review Text=" + reviewText
                + ", Date=" + date + ", Reviewed Entity=" + reviewedEntity + "]";
    }
}