package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTest {

    private Card two, ten, jack, ace;

    @BeforeEach
    public void setUp() {
        two = new Card(CardFace.TWO, CardSuit.DIAMONDS);
        ten = new Card(CardFace.TEN, CardSuit.HEARTS);
        jack = new Card(CardFace.JACK, CardSuit.CLUBS);
        ace = new Card(CardFace.ACE, CardSuit.SPADES);
    }

    @Nested
    @DisplayName("test the two of diamonds")
    class TestTwoOfDiamonds {

        @Test
        public void testTwoOfDiamondsFaceValue() {
            assertEquals(CardFace.TWO, two.getCardFace());
        }

        @Test
        public void testTwoOfDiamondsSuit() {
            assertEquals(CardSuit.DIAMONDS, two.getCardSuit());
        }

        @Test
        public void testTwoOfDiamondsRank() {
            assertEquals(0, two.getCardRank());
        }
    }
}
