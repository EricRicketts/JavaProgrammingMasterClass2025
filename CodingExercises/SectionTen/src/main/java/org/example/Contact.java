package org.example;

import java.util.Objects;

public class Contact {

    private final String name;
    private final String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public static Contact createContact(String name, String phoneNumber) {
        return new Contact(name, phoneNumber);
    }
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Contact contact = (Contact) obj;
        return this.name.equals(contact.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getPhoneNumber());
    }
}
