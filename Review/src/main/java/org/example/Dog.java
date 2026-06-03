package org.example;

import static org.example.Animal.Size.*;

public class Dog extends Animal {

    private boolean trained;

    public Dog(String name, Size size, boolean trained) {
        super(name, size);
        this.trained = trained;
    }

    public Dog(String name) {
        this(name, MEDIUM, false);
    }

    public Dog() {
        this("Unknown Name", MEDIUM, false);
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
