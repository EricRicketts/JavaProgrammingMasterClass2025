package org.example;

public enum CardFace {

    TWO(50),
    THREE(51),
    FOUR(52),
    FIVE(53),
    SIX(54),
    SEVEN(55),
    EIGHT(56),
    NINE(57),
    TEN(48),
    JACK(74),
    QUEEN(81),
    KING(75),
    ACE(65);

    private final int symbolCode;

    CardFace(int symbolCode) {
        this.symbolCode = symbolCode;
    }

    public int getSymbolCode() {
        return this.symbolCode;
    }

    public char convertToImage() {
        if (this.symbolCode == 48) {
            return (char) ((char) (this.getSymbolCode() + 1) + (char) this.getSymbolCode());
        }
        return (char) this.getSymbolCode();
    }
}
