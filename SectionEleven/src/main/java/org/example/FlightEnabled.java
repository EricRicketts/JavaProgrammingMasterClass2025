package org.example;

public interface FlightEnabled {

    public abstract String takeOff();

    abstract String land();

    String fly(); // In an interface all methods by default are public and abstract.
}
