package org.example;

public class ForLoopRecapAndWhileAndDoWhileLoops {

    public static Integer forLoopExample() {
        Integer sum = 0;
        for (int number = 1; number < 7; number += 2) {
            sum += number;
        }
        return sum;
    }

    public static Integer whileLoopExample() {
        Integer sum = 0, number = 1;
        while (number < 7) {
            sum += number;
            number += 2;
        }
        return sum;
    }

    public static Integer doWhileLoopExample() {
        Integer sum = 0, number = 1;
        do {
            sum += number;
            number += 2;
        } while (number < 7);
        return sum;
    }
}
