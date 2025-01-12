package model.users;

import model.Delivery;
import model.enums.UserType;

import java.util.List;

public class Driver extends User {
    public static class DriverBuilder extends UserBuilder<DriverBuilder> {
        private String driverLicense;
        private String vehicleDetails;
        private List<Delivery> deliveries;
        private boolean isAvailable;
        private double rating;
        private String preferredPaymentMethod;

        public DriverBuilder(int id, String username, String fullName, String email, String phoneNumber, String hashedPassword) {
            super(UserType.DRIVER, id, username, fullName, email, phoneNumber, hashedPassword);
        }

        public DriverBuilder driverLicense(String driverLicense) {
            this.driverLicense = driverLicense;
            return this;
        }
        public DriverBuilder vehicleDetails(String vehicleDetails) {
            this.vehicleDetails = vehicleDetails;
            return this;
        }
        public DriverBuilder deliveries(List<Delivery> deliveries) {
            this.deliveries = deliveries;
            return this;
        }
        public DriverBuilder rating(double rating) {
            this.rating = rating;
            return this;
        }
        public DriverBuilder isAvailable(boolean isAvailable) {
            this.isAvailable = isAvailable;
            return this;
        }
        public DriverBuilder preferredPaymentMethod(String preferredPaymentMethod) {
            this.preferredPaymentMethod = preferredPaymentMethod;
            return this;
        }

        @Override
        protected DriverBuilder self() {
            return this;
        }

        @Override
        public User build() {
            return new Driver(this);
        }
    }
    private String driverLicense;
    private String vehicleDetails;
    private List<Delivery> deliveries;
    private boolean isAvailable;
    private double rating;
    private String preferredPaymentMethod;

    private Driver(DriverBuilder driverBuilder) {
        super(driverBuilder);
        this.driverLicense = driverBuilder.driverLicense;
        this.vehicleDetails = driverBuilder.vehicleDetails;
        this.deliveries = driverBuilder.deliveries;
        this.isAvailable = driverBuilder.isAvailable;
        this.rating = driverBuilder.rating;
        this.preferredPaymentMethod = driverBuilder.preferredPaymentMethod;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public String getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(String vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getPreferredPaymentMethod() {
        return preferredPaymentMethod;
    }

    public void setPreferredPaymentMethod(String preferredPaymentMethod) {
        this.preferredPaymentMethod = preferredPaymentMethod;
    }
}
