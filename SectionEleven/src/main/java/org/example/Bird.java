package org.example;

// Java can only extend one class, but it can implement multiple interfaces.
public class Bird extends Animal implements FlightEnabled, Trackable {
    @Override
    public String move() {
        return this.getClass().getSimpleName() +
            " main type of movement is to fly.";
    }

    @Override
    public String takeOff() {
        return this.getClass().getSimpleName() + " leaves its nest.";
    }

    @Override
    public String land() {
        return this.getClass().getSimpleName() + " returns to its nest.";
    }

    @Override
    public String fly() {
        return this.getClass().getSimpleName() + " flies.";
    }

    @Override
    public String track() {
        return this.getClass().getSimpleName() + " is being tracked.";
    }
}
