package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardSuitTest {

    private final static int DIAMONDS_SYMBOL = '♦';
    private final static int CLUBS_SYMBOL = '♣';
    private final static int HEARTS_SYMBOL = '♥';
    private final static int SPADES_SYMBOL = '♠';

    @Nested
    @DisplayName("test symbol code for each suit")
    class TestSymbolCodeForEachSuit {

        @Test
        public void testSymbolCodeForDiamonds() {
            assertEquals(9830, CardSuit.DIAMONDS.getSymbolCode());
        }

        @Test
        public void testSymbolCodeForClubs() {
            assertEquals(9827, CardSuit.CLUBS.getSymbolCode());
        }

        @Test
        public void testSymbolCodeForHearts() {
            assertEquals(9829, CardSuit.HEARTS.getSymbolCode());
        }

        @Test
        public void testSymbolCodeForSpades() {
            assertEquals(9824, CardSuit.SPADES.getSymbolCode());
        }
    }

    @Nested
    @DisplayName("test suit toString")
    class TestSuitToString {

        @Test
        public void testDiamondsSuit() {
            assertEquals("♦", CardSuit.DIAMONDS.toString());
        }

        @Test
        public void testClubsSuit() {
            assertEquals("♣", CardSuit.CLUBS.toString());
        }

        @Test
        public void testHeartsSuit() {
            assertEquals("♥", CardSuit.HEARTS.toString());
        }

        @Test
        public void testSpadesSuit() {
            assertEquals("♠", CardSuit.SPADES.toString());
        }
    }
}
