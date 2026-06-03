package org.example;

import static org.example.Animal.Size.*;

public class Cat extends Animal {

    private boolean deClawed;

    public Cat(String name, Size size, boolean deClawed) {
        super(name, size);
        this.deClawed = deClawed;
    }

    public Cat(String name) {
        this(name, MEDIUM, false);
    }

    public Cat() {
        this("Unknown Name", MEDIUM, false);
    }

    @Override
    public String makeSound() {
        return "Meow!!";
    }

    public boolean isDeClawed() {
        return deClawed;
    }

    public void setDeClawed(boolean deClawed) {
        this.deClawed = deClawed;
    }
}

