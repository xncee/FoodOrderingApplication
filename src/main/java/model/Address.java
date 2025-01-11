package model;

public class Address {
    private String name; // Name of the recipient or owner of the address
    private String country;
    private String city;
    private String line1;
    private String line2; // Optional
    private String postalCode;
    private String additionalInstructions; // special delivery instructions
    private boolean isDefault; // Whether this is the default address for the customer
    private double latitude; // Geolocation latitude (optional)
    private double longitude; // Geolocation longitude (optional)
    private String phoneNumber; // Contact number at this address

    public Address(String name, String country, String city, String line1, String line2) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.line1 = line1;
        this.line2 = line2;
    }

    public Address(String name, String line1, String line2, String city, String postalCode,
                   String country, String additionalInstructions, boolean isDefault, double latitude,
                   double longitude, String phoneNumber) {
        this.name = name;
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.additionalInstructions = additionalInstructions;
        this.isDefault = isDefault;
        this.latitude = latitude;
        this.longitude = longitude;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters for all attributes

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAdditionalInstructions() {
        return additionalInstructions;
    }

    public void setAdditionalInstructions(String additionalInstructions) {
        this.additionalInstructions = additionalInstructions;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
