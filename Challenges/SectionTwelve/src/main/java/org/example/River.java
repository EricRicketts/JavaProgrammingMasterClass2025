package org.example;

import java.util.ArrayList;

public class River extends Line {

    private final String name;

    private final String type;

    public River(ArrayList<Point> points, int precision, String name, String type) {
        super(points, precision);
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return name + " (" + type + ") " + super.toString();
    }
}
