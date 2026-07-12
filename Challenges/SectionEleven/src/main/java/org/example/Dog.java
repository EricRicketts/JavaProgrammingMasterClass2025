package org.example;

import java.util.Objects;

public class Dog extends Animal {

    public Dog(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public String move(String speed) {
        return this.getClass().getSimpleName() + " is loping at " + speed + " km/hr.";
    }

    @Override
    public String makeNoise() {
        if (Objects.equals(type, "Wolf")) {
            return "Howling!";
        } else {
            return "Woff!";
        }
    }
}
