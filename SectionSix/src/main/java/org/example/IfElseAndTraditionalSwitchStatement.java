package org.example;

public class IfElseAndTraditionalSwitchStatement {

    public static String ifElseExample(int value) {
        String message = "";
        if (value == 1) {
            message = "Value was 1";
        } else if (value == 2) {
            message = "Value was 2";
        } else {
            message = "Value was neither 1 nor 2";
        }
        return message;
    }

    public static String traditionalSwitchExample(int value) {
        String message = "";
        switch(value) {
            case 1: {
                message = "Value was 1";
                break;
            }
            case 2: {
                message = "Value was 2";
                break;
            }
            default: {
                message = "Value was neither 1 nor 2";
                break;
            }
        }
        return message;
    }
}
