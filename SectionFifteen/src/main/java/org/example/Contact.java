package org.example;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Contact {

    private String firstName, middleName, lastName;
    Set<String> emails = new HashSet<>();
    Set<String> phones = new HashSet<>();

    public Contact(String firstName, String middleName, String lastName, String email, BigInteger phoneNumber) {
        this.firstName = verifyName(firstName);
        this.middleName = verifyName(middleName);
        this.lastName = verifyName(lastName);
        this.emails.add(verifyEmail(email));
        phones.add(transformPhoneNumber(verifyPhoneNumber(phoneNumber)));
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName.concat(" ").concat(middleName).concat(" ").concat(lastName);
    }

    public Set<String> getEmails() {
        return emails;
    }

    public Set<String> getPhones() {
        return phones;
    }

    private String verifyEmail(String email) {
        boolean isValidEmail = NameEmailAndPhoneValidator.isValidEmail(email);
        if (!isValidEmail) {
            throw new IllegalArgumentException("Invalid email format");
        }
        return email;
    }

    private String verifyName(String name) {
        boolean isValidName = NameEmailAndPhoneValidator.isValidUnicodeName(name);
        if (!isValidName) {
            throw new IllegalArgumentException("Invalid name format");
        }
        return name;
    }

    private String verifyPhoneNumber(BigInteger phoneNumber) {
        String phoneNumberString = String.valueOf(phoneNumber);
        boolean isValidPhoneNumber = NameEmailAndPhoneValidator.isValidUSPhoneNumber(phoneNumberString);
        if (!isValidPhoneNumber) {
            throw new IllegalArgumentException("Invalid Phone Number format");
        }
        return phoneNumberString;
    }

    private String transformPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber.replaceAll("\\s+", "");
        String areaCode = "(".concat(phoneNumber.substring(0, 3)).concat(") ");
        String exchangeCode = phoneNumber.substring(3, 6).concat("-");
        String lineNumber = phoneNumber.substring(5);

        return areaCode.concat(exchangeCode).concat(lineNumber);
    }
}
