package org.example;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.example.CardAndDeckConstants.*;

public class Card {

    private final String cardFace;
    private final CardSuit cardSuit;
    private final int cardRank;

    public Card(String cardFace, CardSuit cardSuit) {
        this.cardFace = verifyCardFace(cardFace);
        this.cardSuit = verifyCardSuit(cardSuit);
        this.cardRank = MAP_OF_CARD_FACE_TO_RANK.get(cardFace);
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
        return this.getCardFace() + this.getCardSuit().toString() + "(" +
            this.getCardRank() + ")";
    }

    private static String verifyCardFace(String cardFace) {
        if (!VALID_CARD_FACES.contains(cardFace)) {
            throw new IllegalArgumentException("Invalid card face, must be 2-10, Jack, Queen, King or Ace.");
        }
        return cardFace;
    }

    private static CardSuit verifyCardSuit(CardSuit cardSuit) {
        if (!VALID_CARD_SUITS.contains(cardSuit)) {
            throw new IllegalArgumentException("Invalid card suit, must be diamonds, clubs, hearts or spades.");
        }
        return cardSuit;
    }

    private static int verifyCardRank(int cardRank) {
        if (cardRank < MAP_OF_CARD_FACE_TO_RANK.get("2") ||
            cardRank > MAP_OF_CARD_FACE_TO_RANK.get("A")) {
            throw new IllegalArgumentException("Invalid card rank, but be between 0 and 12 inclusive.");
        }
        return cardRank;
    }

    private static int verifyRowCount(int rows) {
        if (rows < 1 || rows > 4) {
            throw new IllegalArgumentException("Invalid number of rows, must be between 1 and 4 inclusive.");
        }
        return rows;
    }

    private static String getCardFaceFromCardRank(int cardRank) {
        int verifiedCardRank = Card.verifyCardRank(cardRank);
        String validCardRank = "";
        for (Map.Entry<String, Integer> entry : MAP_OF_CARD_FACE_TO_RANK.entrySet()) {
            if (Objects.equals(verifiedCardRank, entry.getValue())) {
                validCardRank = entry.getKey();
            }
        }
        return validCardRank;
    }
}
