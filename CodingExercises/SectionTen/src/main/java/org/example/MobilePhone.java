package org.example;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact) {
        // Returns true if the contact does not exist, false if it does exist.
        return !getMyContacts().contains(contact);
    }

    public int findContact(Contact contact) {
        return addNewContact(contact) ? -1 : getMyContacts().indexOf(contact);
    }

    public int findContact(String contactName) {
        for (int i = 0; i < getMyContacts().size(); i++) {
            Contact storedContact = getMyContacts().get(i);
            if (storedContact.getName().equals(contactName)) return i;
        }
        return -1;
    }

    public boolean updateContact(Contact existingContact, Contact newContact) {
        int locationOfNewContact = findContact(existingContact);
        if (locationOfNewContact > -1) {
            getMyContacts().set(locationOfNewContact, newContact);
            return true;
        }
        return false;
    }

    public boolean removeContact(Contact existingContact) {
        int locationOfExistingContact = findContact(existingContact);
        if (locationOfExistingContact > -1) {
            this.myContacts.remove(locationOfExistingContact);
            return true;
        }
        return false;
    }

    public Contact queryContact(String contactName) {
        int locationOfExistingContact = findContact(contactName);
        return (locationOfExistingContact > -1) ?
            getMyContacts().get(locationOfExistingContact) :
            null;
    }

    public String printContacts() {
        String contacts = "";
        for (Contact contact : getMyContacts()) {
            contacts = contacts
                    .concat(contact.getName())
                    .concat(" -> ")
                    .concat(contact.getPhoneNumber())
                    .concat("\n");
        }
        return contacts.stripTrailing();
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }

    public void setMyContacts(ArrayList<Contact> myContacts) {
        this.myContacts = myContacts;
    }
}
