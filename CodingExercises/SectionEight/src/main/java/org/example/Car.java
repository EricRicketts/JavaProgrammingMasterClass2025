package org.example;

public class Car {

    private boolean engine;
    private final int cylinders, wheels;
    private String name, makeAndModel;

    public Car(int cylinders, String makeAndModel) {
        this.makeAndModel = makeAndModel;
        this.cylinders = cylinders;
        this.engine = true;
        this.wheels = 4;
    }

    public String startEngine() {
        return this.getName() + " -> startEngine()";
    }

    public String accelerate() {
        return this.getName() + " -> accelerate()";
    }

    public String brake() {
        return this.getName() + " -> brake()";
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getMakeAndModel() {
        return makeAndModel;
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }
}
