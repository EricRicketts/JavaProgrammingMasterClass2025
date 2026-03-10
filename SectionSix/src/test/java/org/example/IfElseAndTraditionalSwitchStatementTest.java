package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IfElseAndTraditionalSwitchStatementTest {

    String expected, result;

    @Test
    public void testIfElseStatement() {
        expected = "Value was 1" ;
        result = IfElseAndTraditionalSwitchStatement.ifElseExample(1);
        assertEquals(expected, result);
    }

    @Test
    public void testTraditionalSwitchStatement() {
        expected = "Value was 2";
        result = IfElseAndTraditionalSwitchStatement.traditionalSwitchExample(2);
        assertEquals(expected, result);
    }
}
