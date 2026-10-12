package org.example;

import java.util.Arrays;
import java.util.function.Supplier;

public class PlainOld {

    public static PlainOld[] seedArray(Supplier<PlainOld> reference, int count) {
        PlainOld[] array = new PlainOld[count];
        Arrays.setAll(array, i -> reference.get());

        return array;
    }

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
