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

    public int printPages(int pages) {
        int pagesToPrint = pages;
        if (this.isDuplex()) {
            pagesToPrint = pages / 2 + pages % 2;
        }
        this.pagesPrinted += pagesToPrint;
        return pagesToPrint;
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
        int validTonerAmount = validateTonerAmount(tonerAmount);
        if (validTonerAmount == -1) return -1;
        int newTonerLevel = this.tonerLevel + validateTonerAmount(validTonerAmount);
        if (newTonerLevel > 100) {
            return -1;
        } else {
            this.tonerLevel = newTonerLevel;
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
