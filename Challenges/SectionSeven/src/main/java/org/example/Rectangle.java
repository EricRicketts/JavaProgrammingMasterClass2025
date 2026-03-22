package org.example;

public class Rectangle {

    private final int x, y;
    private final int width, height;

    /*
        This is proper constructor chaining.  We define the four-parameter constructor
        and then define a two-parameter constructor by calling the four-parameter
        constructor.  Finally, we define a no-parameter constructor by calling the
        two-parameter constructor.
    */
    public Rectangle() {
        this(0, 0);
    }
    public Rectangle(int width, int height) {
        this(0, 0, width, height);
    }
    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}
