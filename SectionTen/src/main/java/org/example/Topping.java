package org.example;

public enum Topping {

    BACON,
    CHEDDAR,
    KETCHUP,
    MUSTARD,
    PICKLES,
    TOMATO;

    public double getPrice() {
        return switch(this) {
            case BACON -> 1.55;
            case PICKLES, TOMATO -> 0.75;
            case CHEDDAR, KETCHUP, MUSTARD -> 0.55;
            default -> 1.00;
        };
    }
}
