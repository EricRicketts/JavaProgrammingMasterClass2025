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
            assertEquals('2', CardFace.TWO.convertToImage());
        }

        @Test
        public void testCardFaceThree() {
            assertEquals('3', CardFace.THREE.convertToImage());
        }

        @Test
        public void testCardFaceFour() {
            assertEquals('4', CardFace.FOUR.convertToImage());
        }

        @Test
        public void testCardFaceFive() {
            assertEquals('5', CardFace.FIVE.convertToImage());
        }

        @Test
        public void testCardFaceSix() {
            assertEquals('6', CardFace.SIX.convertToImage());
        }

        @Test
        public void testCardFaceSeven() {
            assertEquals('7', CardFace.SEVEN.convertToImage());
        }

        @Test
        public void testCardFaceEight() {
            assertEquals('8', CardFace.EIGHT.convertToImage());
        }

        @Test
        public void testCardFaceNine() {
            assertEquals('9', CardFace.NINE.convertToImage());
        }

        @Test
        public void testCardFaceTen() {
            assertEquals('1' + '0', CardFace.TEN.convertToImage());
        }

        @Test
        public void testCardFaceJack() {
            assertEquals('\u004A', CardFace.JACK.convertToImage());
        }

        @Test
        public void testCardFaceQueen() {
            assertEquals('\u0051', CardFace.QUEEN.convertToImage());
        }

        @Test
        public void testCardFaceKing() {
            assertEquals('\u004B', CardFace.KING.convertToImage());
        }

        @Test
        public void testCardFaceAce() {
            assertEquals('\u0041', CardFace.ACE.convertToImage());
        }
    }
}
