package org.example;

import java.util.Objects;

public class Wolf extends Animal {

    public Wolf(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public String move(String speed) {
        return getExplicitType() + " is loping at " + speed + " km/hr.";
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
