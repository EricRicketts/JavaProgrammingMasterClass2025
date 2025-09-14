package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SwitchStatementTest {

    String expected, result;
    @Test
    public void testClassicSwitchStatement() {
        int[] inputs = new int[]{1, 2, 3, 4, 5, 6};
        String[] expectedResults = new String[]{
                "The value was 1.",
                "The value was 2.",
                "The value was 3.",
                "The value was 4.",
                "The value was 5.",
                "The value was not 1, 2, 3, 4 or 5."
        };

        for (int i = 0; i< inputs.length; i++) {
            int input = inputs[i];
            expected = expectedResults[i];
            result = SwitchStatement.chooseValues(input);

            Assertions.assertEquals(expected, result);
        }
    }
}
