package org.example;

public class Person {

    private final String name;
    private int age;
    private String city;

    public Person(String name, int age) {
        this(name, age, "Unknown");
    }

    public Person(String name, int age, String city) {
        this.name = validateNameAndReturn(name);
        this.age = validateAgeAndReturn(age);
        this.city = validateCityAndReturn(city);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = validateAgeAndReturn(age);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = validateCityAndReturn(city);
    }

    @Override
    public String toString() {
        return
                "Person[name = " +
                        name +
                        ", age = " +
                        age +
                        ", city = " +
                        city +
                        "]";
    }

    private int validateAgeAndReturn(int age) {
        return ValueValidator.checkForNegativeOrZeroValue(
                age,
                ErrorMessages.NEGATIVE_OR_ZERO_VALUE_MESSAGE_FOR_AGE.getErrorMessage()
        );
    }

    private String validateNameAndReturn(String name) {
        if (name == null) {
            throw new NullPointerException(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_NAME.getErrorMessage()
            );
        } else if (name.isBlank()) {
            throw new IllegalArgumentException(
                    ErrorMessages.BLANK_VALUE_MESSAGE_FOR_NAME.getErrorMessage()
            );
        }
        return name;
    }

    private String validateCityAndReturn(String city) {
        if (city == null) {
            throw new NullPointerException(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_CITY.getErrorMessage()
            );
        } else if (city.isBlank()) {
            throw new IllegalArgumentException(
                    ErrorMessages.BLANK_VALUE_MESSAGE_FOR_CITY.getErrorMessage()
            );
        }
        return city;
    }
}
