package org.example;

public class LargestPrime {

    public static int getLargestPrime(int number) {
        if (number < 2) { // test for negative number or a number less than 2 which is not prime
            return -1;
        }

        int factor = -1; // set the largest factor to a low number so it will be at least 2
        for (int i = 2; i * i <= number; i++) { // outer for loop statement from exercise hints say
            if (number % i != 0) {  // largest prime factor cannot exceed the square root of the number
                continue;           // so i < sqrt(number) is same as i * i <= number
                // above we are checking if "i" is not a factor of the number, if not we continue to the next number
                // if number = 12, then 12 % 2 = 0
            }
            factor = i; // factor = 2
            while (number % i == 0) {
                number /= i;
            }
            // 12 % 2 = 0, then number = 12 / 2 = 6, then 6 % 2 = 0, so number = 6 / 2 = 3, then number = 3
        }
        // number != 1 so number or 3 is chosen
        return number == 1 ? factor : number;
    }
}
/*
    I was spending too much time on the exercise, so I copied the instructor solution.
*/
