-- Insert into Users table
INSERT INTO Users (id, userType, username, fullName, email, phoneNumber, hashedPassword, balance)
VALUES
    ('u1', 'Customer', 'john_doe', 'John Doe', 'john@example.com', '+1234567890', 'hashedpassword1', 100.0),
    ('u2', 'Restaurant', 'pizza_hut', 'Pizza Hut', 'contact@pizzahut.com', '+0987654321', 'hashedpassword2', 0.0),
    ('u3', 'Driver', 'driver_joe', 'Joe Driver', 'joe@example.com', '+1122334455', 'hashedpassword3', 50.0);

-- Insert into Customers table
INSERT INTO Customers (userId, preferences, shoppingCartId)
VALUES
    ('u1', '{"language":"en", "uiTheme":"dark", "prefersEmailNotifications":true}', 'cart1');

-- Insert into Restaurants table
INSERT INTO Restaurants (userId, restaurantName, location, rating)
VALUES
    ('u2', 'Pizza Hut', '123 Main Street', 4.5);

-- Insert into Drivers table
INSERT INTO Drivers (userId, driverLicense, vehicleDetails, isAvailable, rating, preferredPaymentMethod)
VALUES
    ('u3', 'DL123456789', 'Toyota Corolla 2018', 1, 4.8, 'Cash');

-- Insert into Orders table
INSERT INTO Orders (orderId, customerId, restaurantId, deliveryId, orderType, promoCode, discount, total, paymentMethod, paymentStatus, status, placedAt)
VALUES
    ('o1', 'u1', 'u2', 'd1', 'DELIVERY', 'PROMO10', 10.0, 90.0, 'CREDIT_CARD', 'PAID', 'PLACED', '2025-01-11T10:00:00');

-- Insert into OrderItems table
INSERT INTO OrderItems (orderId, itemId, itemName, quantity, price, specialInstructions)
VALUES
    ('o1', 'i1', 'Pepperoni Pizza', 1, 90.0, 'Extra cheese');

-- Insert into Items table
INSERT INTO Items (itemId, restaurantId, category, title, description, image, price, discount, finalPrice, isAvailable)
VALUES
    ('i1', 'u2', 'Pizza', 'Pepperoni Pizza', 'Delicious pepperoni pizza with extra cheese', NULL, 100.0, 10.0, 90.0, 1);

-- Insert into Addresses table
INSERT INTO Addresses (addressId, userId, name, country, city, line1, line2, postalCode, additionalInstructions, isDefault, latitude, longitude, isResidential, phoneNumber)
VALUES
    ('a1', 'u1', 'John Doe', 'USA', 'New York', '123 Main St', NULL, '10001', 'Leave at the door', 1, 40.7128, -74.0060, 1, '+1234567890');

-- Insert into Deliveries table
INSERT INTO Deliveries (trackingNumber, deliveryType, orderId, driverId, addressId, deliveryInstructions, distance, deliveryFee, estimatedDeliveryTime, deliveryStatus, startedAt)
VALUES
    ('d1', 'STANDARD', 'o1', 'u3', 'a1', 'Handle with care', 5.0, 5.0, '2025-01-11T11:00:00', 'IN_TRANSIT', '2025-01-11T10:30:00');

-- Insert into Invoices table
INSERT INTO Invoices (invoiceId, orderId, customerId, restaurantId, totalAmount, tax, discount, finalAmount, issuedAt, paymentStatus, paymentMethod)
VALUES
    ('inv1', 'o1', 'u1', 'u2', 100.0, 5.0, 10.0, 95.0, '2025-01-11T10:05:00', 'PAID', 'CREDIT_CARD');

-- Insert into ShoppingCart table
INSERT INTO ShoppingCart (cartId, customerId, restaurantId, items)
VALUES
    ('cart1', 'u1', 'u2', '[{"itemId":"i1", "quantity":1, "specialInstructions":"Extra cheese"}]');
