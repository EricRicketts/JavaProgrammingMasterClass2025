package org.example;

public class Product {

    private final String model;
    private final String manufacturer;
    private final int width;
    private final int height;
    private final int depth;

    public  String getModel() {
        return this.model;
    };

    public  String getManufacturer() {
        return this.manufacturer;
    };

    public  int getWidth() {
        return this.width;
    };

    public  int getHeight() {
        return this.height;
    };

    public  int getDepth() {
        return this.depth;
    };

    public Product(String model, String manufacturer, int width, int height, int depth) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
}