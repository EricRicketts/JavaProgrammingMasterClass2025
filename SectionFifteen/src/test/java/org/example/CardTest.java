package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTest {

    private Card firstCard, secondCard, thirdCard, fourthCard;

    @BeforeEach
    public void setUp() {
        firstCard = new Card(CardFace.TWO, CardSuit.DIAMONDS);
        secondCard = new Card(CardFace.JACK, CardSuit.CLUBS);
        thirdCard = new Card(CardFace.TEN, CardSuit.HEARTS);
        fourthCard = new Card(CardFace.ACE, CardSuit.SPADES);
    }

    @Nested
    @DisplayName("test the two of diamonds")
    class TestTheFirstCard {

        @Test
        public void testFaceValue() {
            assertEquals(CardFace.TWO, firstCard.getCardFace());
        }
    }
}
