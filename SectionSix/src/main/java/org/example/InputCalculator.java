package org.example;

public class InputCalculator {

    private static int sum = 0;
    private static long avg = 0;
    private static int iterations = 0;

    public static String inputThenPrintSumAndAverage(String number) {
        iterations++;
        int num =  Integer.parseInt(number);
        sum += num;
        avg = Math.round((sum * 1.0) / iterations);

        return "SUM = " + sum  + ", AVG = " + avg;
    }

    public static int  getSum() {
        return sum;
    }

    public static long getAvg() {
        return avg;
    }
}