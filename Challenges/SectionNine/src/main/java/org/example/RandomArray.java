package org.example;

import java.util.Random;

public class RandomArray {

    public static int[] getRandomArray(int length) {
        Random random = new Random();
        int[] newInt = new int[length];

        for (int i = 0; i < length; i++) {
            newInt[i] = random.nextInt(100);
        }
        return newInt;
    }
}
