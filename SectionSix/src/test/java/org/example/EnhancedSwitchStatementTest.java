package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EnhancedSwitchStatementTest {

    @Test
    public void testEnhancedSwitchStatement() {
        int[] values = new  int[]{1, 2, 3};
        String[] expectedResults = new String[]{
                "The value was 1.",
                "The value was 2.",
                "The value was a 3, a 4, or a 5.  The exact value was 3."
        };

        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String expected =  expectedResults[i];
            String result = EnhancedSwitchStatement.chooseValues(value);

            Assertions.assertEquals(expected,result);
        }
    }
}
