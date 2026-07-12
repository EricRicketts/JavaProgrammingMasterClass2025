package org.example;

public abstract class Animal {

    protected String type;
    private String size;
    private double weight;

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public abstract String move(String speed);

    public abstract String makeNoise();

    public String getExplicitType() {
        return getClass().getSimpleName() + " (" + this.type + ")";
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public double getWeight() {
        return weight;
    }
}
