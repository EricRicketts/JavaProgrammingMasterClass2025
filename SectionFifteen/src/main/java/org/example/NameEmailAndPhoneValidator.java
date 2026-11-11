package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class NameEmailAndPhoneValidator {

    // Supports Unicode letters, combining marks, hyphens, apostrophes, dots, and whitespace
    private static final Pattern VALID_NAME_PATTERN =
        Pattern.compile("^[\\p{L}\\p{M}]+([\\p{L}\\p{M}'\\-\\.\\s]+[\\p{L}\\p{M}]+)*$");


        // RFC 5322 compliant regex
        private static final String EMAIL_STRING =
            "^(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|" +
                "\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")" +
                "@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|" +
                "\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])$";

        private static final String US_PHONE_REGEX = "^(\\+?1)?[2-9]\\d{2}[2-9]\\d{2}\\d{4}$";

        private static final Pattern VALID_EMAIL_PATTERN = Pattern.compile(EMAIL_STRING, Pattern.CASE_INSENSITIVE);


    private NameEmailAndPhoneValidator() {}

    public static boolean isValidUnicodeName(String name) {
        if (name == null || name.isBlank()) {
            return false;
        }
        return VALID_NAME_PATTERN.matcher(name.trim()).matches();
    }

    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        Matcher matcher = VALID_EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidUSPhoneNumber(String phoneNumber) {
        String cleaned = phoneNumber.replaceAll("[\\s\\-()]", "");
        return Pattern.matches(US_PHONE_REGEX, cleaned);
    }

}