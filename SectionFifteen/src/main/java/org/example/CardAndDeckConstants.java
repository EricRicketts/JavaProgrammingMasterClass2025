package org.example;

import java.util.List;
import java.util.Map;

import static java.util.Map.entry;
import static org.example.CardFace.*;
import static org.example.CardFace.ACE;
import static org.example.CardSuit.*;
import static org.example.CardSuit.SPADES;

public final class CardAndDeckConstants {

    private CardAndDeckConstants() {
        throw new AssertionError();
    }

    public static final List<String> VALID_CARD_FACES =
        List.of("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");

    public static final List<CardSuit> VALID_CARD_SUITS =
        List.of(CardSuit.DIAMONDS, CardSuit.CLUBS, CardSuit.HEARTS, CardSuit.SPADES);
    public static final Map<String, Integer> MAP_OF_CARD_FACE_TO_RANK = Map.ofEntries(
        entry("2", 0), // 2, ASCII 50
        entry("3", 1), // 3, ASCII 51
        entry("4", 2), // 4, ASCII 52
        entry("5", 3), // 5, ASCII 53
        entry("6", 4), // 6, ASCII 54
        entry("7", 5), // 7, ASCII 55
        entry("8", 6), // 8, ASCII 56
        entry("9", 7), // 9, ASCII 57
        entry("10", 8), // 10, ASCII 48
        entry("J", 9), // Jack, ASCII 74
        entry("Q", 10), // Queen, ASCII 81
        entry("K", 11), // King, ASCII 75
        entry("A", 12) // Ace, ASCII 65
    );

    public final static List<Card> DIAMOND_CARDS = List.of(
        new Card(TWO.toString(), DIAMONDS), new Card(THREE.toString(), DIAMONDS), new Card(FOUR.toString(), DIAMONDS),
        new Card(FIVE.toString(), DIAMONDS), new Card(SIX.toString(), DIAMONDS), new Card(SEVEN.toString(), DIAMONDS),
        new Card(EIGHT.toString(), DIAMONDS), new Card(NINE.toString(), DIAMONDS), new Card(TEN.toString(), DIAMONDS),
        new Card(JACK.toString(), DIAMONDS), new Card(QUEEN.toString(), DIAMONDS), new Card(KING.toString(), DIAMONDS),
        new Card(ACE.toString(), DIAMONDS)
    );
    public final static List<Card> CLUB_CARDS = List.of(
        new Card(TWO.toString(), CLUBS), new Card(THREE.toString(), CLUBS), new Card(FOUR.toString(), CLUBS),
        new Card(FIVE.toString(), CLUBS), new Card(SIX.toString(), CLUBS), new Card(SEVEN.toString(), CLUBS),
        new Card(EIGHT.toString(), CLUBS), new Card(NINE.toString(), CLUBS), new Card(TEN.toString(), CLUBS),
        new Card(JACK.toString(), CLUBS), new Card(QUEEN.toString(), CLUBS), new Card(KING.toString(), CLUBS),
        new Card(ACE.toString(), CLUBS)
    );
    public final static List<Card> HEART_CARDS = List.of(
        new Card(TWO.toString(), HEARTS), new Card(THREE.toString(), HEARTS), new Card(FOUR.toString(), HEARTS),
        new Card(FIVE.toString(), HEARTS), new Card(SIX.toString(), HEARTS), new Card(SEVEN.toString(), HEARTS),
        new Card(EIGHT.toString(), HEARTS), new Card(NINE.toString(), HEARTS), new Card(TEN.toString(), HEARTS),
        new Card(JACK.toString(), HEARTS), new Card(QUEEN.toString(), HEARTS), new Card(KING.toString(), HEARTS),
        new Card(ACE.toString(), HEARTS)
    );
    public final static List<Card> SPADE_CARDS = List.of(
        new Card(TWO.toString(), SPADES), new Card(THREE.toString(), SPADES), new Card(FOUR.toString(), SPADES),
        new Card(FIVE.toString(), SPADES), new Card(SIX.toString(), SPADES), new Card(SEVEN.toString(), SPADES),
        new Card(EIGHT.toString(), SPADES), new Card(NINE.toString(), SPADES), new Card(TEN.toString(), SPADES),
        new Card(JACK.toString(), SPADES), new Card(QUEEN.toString(), SPADES), new Card(KING.toString(), SPADES),
        new Card(ACE.toString(), SPADES)
    );

    public final static CardFace[] cardFaceValues = {
        CardFace.TWO, CardFace.THREE, CardFace.FOUR, CardFace.FIVE,
        CardFace.SIX, CardFace.SEVEN, CardFace.EIGHT, CardFace.NINE,
        CardFace.TEN, CardFace.JACK, CardFace.QUEEN, CardFace.KING,
        CardFace.ACE
    };

    public final static String DIAMONDS_SYMBOL = "♦";
    public final static String CLUBS_SYMBOL = "♣";
    public final static String HEARTS_SYMBOL = "♥";
    public final static String SPADES_SYMBOL = "♠";
    public final static String ALL_DIAMONDS = """
        2♦(0) 3♦(1) 4♦(2) 5♦(3) 6♦(4) 7♦(5) 8♦(6) 9♦(7) 10♦(8) J♦(9) Q♦(10) K♦(11) A♦(12)
        """;
    public final static String ALL_CLUBS = """
       2♣(0) 3♣(1) 4♣(2) 5♣(3) 6♣(4) 7♣(5) 8♣(6) 9♣(7) 10♣(8) J♣(9) Q♣(10) K♣(11) A♣(12)
       """;
    public final static String ALL_HEARTS = """
        2♥(0) 3♥(1) 4♥(2) 5♥(3) 6♥(4) 7♥(5) 8♥(6) 9♥(7) 10♥(8) J♥(9) Q♥(10) K♥(11) A♥(12)
        """;
    public final static String ALL_SPADES = """
        2♠(0) 3♠(1) 4♠(2) 5♠(3) 6♠(4) 7♠(5) 8♠(6) 9♠(7) 10♠(8) J♠(9) Q♠(10) K♠(11) A♠(12)
        """;
}
