package org.example;

public class Printer {

    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        this.tonerLevel += (tonerLevel > 0 && tonerLevel <= 100) ? tonerLevel : -1;
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
        int validTonerAmount = (tonerAmount > 0 && tonerAmount <= 100) ? tonerAmount : -1;
        if (validTonerAmount == -1) return -1;
        int newTonerLevel = this.tonerLevel + validTonerAmount;
        newTonerLevel = (newTonerLevel > 0 && newTonerLevel <= 100) ? newTonerLevel : -1;
        if (newTonerLevel == -1) {
            return -1;
        } else {
            this.tonerLevel = newTonerLevel;
            return newTonerLevel;
        }
    }
}
