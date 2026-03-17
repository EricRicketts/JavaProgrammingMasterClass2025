package org.example;

import java.util.Scanner;

public class InputFromScannerAndConsole {

    public static void main(String[] args) {
        System.out.println(getInputFromScanner(2026));
    }

    public static String getInputFromScanner(int currentYear) {
        boolean validDOB = false;
        int age = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hi, what is your name? ");
        String name = scanner.nextLine();

        System.out.println("Hi " + name + ", thanks for taking the course!");

        System.out.println("In what year where you born? ");

        do {
            String yearOfBirthWithAgeRestrictions =
                    "Enter a year of birth >= " + (currentYear - 125) + " and <= " +
                            currentYear;
            System.out.println(yearOfBirthWithAgeRestrictions);
            try {
                age = checkData(currentYear, scanner.nextLine());
                validDOB = age >= 0;
            } catch (NumberFormatException error) {
                System.out.println("Characters not allowed, only numbers!!  Try again.");
            }

        } while (!validDOB);

        return "So you are " + age + " years old.";
    }

    public static int checkData(int currentYear, String dateOfBirth) {
        int dob = Integer.parseInt(dateOfBirth);
        int minimumYear = currentYear - 125; // We assume the age limit for a person is 125 years.
        if ((dob < minimumYear || (dob > currentYear))) {
            return -1; // Indicates invalid input.
        }

        return (currentYear - dob); // If the validation check works, return the age.
    }
}
