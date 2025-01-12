package model;

public class CreditCard {
    private final String type;
    private final String name;
    private final String cardNumber;
    private final String expiryDate;
    private final String cvv;

    private CreditCard(String type, String name, String cardNumber, String expiryDate, String cvv) {
        this.type = type;
        this.name = name;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    public static CreditCard create(String type, String name, String cardNumber, String expiryDate, String cvv) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Type cannot be null or empty");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (cardNumber == null || cardNumber.length() < 13 || cardNumber.length() > 19) {
            throw new IllegalArgumentException("Card number must be between 13 and 19 digits");
        }
        if (expiryDate == null || !expiryDate.matches("(0[1-9]|1[0-2])/\\d{2}")) {
            throw new IllegalArgumentException("Invalid expiry date format. Use MM/YY");
        }
        if (cvv == null || (cvv.length() != 3 && cvv.length() != 4)) {
            throw new IllegalArgumentException("CVV must be 3 or 4 digits");
        }
        return new CreditCard(type, name, cardNumber, expiryDate, cvv);
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getCvv() {
        return cvv;
    }
}
