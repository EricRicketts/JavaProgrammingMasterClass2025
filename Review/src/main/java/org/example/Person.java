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
        this.name = ValueValidator.validateNameAndReturn(name);
        this.age = ValueValidator.validateAgeAndReturn(age);
        this.city = ValueValidator.validateCityAndReturn(city);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = ValueValidator.validateAgeAndReturn(age);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = ValueValidator.validateCityAndReturn(city);
    }

    @Override
    public String toString() {
        return String.format(
                "name = %s%n" +
                "age = %d%n" +
                "city = %s%n", name, age, city
        ).trim();
    }
}
