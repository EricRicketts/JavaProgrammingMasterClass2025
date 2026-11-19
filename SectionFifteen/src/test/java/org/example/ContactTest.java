package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    private Contact contact, secondContact;

    @BeforeEach
    public void setUp() {
        contact = new Contact(
            "Eric",
            "Vernon",
            "Ricketts",
            "eric_ricketts@icloud.com",
            BigInteger.valueOf(9194495529L)
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

        @Test
        public void testFullNameGetterFirstAndLastNameOnly() {
            contact = new Contact("Louis", "", "Armstrong");
            assertEquals("Louis Armstrong", contact.getFullName());
        }
    }

    @Nested
    @DisplayName("test email and phone number getters")
    class TestEmailAndPhoneNumberGetters {

        @Test
        public void testEmailGetter() {
            String emails = "";
            if (!contact.getEmail().isEmpty()) {
                emails = contact.getEmail();
            }
            assertEquals("eric_ricketts@icloud.com", emails);
        }

        @Test
        public void testPhoneGetter() {
            String phones = "";
            if (!contact.getFirstPhoneNumber().isEmpty()) {
                phones = contact.getFirstPhoneNumber();
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
                    "eric_ricketts@icloud.com", BigInteger.valueOf(9194495529L)
                ));

            assertEquals("Invalid name format", exception.getMessage());
        }

        @Test
        public void testVerifyNameMethodNullMiddleName() {
            Exception exception = assertThrowsExactly(
                NullPointerException.class, () -> new Contact(
                    "Eric", null, "Ricketts",
                    "eric_ricketts@icloud.com", BigInteger.valueOf(9194495529L)
                ));

            assertEquals("Cannot invoke \"String.isBlank()\" because \"middleName\" is null", exception.getMessage());
        }

        @Test
        public void testVerifyNameMethodIncorrectLastName() {
            Exception exception = assertThrowsExactly(
                IllegalArgumentException.class, () -> new Contact(
                    "Eric", "Vernon", "E@#Name",
                    "eric_ricketts@icloud.com", BigInteger.valueOf(9194495529L)
                ));

            assertEquals("Invalid name format", exception.getMessage());
        }

        @Test
        public void testVerifyNameDoesNotAllowNumeralsInName() {
            Exception exception = assertThrowsExactly(
                IllegalArgumentException.class, () -> new Contact(
                    "Eric", "Vernon", "E1Name",
                    "eric_ricketts@icloud.com", BigInteger.valueOf(9194495529L)
                ));

            assertEquals("Invalid name format", exception.getMessage());
        }

        @Test
        public void testVerifyEmailDoesNotAllowIncorrectlyFormattedEmail() {
            Exception exception = assertThrowsExactly(
                IllegalArgumentException.class, () -> new Contact(
                    "Eric", "Vernon", "Ricketts",
                    "eric ricketts@icloud.com", BigInteger.valueOf(9194495529L)
                ));

            assertEquals("Invalid email format", exception.getMessage());
        }

        @Test
        public void testVerifyPhoneNumberDoesNotAllowIncorrectlyFormattedPhoneNumber() {
            Exception exception = assertThrowsExactly(
                IllegalArgumentException.class, () -> new Contact(
                    "Eric", "Vernon", "Ricketts",
                    "eric_ricketts@icloud.com", BigInteger.valueOf(919495529L)
                ));

            assertEquals("Invalid phone number format", exception.getMessage());
        }

        @Test
        public void testVerifyContactFirstPhoneSetter() {
            assertEquals("(919) 449-5529", contact.getFirstPhoneNumber());
            contact.setFirstPhoneNumber(BigInteger.valueOf(9194495456L));

            assertEquals("(919) 449-5456", contact.getFirstPhoneNumber());
        }

        @Test
        public void testVerifyContactSecondPhoneSetter() {
            assertEquals("", contact.getSecondPhoneNumber());
            contact.setSecondPhoneNumber(BigInteger.valueOf(7034510235L));

            assertEquals("(703) 451-0235", contact.getSecondPhoneNumber());
        }

        @Test
        public void verifyPhoneSettersDoNotAllowInvalidPhoneNumbers() {
            assertEquals("(919) 449-5529", contact.getFirstPhoneNumber());

            Exception exception = assertThrowsExactly(
                IllegalArgumentException.class, () ->
                contact.setFirstPhoneNumber(BigInteger.valueOf(50433112345L))
            );

            assertEquals("Invalid phone number format", exception.getMessage());
        }
    }

    @Nested
    @DisplayName("test equals method")
    class TestContactEqualsMethod {

        @Test
        public void TestTwoEqualContact() {
            secondContact = new Contact(
                "Eric",
                "Vernon",
                "Ricketts",
                "eric_ricketts@icloud.com",
                BigInteger.valueOf(9194495529L)
            );

            assertEquals(contact, secondContact);
        }

        @Test
        public void testContactsDifferByName() {
            secondContact = new Contact(
                "James",
                "Bruce",
                "Ricketts",
                "eric_ricketts@icloud.com",
                BigInteger.valueOf(9194495529L)
            );

            assertNotEquals(contact, secondContact);
        }

        @Test
        public void testContactsDifferByEmail() {
            secondContact = new Contact(
                "Eric",
                "Vernon",
                "Ricketts",
                "eric_ricketts@example.org",
                BigInteger.valueOf(9194495529L)
            );

            assertNotEquals(contact, secondContact);
        }

        @Test
        public void testContactsDifferByPhoneNumber() {
            secondContact = new Contact(
                "Eric",
                "Vernon",
                "Ricketts",
                "eric_ricketts@icloud.com",
                BigInteger.valueOf(9194495429L)
            );

            assertNotEquals(contact, secondContact);
        }
    }

    @Nested
    @DisplayName("test different constructors")
    class TestDifferentContactConstructors {

        @Test
        public void testFourArgumentConstructorNameAndPhoneNumber() {
            contact = new Contact(
                "Eric",
                "Vernon",
                "Ricketts",
                BigInteger.valueOf(9194495529L));

            assertEquals("Eric Vernon Ricketts", contact.getFullName());
            assertEquals("(919) 449-5529", contact.getFirstPhoneNumber());
            assertEquals("eric_ricketts@example.org", contact.getEmail());
        }

        @Test
        public void testFourArgumentConstructorNameAndEmail() {
            contact = new Contact(
                "Eric",
                "Vernon",
                "Ricketts",
                "eric_ricketts@icloud.com"
            );

            assertEquals("Eric Vernon Ricketts", contact.getFullName());
            assertEquals("(212) 555-0123", contact.getFirstPhoneNumber());
            assertEquals("eric_ricketts@icloud.com", contact.getEmail());
        }

        @Test
        public void testThreeArgumentConstructorForNameOnly() {
            contact = new Contact("James", "Bruce", "Ricketts");

            assertEquals("James Bruce Ricketts", contact.getFullName());
            assertEquals("(212) 555-0123", contact.getFirstPhoneNumber());
            assertEquals("james_ricketts@example.org", contact.getEmail());
        }
    }

    @Nested
    @DisplayName("test to string")
    class TestToString {

        @Test
        public void testToString() {
            String expected =
                "Contact Name: Eric Vernon Ricketts; Email: eric_ricketts@icloud.com; Phone Number: (919) 449-5529\n";

            assertEquals(expected, contact.toString());
        }
    }
}
