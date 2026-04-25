package org.example;

public class Person {

    private final String name;
    private final int age;
    private final String city;

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

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Person[name = " + name + ", age = " + age + ", city = " + city + "]";
    }

    private int validateAgeAndReturn(int age) {
        return ValueValidator.checkForNegativeOrZeroValue(
                age,
                ErrorMessages.NEGATIVE_OR_ZERO_VALUE_MESSAGE_FOR_AGE.getErrorMessage()
        );
    }

    private String validateNameAndReturn(String name) {
        return ValueValidator.checkForNull(name, "Null value is not allowed for name");
    }

    private String validateCityAndReturn(String city) {
        return ValueValidator.checkForNull(city, "Null value is not allowed for city");
    }
}
