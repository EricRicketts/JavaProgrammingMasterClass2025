package org.example;

public class Truck implements Trackable {

    @Override
    public String track() {
        return this.getClass().getSimpleName() + " coordinates recorded.";
    }
}
