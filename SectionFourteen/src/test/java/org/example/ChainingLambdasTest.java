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
    }

    @Nested
    @DisplayName("test chaining operations together")
    class TestChainOperationsTogether {

        @Test
        public void testStringToUpperCaseNoChaining() {
            upperCase = String::toUpperCase;

            assertEquals("ERIC", upperCase.apply(name));
        }

        @Test
        public void testChainStringToUpperCaseAndLastNameSuffix() {
            upperCase = String::toUpperCase;
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
            upperCase = String::toUpperCase;
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
            upperCase = String::toUpperCase;
            Function<String, String[]> f0 = upperCase
                .andThen(s -> s.concat(" Ricketts"))
                .andThen(s -> s.split("\\s+"));

            String[] result = f0.apply(name);
            assertArrayEquals(expected, result);
        }

        
    }
}
