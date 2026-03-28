package org.example;

public class Holden extends Car {

    public Holden(int cylinders, String makeAndModel) {
        super(cylinders, makeAndModel);
    }

    @Override
    public String startEngine() {
        return super.startEngine();
    }

    @Override
    public String accelerate() {
        return super.accelerate();
    }

    @Override
    public String brake() {
        return super.brake();
    }

    @Override
    public String getMakeAndModel() {
        return super.getMakeAndModel();
    }
}
