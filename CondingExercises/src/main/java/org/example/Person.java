package org.example;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 100) {
            this.age = 0;
        } else {
           this.age = age;
        }
    }

    public boolean isTeen() {
        return this.age >= 13 && this.age <= 19;
    }

    public String getFullName() {
        if ((this.firstName == null || this.firstName.trim().isEmpty()) &&
                (this.lastName == null || this.lastName.trim().isEmpty())) {
            return "";
        } else if (this.firstName == null || this.firstName.trim().isEmpty()) {
            return this.lastName;
        } else if (this.lastName == null || this.lastName.trim().isEmpty()) {
            return this.firstName;
        }  else return "";
    }
}
