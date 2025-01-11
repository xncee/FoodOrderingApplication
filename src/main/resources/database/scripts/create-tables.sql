CREATE TABLE Users (
    id NVARCHAR(50) PRIMARY KEY,
    userType NVARCHAR(255) NOT NULL,
    username NVARCHAR(255) NOT NULL UNIQUE,
    fullName NVARCHAR(255) NOT NULL,
    email NVARCHAR(255) NOT NULL UNIQUE,
    phoneNumber NVARCHAR(20) NOT NULL,
    hashedPassword NVARCHAR(MAX) NOT NULL,
    balance FLOAT DEFAULT 0.0
);

CREATE TABLE Customers (
    userId NVARCHAR(50) PRIMARY KEY,
    preferences NVARCHAR(MAX),
    shoppingCartId NVARCHAR(50),
    FOREIGN KEY (userId) REFERENCES Users(id) ON DELETE CASCADE
);

CREATE TABLE Addresses (
    addressId NVARCHAR(50) PRIMARY KEY,
    userId NVARCHAR(50),
    name NVARCHAR(MAX) NOT NULL,
    country NVARCHAR(MAX) NOT NULL,
    city NVARCHAR(MAX) NOT NULL,
    line1 NVARCHAR(MAX) NOT NULL,
    line2 NVARCHAR(MAX),
    postalCode NVARCHAR(20),
    additionalInstructions NVARCHAR(MAX),
    isDefault BIT DEFAULT 0,
    latitude FLOAT,
    longitude FLOAT,
    isResidential BIT DEFAULT 1,
    phoneNumber NVARCHAR(20) NOT NULL,
    FOREIGN KEY (userId) REFERENCES Customers(userId) ON DELETE CASCADE
);

CREATE TABLE Drivers (
    userId NVARCHAR(50) PRIMARY KEY,
    driverLicense NVARCHAR(MAX) NOT NULL,
    vehicleDetails NVARCHAR(MAX) NOT NULL,
    isAvailable BIT DEFAULT 1,
    rating FLOAT DEFAULT 0.0,
    preferredPaymentMethod NVARCHAR(MAX),
    FOREIGN KEY (userId) REFERENCES Users(id) ON DELETE CASCADE
);

CREATE TABLE Restaurants (
    userId NVARCHAR(50) PRIMARY KEY,
    restaurantName NVARCHAR(MAX) NOT NULL,
    location NVARCHAR(MAX) NOT NULL,
    rating FLOAT DEFAULT 0.0,
    FOREIGN KEY (userId) REFERENCES Users(id) ON DELETE CASCADE
);

CREATE TABLE Items (
    itemId NVARCHAR(50) PRIMARY KEY,
    restaurantId NVARCHAR(50),
    category NVARCHAR(MAX) NOT NULL,
    title NVARCHAR(MAX) NOT NULL,
    description NVARCHAR(MAX),
    image NVARCHAR(MAX),
    price FLOAT NOT NULL,
    discount FLOAT DEFAULT 0.0,
    finalPrice FLOAT NOT NULL,
    isAvailable BIT DEFAULT 1,
    FOREIGN KEY (restaurantId) REFERENCES Restaurants(userId) ON DELETE CASCADE
);

CREATE TABLE ShoppingCart (
    cartId NVARCHAR(50) PRIMARY KEY,
    customerId NVARCHAR(50),
    restaurantId NVARCHAR(50),
    items NVARCHAR(MAX) NOT NULL,
    FOREIGN KEY (customerId) REFERENCES Customers(userId) ON DELETE CASCADE,
    FOREIGN KEY (restaurantId) REFERENCES Restaurants(userId)
);

CREATE TABLE Promos (
    code NVARCHAR(50) PRIMARY KEY,
    description NVARCHAR(MAX),
    discount FLOAT NOT NULL,
    minimumTotal FLOAT,
    amountLimit FLOAT,
    expirationDate DATE,
    freeDelivery BIT DEFAULT 0,
    discountType NVARCHAR(MAX) NOT NULL,
    usageLimit INT,
    usageCount INT DEFAULT 0
);

CREATE TABLE Deliveries (
    trackingNumber NVARCHAR(50) PRIMARY KEY,
    deliveryType NVARCHAR(MAX) NOT NULL,
    orderId NVARCHAR(50),
    driverId NVARCHAR(50),
    addressId NVARCHAR(50),
    deliveryInstructions NVARCHAR(MAX),
    distance FLOAT NOT NULL,
    deliveryFee FLOAT NOT NULL,
    estimatedDeliveryTime DATETIME2,
    deliveryStatus NVARCHAR(MAX) NOT NULL,
    startedAt DATETIME2,
    deliveredAt DATETIME2,
    FOREIGN KEY (driverId) REFERENCES Drivers(userId) ON DELETE NO ACTION,
    FOREIGN KEY (addressId) REFERENCES Addresses(addressId) ON DELETE NO ACTION,
);

CREATE TABLE Orders (
    orderId NVARCHAR(50) PRIMARY KEY,
    customerId NVARCHAR(50) NULL,
    restaurantId NVARCHAR(50) NULL,
    deliveryId NVARCHAR(50) NULL,
    orderType NVARCHAR(MAX) NOT NULL,
    promoCode NVARCHAR(50) NULL,
    discount FLOAT DEFAULT 0.0,
    total FLOAT NOT NULL,
    paymentMethod NVARCHAR(MAX) NOT NULL,
    paymentStatus NVARCHAR(MAX) NOT NULL,
    status NVARCHAR(MAX) NOT NULL,
    placedAt DATETIME2 NOT NULL,
    acceptedAt DATETIME2,
    preparedAt DATETIME2,
    completedAt DATETIME2,
    isCanceled BIT DEFAULT 0,
    cancellationReason NVARCHAR(MAX),
    modifiedAt DATETIME2,
    updatedBy NVARCHAR(50),
    updatedAt DATETIME2,
    FOREIGN KEY (customerId) REFERENCES Customers(userId) ON DELETE NO ACTION,  -- No cascade
    FOREIGN KEY (deliveryId) REFERENCES Deliveries(trackingNumber) ON DELETE NO ACTION,  -- No cascade
    FOREIGN KEY (promoCode) REFERENCES Promos(code) ON DELETE NO ACTION,  -- No cascade
    FOREIGN KEY (restaurantId) REFERENCES Restaurants(userId) ON DELETE NO ACTION  -- No cascade
);


CREATE TABLE Invoices (
    invoiceId NVARCHAR(50) PRIMARY KEY,
    orderId NVARCHAR(50),
    customerId NVARCHAR(50),
    restaurantId NVARCHAR(50),
    totalAmount FLOAT NOT NULL,
    tax FLOAT,
    discount FLOAT,
    finalAmount FLOAT NOT NULL,
    issuedAt DATETIME2 NOT NULL,
    paymentStatus NVARCHAR(MAX) NOT NULL,
    paymentMethod NVARCHAR(MAX) NOT NULL,
    FOREIGN KEY (customerId) REFERENCES Customers(userId) ON DELETE NO ACTION,  -- Adjusted to avoid cascade
    FOREIGN KEY (orderId) REFERENCES Orders(orderId) ON DELETE CASCADE,  -- Retaining cascade for orders
    FOREIGN KEY (restaurantId) REFERENCES Restaurants(userId) ON DELETE NO ACTION  -- Adjusted to avoid cascade
);

CREATE TABLE Reviews (
    reviewId NVARCHAR(50) PRIMARY KEY,
    orderId NVARCHAR(50),
    customerId NVARCHAR(50),
    comment NVARCHAR(MAX),
    rating FLOAT CHECK (rating BETWEEN 0 AND 5),
    createdAt DATETIME2 NOT NULL,
    FOREIGN KEY (orderId) REFERENCES Orders(orderId) ON DELETE CASCADE,
    FOREIGN KEY (customerId) REFERENCES Customers(userId) ON DELETE CASCADE
);

