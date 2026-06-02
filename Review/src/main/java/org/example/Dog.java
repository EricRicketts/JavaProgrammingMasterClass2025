package org.example;

import static org.example.Animal.Size.*;

public class Dog extends Animal {

    private boolean trained;

    public Dog(String name, Size size) {
        super(name, size);
    }

    public Dog(String name) {
        this(name, MEDIUM);
    }

    public Dog() {
        this("Unknown Name", MEDIUM);
    }

    @Override
    public String makeSound() {
        return "Woof!!";
    }

    public boolean isTrained() {
        return trained;
    }

    public void setTrained(boolean trained) {
        this.trained = trained;
    }
}
