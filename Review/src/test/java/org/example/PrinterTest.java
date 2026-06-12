package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrinterTest {

    private Printer printer;
    private static final String STRING_FIELD_NAME_PRINT_STRING =
        "the string argument for print(String) method";
    
    private static final String INT_FIELD_NAME_PRINT_INT =
        "the int argument for print(int) method";
    
    private static final String STRING_FIELD_NAME_PRINT_STRING_INT =
        "the string argument for print(String, int) method";
    
    private static final String INT_FIELD_NAME_PRINT_STRING_INT =
        "the int argument for print(String, int) method";
    NullPointerException nullPointerException;
    IllegalArgumentException illegalArgumentException;

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
           nullPointerException = assertThrows(
                NullPointerException.class,
                () -> printer.print(null)
           );

           assertEquals(
               ErrorMessages.nullValue(STRING_FIELD_NAME_PRINT_STRING),
               nullPointerException.getMessage()
           );
        }

        @Test
        public void testPrintStringRejectsEmptyString() {
            illegalArgumentException = assertThrows(
                IllegalArgumentException.class,
                () -> printer.print("")
            );

            assertEquals(
                ErrorMessages.emptyValue(STRING_FIELD_NAME_PRINT_STRING),
                illegalArgumentException.getMessage()
            );
        }

        @Test
        public void testPrintStringRejectsBlankString() {
            illegalArgumentException = assertThrows(
                IllegalArgumentException.class,
                () -> printer.print("  ")
            );

            assertEquals(
                ErrorMessages.blankValue(STRING_FIELD_NAME_PRINT_STRING),
                illegalArgumentException.getMessage());
        }
    }

    @Nested
    @DisplayName("test invalid int inputs for print(int) method")
    class TestInvalidIntInputsForPrintMethodWithIntArgument {

        @Test
        public void testPrintIntRejectsNegativeInteger() {
            illegalArgumentException = assertThrows(
                IllegalArgumentException.class,
                () -> printer.print(-1)
            );

            assertEquals(
                ErrorMessages.negativeValue(INT_FIELD_NAME_PRINT_INT),
                illegalArgumentException.getMessage()
            );
        }

        @Test
        public void testPrintIntRejectsZeroInput() {
            illegalArgumentException = assertThrows(
                IllegalArgumentException.class,
                () -> printer.print(0)
            );

            assertEquals(
                ErrorMessages.zeroValue(INT_FIELD_NAME_PRINT_INT),
                illegalArgumentException.getMessage()
            );
        }
    }

    @Nested
    @DisplayName("test invalid String inputs for print(String, int) method")
    class TestInvalidStringInputsForPrintMethodWithStringAndIntArguments {

        @Test
        public void testPrintStringIntRejectsNull() {
            nullPointerException = assertThrows(
                NullPointerException.class,
                () -> printer.print(null, 1)
            );

            assertEquals(
                ErrorMessages.nullValue(STRING_FIELD_NAME_PRINT_STRING_INT),
                nullPointerException.getMessage()
            );
        }

        @Test
        public void testPrintStringIntRejectsEmptyString() {
            illegalArgumentException = assertThrows(
                IllegalArgumentException.class,
                () -> printer.print("", 1)
            );

            assertEquals(
                ErrorMessages.emptyValue(STRING_FIELD_NAME_PRINT_STRING_INT),
                illegalArgumentException.getMessage()
            );
        }

        @Test
        public void testPrintStringIntRejectsBlankString() {
            illegalArgumentException = assertThrows(
                IllegalArgumentException.class,
                () -> printer.print("  ", 1)
            );

            assertEquals(
                ErrorMessages.blankValue(STRING_FIELD_NAME_PRINT_STRING_INT),
                illegalArgumentException.getMessage()
            );
        }
    }

    @Nested
    @DisplayName("test invalid int inputs for print(String, int) method")
    class TestInvalidIntInputsForPrintMethodWithStringAndIntArguments {

        @Test
        public void testPrintStringIntRejectsNegativeInteger() {
            illegalArgumentException = assertThrows(
                IllegalArgumentException.class,
                () -> printer.print("Foobar", -1)
            );

            assertEquals(
                ErrorMessages.negativeValue(INT_FIELD_NAME_PRINT_STRING_INT),
                illegalArgumentException.getMessage()
            );
        }

        @Test
        public void testPrintStringIntRejectsZero() {
            illegalArgumentException = assertThrows(
                IllegalArgumentException.class,
                () -> printer.print("Foobar", 0)
            );

            assertEquals(
                ErrorMessages.zeroValue(INT_FIELD_NAME_PRINT_STRING_INT),
                illegalArgumentException.getMessage()
            );
        }
    }
}