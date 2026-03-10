package org.example;

public class YearlyQuarterPicker {

    public static String getQuarterTraditionalSwitch(String month) {
        month = month.toUpperCase();
        String quarter;
        switch (month) {
            case "JANUARY": case "FEBRUARY": case "MARCH": {
                quarter = "Q1";
                break;
            }
            case "APRIL": case "MAY": case "JUNE": {
                quarter = "Q2";
                break;
            }
            case "JULY": case "AUGUST": case "SEPTEMBER": {
                quarter = "Q3";
                break;
            }
            case "OCTOBER": case "NOVEMBER": case "DECEMBER": {
                quarter = "Q4";
                break;
            }
            default: {
                quarter = "Invalid Value";
                break;
            }
        }
        return quarter;
    }

    public static String getQuarterEnhancedSwitch(String month) {
        month = month.toUpperCase();
        String quarter;
        return switch (month) {
            case "JANUARY", "FEBRUARY", "MARCH" -> {
                quarter = "Q1";
                yield quarter;
            }
            case "APRIL", "MAY", "JUNE" -> {
                quarter = "Q2";
                yield quarter;
            }
            case "JULY", "AUGUST", "SEPTEMBER" -> {
                quarter = "Q3";
                yield quarter;
            }
            case "OCTOBER", "NOVEMBER", "DECEMBER" -> {
                quarter = "Q4";
                yield quarter;
            }
            default -> {
                quarter = "Invalid Value";
                yield quarter;
            }
        };
    }
}