package org.example;

public class Animal {

    protected String type; // I had to make the access modifier protected so
    // the subclass (Dog) could refer to this attribute in its own methods.  The private
    // access modifier will not allow subclasses to access the attribute.
    private String size;
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
