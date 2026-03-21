package org.example;

public class Animal {

    private String type, size;
    private double weight;

    public Animal() {}

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", weight=" + weight +
                '}';
    }

    public String move(String speed) {
        return type + " moves at " + speed + "km/hr.";
    }

    public String makeNoise() {
        return type + " makes some kind of noise.";
    }
}
