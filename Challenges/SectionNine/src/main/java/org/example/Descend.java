package org.example;

import java.util.Arrays;

public class Descend {

    public static int[] sort(int[] original) {
        boolean sortComplete = false;
        int[] sorted = Arrays.copyOf(original, original.length);
        continueSort:
        while (!sortComplete) {
            for (int i = 0; i < original.length - 1; i++) {
                if (sorted[i + 1] > sorted[i]) {
                    int temp = sorted[i];
                    sorted[i] = sorted[i + 1];
                    sorted[i + 1] = temp;
                }
            }
            for (int i = 0; i < original.length; i++) {
                 if (sorted[i] > sorted[i+1]) {
                     continue;
                 } else {
                    break continueSort;
                 }
            }
            sortComplete = true;
        }
        return sorted;
    }
}
