package org.example;

public class CodingExerciseOnePositiveNegativeZero {
    public String checkNumber (int number) {
        String  result;

        if (number > 0) {
            result = "positive";
        } else if (number < 0) {
           result = "negative";
        } else {
            result = "zero";
        }

        return result;
    }
}
