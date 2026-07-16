package org.example;

public record DragonFly(String name, String type) implements FlightEnabled {
    @Override
    public String takeOff() {
        return this.getClass().getSimpleName() + " takes off from flower.";
    }

    @Override
    public String land() {
        return this.getClass().getSimpleName() + " lands on from flower.";
    }

    @Override
    public String fly() {
        return this.getClass().getSimpleName() + " is hovering around the flower.";
    }
}
