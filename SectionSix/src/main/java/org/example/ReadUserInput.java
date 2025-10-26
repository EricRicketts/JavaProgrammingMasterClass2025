package org.example;

import java.util.Scanner;

/*
https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
how to read and test System.out.println();
 */
public class ReadUserInput {

    public String readValidNumber(int number) {
        String numberToString = "";
        try {
            numberToString = String.valueOf(number);
        } catch (NumberFormatException nfe) {
            return "Invalid input. Please try again.";
        }
        return numberToString;
    }
}