package org.example;

public class CodingExerciseOnePositiveNegativeZero {
    public String checkNumber (int number) {
        String  result = "zero";

        if  (number > 0) {
            result = "positive";
        } else if (number < 0) {
            result = "negative";
        }

        return result;
    }
}
