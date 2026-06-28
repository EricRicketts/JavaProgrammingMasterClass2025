package org.example;

public record GroceryItem(String name, String type, int count) {

    public GroceryItem(String name, String type) {
        this(name, type, 1);
    }

    public GroceryItem(String name) {
        this(name, "DAIRY", 1);
    }
}