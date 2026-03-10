package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterestRateTest {

    @Test
    public void testInterestRateCalculation() {
        double[] ratesAndAmounts =
                {7.5, 7.75, 8.0, 8.25, 8.5, 8.75, 9.0, 9.25, 9.5, 9.75, 10.0};
        for (int i = 0; i <= 10; i++) {
            double rate = ratesAndAmounts[i];
            double expectedAmount = rate;
            double amount = InterestRate.calculateInterest(100, rate);
            assertEquals(expectedAmount, amount);
        }
    }
}
