package org.example;

public class Monitor extends Product {

    private final int size;
    private final String resolution;

    public int getSize() {
        return size;
    }

    public String getResolution() {
        return this.resolution;
    }

    public String drawPixelAt(int x, int y, String color) {
        return String.format("Drawing pixel at %d, %d in color %s.", x, y, color);
    }

    public Monitor(
        String model,
        String manufacturer,
        int width,
        int height,
        int depth,
        int size,
        String resolution
    ) {
        super(model, manufacturer, width, height, depth);
        this.size = size;
        this.resolution = resolution;
    }
}