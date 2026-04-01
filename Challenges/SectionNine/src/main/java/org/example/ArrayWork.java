package org.example;

import java.util.Arrays;
import java.util.Random;

public class ArrayWork {

    public static int[] reverse(int[] original) {
        int[] reversed = Arrays.copyOf(original, original.length);
        for (int i = 0; i < original.length/2; i++) {
            int farIndex = original.length - (i + 1);
            int nearNumber = reversed[i];
            int farNumber = reversed[farIndex];
            reversed[i] = farNumber;
            reversed[farIndex] = nearNumber;
        }
        return reversed;
    }

    public static int[] sort(int[] original) {
        /*
        loop only one time.  I gave up and looked at the instructor's solution.  His use of a while
        loop simplified everything.  The "sortNotComplete" variable starts as true and then is set
        to false as it enters the loop.  We enter a for loop with one test condition.  If the array
        is not sorted, then the test condition will pass and the current elements being checked
        will get swapped.  Two successive elements are looked at each time: [0,1], [1,2], [2,3] ...
        The last line in the if block sets "sortNotComplete" to true, ensuring the while loop will continue.
        This is important because the "sortNotComplete" set to true ensures the while loop will continue
        until all elements have been sorted.  The while loop will exit when, during the previous run,
        the sort process completes.  Now the while loop enters the loop one more time, "setNotComplete" is
        set too false to begin with, and each test of the if condition within the for loop will fail.
        This means the "sortNotComplete" will remain at false as the if condition under the for loop
        was never entered.  When the array is fully sorted, the body of the if condition will never
        be called, and setComplete will be set to false, and the loop will exit.
        */
        boolean sortNotComplete = true;
        int[] sorted = Arrays.copyOf(original, original.length);
        while (sortNotComplete) {
            sortNotComplete = false;
            for (int i = 0; i < original.length - 1; i++) {
                if (sorted[i] < sorted[i + 1]) {
                    int temp = sorted[i];
                    sorted[i] = sorted[i + 1];
                    sorted[i + 1] = temp;
                    sortNotComplete = true;
                }
            }
        }
        return sorted;
    }

    public static int findMin(int[] integers) {
        int minimum = Integer.MAX_VALUE;
        for (int currentInteger : integers) {
            if (currentInteger < minimum) {
                minimum = currentInteger;
            }
        }
        return minimum;
    }

    public static int[] getRandomArray(int length) {
        Random random = new Random();
        int[] newInt = new int[length];

        for (int i = 0; i < length; i++) {
            newInt[i] = random.nextInt(1000);
        }
        return newInt;
    }
}
