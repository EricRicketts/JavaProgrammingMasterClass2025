package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FactorPrinterTest {
    List<Integer> expected = new ArrayList<>(); List<Integer> results = new ArrayList<>();

    @Test
    public void factorPrinterTestForNumberLessThanOne() {
        expected.add(-1);
        results = FactorPrinter.printFactors(0);

        Assertions.assertEquals(expected, results);
    }

    @Test
    public void factorPrinterTestForTheNumberSix() {
        expected.addAll(List.of(1, 2, 3, 6));
        results = FactorPrinter.printFactors(6);

        Assertions.assertEquals(expected, results);
    }

    @Test
    public void factorPrinterTestForTheNumberSeven() {
        expected.addAll(List.of(1, 7));
        results = FactorPrinter.printFactors(7);

        Assertions.assertEquals(expected, results);
    }

    @Test
    public void factorPrinterTestForTheNumberTen() {
        expected.addAll(List.of(1, 2, 5, 10));
        results = FactorPrinter.printFactors(10);

        Assertions.assertEquals(expected, results);
    }

    @Test
    public void factorPrinterTestForTheNumberThirtyTwo() {
        expected.addAll(List.of(1, 2, 4, 8, 16, 32));
        results = FactorPrinter.printFactors(32);

        Assertions.assertEquals(expected, results);
    }
}
