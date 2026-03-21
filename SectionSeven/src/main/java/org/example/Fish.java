package org.example;

import java.util.Objects;

public class Fish extends Animal {

    private final int fins;
    private final int gills;

    public Fish(String type, double weight, int gills, int fins) {
        super(type, "small", weight);
        this.gills = gills;
        this.fins = fins;
    }

    private String moveMuscles() {
        return "Muscles Moving.";
    }

    private String moveBackFin() {
        return "BackFin Moving.";
    }

    @Override
    public String move(String speed) {
        String movement = "";
        super.move(speed);
        String muscleAction = moveMuscles();
        if (Objects.equals(speed, "fast")) {
            movement = moveBackFin();
        }
        return muscleAction + " " + movement;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "fins=" + fins +
                ", gills=" + gills +
                "} " + super.toString();
    }
}
