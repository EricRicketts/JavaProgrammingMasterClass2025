package org.example;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact) {
        return !this.myContacts.contains(contact);
    }

    public int findContact(Contact contact) {
        return this.addNewContact(contact) ? -1 : this.myContacts.indexOf(contact);
    }

    public int findContact(String contactName) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact storedContact = this.myContacts.get(i);
            if (storedContact.getName().equals(contactName)) return i;
        }
        return -1;
    }

    public boolean updateContact(Contact existingContact, Contact newContact) {
        int locationOfNewContact = this.findContact(existingContact);
        if (locationOfNewContact > -1) {
            this.myContacts.set(locationOfNewContact, newContact);
            return true;
        }
        return false;
    }

}
