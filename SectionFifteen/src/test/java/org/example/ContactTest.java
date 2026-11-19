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
                    "eric_ricketts@icloud.com", BigInteger.valueOf(9194495529L)
                ));

            assertEquals("Invalid name format", exception.getMessage());
        }

        @Test
        public void testVerifyNameMethodNullMiddleName() {
            Exception exception = assertThrowsExactly(
                IllegalArgumentException.class, () -> new Contact(
                    "Eric", null, "Ricketts",
                    "eric_ricketts@icloud.com", BigInteger.valueOf(9194495529L)
                ));

            assertEquals("Invalid name format", exception.getMessage());
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
            assertEquals("(919) 449-5529", contact.getPhones().iterator().next());
            assertEquals("eric_ricketts@example.org", contact.getEmails().iterator().next());
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
            assertEquals("(212) 555-0123", contact.getPhones().iterator().next());
            assertEquals("eric_ricketts@icloud.com", contact.getEmails().iterator().next());
        }

        @Test
        public void testThreeArgumentConstructorForNameOnly() {
            contact = new Contact("James", "Bruce", "Ricketts");

            assertEquals("James Bruce Ricketts", contact.getFullName());
            assertEquals("(212) 555-0123", contact.getPhones().iterator().next());
            assertEquals("james_ricketts@example.org", contact.getEmails().iterator().next());
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
