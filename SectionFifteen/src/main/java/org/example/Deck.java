package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

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
                    case DIAMONDS -> diamondCards.add(new Card(cardFace, CardSuit.DIAMONDS));
                    case CLUBS -> clubCards.add(new Card(cardFace, CardSuit.CLUBS));
                    case HEARTS -> heartCards.add(new Card(cardFace, CardSuit.HEARTS));
                    case SPADES -> spadeCards.add(new Card(cardFace, CardSuit.SPADES));
                }
            }
        }

        return new ArrayList<>(List.of(diamondCards, clubCards, heartCards, spadeCards));
    }
}
