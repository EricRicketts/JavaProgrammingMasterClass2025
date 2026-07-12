package org.example;

import java.util.Objects;

public class Lynx extends Animal {

    public Lynx(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public String move(String speed) {
        return getExplicitType() + " is running at " + speed + " km/hr.";
    }

    @Override
    public String makeNoise() {
        if (Objects.equals(type, "Bobcat")) {
            return "Loud Screech!";
        } else {
            return "Soft moan";
        }
    }
}
