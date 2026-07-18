package org.example;

// Java can only extend one class, but it can implement multiple interfaces.
public class Jet extends Animal implements FlightEnabled, Trackable {
    @Override
    public String move() {
        return this.getClass().getSimpleName() +
            " main type of movement is to fly.";
    }

    @Override
    public String takeOff() {
        return this.getClass().getSimpleName() + " takes off.";
    }

    @Override
    public String land() {
        return this.getClass().getSimpleName() + " is landing.";
    }

    @Override
    public String fly() {
        return this.getClass().getSimpleName() + " is flying.";
    }

    @Override
    public String track() {
        return this.getClass().getSimpleName() + " coordinates recorded.";
    }

    @Override
    public FlightStages transition(FlightStages stage) {
        return FlightEnabled.super.transition(stage);
    }
}
