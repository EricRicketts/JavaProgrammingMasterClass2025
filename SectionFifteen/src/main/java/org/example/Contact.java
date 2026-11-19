package org.example;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Contact {

    private String firstName, middleName, lastName;
    String email, firstPhoneNumber, secondPhoneNumber;

    public Contact(String firstName, String middleName, String lastName, String email, BigInteger phoneNumber) {
        this.firstName = verifyName(firstName);
        this.middleName = middleName.isBlank()? "" : verifyName(middleName);
        this.lastName = verifyName(lastName);
        this.email = verifyEmail(email);
        String verifiedPhoneNumber = verifyPhoneNumber(phoneNumber);
        this.firstPhoneNumber = transformPhoneNumber(verifiedPhoneNumber);
        this.secondPhoneNumber = "";
    }

    public Contact(String firstName, String middleName, String lastName, BigInteger phoneNumber) {
        this(
            firstName,
            middleName,
            lastName,
            firstName.toLowerCase()
                .concat("_")
                .concat(lastName.toLowerCase()
                .concat("@example.org")),
            phoneNumber);
    }

    public Contact(String firstName, String middleName, String lastName, String email) {
        this(firstName, middleName, lastName, email, BigInteger.valueOf(2125550123L));
    }

    public Contact(String firstName, String middleName, String lastName) {
        this(
            firstName,
            middleName,
            lastName,
            firstName.toLowerCase()
                .concat("_")
                .concat(lastName.toLowerCase()
                .concat("@example.org")),
            BigInteger.valueOf(2125550123L));
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
        if (middleName.isBlank()) {
            return  firstName.concat(" ").concat(lastName);
        } else {
            return firstName.concat(" ").concat(middleName).concat(" ").concat(lastName);
        }
    }

    public String getEmail() {
        return email;
    }

    public String getFirstPhoneNumber() {
        return firstPhoneNumber;
    }

    public String getSecondPhoneNumber() {
        return secondPhoneNumber;
    }

    public void setFirstPhoneNumber(BigInteger newFirstPhoneNumber) {
        String verifiedPhoneNumber = verifyPhoneNumber(newFirstPhoneNumber);
        this.firstPhoneNumber = transformPhoneNumber(verifiedPhoneNumber);
    }

    public void setSecondPhoneNumber(BigInteger newSecondPhoneNumber) {
        String verifiedPhoneNumber = verifyPhoneNumber(newSecondPhoneNumber);
        this.secondPhoneNumber = transformPhoneNumber(verifiedPhoneNumber);
    }

    public void mergeContactData(Contact contact) {

    }

    @Override
    public boolean equals(Object object) {
        if (Objects.isNull(object)) return false;
        if (object.getClass() != this.getClass()) return false;
        if (this == object) return true;

        Contact contact = (Contact) object;
        return this.getFullName().equals(contact.getFullName()) &&
            Objects.equals(this.getEmail(), contact.getEmail()) &&
            Objects.equals(this.getFirstPhoneNumber(), contact.getFirstPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getFullName(), this.getEmail(), this.getFirstPhoneNumber());
    }

    @Override
    public String toString() {
        return "Contact Name: "
            .concat(this.getFullName())
            .concat("; Email: ")
            .concat(this.getEmail())
            .concat("; Phone Number: ")
            .concat(this.getFirstPhoneNumber())
            .concat("\n");
    }

    private String verifyEmail(String email) {
        if (email.isBlank()) return "";
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
            throw new IllegalArgumentException("Invalid phone number format");
        }
        return phoneNumberString;
    }

    private String transformPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber.replaceAll("\\s+", "");
        String areaCode = "(".concat(phoneNumber.substring(0, 3)).concat(") ");
        String exchangeCode = phoneNumber.substring(3, 6).concat("-");
        String lineNumber = phoneNumber.substring(6);

        return areaCode.concat(exchangeCode).concat(lineNumber);
    }
}
