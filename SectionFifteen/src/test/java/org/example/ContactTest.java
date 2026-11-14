package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    private Contact contact;

    @BeforeEach
    public void setUp() {
        contact = new Contact(
            "Eric", "Vernon", "Ricketts",
            "eric_ricketts@icloud.com", new BigInteger("9194495529")
        );
    }

    @Nested
    @DisplayName("test getters for all names")
    class TestGettersForAllNames {

        @Test
        public void testFirstNameGetter() {
            assertEquals("Eric", contact.getFirstName());
        }

        @Test
        public void testLastNameGetter() {
            assertEquals("Ricketts", contact.getLastName());
        }

        @Test
        public void testMiddleNameGetter() {
            assertEquals("Vernon", contact.getMiddleName());
        }

        @Test
        public void testFullNameGetter() {
            assertEquals("Eric Vernon Ricketts", contact.getFullName());
        }
    }

    @Nested
    @DisplayName("test email and phone number getters")
    class TestEmailAndPhoneNumberGetters {

        @Test
        public void testEmailGetter() {
            String emails = "";
            if (!contact.getEmails().isEmpty()) {
                emails = contact.getEmails().iterator().next();
            }
            assertEquals("eric_ricketts@icloud.com", emails);
        }

        @Test
        public void testPhoneGetter() {
            String phones = "";
            if (!contact.getPhones().isEmpty()) {
                phones = contact.getPhones().iterator().next();
            }
            assertEquals("(919) 449-5529", phones);

        }
    }

    @Nested
    @DisplayName("test verification methods")
    class TestVerificationMethods {

        @Test
        public void testVerifyNameMethodBlankFirstName() {
            Exception exception = assertThrowsExactly(
                IllegalArgumentException.class, () -> new Contact(
                    "", "Vernon", "Ricketts",
                    "eric_ricketts@iclod.com", new BigInteger("9194495529")
                ));

            assertEquals("Invalid name format", exception.getMessage());
        }

        @Test
        public void testVerifyNameMethodNullMiddleName() {
            Exception exception = assertThrowsExactly(
                IllegalArgumentException.class, () -> new Contact(
                    "Eric", null, "Ricketts",
                    "eric_ricketts@iclod.com", new BigInteger("9194495529")
                ));

            assertEquals("Invalid name format", exception.getMessage());
        }

        @Test
        public void testVerifyNameMethodIncorrectLastName() {
            Exception exception = assertThrowsExactly(
                IllegalArgumentException.class, () -> new Contact(
                    "Eric", "Vernon", "E@#Name",
                    "eric_ricketts@iclod.com", new BigInteger("9194495529")
                ));

            assertEquals("Invalid name format", exception.getMessage());
        }

        @Test
        public void testVerifyNameDoesNotAllowNumeralsInName() {
            Exception exception = assertThrowsExactly(
                IllegalArgumentException.class, () -> new Contact(
                    "Eric", "Vernon", "E1Name",
                    "eric_ricketts@iclod.com", new BigInteger("9194495529")
                ));

            assertEquals("Invalid name format", exception.getMessage());
        }

    }
}
