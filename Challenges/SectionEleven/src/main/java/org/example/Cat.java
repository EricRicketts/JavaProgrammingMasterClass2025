package org.example;

import java.util.Objects;

public class Cat extends Animal {

    public Cat(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public String move(String speed) {
        return getExplicitType() + " is walking at " + speed + " km/hr.";
    }

    @Override
    public String makeNoise() {
        if (Objects.equals(type, "Persian")) {
            return "Loud Purr!";
        } else {
            return "Soft Purr";
        }
    }
}
