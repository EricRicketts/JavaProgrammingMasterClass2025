package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.example.CardSuit.*;
import static org.example.CardFace.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeckTest {

    private final static List<Card> DIAMOND_CARDS = List.of(
        new Card(TWO.toString(), DIAMONDS), new Card(THREE.toString(), DIAMONDS), new Card(FOUR.toString(), DIAMONDS),
        new Card(FIVE.toString(), DIAMONDS), new Card(SIX.toString(), DIAMONDS), new Card(SEVEN.toString(), DIAMONDS),
        new Card(EIGHT.toString(), DIAMONDS), new Card(NINE.toString(), DIAMONDS), new Card(TEN.toString(), DIAMONDS),
        new Card(JACK.toString(), DIAMONDS), new Card(QUEEN.toString(), DIAMONDS), new Card(KING.toString(), DIAMONDS),
        new Card(ACE.toString(), DIAMONDS)
    );
    private final static List<Card> CLUB_CARDS = List.of(
        new Card(TWO.toString(), CLUBS), new Card(THREE.toString(), CLUBS), new Card(FOUR.toString(), CLUBS),
        new Card(FIVE.toString(), CLUBS), new Card(SIX.toString(), CLUBS), new Card(SEVEN.toString(), CLUBS),
        new Card(EIGHT.toString(), CLUBS), new Card(NINE.toString(), CLUBS), new Card(TEN.toString(), CLUBS),
        new Card(JACK.toString(), CLUBS), new Card(QUEEN.toString(), CLUBS), new Card(KING.toString(), CLUBS),
        new Card(ACE.toString(), CLUBS)
    );
    private final static List<Card> HEART_CARDS = List.of(
        new Card(TWO.toString(), HEARTS), new Card(THREE.toString(), HEARTS), new Card(FOUR.toString(), HEARTS),
        new Card(FIVE.toString(), HEARTS), new Card(SIX.toString(), HEARTS), new Card(SEVEN.toString(), HEARTS),
        new Card(EIGHT.toString(), HEARTS), new Card(NINE.toString(), HEARTS), new Card(TEN.toString(), HEARTS),
        new Card(JACK.toString(), HEARTS), new Card(QUEEN.toString(), HEARTS), new Card(KING.toString(), HEARTS),
        new Card(ACE.toString(), HEARTS)
    );
    private final static List<Card> SPADE_CARDS = List.of(
        new Card(TWO.toString(), SPADES), new Card(THREE.toString(), SPADES), new Card(FOUR.toString(), SPADES),
        new Card(FIVE.toString(), SPADES), new Card(SIX.toString(), SPADES), new Card(SEVEN.toString(), SPADES),
        new Card(EIGHT.toString(), SPADES), new Card(NINE.toString(), SPADES), new Card(TEN.toString(), SPADES),
        new Card(JACK.toString(), SPADES), new Card(QUEEN.toString(), SPADES), new Card(KING.toString(), SPADES),
        new Card(ACE.toString(), SPADES)
    );

    private final static List<List<Card>> standardDeck = List.of(
        DIAMOND_CARDS, CLUB_CARDS, HEART_CARDS, SPADE_CARDS
    );
    List<List<Card>> deck;

    @BeforeEach
    public void setUp() {
        deck = Deck.getStandardDeck();
    }

    @Nested
    @DisplayName("TestStandardDeckOfCards")
    class TestStandardDeckOfCards {

        @Test
        public void testStandardDeckOfCards() {
            assertEquals(standardDeck, deck);
        }

        @Test
        public void testPrintOutAllDiamonds() {
        }
    }

}
