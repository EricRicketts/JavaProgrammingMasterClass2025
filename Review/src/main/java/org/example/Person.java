package org.example;

import java.util.regex.Pattern;

public class Person {

    private final Pattern ONE_OR_MORE_SPACES = Pattern.compile("\\s+");
    private final String EMPTY_STRING = "";
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
                "city = %s%n", name, age, city
        ).trim();
    }

    private int validateAgeAndReturn(int age) {
        int nonNullAge = ValueValidator.checkForZeroValueAndReturn(
                age,
                ErrorMessages.ZERO_VALUE_MESSAGE_FOR_AGE.getErrorMessage()
        );

        return ValueValidator.checkForNegativeValueAndReturn(
                nonNullAge,
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_AGE.getErrorMessage()
        );
    }

    private String validateNameAndReturn(String name) {
        return switch(name) {
            case null -> throw new NullPointerException(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_NAME.getErrorMessage()
            );
            case EMPTY_STRING -> throw new IllegalArgumentException(
                    ErrorMessages.EMPTY_VALUE_MESSAGE_FOR_NAME.getErrorMessage()
            );
            case String s when ONE_OR_MORE_SPACES.matcher(s).matches() -> throw new IllegalArgumentException(
                    ErrorMessages.BLANK_VALUE_MESSAGE_FOR_NAME.getErrorMessage()
            );
            default -> name;
        };
    }

    private String validateCityAndReturn(String city) {
        if (city == null) {
            throw new NullPointerException(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_CITY.getErrorMessage()
            );
        } else if (city.isEmpty()) {
            throw new IllegalArgumentException(
                    ErrorMessages.EMPTY_VALUE_MESSAGE_FOR_CITY.getErrorMessage()
            );
        } else if (city.isBlank()) {
            throw new IllegalArgumentException(
                    ErrorMessages.BLANK_VALUE_MESSAGE_FOR_CITY.getErrorMessage()
            );
        }
        return city;
    }
}
