package org.example;

public class Oblong extends Shape {

    private final int width, height;

    public Oblong(int x, int y) {
        this(x, y, 0, 0);
    }
    public Oblong (int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
