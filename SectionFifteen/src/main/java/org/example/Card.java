package org.example;

import java.util.Map;

import static java.util.Map.entry;

public class Card {

    private CardFace cardFace;
    private CardSuit cardSuit;
    private int rank;
    private final Map<Integer, Integer> cardRank = Map.ofEntries(
        entry(50, 0), // 2
        entry(51, 1), // 3
        entry(52, 2), // 4
        entry(53, 3), // 5
        entry(54, 4), // 6
        entry(55, 5), // 7
        entry(56, 6), // 8
        entry(57, 7), // 9
        entry(48, 8), // 10
        entry(74, 9), // Jack
        entry(81, 10), // Queen
        entry(75, 11), // King
        entry(65, 12) // Ace
    );
    public Card(CardFace cardFace, CardSuit cardSuit) {
        int cardSymbolCode = cardFace.getSymbolCode();
        this.cardFace = cardFace;
        this.cardSuit = cardSuit;
        this.rank = cardRank.get(cardSymbolCode);
    }

    public CardFace getCardFace() {
        return this.cardFace;
    }
}
