package org.example;

public class Pig extends Animal {

    // As a concrete class inheriting from Abstract class Animal, the Pig class must implement all abstract
    // methods in the Animal class or else itself be declared abstract.
    @Override
    public String move() {
        return this.getClass().getSimpleName() + " moves on its stubby little legs.";
    }
}