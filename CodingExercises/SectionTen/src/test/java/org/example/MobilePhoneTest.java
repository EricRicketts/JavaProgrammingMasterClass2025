package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MobilePhoneTest {

    private MobilePhone mobilePhone;
    private Contact contact;

    @BeforeEach
    public void setUp() {
        mobilePhone = new MobilePhone("0123456789");
        Contact firstContact = new Contact("Elmer Fudd", "1122334455");
        Contact secondContact = new Contact("Daffy Duck", "0011223344");
        Contact thirdContact = new Contact("Bugs Bunny", "6677889900");
        Contact fourthContact = new Contact("Foghorn Leghorn", "0123456789");
        Contact fifthContact = new Contact("Porky Pig", "9876543210");
        ArrayList<Contact> contacts = new ArrayList<>(List.of(
                firstContact, secondContact, thirdContact, fourthContact, fifthContact
        ));
        for (Contact  contact : contacts) {
            mobilePhone.myContacts = new ArrayList<>(
                List.of(firstContact, secondContact, thirdContact, fourthContact, fifthContact)
            );
        }
    }

    @Test
    public void testAddNewContactFalse() {
        // The contact exists, so there is no need to add a contact
        contact = new Contact("Elmer Fudd", "1122334455");
        assertFalse(mobilePhone.addNewContact(contact));
    }

    @Test
    public void testAddNewContactTrue() {
        // The contact does not exist, so return true
        contact = new Contact("John Doe", "2309458761");
        assertTrue(mobilePhone.addNewContact(contact));
    }

    @Test
    public void testFindContactObjectFound() {
        contact = new Contact("Foghorn Leghorn", "0123456789");
        int expected = 3;
        int result = mobilePhone.findContact(contact);
        assertEquals(expected, result);
    }

    @Test
    public void testFindContactObjectNotFound() {
        contact = new Contact("Tasmanian Devil", "9990008881");
        int expected = -1;
        int result = mobilePhone.findContact(contact);
        assertEquals(expected, result);
    }

    @Test
    public void testFindContactStringFound() {
        String contactName = "Porky Pig";
        int expected = 4;
        int result = mobilePhone.findContact(contactName);
        assertEquals(expected, result);
    }

    @Test
    public void testFindContactStringNotFound() {
        String contactName = "Tweety Bird";
        int expected = -1;
        int result = mobilePhone.findContact(contactName);
        assertEquals(expected, result);
    }

    @Test
    public void testUpdateExistingContactFound() {
        int existingLocation = 2;
        Object[] expected = new Object[]{true, "Road Runner", "1029384756"};
        Contact existingContact = new Contact("Bugs Bunny", "6677889900");
        Contact newContact = new Contact("Road Runner", "1029384756");
        boolean result = mobilePhone.updateContact(existingContact, newContact);
        Contact insertedContact = mobilePhone.myContacts.get(existingLocation);
        Object[] results = new Object[]{
                result,
                insertedContact.getName(),
                insertedContact.getPhoneNumber()
        };
        assertArrayEquals(expected, results);
    }

    @Test
    public void testUpdateExistingContactNotFound() {
        Contact existingContact = new Contact("Wile E Coyote", "0192837465");
        Contact newContact = new Contact("Road Runner", "1029384756");
        boolean result = mobilePhone.updateContact(existingContact, newContact);
        assertFalse(result);
    }

    @Test
    public void testRemoveExistingContact() {
        Object[] expected = new Object[]{true, 5, 4};
        int priorSizeBeforeRemoval = mobilePhone.myContacts.size();
        contact = new Contact("Foghorn Leghorn", "0123456789");
        boolean result = mobilePhone.removeContact(contact);
        Object[] results = new Object[]{
                result, priorSizeBeforeRemoval, mobilePhone.myContacts.size()
        };
        assertArrayEquals(expected, results);
    }

    @Test
    public void testRemoveNonExistingContact() {
        contact = new Contact("Road Runner", "1029384756");
        boolean result = mobilePhone.removeContact(contact);
        assertFalse(result);
    }

    @Test
    public void testQueryForExistingContact() {
        Contact expectedContact = new Contact("Daffy Duck", "0011223344");
        contact = mobilePhone.queryContact("Daffy Duck");
        assertEquals(expectedContact, contact);
    }

    @Test
    public void testQueryForNonExistentContact() {
        contact = mobilePhone.queryContact("Road Runner");
        assertNull(contact);
    }

    @Test
    public void testPrintContacts() {
        String expected = """
                Elmer Fudd -> 1122334455
                Daffy Duck -> 0011223344
                Bugs Bunny -> 6677889900
                Foghorn Leghorn -> 0123456789
                Porky Pig -> 9876543210""";
        String result = mobilePhone.printContacts();
        assertEquals(expected, result);
    }

}
