package org.example;

import java.util.Arrays;

public class Descend {

    public static int[] sort(int[] original) {
        /*
            I had the algorithm correct, but I was trying to figure how to break out of the loop.
            I tried code to determine a break condition, but it always caused me to run through the
            loop only one time.  I gave up and looked at the instructor's solution.  His use of a while
            loop simplified everything.  The "sortComplete" variable starts as true and then is set
            to false as it enters the loop.  We enter a for loop with one test condition.  If the array
            is not sorted, then the test condition will pass and the current elements being checked
            will get swapped.  Two successive elements are looked at each time: [0,1], [1,2], [2,3] ...
            The last line in the if block sets "sortComplete" to true, ensuring the while loop will continue.
            When the array is fully sorted, the body of the if condition will never be called, and
            setComplete will be set to false, and the loop will exit.
        */
        boolean sortComplete = true;
        int[] sorted = Arrays.copyOf(original, original.length);
        while (sortComplete) {
            sortComplete = false;
            for (int i = 0; i < original.length - 1; i++) {
                if (sorted[i] < sorted[i + 1]) {
                    int temp = sorted[i];
                    sorted[i] = sorted[i + 1];
                    sorted[i + 1] = temp;
                    sortComplete = true;
                }
            }
        }
        return sorted;
    }
}
