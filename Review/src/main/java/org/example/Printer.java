package org.example;

public class Printer {

    public String print(int intArg) {
        return "The argument for the print(int) overloaded method is "
            .concat(String.valueOf(intArg))
            .concat(".\n");
    }

    public String print(String stringArg) {
        return "The argument for the print(String) overloaded method is "
            .concat(stringArg)
            .concat(".\n");
    }

    public String print(String stringArg, int intArg) {
        return "The arguments for the print(String, int) overloaded method are as follows:\n"
            .concat(print(stringArg))
            .concat(print(intArg));
    }
}
