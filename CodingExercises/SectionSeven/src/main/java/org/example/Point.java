package org.example;

public class Point {

    int x, y;

    public Point() {}
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance() {
        return Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2));
    }

    public double distance(Point point) {
        double radicand =
                Math.pow((this.getX() - point.getX()), 2) +
                        Math.pow((this.getY() - point.getY()), 2);
        return Math.sqrt(radicand);
    }

    public double distance(int x, int y) {
        Point point = new Point(x, y);
        double radicand =
                Math.pow((this.getX() - point.getX()), 2) +
                        Math.pow((this.getY() - point.getY()), 2);
        return Math.sqrt(radicand);
    }
}
