package model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    public static class OrderBuilder {
        private String orderId;
        private String restaurantId;
        private String customerId;
        private String deliveryId;
        private String orderType;
        private ShoppingCart shoppingCart;
        private Promo promoCode;
        private double discount;
        private double total;
        private String paymentMethod;
        private String paymentStatus;
        private LocalDateTime placedAt;
        private LocalDateTime acceptedAt;
        private LocalDateTime preparedAt;
        private LocalDateTime completedAt;
        private Review review;
        private String status;
        private boolean isCanceled;
        private String cancellationReason;

        public OrderBuilder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public OrderBuilder setRestaurantId(String restaurantId) {
            this.restaurantId = restaurantId;
            return this;
        }

        public OrderBuilder setCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public OrderBuilder setDeliveryId(String deliveryId) {
            this.deliveryId = deliveryId;
            return this;
        }

        public OrderBuilder setOrderType(String orderType) {
            this.orderType = orderType;
            return this;
        }

        public OrderBuilder setShoppingCart(ShoppingCart shoppingCart) {
            this.shoppingCart = shoppingCart;
            return this;
        }

        public OrderBuilder setPromoCode(Promo promoCode) {
            this.promoCode = promoCode;
            return this;
        }

        public OrderBuilder setDiscount(double discount) {
            this.discount = discount;
            return this;
        }

        public OrderBuilder setTotal(double total) {
            this.total = total;
            return this;
        }

        public OrderBuilder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public OrderBuilder setPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        public OrderBuilder setPlacedAt(LocalDateTime placedAt) {
            this.placedAt = placedAt;
            return this;
        }

        public OrderBuilder setAcceptedAt(LocalDateTime acceptedAt) {
            this.acceptedAt = acceptedAt;
            return this;
        }

        public OrderBuilder setPreparedAt(LocalDateTime preparedAt) {
            this.preparedAt = preparedAt;
            return this;
        }

        public OrderBuilder setCompletedAt(LocalDateTime completedAt) {
            this.completedAt = completedAt;
            return this;
        }

        public OrderBuilder setReview(Review review) {
            this.review = review;
            return this;
        }

        public OrderBuilder setStatus(String status) {
            this.status = status;
            return this;
        }

        public OrderBuilder setIsCanceled(boolean isCanceled) {
            this.isCanceled = isCanceled;
            return this;
        }

        public OrderBuilder setCancellationReason(String cancellationReason) {
            this.cancellationReason = cancellationReason;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

    private String orderId;
    private String restaurantId;
    private String customerId;
    private String deliveryId;
    private String orderType;
    private ShoppingCart shoppingCart;
    private Promo promoCode;
    private double discount;
    private double total;
    private String paymentMethod;
    private String paymentStatus;
    private LocalDateTime placedAt;
    private LocalDateTime acceptedAt;
    private LocalDateTime preparedAt;
    private LocalDateTime completedAt;
    private Review review;
    private String status;
    private boolean isCanceled;
    private String cancellationReason;

    private Order(OrderBuilder builder) {
        this.orderId = builder.orderId;
        this.restaurantId = builder.restaurantId;
        this.customerId = builder.customerId;
        this.deliveryId = builder.deliveryId;
        this.orderType = builder.orderType;
        this.shoppingCart = builder.shoppingCart;
        this.promoCode = builder.promoCode;
        this.discount = builder.discount;
        this.total = builder.total;
        this.paymentMethod = builder.paymentMethod;
        this.paymentStatus = builder.paymentStatus;
        this.placedAt = builder.placedAt;
        this.acceptedAt = builder.acceptedAt;
        this.preparedAt = builder.preparedAt;
        this.completedAt = builder.completedAt;
        this.review = builder.review;
        this.status = builder.status;
        this.isCanceled = builder.isCanceled;
        this.cancellationReason = builder.cancellationReason;
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Promo getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(Promo promoCode) {
        this.promoCode = promoCode;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getPlacedAt() {
        return placedAt;
    }

    public void setPlacedAt(LocalDateTime placedAt) {
        this.placedAt = placedAt;
    }

    public LocalDateTime getAcceptedAt() {
        return acceptedAt;
    }

    public void setAcceptedAt(LocalDateTime acceptedAt) {
        this.acceptedAt = acceptedAt;
    }

    public LocalDateTime getPreparedAt() {
        return preparedAt;
    }

    public void setPreparedAt(LocalDateTime preparedAt) {
        this.preparedAt = preparedAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }

    public String getCancellationReason() {
        return cancellationReason;
    }

    public void setCancellationReason(String cancellationReason) {
        this.cancellationReason = cancellationReason;
    }
}