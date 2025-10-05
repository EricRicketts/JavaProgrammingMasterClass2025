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
}
