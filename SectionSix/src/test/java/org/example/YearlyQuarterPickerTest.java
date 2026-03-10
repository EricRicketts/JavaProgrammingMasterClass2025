package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YearlyQuarterPickerTest {

    String[] months = {
            "JANUARY", "FEBRUARY", "MARCH",
            "APRIL", "MAY", "JUNE",
            "JULY", "AUGUST", "SEPTEMBER",
            "OCTOBER", "NOVEMBER", "DECEMBER"
    };
    String[] quarters = {"Q1", "Q2", "Q3", "Q4"};

    @Test
    public void testQuarterSelectionTraditionalSwitch() {
        for (int index = 0; index < months.length; index++) {
            String month = months[index];
            String expectedQuarter = quarters[index / 3];
            String resultantQuarter = YearlyQuarterPicker.getQuarterTraditionalSwitch(month);
            assertEquals(expectedQuarter, resultantQuarter);
        }
    }

    @Test
    public void testQuarterSelectionEnhancedSwitch() {
        for (int index = 0; index < months.length; index++) {
            String month = months[index];
            String expectedQuarter = quarters[index / 3];
            String resultantQuarter = YearlyQuarterPicker.getQuarterEnhancedSwitch(month);
            assertEquals(expectedQuarter, resultantQuarter);
        }
    }
}
