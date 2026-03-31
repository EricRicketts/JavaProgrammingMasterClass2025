package org.example;

public class Varargs {

    public static String printText(String... textList) {
        String text = "";
        for(String t: textList) {
            text = text.concat(t).concat("\n");
        }
        return text.stripTrailing();
    }
}
