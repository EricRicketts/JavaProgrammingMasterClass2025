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
    class TestPrintMethodWithStringArgument {

        @Test
        public void testPrintString() {
            assertEquals(
                "The argument for the print(String) overloaded method is Foobar.\n",
                printer.print("Foobar")
            );
        }
    }

    @Nested
    @DisplayName("test print(int) method")
    class TestPrintMethodWithIntArgument {

        @Test
        public void testPrintInt() {
            assertEquals(
                "The argument for the print(int) overloaded method is 15.\n",
                printer.print(15)
            );
        }

    }


    @Nested
    @DisplayName("test print(String, int) method")
    class TestPrintMethodWithStringAndIntArguments {

        @Test
        public void testPrintStringInt() {
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
    class TestInvalidStringInputsForPrintMethodWithStringArgument {

        @Test
        public void testPrintStringRejectsNull() {
            assertThrows(
                NullPointerException.class,
                () -> printer.print(null)
            );
        }

        @Test
        public void testPrintStringRejectsEmptyString() {
            assertThrows(
                IllegalArgumentException.class,
                () -> printer.print("")
            );
        }

        @Test
        public void testPrintStringRejectsBlankString() {
            assertThrows(
                IllegalArgumentException.class,
                () -> printer.print("  ")
            );
        }
    }

    @Nested
    @DisplayName("test invalid int inputs for print(int) method")
    class TestInvalidIntInputsForPrintMethodWithIntArgument {

        @Test
        public void testPrintIntRejectsNegativeInteger() {
            assertThrows(
                IllegalArgumentException.class,
                () -> printer.print(-1)
            );
        }

        @Test
        public void testPrintIntRejectsZeroInput() {
            assertThrows(
                IllegalArgumentException.class,
                () -> printer.print(0)
            );
        }
    }

    @Nested
    @DisplayName("test invalid String inputs for print(String, int) method")
    class TestInvalidStringInputsForPrintMethodWithStringAndIntArguments {

        @Test
        public void testPrintStringIntRejectsNull() {
            assertThrows(
                NullPointerException.class,
                () -> printer.print(null, 1)
            );
        }

        @Test
        public void testPrintStringIntRejectsEmptyString() {
            assertThrows(
                IllegalArgumentException.class,
                () -> printer.print("", 1)
            );
        }

        @Test
        public void testPrintStringIntRejectsBlankString() {
            assertThrows(
                IllegalArgumentException.class,
                () -> printer.print("  ", 1)
            );
        }
    }

    @Nested
    @DisplayName("test invalid int inputs for print(String, int) method")
    class TestInvalidIntInputsForPrintMethodWithStringAndIntArguments {

        @Test
        public void testPrintStringIntRejectsNegativeInteger() {
            assertThrows(
                IllegalArgumentException.class,
                () -> printer.print("Foobar", -1)
            );
        }

        @Test
        public void testPrintStringIntRejectsZero() {
            assertThrows(
                IllegalArgumentException.class,
                () -> printer.print("Foobar", 0)
            );
        }
    }
}
