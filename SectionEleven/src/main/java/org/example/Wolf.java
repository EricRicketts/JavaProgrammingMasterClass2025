package org.example;

public class Wolf extends Mammal {
    /*
        Since Wolf extends Mammal and is a concrete class, it must implement all the abstract methods
        declared in the Mammal abstract class, and it must implement all the abstract methods in the
        Trackable and MoveEnabled interfaces.
    */

    @Override
    public String move() {
        return this.getClass().getSimpleName() + " is now on the move.";
    }

    @Override
    public String walk() {
        return this.getClass().getSimpleName() + " is now walking.";
    }

    @Override
    public String lope() {
        return this.getClass().getSimpleName() + " is now loping.";
    }

    @Override
    public String run() {
        return this.getClass().getSimpleName() + " is now running.";
    }

    @Override
    public String track() {
        return this.getClass().getSimpleName() + " has its tracking devices.";
    }
}
