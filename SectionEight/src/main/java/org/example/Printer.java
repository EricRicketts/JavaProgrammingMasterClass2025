package org.example;

public class Printer {

    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        this.tonerLevel += validateTonerAmount(tonerLevel);
        this.duplex = duplex;
        this.pagesPrinted = 0;
    }

    public void setDuplex(boolean duplex) {
        this.duplex = duplex;
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }

    public boolean isDuplex() {
        return duplex;
    }

    public int addToner(int tonerAmount) {
        int newTonerLevel = this.tonerLevel + validateTonerAmount(tonerAmount);
        if (newTonerLevel > 100) {
            return -1;
        } else {
            return newTonerLevel;
        }
    }
    private int validateTonerAmount(int tonerAmount) {
        if (tonerAmount <= 0) {
            return -1;
        } else if (tonerAmount > 100) {
            return -1;
        } else {
            return tonerAmount;
        }
    }
}
