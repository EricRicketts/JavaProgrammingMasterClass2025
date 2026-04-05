package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactTest {

    private Contact contact, expectedContact;

    @BeforeEach
    public void setUp() {
        contact = new Contact("Elmer Fudd", "1234567890");
        expectedContact = new Contact("Bugs Bunny", "1123345567");
    }

    @Test
    public void testGetName() {
        assertEquals("Elmer Fudd", contact.getName());
    }

    @Test
    public void testGetPhoneNumber() {
        assertEquals("1234567890", contact.getPhoneNumber());
    }

    @Test
    public void testCreateContact() {
        var resultantContact = Contact.createContact("Bugs Bunny", "1123345567");
        assertEquals(expectedContact, resultantContact);
    }
}
