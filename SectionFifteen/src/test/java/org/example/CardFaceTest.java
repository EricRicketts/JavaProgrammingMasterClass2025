package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardFaceTest {

    @Test
    public void testCardFaceTwo() {
        assertEquals('\u0032', CardFace.TWO.convertToImage());
    }

    @Test
    public void testCardFaceThree() {
        assertEquals('\u0033', CardFace.THREE.convertToImage());
    }

    @Test
    public void testCardFaceFour() {
        assertEquals('\u0034', CardFace.FOUR.convertToImage());
    }

    @Test
    public void testCardFaceFive() {
        assertEquals('\u0035', CardFace.FIVE.convertToImage());
    }

    @Test
    public void testCardFaceSix() {
        assertEquals('\u0036', CardFace.SIX.convertToImage());
    }

    @Test
    public void testCardFaceSeven() {
        assertEquals('\u0037', CardFace.SEVEN.convertToImage());
    }

    @Test
    public void testCardFaceEight() {
        assertEquals('\u0038', CardFace.EIGHT.convertToImage());
    }

    @Test
    public void testCardFaceNine() {
        assertEquals('\u0039', CardFace.NINE.convertToImage());
    }

    @Test
    public void testCardFaceTen() {
        assertEquals('\u0031' + '\u0030', CardFace.TEN.convertToImage());
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
