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
    @DisplayName("test suit images")
    class TestSuitImages {

        @Test
        public void testDiamondsSuit() {
            assertEquals(DIAMONDS_SYMBOL, CardSuit.DIAMONDS.convertToImage());
        }

        @Test
        public void testClubsSuit() {
            assertEquals(CLUBS_SYMBOL, CardSuit.CLUBS.convertToImage());
        }

        @Test
        public void testHeartsSuit() {
            assertEquals(HEARTS_SYMBOL, CardSuit.HEARTS.convertToImage());
        }

        @Test
        public void testSpadesSuit() {
            assertEquals(SPADES_SYMBOL, CardSuit.SPADES.convertToImage());
        }
    }
}
