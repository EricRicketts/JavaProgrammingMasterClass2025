package org.example;

public class Printer {

    private int tonerLevel, pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        this.tonerLevel = tonerLevel;
        this.duplex = duplex;
    }

    public double printPages(int pages) {
        /*
            If a non-duplex printer is used, 20 pages would print out 20 sheets.
            If a duplex printer is used, 20 pages would print out 10 sheets
        */
        int pageToSheetRatio = (!duplex) ? 1 : 2;
        double sheets = (double) pages / pageToSheetRatio;
        this.pagesPrinted += pages;
        return sheets;
    }

    public void printPagesNotification(int pages) {
        double sheets = printPages(pages);
        if (duplex) {
            System.out.println("This is a duplex printer " + sheets + " sheets were printed.");
        } else {
            System.out.println(sheets + " sheets were printed.");
        }
    }
    public int addToner(int addedToner) {
        int newTonerLevel = this.tonerLevel + addedToner;
        this.tonerLevel =
                (newTonerLevel < 0) || (newTonerLevel > 100) ? -1 : newTonerLevel;
        return this.tonerLevel;
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
}
