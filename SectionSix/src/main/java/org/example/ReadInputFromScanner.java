package org.example;

import java.util.Scanner;

public class ReadInputFromScanner {

    public static String readInput(Scanner scanner) {
        int count = 0; int sum = 0;
        boolean exitLoop = false;
        System.out.println("You will enter five integers and their sum will be computed.");

        do {
            try {
                String queryString = "Enter Number #" + (count + 1) + ": ";
                System.out.println(queryString);
                String number = scanner.nextLine();

                sum += Integer.parseInt(number);
                count++;
                if (count >= 5) {
                    exitLoop = true;
                }
            } catch (NumberFormatException error) {
                System.out.println("Only Integer numbers are allowed, try again.");
            }
        } while (!exitLoop);

        return "The sum of the five numbers is " + sum;
    }
}
