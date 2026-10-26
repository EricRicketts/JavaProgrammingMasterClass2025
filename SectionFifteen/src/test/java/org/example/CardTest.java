package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTest {

    private Card card;
    private CardSuit expectedCardSuit;

    CardFace[] cardFaceValues = {
        CardFace.TWO, CardFace.THREE, CardFace.FOUR, CardFace.FIVE,
        CardFace.SIX, CardFace.SEVEN, CardFace.EIGHT, CardFace.NINE,
        CardFace.TEN, CardFace.JACK, CardFace.QUEEN, CardFace.KING,
        CardFace.ACE
    };

    @Nested
    @DisplayName("test the diamonds suite")
    class TestDiamondsSuite {

        @BeforeEach
        public void setUp() {
            expectedCardSuit = CardSuit.DIAMONDS;
        }

        @Test
        public void testEntireDiamondSuit() {
            for (int expectedRank = 0; expectedRank < cardFaceValues.length; expectedRank += 1) {
                CardFace expectedCardFace = cardFaceValues[expectedRank];
                card = new Card(expectedCardFace, expectedCardSuit);

                assertEquals(expectedCardFace, card.getCardFace());
                assertEquals(expectedCardSuit, card.getCardSuit());
                assertEquals(expectedRank, card.getCardRank());
            }
        }
    }

    @Nested
    @DisplayName("test the clubs suite")
    class TestClubsSuit {

        @BeforeEach
        public void setUp() {
            expectedCardSuit = CardSuit.CLUBS;
        }

        @Test
        public void testEntireClubsSuit() {
            for (int expectedRank = 0; expectedRank < cardFaceValues.length; expectedRank += 1) {
                CardFace expectedCardFace = cardFaceValues[expectedRank];
                card = new Card(expectedCardFace, expectedCardSuit);

                assertEquals(expectedCardFace, card.getCardFace());
                assertEquals(expectedCardSuit, card.getCardSuit());
                assertEquals(expectedRank, card.getCardRank());
            }
        }
    }

    @Nested
    @DisplayName("test the hearts suite")
    class TestHeartsSuit {

        @BeforeEach
        public void setUp() {
            expectedCardSuit = CardSuit.HEARTS;
        }

        @Test
        public void testEntireHeartsSuit() {
            for (int expectedRank = 0; expectedRank < cardFaceValues.length; expectedRank += 1) {
                CardFace expectedCardFace = cardFaceValues[expectedRank];
                card = new Card(expectedCardFace, expectedCardSuit);

                assertEquals(expectedCardFace, card.getCardFace());
                assertEquals(expectedCardSuit, card.getCardSuit());
                assertEquals(expectedRank, card.getCardRank());
            }
        }
    }

    @Nested
    @DisplayName("test the spades suite")
    class TestSpadesSuit {

        @BeforeEach
        public void setUp() {
            expectedCardSuit = CardSuit.SPADES;
        }

        @Test
        public void testEntireSpadesSuit() {
            for (int expectedRank = 0; expectedRank < cardFaceValues.length; expectedRank += 1) {
                CardFace expectedCardFace = cardFaceValues[expectedRank];
                card = new Card(expectedCardFace, expectedCardSuit);

                assertEquals(expectedCardFace, card.getCardFace());
                assertEquals(expectedCardSuit, card.getCardSuit());
                assertEquals(expectedRank, card.getCardRank());
            }
        }
    }
}
