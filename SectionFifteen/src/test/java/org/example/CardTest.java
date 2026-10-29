package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import static org.example.CardFace.*;
import static org.example.CardSuit.*;

public class CardTest {

    private final static String DIAMONDS_SYMBOL = "♦";
    private final static String CLUBS_SYMBOL = "♣";
    private final static String HEARTS_SYMBOL = "♥";
    private final static String SPADES_SYMBOL = "♠";
    private final static String ALL_DIAMONDS = """
        2♦(0) 3♦(1) 4♦(2) 5♦(3) 6♦(4) 7♦(5) 8♦(6) 9♦(7) 10♦(8) J♦(9) Q♦(10) K♦(11) A♦(12)
        """;
    private final static String ALL_CLUBS = """
       2♣(0) 3♣(1) 4♣(2) 5♣(3) 6♣(4) 7♣(5) 8♣(6) 9♣(7) 10♣(8) J♣(9) Q♣(10) K♣(11) A♣(12)
       """;
    private final static String ALL_HEARTS = """
        2♥(0) 3♥(1) 4♥(2) 5♥(3) 6♥(4) 7♥(5) 8♥(6) 9♥(7) 10♥(8) J♥(9) Q♥(10) K♥(11) A♥(12)
        """;
    private final static String ALL_SPADES = """
        2♠(0) 3♠(1) 4♠(2) 5♠(3) 6♠(4) 7♠(5) 8♠(6) 9♠(7) 10♠(8) J♠(9) Q♠(10) K♠(11) A♠(12)
        """;
    private Card card, expectedCard;
    private String expectedCardString;
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

    CardFace[] cardFaceValues = {
        CardFace.TWO, CardFace.THREE, CardFace.FOUR, CardFace.FIVE,
        CardFace.SIX, CardFace.SEVEN, CardFace.EIGHT, CardFace.NINE,
        CardFace.TEN, CardFace.JACK, CardFace.QUEEN, CardFace.KING,
        CardFace.ACE
    };

    @Nested
    @DisplayName("test the diamonds suite")
    class TestDiamondsSuite {

        @Test
        public void testEntireDiamondSuit() {
            for (int index = 0; index < cardFaceValues.length; index += 1) {
                card = new Card(cardFaceValues[index].toString(), DIAMONDS);
                expectedCard = DIAMOND_CARDS.get(index);

                assertEquals(expectedCard, card);
            }
        }
    }

    @Nested
    @DisplayName("test the clubs suite")
    class TestClubsSuit {

        @Test
        public void testEntireClubsSuit() {
            for (int index = 0; index < cardFaceValues.length; index += 1) {
                card = new Card(cardFaceValues[index].toString(), CLUBS);
                expectedCard = CLUB_CARDS.get(index);

                assertEquals(expectedCard, card);
            }
        }
    }

    @Nested
    @DisplayName("test the hearts suite")
    class TestHeartsSuit {

        @Test
        public void testEntireHeartsSuit() {
            for (int index = 0; index < cardFaceValues.length; index += 1) {
                card = new Card(cardFaceValues[index].toString(), CLUBS);
                expectedCard = CLUB_CARDS.get(index);

                assertEquals(expectedCard, card);
            }
        }
    }

    @Nested
    @DisplayName("test the spades suite")
    class TestSpadesSuit {

        @Test
        public void testEntireSpadesSuit() {
            for (int index = 0; index < cardFaceValues.length; index += 1) {
                card = new Card(cardFaceValues[index].toString(), SPADES);
                expectedCard = SPADE_CARDS.get(index);

                assertEquals(expectedCard, card);
            }
        }
    }

    @Nested
    @DisplayName("test card to string")
    class TestCardToString {

       @Test
        public void testDiamondCardToString() {
            expectedCardString = "5".concat(DIAMONDS_SYMBOL).concat("(3)");
            assertEquals(expectedCardString, new Card(FIVE.toString(), DIAMONDS).toString());
       }

        @Test
        public void testClubCardToString() {
            expectedCardString = "J".concat(CLUBS_SYMBOL).concat("(9)");
            assertEquals(expectedCardString, new Card(JACK.toString(), CLUBS).toString());
        }

        @Test
        public void testHeartCardToString() {
            expectedCardString = "10".concat(HEARTS_SYMBOL).concat("(8)");
            assertEquals(expectedCardString, new Card(TEN.toString(), HEARTS).toString());
        }

        @Test
        public void testSpadeCardToString() {
            expectedCardString = "K".concat(SPADES_SYMBOL).concat("(11)");
            assertEquals(expectedCardString, new Card(KING.toString(), SPADES).toString());
        }
    }

    @Nested
    @DisplayName("test suit to string")
    class TestSuitToString {

        @Test
        public void testAllDiamondsToString() {
            String diamondCards = "";
            for (int index = 0; index < CardFace.values().length; index+=1) {
                String cardFace = cardFaceValues[index].toString();
                card = new Card(cardFace, DIAMONDS);
                diamondCards = diamondCards.concat(card + " ");
            }
            diamondCards = diamondCards.trim() + "\n";
            assertEquals(ALL_DIAMONDS, diamondCards);
        }

        @Test
        public void testAllClubsToString() {
            String clubCards = "";
            for (int index = 0; index < CardFace.values().length; index+=1) {
                String cardFace = cardFaceValues[index].toString();
                card = new Card(cardFace, CardSuit.CLUBS);
                clubCards = clubCards.concat(card + " ");
            }
            clubCards = clubCards.trim() + "\n";
            assertEquals(ALL_CLUBS, clubCards);
        }

        @Test
        public void testAllHeartsToString() {
            String heartCards = "";
            for (int index = 0; index < CardFace.values().length; index+=1) {
                String cardFace = cardFaceValues[index].toString();
                card = new Card(cardFace, CardSuit.HEARTS);
                heartCards = heartCards.concat(card + " ");
            }
            heartCards = heartCards.trim() + "\n";
            assertEquals(ALL_HEARTS, heartCards);
        }

        @Test
        public void testAllSpadesToString() {
            String spadeCards = "";
            for (int index = 0; index < CardFace.values().length; index+=1) {
                String cardFace = cardFaceValues[index].toString();
                card = new Card(cardFace, CardSuit.SPADES);
                spadeCards = spadeCards.concat(card + " ");
            }
            spadeCards = spadeCards.trim() + "\n";
            assertEquals(ALL_SPADES, spadeCards);
        }
    }

    @Nested
    @DisplayName("test getNumericCard method")
    class TestGetNumericCardMethod {

        @Test
        public void testGetDiamondsCard() {
            expectedCard = new Card(CardFace.FOUR.toString(), DIAMONDS);
            card = Card.getNumericCard(DIAMONDS, 2);

            assertEquals(expectedCard, card);
        }

        @Test
        public void testGetClubsCard() {
            expectedCard = new Card(CardFace.JACK.toString(), CardSuit.CLUBS);
            card = Card.getNumericCard(CardSuit.CLUBS, 9);

            assertEquals(expectedCard, card);
        }

        @Test
        public void testGetHeartsCard() {
            expectedCard = new Card(CardFace.TEN.toString(), CardSuit.HEARTS);
            card = Card.getNumericCard(CardSuit.HEARTS, 8);

            assertEquals(expectedCard, card);
        }

        @Test
        public void testGetSpadesCard() {
            expectedCard = new Card(CardFace.ACE.toString(), CardSuit.SPADES);
            card = Card.getNumericCard(CardSuit.SPADES, 12);

            assertEquals(expectedCard, card);
        }
    }

    @Nested
    @DisplayName("test getFaceCard method")
    class TestGetFaceCardMethod {

        @Test
        public void testGetDiamondsCard() {
            expectedCard = new Card(CardFace.THREE.toString(), DIAMONDS);
            card = Card.getFaceCard(DIAMONDS, "3");

            assertEquals(expectedCard, card);
        }

        @Test
        public void testGetClubsCard() {
            expectedCard = new Card(CardFace.QUEEN.toString(), CardSuit.CLUBS);
            card = Card.getFaceCard(CardSuit.CLUBS, "Q");

            assertEquals(expectedCard, card);
        }

        @Test
        public void testGetHeartsCard() {
            expectedCard = new Card(CardFace.TWO.toString(), CardSuit.HEARTS);
            card = Card.getFaceCard(CardSuit.HEARTS, "2");

            assertEquals(expectedCard, card);
        }

        @Test
        public void testGetSpadesCard() {
            expectedCard = new Card(CardFace.KING.toString(), CardSuit.SPADES);
            card = Card.getFaceCard(CardSuit.SPADES, "K");

            assertEquals(expectedCard, card);
        }
    }
}
