package model;

import java.time.LocalDateTime;

public class Invoice {
    private String invoiceId;
    private String orderId;
    private String customerId;
    private String restaurantId;
    private double totalAmount;
    private double tax;
    private double discount;
    private double finalAmount; // After applying tax and discount
    private LocalDateTime issuedAt;
    private String paymentStatus; // e.g., "PAID", "PENDING", "FAILED"
    private String paymentMethod; // e.g., "CREDIT_CARD", "CASH"

    public Invoice(String invoiceId, String orderId, String customerId, String restaurantId, double totalAmount, double tax, double discount, double finalAmount, LocalDateTime issuedAt, String paymentStatus, String paymentMethod) {
        this.invoiceId = invoiceId;
        this.orderId = orderId;
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.totalAmount = totalAmount;
        this.tax = tax;
        this.discount = discount;
        this.finalAmount = finalAmount;
        this.issuedAt = issuedAt;
        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }

    public LocalDateTime getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(LocalDateTime issuedAt) {
        this.issuedAt = issuedAt;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
