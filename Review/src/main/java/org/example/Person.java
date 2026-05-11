package org.example;

import java.util.regex.Pattern;

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
        return String.format(
                "name = %s%n" +
                "age = %d%n" +
                "city = %s%n",
                name,
                age,
                city
        ).trim();
    }

    private int validateAgeAndReturn(int age) {
        return ValueValidator.validatePositiveIntAndReturn(age, "age");
    }

    private String validateCityAndReturn(String city) {
        return ValueValidator.validateTextAndReturn(city, "city");
    }

    private String validateNameAndReturn(String name) {
        return ValueValidator.validateTextAndReturn(name, "name");
    }
}
