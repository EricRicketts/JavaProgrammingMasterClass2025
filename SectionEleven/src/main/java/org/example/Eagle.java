package org.example;

public class Eagle extends Animal implements FlightEnabled, Trackable {

    public Eagle() {
    }

    @Override
    public String move() {
        return this.getClass().getSimpleName() + " preferred motion type is flight.";
    }

    @Override
    public String takeOff() {
        return this.getClass().getSimpleName() + " takes off from its nest in the mountains.";
    }

    @Override
    public String land() {
        return this.getClass().getSimpleName() + " lands in its nest in the mountains.";
    }

    @Override
    public String fly() {
        return this.getClass().getSimpleName() + " does not fly it soars.";
    }

    @Override
    public String track() {
        return this.getClass().getSimpleName() + " is being tracked to learn its habits.";
    }
}
