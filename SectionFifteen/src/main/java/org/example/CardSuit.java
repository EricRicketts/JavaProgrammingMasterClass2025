package org.example;

public enum CardSuit {

    DIAMONDS(9830),
    CLUBS(9827),
    HEARTS(9829),
    SPADES(9824);

    private final int symbolCode;

    CardSuit(int symbolCode) {
        this.symbolCode = symbolCode;
    }

    public int getSymbolCode() {
        return this.symbolCode;
    }

    public char convertToImage() {
        return (char) this.symbolCode;
    }

    @Override
    public String toString() {
        return String.valueOf(this.convertToImage());
    }
}

