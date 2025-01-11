package model;

import model.enums.DeliveryStatus;

import java.time.LocalDateTime;

public class Delivery {
    private String trackingNumber;
    private String deliveryType;  // e.g., "standard" or "rush"
    private String orderId;
    private String driverId;
    private Address address;
    private String deliveryInstructions;
    private double distance;
    private double deliveryFee;
    private LocalDateTime estimatedDeliveryTime;
    private DeliveryStatus deliveryStatus;
    private LocalDateTime startedAt;
    private LocalDateTime deliveredAt;

    public Delivery(String trackingNumber, String deliveryType, String orderId, String driverId, Address address, String deliveryInstructions, double distance, double deliveryFee, LocalDateTime estimatedDeliveryTime, DeliveryStatus deliveryStatus, LocalDateTime startedAt, LocalDateTime deliveredAt) {
        this.trackingNumber = trackingNumber;
        this.deliveryType = deliveryType;
        this.orderId = orderId;
        this.driverId = driverId;
        this.address = address;
        this.deliveryInstructions = deliveryInstructions;
        this.distance = distance;
        this.deliveryFee = deliveryFee;
        this.estimatedDeliveryTime = estimatedDeliveryTime;
        this.deliveryStatus = deliveryStatus;
        this.startedAt = startedAt;
        this.deliveredAt = deliveredAt;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDeliveryInstructions() {
        return deliveryInstructions;
    }

    public void setDeliveryInstructions(String deliveryInstructions) {
        this.deliveryInstructions = deliveryInstructions;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public LocalDateTime getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public void setEstimatedDeliveryTime(LocalDateTime estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDateTime getDeliveredAt() {
        return deliveredAt;
    }

    public void setDeliveredAt(LocalDateTime deliveredAt) {
        this.deliveredAt = deliveredAt;
    }
}
