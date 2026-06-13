package org.example;

public class Shape {

    private int length;

    private int width;

    public Shape(int length, int width) {
        this.length = ValueValidator.validatePositiveIntAndReturn(length, "length");
        this.width = ValueValidator.validatePositiveIntAndReturn(width, "width");
    }

    public Shape() {
        this(1, 1);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = ValueValidator.validatePositiveIntAndReturn(length, "length");
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = ValueValidator.validatePositiveIntAndReturn(width, "width");
    }

    public int area() {
        return this.length * this.width;
    }
}
