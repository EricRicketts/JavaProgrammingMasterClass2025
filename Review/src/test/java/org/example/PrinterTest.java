package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrinterTest {

    Printer printer;

    @BeforeEach
    public void setUp() {
        printer = new Printer();
    }

    @Nested
    @DisplayName("test print(String) method")
    class TestPrintStringMethod {

        @Test
        public void testPrintMethodWithStringArgument() {
            assertEquals(
                "The argument for the print(String) overloaded method is Foobar.\n",
                printer.print("Foobar")
            );
        }
    }

    @Nested
    @DisplayName("test print(int) method")
    class TestPrintIntMethod {

        @Test
        public void testPrintMethodWithIntArgument() {
            assertEquals(
                "The argument for the print(int) overloaded method is 15.\n",
                printer.print(15)
            );
        }

    }


    @Nested
    @DisplayName("test print(String, int) method")
    class TestPrintStringIntMethod {

        @Test
        public void testPrintMethodWithStringAndIntArguments() {
            assertEquals(
                "The arguments for the print(String, int) overloaded method are as follows:\n"
                        .concat("The argument for the print(String) overloaded method is Foobar.\n")
                        .concat("The argument for the print(int) overloaded method is 15.\n"),
                printer.print("Foobar", 15)
            );
        }

    }

    @Nested
    @DisplayName("test invalid String inputs for print(String) method")
    class TestInvalidInputsForPrintMethodWithStringArgument {

        @Test
        public void testNullInputForPrintMethodWithStringArgument() {
            assertThrows(
                NullPointerException.class,
                () -> printer.print(null)
            );
        }
    }
}
