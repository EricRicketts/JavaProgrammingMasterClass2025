package org.example;

public class Printer {

    public static final String STRING_FIELD_NAME_PRINT_STRING =
        "the string argument for print(String) method";

    public static final String INT_FIELD_NAME_PRINT_INT =
        "the int argument for print(int) method";

    public static final String STRING_FIELD_NAME_PRINT_STRING_INT =
        "the string argument for print(String, int) method";

    public static final String INT_FIELD_NAME_PRINT_STRING_INT =
        "the int argument for print(String, int) method";

    public static final String RETURN_STRING_FOR_PRINT_INT =
        "The argument for the print(int) overloaded method is %d.%n";

    public static final String RETURN_STRING_FOR_PRINT_STRING =
        "The argument for the print(String) overloaded method is ";

    public static final String RETURN_STRING_FOR_PRINT_STRING_INT =
        "The arguments for the print(String, int) overloaded method are as follows:\n";

    public String print(int intArg) {
        int validInt = ValueValidator.validatePositiveIntAndReturn(intArg, INT_FIELD_NAME_PRINT_INT);

        return RETURN_STRING_FOR_PRINT_INT.formatted(validInt);
    }

    public String print(String stringArg) {
        String validString = ValueValidator.validateTextAndReturn(stringArg, STRING_FIELD_NAME_PRINT_STRING);

        return  RETURN_STRING_FOR_PRINT_STRING + validString + ".\n";
    }

    public String print(String stringArg, int intArg) {
        String validString = ValueValidator.validateTextAndReturn(stringArg, STRING_FIELD_NAME_PRINT_STRING_INT);
        int validInt = ValueValidator.validatePositiveIntAndReturn(intArg, INT_FIELD_NAME_PRINT_STRING_INT);

        return  RETURN_STRING_FOR_PRINT_STRING_INT +
            RETURN_STRING_FOR_PRINT_STRING + validString + ".\n" +
            RETURN_STRING_FOR_PRINT_INT.formatted(validInt);
    }
}