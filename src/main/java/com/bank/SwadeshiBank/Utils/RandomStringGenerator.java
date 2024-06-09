package com.bank.SwadeshiBank.Utils;

import java.security.SecureRandom;
import java.util.Random;

public class RandomStringGenerator {

    private static final String NUMERIC = "0123456789";
    private static final String ALPHANUMERIC = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String ALPHANUMERIC_SPECIAL = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&*()-_=+[]{}|;:'\",.<>?/";
    private static final String DOMAIN = "gmail.com";

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

    public static String generateEmail(int charCount) {
        if (charCount < DOMAIN.length() + 1) {
            throw new IllegalArgumentException("Character count must be greater than the length of the domain plus one character.");
        }

        StringBuilder email = new StringBuilder();
        Random random = new Random();

        int localPartLength = charCount - DOMAIN.length() - 1; // Subtract domain length and '@' character

        for (int i = 0; i < localPartLength; i++) {
            email.append(ALPHANUMERIC.charAt(random.nextInt(ALPHANUMERIC.length())));
        }

        email.append("@").append(DOMAIN);

        return email.toString();
    }
}
