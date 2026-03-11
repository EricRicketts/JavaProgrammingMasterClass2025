package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class SumQuotientsOfDivisorsThreeAndFive {

    public static ArrayList<Integer> sumQuotients() {
        Integer sum = 0;
        ArrayList<Integer> numbers = new ArrayList<>();
        for (Integer number = 1; number <= 1000; number++) {
            if (number % 3 == 0 && number % 5 == 0) {
                numbers.add(number);
                sum += number;
                if (numbers.size() == 5) {
                    numbers.add(sum);
                    break;
                }
            }
        }
        return numbers;
    }
}
