package com.bank.SwadeshiBank.Utils;

import java.security.SecureRandom;
import java.util.Random;

public class RandomStringGenerator {

    private static final String NUMERIC = "0123456789";
    private static final String ALPHANUMERIC = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String ALPHANUMERIC_SPECIAL = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&*()-_=+[]{}|;:'\",.<>?/";

    private static final Random RANDOM = new SecureRandom();

    // Generate a random numeric string and return it as a Long
    public static Long generateRandomNumeric(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be positive.");
        }

        StringBuilder result = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            result.append(NUMERIC.charAt(RANDOM.nextInt(NUMERIC.length())));
        }

        return Long.parseLong(result.toString());
    }

    // Generate a random alphanumeric string
    public static String generateRandomAlphanumeric(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be positive.");
        }

        StringBuilder result = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            result.append(ALPHANUMERIC.charAt(RANDOM.nextInt(ALPHANUMERIC.length())));
        }

        return result.toString();
    }

    // Generate a random alphanumeric string with special characters
    public static String generateRandomAlphanumericSpecial(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be positive.");
        }

        StringBuilder result = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            result.append(ALPHANUMERIC_SPECIAL.charAt(RANDOM.nextInt(ALPHANUMERIC_SPECIAL.length())));
        }

        return result.toString();
    }

//    public static void main(String[] args) {
//        // Example usage
//        System.out.println("Random Numeric Long: " + generateRandomNumeric(10));
//        System.out.println("Random Alphanumeric String: " + generateRandomAlphanumeric(10));
//        System.out.println("Random Alphanumeric with Special Characters String: " + generateRandomAlphanumericSpecial(10));
//    }
}
