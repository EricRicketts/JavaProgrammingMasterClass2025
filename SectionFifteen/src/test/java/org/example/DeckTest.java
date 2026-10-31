package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.example.CardAndDeckConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeckTest {

    List<Card> deck;
    String expected;

    @BeforeEach
    public void setUp() {
        deck = Deck.getStandardDeck();
    }

    @Nested
    @DisplayName("print individual suit of cards")
    class TestPrintIndividualSuitOfCards {

        @Test
        public void testPrintOutDiamondsSuit() {
            assertEquals(ALL_DIAMONDS, Deck.printOneRow(deck, 1));
        }

        @Test
        public void testPrintOutClubsSuit() {
            assertEquals(ALL_CLUBS, Deck.printOneRow(deck, 2));
        }

        @Test
        public void testPrintOutHeartsSuit() {
            assertEquals(ALL_HEARTS, Deck.printOneRow(deck, 3));
        }

        @Test
        public void testPrintOutSpadesSuit() {
            assertEquals(ALL_SPADES, Deck.printOneRow(deck, 4));
        }
    }

    @Nested
    @DisplayName("TestStandardDeckOfCards")
    class TestStandardDeckOfCards {

        @Test
        public void testStandardDeckOfCards() {
            // STANDARD_DECK is immutable, deck is not, but we are running the test to compare the decks
            // of what would be the beginning of a card game.
            assertEquals(STANDARD_DECK, deck);
        }

        @Test
        public void testPrintOutDiamonds() {
            assertEquals(ALL_DIAMONDS, Deck.printDeck(deck, "Just Diamonds", 1));
        }

        @Test
        public void testPrintOutDiamondsAndClubs() {
            expected = ALL_DIAMONDS.concat(ALL_CLUBS);
            assertEquals(expected, Deck.printDeck(deck, "Diamonds and Clubs", 2));
        }

        @Test
        public void testPrintOutDiamondsClubsAndHearts() {
            expected = ALL_DIAMONDS.concat(ALL_CLUBS).concat(ALL_HEARTS);
            assertEquals(expected,
                Deck.printDeck(deck, "Diamonds, Clubs and Hearts", 3)
            );
        }

        @Test
        public void testPrintOutEntireDeck() {
            expected = ALL_DIAMONDS.concat(ALL_CLUBS).concat(ALL_HEARTS).concat(ALL_SPADES);
            assertEquals(expected, Deck.printDeck(deck, "Entire Deck", 4));
        }
    }
}
