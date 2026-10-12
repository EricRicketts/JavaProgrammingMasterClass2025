package org.example;

public class PlainOld {

    private static int last_id = 1;
    private int id;

    public PlainOld() {
        id = PlainOld.last_id++;
    }

    public int getId() {
        return this.id;
    }

    public static int getLastId() {
        return PlainOld.last_id;
    }
}
