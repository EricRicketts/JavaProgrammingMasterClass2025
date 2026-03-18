package org.example;

import java.util.Scanner;

public class MinimumAndMaximumNumberEntered {

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static String computeEnteredNumber(Scanner scanner) {
        boolean exitProgram = false;
        do {
            System.out.println("Enter an Integer Number: ");
            try {
                int number = Integer.parseInt(scanner.nextLine());
                if (number < min) {
                    min = number;
                }
                if (number > max) {
                    max = number;
                }
                String text = "Current minimum is " + min + ", current maximum is " + max + ".";
                System.out.println(text);
            } catch (NumberFormatException error) {
                    exitProgram = true;
                }
        } while (!exitProgram);
        return "Program terminated.";
    }
}
