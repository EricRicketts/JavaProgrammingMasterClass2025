package org.example;

public class Person {

    private String firstName, lastName;
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
        this.age = (age < 0 || age > 100) ? 0 : age;
    }

    public boolean isTeen() {
        return this.age >=13 && this.age <= 19;
    }

    public String getFullName() {
        boolean checkForBothNamesEmpty =
                (this.getFirstName() == null || this.getFirstName().isEmpty()) &&
                        (this.getLastName() == null || this.getLastName().isEmpty());
        if (checkForBothNamesEmpty) {
            return "";
        } else if (this.getLastName() == null || this.getLastName().isEmpty()) {
            return this.getFirstName();
        } else if (this.getFirstName() == null || this.getFirstName().isEmpty()) {
            return this.getLastName();
        } else {
            return this.getFirstName() + " " + this.getLastName();
        }
    }
}
