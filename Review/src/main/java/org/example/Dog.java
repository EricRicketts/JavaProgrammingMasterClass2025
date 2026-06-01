package org.example;

import static org.example.Animal.Size.*;

public class Dog extends Animal {

    public Dog(String name, Size size) {
        super(name, size);
    }

    public Dog(String name) {
        this(name, MEDIUM);
    }

    public Dog() {
        this("Unknown Name", MEDIUM);
    }
}
