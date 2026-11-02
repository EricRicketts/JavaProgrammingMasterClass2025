package org.example;

import org.example.CardAndDeckConstants.*;
import org.example.CardSuit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
            cards = new ArrayList<>(Collections.nCopies(52, kingOfClubs));
            assertEquals(52, cards.size());

            List<Card> thirteenAcesOfHearts = Collections.nCopies(13, aceOfHearts);
            Collections.copy(cards, thirteenAcesOfHearts);

            assertEquals(52, cards.size());
            assertEquals(aceOfHearts, cards.getFirst());
            assertEquals(aceOfHearts, cards.get(12));
            assertEquals(kingOfClubs, cards.get(13));
            assertEquals(kingOfClubs, cards.getLast());
        }
    }
}
