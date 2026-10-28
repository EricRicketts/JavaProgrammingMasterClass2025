package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.Map.entry;
/*
    getFaceCard that should return an instance of a card based on the suit and abbreviation passed to it.
    getStandardDeck that should return a list of cards you see in a standard deck.
    printDeck should take a description, a list of a Card, and a row count; this will print out
    the cards in the number of rows passed.
    another printDeck (overloaded) it will print the "current Deck" as the description and use 4 as the number
    of rows to be printed.

*/
public class Card {

    private final String cardFace;
    private final CardSuit cardSuit;
    private final int cardRank;
    private static final List<String> validCardFaces =
        List.of("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
    private static final List<CardSuit> validCardSuits =
        List.of(CardSuit.DIAMONDS, CardSuit.CLUBS, CardSuit.HEARTS, CardSuit.SPADES);
    private static final Map<String, Integer> mapOfCardRanks = Map.ofEntries(
        entry("2", 0), // 2, ASCII 50
        entry("3", 1), // 3, ASCII 51
        entry("4", 2), // 4, ASCII 52
        entry("5", 3), // 5, ASCII 53
        entry("6", 4), // 6, ASCII 54
        entry("7", 5), // 7, ASCII 55
        entry("8", 6), // 8, ASCII 56
        entry("9", 7), // 9, ASCII 57
        entry("10", 8), // 10, ASCII 48
        entry("J", 9), // Jack, ASCII 74
        entry("Q", 10), // Queen, ASCII 81
        entry("K", 11), // King, ASCII 75
        entry("A", 12) // Ace, ASCII 65
    );

    public Card(String cardFace, CardSuit cardSuit) {
        this.cardFace = verifyCardFace(cardFace);
        this.cardSuit = verifyCardSuit(cardSuit);
        this.cardRank = mapOfCardRanks.get(cardFace);
    }

    public static Card getNumericCard(CardSuit cardSuit, int rank) {
        CardSuit verifiedCardSuit = Card.verifyCardSuit(cardSuit);
        int verifiedCardRank = Card.verifyCardRank(rank);
        String cardFace = Card.getCardFaceFromCardRank(verifiedCardRank);
        return new Card(cardFace, verifiedCardSuit);
    }

    public static Card getFaceCard(CardSuit cardSuit, String cardFace) {
        CardSuit verifiedCardSuit = Card.verifyCardSuit(cardSuit);
        String verifiedCardFace = Card.verifyCardFace(cardFace);

        return new Card(verifiedCardFace, verifiedCardSuit);
    }

    public String getCardFace() {
        return this.cardFace;
    }

    public CardSuit getCardSuit() {
        return this.cardSuit;
    }

    public int getCardRank() {
        return this.cardRank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getCardFace(), this.getCardSuit(), this.getCardRank());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || (this.getClass() != object.getClass())) return false;
        Card otherCard = (Card) object;
        return Objects.equals(this.getCardFace(), otherCard.getCardFace()) &&
            this.getCardSuit() == otherCard.getCardSuit() && this.getCardRank() == otherCard.getCardRank();
    }

    @Override
    public String toString() {

        return this.getCardFace().toString() + this.getCardSuit().toString() + "(" +
            this.getCardRank() + ")";
    }

    private static String verifyCardFace(String cardFace) {
        if (!validCardFaces.contains(cardFace)) {
            throw new IllegalArgumentException("Invalid card face, must be 2-10, Jack, Queen, King or Ace.");
        }
        return cardFace;
    }

    private static CardSuit verifyCardSuit(CardSuit cardSuit) {
        if (!validCardSuits.contains(cardSuit)) {
            throw new IllegalArgumentException("Invalid card suit, must be diamonds, clubs, hearts or spades.");
        }
        return cardSuit;
    }

    private static int verifyCardRank(int cardRank) {
        if (cardRank < 0 || cardRank > 12) {
            throw new IllegalArgumentException("Invalid card rank, but be between 0 and 12 inclusive.");
        }
        return cardRank;
    }

    private static String getCardFaceFromCardRank(int cardRank) {
        int verifiedCardRank = Card.verifyCardRank(cardRank);
        String validCardRank = "";
        for (Map.Entry<String, Integer> entry : mapOfCardRanks.entrySet()) {
            if (Objects.equals(verifiedCardRank, entry.getValue())) {
                validCardRank = entry.getKey();
            }
        }
        return validCardRank;
    }
}
