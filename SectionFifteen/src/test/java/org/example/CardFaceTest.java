package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardFaceTest {

    @Nested
    @DisplayName("test get card face code")
    class TestGetCardFaceCode {

        @Test
        public void testCardFaceTwo() {
            assertEquals(50, CardFace.TWO.getSymbolCode());
        }

        @Test
        public void testCardFaceThree() {
            assertEquals(51, CardFace.THREE.getSymbolCode());
        }

        @Test
        public void testCardFaceFour() {
            assertEquals(52, CardFace.FOUR.getSymbolCode());
        }

        @Test
        public void testCardFaceFive() {
            assertEquals(53, CardFace.FIVE.getSymbolCode());
        }

        @Test
        public void testCardFaceSix() {
            assertEquals(54, CardFace.SIX.getSymbolCode());
        }

        @Test
        public void testCardFaceSeven() {
            assertEquals(55, CardFace.SEVEN.getSymbolCode());
        }

        @Test
        public void testCardFaceEight() {
            assertEquals(56, CardFace.EIGHT.getSymbolCode());
        }

        @Test
        public void testCardFaceNine() {
            assertEquals(57, CardFace.NINE.getSymbolCode());
        }

        @Test
        public void testCardFaceTen() {
            assertEquals(48, CardFace.TEN.getSymbolCode());
        }

        @Test
        public void testCardFaceJack() {
            assertEquals(74, CardFace.JACK.getSymbolCode());
        }

        @Test
        public void testCardFaceQueen() {
            assertEquals(81, CardFace.QUEEN.getSymbolCode());
        }

        @Test
        public void testCardFaceKing() {
            assertEquals(75, CardFace.KING.getSymbolCode());
        }

        @Test
        public void testCardFaceAce() {
            assertEquals(65, CardFace.ACE.getSymbolCode());
        }
    }

    @Nested
    @DisplayName("test get card face image")
    class TestGetCardFaceImage {

        @Test
        public void testCardFaceTwo() {
            assertEquals("2", CardFace.TWO.toString());
        }

        @Test
        public void testCardFaceThree() {
            assertEquals("3", CardFace.THREE.toString());
        }

        @Test
        public void testCardFaceFour() {
            assertEquals("4", CardFace.FOUR.toString());
        }

        @Test
        public void testCardFaceFive() {
            assertEquals("5", CardFace.FIVE.toString());
        }

        @Test
        public void testCardFaceSix() {
            assertEquals("6", CardFace.SIX.toString());
        }

        @Test
        public void testCardFaceSeven() {
            assertEquals("7", CardFace.SEVEN.toString());
        }

        @Test
        public void testCardFaceEight() {
            assertEquals("8", CardFace.EIGHT.toString());
        }

        @Test
        public void testCardFaceNine() {
            assertEquals("9", CardFace.NINE.toString());
        }

        @Test
        public void testCardFaceTen() {
            assertEquals("10", CardFace.TEN.toString());
        }

        @Test
        public void testCardFaceJack() {
            assertEquals("J", CardFace.JACK.toString());
        }

        @Test
        public void testCardFaceQueen() {
            assertEquals("Q", CardFace.QUEEN.toString());
        }

        @Test
        public void testCardFaceKing() {
            assertEquals("K", CardFace.KING.toString());
        }

        @Test
        public void testCardFaceAce() {
            assertEquals("A", CardFace.ACE.toString());
        }
    }
}
