package org.example;

public class Bed {

    private String style;
    private int pillows, height, sheets, quilt;

    public Bed(String style, int pillows, int height, int sheets, int quilt) {
        this.style = style;
        this.pillows = pillows;
        this.height = height;
        this.sheets = sheets;
        this.quilt = quilt;
    }

    public String make() {
        return "The bed is currently being made.";
    }

    public String getStyle() {
        return this.style;
    }

    public int getPillows() {
        return this.pillows;
    }

    public int getHeight() {
        return this.height;
    }

    public int getSheets() {
        return this.sheets;
    }

    public int getQuilt() {
        return this.quilt;
    }
}
