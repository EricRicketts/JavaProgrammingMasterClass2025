package org.example;

public class Printer {

    private int tonerLevel, pagesPrinted;
    private final boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        this.tonerLevel = (tonerLevel >= 0 && tonerLevel <= 100) ? tonerLevel : -1;
        this.duplex = duplex;
    }

    public int addToner(int tonerAmount) {
        boolean tonerAmountConstraintsExceeded =
                (tonerAmount < 0 || tonerAmount > 100) ||
                        (this.getTonerLevel() + tonerAmount > 100);
        if (tonerAmountConstraintsExceeded) return -1;
        this.setTonerLevel(this.getTonerLevel() + tonerAmount);
        return this.getTonerLevel();
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public void setTonerLevel(int tonerLevel) {
        this.tonerLevel = tonerLevel;
    }

    public int printPages(int pages) {
        int pagesToPrint = (duplex) ? (pages / 2) + (pages % 2) : pages;
        this.pagesPrinted += pagesToPrint;
        return pagesToPrint;
    }
    public int getPagesPrinted() {
        return pagesPrinted;
    }

    public boolean isDuplex() {
        return duplex;
    }
}
