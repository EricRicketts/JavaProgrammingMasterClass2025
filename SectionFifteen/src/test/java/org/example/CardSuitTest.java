package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardSuitTest {

    private CardSuit cardSuit;


    @Test
    public void testDiamondsSuit() {
        assertEquals('\u2666', cardSuit.DIAMONDS.convertToImage());
    }

    @Test
    public void testClubsSuit() {
        assertEquals('\u2663', cardSuit.CLUBS.convertToImage());
    }

    @Test
    public void testHeartsSuit() {
        assertEquals('\u2665', cardSuit.HEARTS.convertToImage());
    }

    @Test
    public void testSpadesSuit() {
        assertEquals('\u2660', cardSuit.SPADES.convertToImage());
    }
}
