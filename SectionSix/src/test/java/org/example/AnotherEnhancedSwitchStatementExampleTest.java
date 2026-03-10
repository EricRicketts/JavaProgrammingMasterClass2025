package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnotherEnhancedSwitchStatementExampleTest {

    int[] testValues = {1, 2, 3};
    String[] expectedMessages = {"Value is 1", "Value is 2", "Value is neither 1 or 2"};

    @Test
    public void testAnotherEnhancedSwitchStatementExample() {
        for (int index = 0; index < testValues.length; index++) {
            int value = testValues[index];
            String expected = expectedMessages[index];
            String result =
                    AnotherEnhancedSwitchStatementExample.enhancedSwitchStatementExample(value);
            assertEquals(expected, result);
        }
    }
}
