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
}
