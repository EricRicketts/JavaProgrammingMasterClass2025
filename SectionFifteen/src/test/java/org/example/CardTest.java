package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTest {

    private final static int DIAMONDS_SYMBOL = '♦';
    private final static int CLUBS_SYMBOL = '♣';
    private final static int HEARTS_SYMBOL = '♥';
    private final static int SPADES_SYMBOL = '♠';
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

    @Nested
    @DisplayName("test card to string")
    class TestCardToString {

        @Test
        public void testDiamondsToString() {
            String expected = """
                2♦(0) 3♦(1) 4♦(2) 5♦(3) 6♦(4) 7♦(5) 8♦(6) 9♦(7) 10♦(8) J♦(9) Q♦(10) K♦(11) A♦(12)
                """;
            String diamondCardFaces = "";
            for (int index = 0; index < CardFace.values().length; index+=1) {
                CardFace cardFace = cardFaceValues[index];
                card = new Card(cardFace, CardSuit.DIAMONDS);
                diamondCardFaces = diamondCardFaces.concat(card + " ");
            }
            diamondCardFaces = diamondCardFaces.trim() + "\n";
            assertEquals(expected, diamondCardFaces);
        }

        @Test
        public void testClubsToString() {
            String expected = """
                2♣(0) 3♣(1) 4♣(2) 5♣(3) 6♣(4) 7♣(5) 8♣(6) 9♣(7) 10♣(8) J♣(9) Q♣(10) K♣(11) A♣(12)
                """;
            String clubCardFaces = "";
            for (int index = 0; index < CardFace.values().length; index+=1) {
                CardFace cardFace = cardFaceValues[index];
                card = new Card(cardFace, CardSuit.CLUBS);
                clubCardFaces = clubCardFaces.concat(card + " ");
            }
            clubCardFaces = clubCardFaces.trim() + "\n";
            assertEquals(expected, clubCardFaces);
        }
        @Test
        public void testHeartsToString() {
            String expected = """
                2♥(0) 3♥(1) 4♥(2) 5♥(3) 6♥(4) 7♥(5) 8♥(6) 9♥(7) 10♥(8) J♥(9) Q♥(10) K♥(11) A♥(12)
                """;
            String heartClubFaces = "";
            for (int index = 0; index < CardFace.values().length; index+=1) {
                CardFace cardFace = cardFaceValues[index];
                card = new Card(cardFace, CardSuit.HEARTS);
                heartClubFaces = heartClubFaces.concat(card + " ");
            }
            heartClubFaces = heartClubFaces.trim() + "\n";
            assertEquals(expected, heartClubFaces);
        }
        @Test
        public void testSpades() {
            String expected = """
                2♠(0) 3♠(1) 4♠(2) 5♠(3) 6♠(4) 7♠(5) 8♠(6) 9♠(7) 10♠(8) J♠(9) Q♠(10) K♠(11) A♠(12)
                """;
            String spadeCardFaces = "";
            for (int index = 0; index < CardFace.values().length; index+=1) {
                CardFace cardFace = cardFaceValues[index];
                card = new Card(cardFace, CardSuit.SPADES);
                spadeCardFaces = spadeCardFaces.concat(card + " ");
            }
            spadeCardFaces = spadeCardFaces.trim() + "\n";
            assertEquals(expected, spadeCardFaces);
        }

    }
}
