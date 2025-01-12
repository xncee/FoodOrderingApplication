package model.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Hashing {

    private static final int SALT_LENGTH = 16; // 16 bytes for salt
    private static final int ITERATIONS = 65536; // Recommended iterations for PBKDF2
    private static final int KEY_LENGTH = 256; // Key length in bits

    private static byte[] generateSalt() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH]; // Generate salt of 16 bytes
        secureRandom.nextBytes(salt);
        return salt;
    }

    // Hash the password using PBKDF2 with salt
    public static String hash(String value) throws Exception {
        byte[] salt = generateSalt();

        // Use PBKDF2 to hash the password with the salt
        PBEKeySpec spec = new PBEKeySpec(value.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] hashedPassword = factory.generateSecret(spec).getEncoded();

        // Encode salt and hash to Base64 for storage
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String encodedHash = Base64.getEncoder().encodeToString(hashedPassword);

        return encodedSalt + ":" + encodedHash; // Return salt and hash separated by a colon
    }

    // Method to match the entered value with the stored hash
    public static boolean match(String storedHash, String enteredValue) throws Exception {
        // Split the stored hash into salt and hash
        String[] parts = storedHash.split(":");
        if (parts.length != 2) {
            return false;
        }

        String storedSaltBase64 = parts[0];
        String storedHashBase64 = parts[1];

        // Decode the salt and hash
        byte[] salt = Base64.getDecoder().decode(storedSaltBase64);
        byte[] storedDecodedHash = Base64.getDecoder().decode(storedHashBase64);

        // Hash the entered value with the same salt
        PBEKeySpec spec = new PBEKeySpec(enteredValue.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] hashedPassword = factory.generateSecret(spec).getEncoded();

        // Compare the generated hash with the stored hash
        return MessageDigest.isEqual(storedDecodedHash, hashedPassword);
    }
}