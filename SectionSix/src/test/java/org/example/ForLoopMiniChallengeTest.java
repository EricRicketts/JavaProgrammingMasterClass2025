package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ForLoopMiniChallengeTest {

    double amount = 100.00;
    List<Double> expected = List.of(7.5, 7.75, 8.0, 8.25, 8.5, 8.75, 9.0, 9.25, 9.5, 9.75, 10.0);
    List<Double> results = new ArrayList<>();
    public static double calculateInterest(double amount, double interestRate) {
        return amount *  interestRate / 100;
    }

    @Test
    public void testForLoopMiniChallenge() {
        for (double rate = 7.5; rate <= 10.0; rate += 0.25) {
            double interest =  calculateInterest(amount, rate);
            results.add(interest);
        }
        Assertions.assertEquals(expected, results);
    }

    @Test
    public void testForLoopMiniChallengeWithBreakStatement() {
        expected = List.of(7.5, 7.75, 8.0, 8.25, 8.5);
        for (double rate = 7.5; rate <= 10.0; rate += 0.25) {
            if (rate > 8.5) { break; }
            double interest =  calculateInterest(amount, rate);
            results.add(interest);
        }
        Assertions.assertEquals(expected, results);

    }
}
