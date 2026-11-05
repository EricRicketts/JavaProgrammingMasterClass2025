package org.example;

import org.example.CardAndDeckConstants.*;
import org.example.CardSuit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class IntroductionToCollectionsTest {

    List<String> listOfNames = new ArrayList<>();
    List<String> expected = new ArrayList<>();
    List<Card> cards = new ArrayList<>(52);
    Card aceOfHearts, kingOfClubs;

    @BeforeEach
    public void setUp() {
        aceOfHearts = Card.getFaceCard(CardSuit.HEARTS, "A");
        kingOfClubs = Card.getFaceCard(CardSuit.CLUBS, "K");
        String[] names = {"Anna", "Bob", "Carol", "David", "Edna"};
        listOfNames.addAll(Arrays.asList(names));
        expected.addAll(Arrays.asList(names));
    }

    @Nested
    @DisplayName("test add elements to a list")
    class TestAddElementsToAList {

        @Test
        public void testAddASingleElementToAList() {
            assertEquals(5, listOfNames.size());
            assertEquals(expected, listOfNames);
            listOfNames.add("Fred");

            assertEquals(6, listOfNames.size());
            assertEquals("Fred", listOfNames.getLast());
        }

        @Test
        public void testAddMultipleElementsToAList() {
            assertEquals(5, listOfNames.size());
            listOfNames.addAll(Arrays.asList("George", "Gary", "Grace"));

            assertEquals(8, listOfNames.size());
            expected.clear();
            expected.addAll(Arrays.asList("George", "Gary", "Grace"));

            List<String> subList = listOfNames.subList(5, listOfNames.size());
            assertEquals(expected, subList);
        }

        @Test
        public void testAddAListToAList() {
            List<String> otherNames = new ArrayList<>(List.of("George", "Gary", "Grace"));
            assertEquals(5, listOfNames.size());

            listOfNames.addAll(otherNames);
            assertEquals(8, listOfNames.size());
            assertEquals(otherNames, listOfNames.subList(5, listOfNames.size()));
        }
    }

    @Nested
    @DisplayName("test does a list contain an element")
    class TestListContainsElement {

        @Test
        public void testListContainsSingleElement() {
            assertTrue(listOfNames.contains("Carol"));
        }

        @Test
        public void testListContainsMoreThanOneElement() {
            assertTrue(listOfNames.containsAll(List.of("Anna", "Carol", "Edna")));
        }
    }

    @Nested
    @DisplayName("test list removal")
    class TestListRemoval {

        @Test
        public void testRemoveSingleElementFromList() {
            expected = new ArrayList<>(List.of("Anna", "Bob", "David", "Edna"));
            listOfNames.remove("Carol");

            assertEquals(4, listOfNames.size());
            assertEquals(expected, listOfNames);
        }

        @Test
        public void testRemoveMultipleElementsFromList() {
            expected = new ArrayList<>(List.of("Carol"));
            listOfNames.removeAll(List.of("Anna", "Bob", "David", "Edna"));

            assertEquals(expected, listOfNames);
        }

        @Test
        public void testConditionalRemovalFromList() {
            assertEquals(5, listOfNames.size());

            listOfNames.addAll(List.of("George", "Gary", "Grace"));
            assertEquals(8, listOfNames.size());
            assertEquals(
                new ArrayList<>(List.of("George", "Gary", "Grace")),
                listOfNames.subList(5, listOfNames.size()));

            listOfNames.removeIf(s -> s.charAt(0) == 'G');

            assertEquals(5, listOfNames.size());

            for (String name : listOfNames) {
                assertFalse(name.startsWith("G"));
            }
        }
    }

    @Nested
    @DisplayName("test populating a list")
    class TestPopulatingAList {

        @Test
        public void testPopulateAnArrayWithTheSameElement() {
            Card[] cardArray = new Card[13];

            assertEquals(12, aceOfHearts.getCardRank());
            Arrays.fill(cardArray, aceOfHearts);
            for (Card card : cardArray) {
                assertEquals(aceOfHearts, card);
            }
        }

        @Test
        public void testPopulateAListWithNCopies() {
//          Collections.fill(cards, aceOfHearts);
//          This does not work because Collections.fill only fills the ArrayList with elements
//          that overwrite the existing elements in the list.  The capacity of the cards list
//          is 52, but this does not represent what is actually in the list.

            cards = Collections.nCopies(13, aceOfHearts);
            assertEquals(13, cards.size());
            for (Card card : cards) {
                assertEquals(aceOfHearts, card);
            }
        }

        @Test
        public void testPopulateListWithAddAll() {
            Card[] cardArray = new Card[13];
            Arrays.fill(cardArray, aceOfHearts);

            Collections.addAll(cards, cardArray);
            assertEquals(13, cards.size());
            for (Card card : cards) {
                assertEquals(aceOfHearts, card);
            }
        }

        @Test
        public void testPopulateAListWithCopy() {
            // This wrapper is necessary as Collections.copy will not accept an
            // array as a source argument.  Also, this method only works if the
            // number of elements in the destination is greater or equal to
            // the source list.
            cards = new ArrayList<>(Collections.nCopies(52, kingOfClubs));
            assertEquals(52, cards.size());

            List<Card> thirteenAcesOfHearts = Collections.nCopies(13, aceOfHearts);
            Collections.copy(cards, thirteenAcesOfHearts);

            assertEquals(52, cards.size());
            assertEquals(aceOfHearts, cards.getFirst());
            assertEquals(aceOfHearts, cards.get(12));
            assertEquals(kingOfClubs, cards.get(13));
            assertEquals(kingOfClubs, cards.getLast());

            cards = new ArrayList<>(Collections.nCopies(13, kingOfClubs));
            Collections.copy(cards, thirteenAcesOfHearts);

            assertEquals(13, cards.size());
        }

        @Test
        public void testPopulateAListWithListCopy() {
            cards = List.copyOf(Collections.nCopies(13, aceOfHearts));
            assertEquals(13, cards.size());  // List is immutable.
        }
    }

    @Nested
    @DisplayName("test more methods of the Collections class")
    class TestMoreMethodsCollectionsClass {

        @BeforeEach
        public void setUp() {
            cards = Deck.getStandardDeck();
        }
        @Test
        public void testShuffleMethod() {
            assertEquals(Deck.getStandardDeck(), cards);

            Collections.shuffle(cards);
            assertNotEquals(Deck.getStandardDeck(), cards);
        }

        @Test
        public void testReverseMethod() {
            int index = 0;
            Collections.reverse(cards);
            List<CardSuit> reversedCardSuits = new ArrayList<>(CardAndDeckConstants.VALID_CARD_SUITS).reversed();
            List<String> reversedCardFaces = new ArrayList<>(CardAndDeckConstants.VALID_CARD_FACES).reversed();

            for (CardSuit cardSuit : reversedCardSuits) {
                for (String cardFace : reversedCardFaces) {
                    Card expectedCard = new Card(cardFace, cardSuit);
                    assertEquals(expectedCard, cards.get(index));
                    index += 1;
                }
            }
        }

        @Test
        public void testSortMethod() {
            Card card;
            List<Card> cards = new ArrayList<>();
            List<CardSuit> reversedCardSuits = new ArrayList<>(CardAndDeckConstants.VALID_CARD_SUITS).reversed();
            List<String> reversedCardFaces = new ArrayList<>(CardAndDeckConstants.VALID_CARD_FACES).reversed();

            for (CardSuit cardSuit : reversedCardSuits) {
                for (String cardFace : reversedCardFaces) {
                    card = new Card(cardFace, cardSuit);
                    cards.add(card);
                }
            }
            card = cards.getFirst();
            assertEquals(new Card("A", CardSuit.SPADES), card);
            card = cards.getLast();
            assertEquals(new Card("2", CardSuit.DIAMONDS), card);

            Comparator<Card> sortingAlgorithm = Comparator.comparing(Card::getCardRank)
                .thenComparing(Card::getCardSuit);

            Collections.sort(cards, sortingAlgorithm);

            assertEquals(new Card("2", CardSuit.DIAMONDS), cards.getFirst());
            assertEquals(new Card("A", CardSuit.SPADES), cards.getLast());
        }

        @Test
        public void testSubListMethod() {
            // Get a list of Kings and then a sublist from the list of kings.
            List<Card> deck = Deck.getStandardDeck();
            List<Card> kings = new ArrayList<>();

            int firstKingIndex = 11;
            for (int index = firstKingIndex; index < deck.size(); index += 13) {
                kings.add(deck.get(index));
            }
            List<Card> expectedKings = new ArrayList<>(
                List.of(
                new Card("K", CardSuit.DIAMONDS),
                new Card("K", CardSuit.CLUBS),
                new Card("K", CardSuit.HEARTS),
                new Card("K", CardSuit.SPADES)
                )
            );

            assertEquals(expectedKings, kings);

            expectedKings = new ArrayList<>(
                List.of(
                    new Card("K", CardSuit.DIAMONDS),
                    new Card("K", CardSuit.CLUBS)
                )
            );

            List<Card> subListOfKings = kings.subList(0, 2);
            assertEquals(expectedKings, subListOfKings);
        }

        @Test
        public void testIndexOfSublist() {
            List<Card> fourCards = new ArrayList<>(
                List.of(
                    new Card("K", CardSuit.HEARTS),
                    new Card("A", CardSuit.HEARTS),
                    new Card("2", CardSuit.SPADES),
                    new Card("3", CardSuit.SPADES)
                )
            );
            int expectedStartIndex = 37; // Index of King of Hearts is 17, 11 (king of diamonds) + 26 (two suits)
            int resultantStartIndex = Collections.indexOfSubList(cards, fourCards);
            assertEquals(expectedStartIndex, resultantStartIndex);
        }
    }
}
