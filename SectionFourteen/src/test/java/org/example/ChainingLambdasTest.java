package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChainingLambdasTest {

    private String name;
    Function<String, String> upperCase;

    @BeforeEach
    public void setUp() {
        name = "Eric";
        upperCase = String::toUpperCase;
    }

    @Nested
    @DisplayName("test chaining operations together")
    class TestChainOperationsTogether {

        @Test
        public void testStringToUpperCaseNoChaining() {
            assertEquals("ERIC", upperCase.apply(name));
        }

        @Test
        public void testChainStringToUpperCaseAndLastNameSuffix() {
            Function<String, String> addLastName = s -> s.concat(" Ricketts");
            Function<String, String> uCaseAndLastName = upperCase.andThen(addLastName);

            name = uCaseAndLastName.apply(name);

            assertEquals("ERIC Ricketts", name);
        }

        @Test
        public void testChainAddLastNameSuffixAndToUpperCaseWithCompose() {
            /*
                The difference between "andThen" and "compose" is "compose" reverses
                the stated order of operations.  In the same of the previous test, the
                name String was upper-cased first and then the last name was added.  In the
                case for "compose" the last name is added first, and then the entire string
                is upper-cased.
            */
            Function<String, String> addLastName = s -> s.concat(" Ricketts");
            Function<String, String> uCaseAndLastName;

            uCaseAndLastName = upperCase.compose(addLastName);

            name = uCaseAndLastName.apply(name);

            assertEquals("ERIC RICKETTS", name);
        }

        @Test
        public void testMoreSuccessiveChainingReturnsStringArray() {
            /*
                As mentioned by the instructor, the end result of the entire operation is
                to return a type as specified by Function<T, R>.  Intermediate values are
                only relevant in the sense the following function in the chain must be able
                to operate on the data it has been handed.
            */
            String[] expected = {"ERIC", "Ricketts"};
            Function<String, String[]> f0 = upperCase
                .andThen(s -> s.concat(" Ricketts"))
                .andThen(s -> s.split("\\s+"));

            String[] result = f0.apply(name);
            assertArrayEquals(expected, result);
        }

        @Test
        public void testInstructorLambda() {
            Function<String, String> f1 =  upperCase
                .andThen(s -> s.concat(" Ricketts"))
                .andThen(s -> s.split("\\s+"))
                .andThen(s -> s[1].toUpperCase() + ", " + s[0]);

            String result = f1.apply(name);

            assertEquals("RICKETTS, ERIC", result);
        }

        @Test
        public void testReturnADifferentType() {
            Function<String, Integer> f2 = upperCase
                .andThen(s -> s.concat(" Ricketts"))
                .andThen(s -> s.split("\\s+"))
                .andThen(s -> String.join(", ", s))
                .andThen(String::length);

            assertEquals(14, f2.apply(name));
        }

    }
}
