package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.example.CardAndDeckConstants.*;
import static org.example.CardSuit.*;

import static java.util.Map.entry;
import static org.example.CardSuit.DIAMONDS;

public class Deck {

    private static final List<String> VALID_CARD_FACES =
        List.of("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
    private static final List<CardSuit> VALID_CARD_SUITS =
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

    public Deck() {
        Deck.getStandardDeck();
    }

    public static List<List<Card>> getStandardDeck() {
        List<Card> diamondCards = new ArrayList<>();
        List<Card> clubCards = new ArrayList<>();
        List<Card> heartCards = new ArrayList<>();
        List<Card> spadeCards = new ArrayList<>();

        for (CardSuit cardSuit : VALID_CARD_SUITS) {
            for (String cardFace : VALID_CARD_FACES) {
                switch(cardSuit) {
                    case DIAMONDS -> diamondCards.add(new Card(cardFace, DIAMONDS));
                    case CLUBS -> clubCards.add(new Card(cardFace, CLUBS));
                    case HEARTS -> heartCards.add(new Card(cardFace, HEARTS));
                    case SPADES -> spadeCards.add(new Card(cardFace, SPADES));
                }
            }
        }

        return new ArrayList<>(List.of(diamondCards, clubCards, heartCards, spadeCards));
    }

    public static String printDeck(List<List<Card>> cards, String description, int rows) {
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

    public static String printOneRow(List<List<Card>> cards, int rowNumber) {
        Card card;
        String suitRow = "";
        switch(rowNumber) {
            case 1 -> {
                for (int index = 0; index < cards.getFirst().size(); index+=1) {
                    card = new Card(CARD_FACE_VALUES[index].toString(), DIAMONDS);
                    if ("A".equals(card.getCardFace())) {
                        suitRow = suitRow.concat(card + "\n");
                    } else {
                        suitRow = suitRow.concat(card + " ");
                    }
                }
            }

            case 2 -> {
                for (int index = 0; index < cards.get(1).size(); index+=1) {
                    card = new Card(CARD_FACE_VALUES[index].toString(), CLUBS);
                    if ("A".equals(card.getCardFace())) {
                        suitRow = suitRow.concat(card + "\n");
                    } else {
                        suitRow = suitRow.concat(card + " ");
                    }
                }
            }

            case 3 -> {
                for (int index = 0; index < cards.get(2).size(); index+=1) {
                    card = new Card(CARD_FACE_VALUES[index].toString(), HEARTS);
                    if ("A".equals(card.getCardFace())) {
                        suitRow = suitRow.concat(card + "\n");
                    } else {
                        suitRow = suitRow.concat(card + " ");
                    }
                }
            }

            default -> {
                for (int index = 0; index < cards.getLast().size(); index+=1) {
                    card = new Card(CARD_FACE_VALUES[index].toString(), SPADES);
                    if ("A".equals(card.getCardFace())) {
                        suitRow = suitRow.concat(card + "\n");
                    } else {
                        suitRow = suitRow.concat(card + " ");
                    }
                }
            }
        }
        return suitRow;
    }
}
