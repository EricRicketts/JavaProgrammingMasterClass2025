package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.example.CardFace.TWO;
import static org.example.CardFace.THREE;
import static org.example.CardFace.FOUR;
import static org.example.CardFace.FIVE;
import static org.example.CardFace.SIX;
import static org.example.CardFace.SEVEN;
import static org.example.CardFace.EIGHT;
import static org.example.CardFace.NINE;
import static org.example.CardFace.TEN;
import static org.example.CardFace.JACK;
import static org.example.CardFace.QUEEN;
import static org.example.CardFace.KING;
import static org.example.CardFace.ACE;

import java.util.List;

import static org.example.CardSuit.DIAMONDS;
import static org.example.CardSuit.CLUBS;
import static org.example.CardSuit.HEARTS;
import static org.example.CardSuit.SPADES;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    private CardSuit expectedCardSuit;
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

        @BeforeEach
        public void setUp() {
            expectedCardSuit = DIAMONDS;
        }

        @Test
        public void testEntireDiamondSuit() {
            for (int expectedRank = 0; expectedRank < cardFaceValues.length; expectedRank += 1) {
                String expectedCardFace = cardFaceValues[expectedRank].toString();
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
                String expectedCardFace = cardFaceValues[expectedRank].toString();
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
                String expectedCardFace = cardFaceValues[expectedRank].toString();
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
                String expectedCardFace = cardFaceValues[expectedRank].toString();
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
        public void testClubsToString() {
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
        public void testHeartsToString() {
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
        public void testSpades() {
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

    @Nested
    @DisplayName("test getStandardDeck and printDeck methods")
    class TestGetStandardDeckAndPrintDeckMethods {
    }


}
