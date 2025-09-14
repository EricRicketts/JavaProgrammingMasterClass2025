package org.example;

public class SwitchStatement {

    public static String chooseValues(int value) {
        String result = "";
        switch (value) {
            case 1: {
                result =  "The value was 1.";
                break;
            } case 2: {
                result =  "The value was 2.";
                break;
            }  case 3: case 4: case 5: {
                result = "The value was " + value + ".";
                break;
            } default: {
                result =  "The value was not 1, 2, 3, 4 or 5.";
                break;
            }
        }
        return result;
    }
}
