package org.example;

import java.util.ArrayList;
import java.util.List;

public class SharedDigit {

    public static boolean hasSharedDigit(int firstNumber, int secondNumber) {
        if ((firstNumber < 10 || firstNumber > 99) || (secondNumber < 10 || secondNumber > 99))  { return false; }

        List<Integer> firstNumberDigits = new ArrayList<>();
        List<Integer> secondNumberDigits = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            int firstNumberDigit = firstNumber % 10;
            int secondNumberDigit = secondNumber % 10;
            firstNumberDigits.add(firstNumberDigit);
            secondNumberDigits.add(secondNumberDigit);
            firstNumber = firstNumber / 10;
            secondNumber = secondNumber / 10;
        }

        int firstNumberFirstDigit = firstNumberDigits.get(0);
        int firstNumberSecondDigit = firstNumberDigits.get(1);
        return secondNumberDigits.contains(firstNumberFirstDigit) ||
                secondNumberDigits.contains(firstNumberSecondDigit);
    }
}
