package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadUserInput {

    public void readFiveValidNumbers() {
       int validNumberCount = 1;
       int sum = 0;
       System.out.println("We will sum 5 numbers in this exercise.");
       Scanner scanner = new Scanner(System.in);

       do {
           System.out.print("Enter number #" + validNumberCount + ": ");
            try {
                String numberAsString = scanner.nextLine();
                int number = Integer.parseInt(numberAsString);
                sum += number;
                validNumberCount++;
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid input. Please try again.");
            }

       } while(validNumberCount < 6);
       System.out.println("The sum of the five numbers is " + sum);
    }

    public void readAndFindMinAndMaxNumbers() {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        System.out.println("We will find the min and max integers in this exercise.");
        System.out.println("Enter an integer or a character(s) to quit.");

        Scanner scanner = new Scanner(System.in);

        do {
            try {
                String numberAsString = scanner.nextLine();
                int number = Integer.parseInt(numberAsString);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } while (true);
    }
}
