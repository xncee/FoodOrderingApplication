package model;

import model.enums.DiscountType;

import java.time.LocalDate;

public class Promo {
    private final String code;
    private final String description;
    private final double discount;
    private final double minimumTotal;
    private final double amountLimit;
    private final LocalDate expirationDate;
    private final boolean freeDelivery;
    private final DiscountType discountType;
    private final int usageLimit; // Maximum number of times this promo can be used
    private int usageCount; // How many times the promo has been used

    private Promo(PromoBuilder builder) {
        this.code = builder.code;
        this.description = builder.description;
        this.discount = builder.discount;
        this.minimumTotal = builder.minimumTotal;
        this.amountLimit = builder.amountLimit;
        this.expirationDate = builder.expirationDate;
        this.freeDelivery = builder.freeDelivery;
        this.discountType = builder.discountType;
        this.usageLimit = builder.usageLimit;
        this.usageCount = 0;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public double getDiscount() {
        return discount;
    }

    public double getMinimumTotal() {
        return minimumTotal;
    }

    public double getAmountLimit() {
        return amountLimit;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public boolean isFreeDelivery() {
        return freeDelivery;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public int getUsageLimit() {
        return usageLimit;
    }

    public int getUsageCount() {
        return usageCount;
    }

    public boolean isUsageAvailable() {
        return usageCount < usageLimit;
    }

    public void incrementUsage() {
        if (isUsageAvailable()) {
            usageCount++;
        } else {
            throw new IllegalStateException("Usage limit exceeded for promo: " + code);
        }
    }

    public static class PromoBuilder {
        private final String code;
        private final double discount;
        private final LocalDate expirationDate;
        private final DiscountType discountType;
        private String description;
        private double minimumTotal;
        private double amountLimit;
        private boolean freeDelivery;
        private int usageLimit = -1; // Default: Unlimited

        public PromoBuilder(String code, double discount, LocalDate expirationDate, DiscountType discountType) {
            if (code == null || code.trim().isEmpty()) {
                throw new IllegalArgumentException("Promo code cannot be null or empty");
            }
            if (discount <= 0) {
                throw new IllegalArgumentException("Discount must be greater than 0");
            }
            if (expirationDate == null || expirationDate.isBefore(LocalDate.now())) {
                throw new IllegalArgumentException("Expiration date must be in the future");
            }
            if (discountType == null) {
                throw new IllegalArgumentException("Discount type cannot be null");
            }

            this.code = code;
            this.discount = discount;
            this.expirationDate = expirationDate;
            this.discountType = discountType;
        }

        public PromoBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public PromoBuilder setMinimumTotal(double minimumTotal) {
            this.minimumTotal = minimumTotal;
            return this;
        }

        public PromoBuilder setAmountLimit(double amountLimit) {
            this.amountLimit = amountLimit;
            return this;
        }

        public PromoBuilder setFreeDelivery(boolean freeDelivery) {
            this.freeDelivery = freeDelivery;
            return this;
        }

        public PromoBuilder setUsageLimit(int usageLimit) {
            if (usageLimit <= 0) {
                throw new IllegalArgumentException("Usage limit must be greater than 0");
            }
            this.usageLimit = usageLimit;
            return this;
        }

        public Promo build() {
            return new Promo(this);
        }
    }
}