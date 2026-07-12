package org.example;

public class Horse extends Mammal {

    public Horse(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public String move(String speed) {
        return getExplicitType() + " " + (speed.equals("slow") ? "walks" : "runs");
    }

    @Override
    public String makeNoise() {
        return "Any horse can neigh.";
    }

    @Override
    public String shedHair() {
        return "A horse sheds hair in the Spring.";
    }
}
