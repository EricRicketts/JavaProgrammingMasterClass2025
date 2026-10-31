package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.example.CardFace.*;
import static org.example.CardSuit.*;
import static org.example.CardAndDeckConstants.*;

public class CardTest {


    private Card card, expectedCard;
    private String expectedCardString;

    @Nested
    @DisplayName("test the diamonds suite")
    class TestDiamondsSuite {

        @Test
        public void testEntireDiamondSuit() {
            for (int index = 0; index < CARD_FACE_VALUES.length; index += 1) {
                card = new Card(CARD_FACE_VALUES[index].toString(), DIAMONDS);
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
            for (int index = 0; index < CARD_FACE_VALUES.length; index += 1) {
                card = new Card(CARD_FACE_VALUES[index].toString(), CLUBS);
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
            for (int index = 0; index < CARD_FACE_VALUES.length; index += 1) {
                card = new Card(CARD_FACE_VALUES[index].toString(), HEARTS);
                expectedCard = HEART_CARDS.get(index);

                assertEquals(expectedCard, card);
            }
        }
    }

    @Nested
    @DisplayName("test the spades suite")
    class TestSpadesSuit {

        @Test
        public void testEntireSpadesSuit() {
            for (int index = 0; index < CARD_FACE_VALUES.length; index += 1) {
                card = new Card(CARD_FACE_VALUES[index].toString(), SPADES);
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
                String cardFace = CARD_FACE_VALUES[index].toString();
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
                String cardFace = CARD_FACE_VALUES[index].toString();
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
                String cardFace = CARD_FACE_VALUES[index].toString();
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
                String cardFace = CARD_FACE_VALUES[index].toString();
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
