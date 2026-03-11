package org.example;

public class ForLoopRecap {

    public static Integer forLoopExample() {
        Integer sum = 0;
        for (int number = 1; number < 7; number += 2) {
            sum += number;
        }
        return sum;
    }
}
