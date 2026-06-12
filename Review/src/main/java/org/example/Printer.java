package org.example;

public class Printer {

    private static final String stringFieldNamePrintString = "the string argument for print(String) method";
    private static final String intFieldNamePrintInt = "the int argument for print(int) method";
    private static final String stringFieldNamePrintStringInt = "the string argument for print(String, int) method";
    private static final String intFieldNamePrintStringInt = "the int argument for print(String, int) method";

    public String print(int intArg) {
        String fieldName = "the int argument for print(int) method";
        int validInt = ValueValidator.validatePositiveIntAndReturn(intArg, fieldName);
        return "The argument for the print(int) overloaded method is "
            .concat(String.valueOf(validInt))
            .concat(".\n");
    }

    public String print(String stringArg) {
        String fieldName = "the string argument for print(String) method";
        String validString = ValueValidator.validateTextAndReturn(stringArg, fieldName);
        return "The argument for the print(String) overloaded method is "
            .concat(validString)
            .concat(".\n");
    }

    public String print(String stringArg, int intArg) {
        return "The arguments for the print(String, int) overloaded method are as follows:\n"
            .concat(print(stringArg))
            .concat(print(intArg));
    }
}
