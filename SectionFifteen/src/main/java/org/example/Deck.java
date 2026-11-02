package org.example;

import java.util.ArrayList;
import java.util.List;
import static org.example.CardAndDeckConstants.*;
import static org.example.CardSuit.*;

public class Deck {

    public Deck() {}

    public static List<Card> getStandardDeck() {
        List<Card> allCards = new ArrayList<>();

        for (CardSuit cardSuit : VALID_CARD_SUITS) {
            for (String cardFace : VALID_CARD_FACES) {
                switch(cardSuit) {
                    case DIAMONDS -> allCards.add(new Card(cardFace, DIAMONDS));
                    case CLUBS -> allCards.add(new Card(cardFace, CLUBS));
                    case HEARTS -> allCards.add(new Card(cardFace, HEARTS));
                    case SPADES -> allCards.add(new Card(cardFace, SPADES));
                }
            }
        }

        return allCards;
    }

    public static String printDeck(List<Card> cards, String description, int rows) {
        int validRowNumber = Deck.validateRows(rows);
        String output = "";
        switch (validRowNumber) {
            case 1 -> output = output.concat(Deck.printOneRow(cards, 1));
            case 2 -> output = output.concat(Deck.printOneRow(cards, 1).concat(Deck.printOneRow(cards, 2)));
            case 3 -> output = output.concat(Deck.printOneRow(cards, 1).concat(Deck.printOneRow(cards, 2))
                .concat(Deck.printOneRow(cards, 3)));
            default -> output = output.concat(Deck.printOneRow(cards, 1).concat(Deck.printOneRow(cards, 2))
                .concat(Deck.printOneRow(cards, 3)).concat(Deck.printOneRow(cards, 4)));
        }
        return output;
    }

    private static int validateRows(int numberOfRows) {
        if (numberOfRows < 1 || numberOfRows > 4) {
            throw new IllegalArgumentException("Invalid row numbers, rows must be between 1 and 4 inclusive.");
        }
        return numberOfRows;
    }

    public static String printOneRow(List<Card> cards, int rowNumber) {
        Card card;
        String suitRow = "";
        switch(rowNumber) {
            case 1 -> suitRow = collectOneRowOfCardOutput(cards, STARTING_INDEX_DIAMONDS, STARTING_INDEX_CLUBS);
            case 2 -> suitRow = collectOneRowOfCardOutput(cards, STARTING_INDEX_CLUBS, STARTING_INDEX_HEARTS);
            case 3 -> suitRow = collectOneRowOfCardOutput(cards, STARTING_INDEX_HEARTS, STARTING_INDEX_SPADES);
            default -> suitRow = collectOneRowOfCardOutput(cards, STARTING_INDEX_SPADES, DECK_SIZE);
        }

        return suitRow;
    }

    private static String collectOneRowOfCardOutput(List<Card> cards, int startingIndex, int finishingIndex) {
        Card card;
        String oneRowOfCards = "";
        for (int index = startingIndex; index < finishingIndex; index+=1) {
            card = cards.get(index);
            if ("A".equals(card.getCardFace())) {
                oneRowOfCards = oneRowOfCards.concat(card + "\n");
            } else {
                oneRowOfCards = oneRowOfCards.concat(card + " ");
            }
        }
        return oneRowOfCards;
    }
}
