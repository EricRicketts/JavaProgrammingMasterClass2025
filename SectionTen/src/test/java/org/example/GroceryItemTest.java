package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class GroceryItemTest {

    GroceryItem[] groceryArray = new GroceryItem[3];
    /*
        Below, we instantiate an Array List of type GroceryItem.  This means all
        elements in the list must be a GroceryItem.  We preserve Java's type
        checking when we do this.  To complete the instantiation, we do
        not need to specify the type in the second <>.
     */
    ArrayList<GroceryItem> secondGroceryList = new ArrayList<>();
    ArrayList<GroceryItem> thirdGroceryList;
    GroceryItem resultantItem, expectedItem, item;
    int originalListSize;

    @BeforeEach
    public void setUp() {
        groceryArray[0] = new GroceryItem("milk");
        groceryArray[1] = new GroceryItem("apples", "PRODUCE");
        groceryArray[2] = new GroceryItem("oranges", "PRODUCE", 5);
        secondGroceryList.add(new GroceryItem("butter"));
        secondGroceryList.add(new GroceryItem("pears", "PRODUCE", 3));
        thirdGroceryList = new ArrayList<>(
            List.of(
                new GroceryItem("milk"),
                new GroceryItem("apples", "PRODUCE", 6),
                new GroceryItem("oranges", "PRODUCE", 5),
                new GroceryItem("butter", "DAIRY", 3),
                new GroceryItem("spinach", "PRODUCE", 2),
                new GroceryItem("milk", "DAIRY", 3),
                new GroceryItem("cucumber", "PRODUCE", 4),
                new GroceryItem("pears", "PRODUCE", 5),
                new GroceryItem("milk", "DAIRY", 2),
                new GroceryItem("kale", "PRODUCE", 8))
        );
    }

    @Nested
    @DisplayName("test contents of grocery list array")
    class TestContentsOfGroceryListArray {

        @Test
        public void testGettingEachElementOfTheFirstRecord() {
            Object[] expected = {"milk", "DAIRY", 1};
            Object[] result = {
                groceryArray[0].name(),
                groceryArray[0].type(),
                groceryArray[0].count()
            };
            assertArrayEquals(expected, result);
        }

        @Test
        public void testGettingEachElementOfTheSecondRecord() {
            Object[] expected = {"apples", "PRODUCE", 1};
            Object[] result = {
                groceryArray[1].name(),
                groceryArray[1].type(),
                groceryArray[1].count(),
            };
            assertArrayEquals(expected, result);
        }

        @Test
        public void testGettingEachElementOfTheThirdRecord() {
            Object[] expected = {"oranges", "PRODUCE", 5};
            Object[] result = {
                groceryArray[2].name(),
                groceryArray[2].type(),
                groceryArray[2].count()
            };
            assertArrayEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test second grocery list")
    class TestSecondGroceryList {

        @Test
        public void testAddAnItemToTheFrontOfAList() {
            secondGroceryList.addFirst(new GroceryItem("apples", "PRODUCE", 6));
            expectedItem = new GroceryItem("apples", "PRODUCE", 6);

            resultantItem = secondGroceryList.getFirst();
            assertEquals(expectedItem, resultantItem);
        }

        @Test
        public void testEffectOfAddingItemToFrontOfList() {
            // Once an item is added to the front of a list, everything shifts right by one slot.
            assertEquals(2, secondGroceryList.size());
            secondGroceryList.addFirst(new GroceryItem("apples", "PRODUCE", 6));
            expectedItem = new GroceryItem("butter", "DAIRY", 1);

            resultantItem = secondGroceryList.get(1);
            assertEquals(expectedItem, resultantItem);
            assertEquals(3, secondGroceryList.size());
        }

        @Test
        public void testAddAnItemToEndOfAList() {
            secondGroceryList.addLast(new GroceryItem("mangoes", "PRODUCE", 3));
            expectedItem = new GroceryItem("mangoes", "PRODUCE", 3);

            resultantItem = secondGroceryList.getLast();
            assertEquals(expectedItem, resultantItem);
        }

        @Test
        public void testEffectOfAddingItemToEndOfList() {
            assertEquals(2, secondGroceryList.size());
            secondGroceryList.addLast(new GroceryItem("avocados", "PRODUCE", 2));
            expectedItem = new GroceryItem("avocados", "PRODUCE", 2);

            assertEquals(3, secondGroceryList.size());
            // Adding an item to the end of a list does not change the order of the existing items.
            expectedItem = new GroceryItem("butter", "DAIRY", 1);
            resultantItem = secondGroceryList.getFirst();

            assertEquals(expectedItem, resultantItem);
        }

        @Test
        public void testAListFromAListUsingSublist() {
            int[] expected = {2, 5};
            assertEquals(2, secondGroceryList.size());

            // List.addAll(listOfItems) adds the listOfItems individually to the current list.
            List<GroceryItem> additionalItems = Arrays.asList(groceryArray);
            secondGroceryList.addAll(additionalItems);

            assertEquals(5, secondGroceryList.size());
            // The newArrayList<>() call makes an independent copy of the sublist, this
            // avoids concurrency issues or any structural dependencies.
            List<GroceryItem> addedItems = new ArrayList<>(secondGroceryList.subList(2, 5));
            assertEquals(additionalItems, addedItems);
        }
    }

    @Nested
    @DisplayName("test searching for and retrieving items from a list")
    class TestSearchAndRetrieveItemsFromList {

        @Test
        public void searchForAnItemInAList() {
            item = new GroceryItem("spinach", "PRODUCE", 2);
            boolean found = thirdGroceryList.contains(item);
            assertTrue(found);
        }

        @Test
        public void searchForAnItemInAListMustHaveExactMatch() {
            item = new GroceryItem("spinach", "PRODUCE", 5);
            boolean found = thirdGroceryList.contains(item);
            assertFalse(found);
        }

        @Test
        public void retrieveTheFirstAppearanceOfAnObject() {
            item = new GroceryItem("milk", "DAIRY", 3);
            int firstIndex = thirdGroceryList.indexOf(item);
            int expectedFirstIndex = 5; // Milk in position 0 has a count of 1
            assertEquals(expectedFirstIndex, firstIndex);
        }

        @Test
        public void retrieveTheLastAppearanceOfAnObject() {
            item = new GroceryItem("milk", "DAIRY", 2);
            int lastIndex = thirdGroceryList.lastIndexOf(item);
            int expectedLastIndex = 8; // Milk in position 8 has a count of 2
            assertEquals(expectedLastIndex, lastIndex);
        }
    }

    @Nested
    @DisplayName("test list removal")
    class TestListRemoval {

        @Test
        public void removeAnObjectFromAListByIndex() {
            int expectedOriginalListSize = 10;
            originalListSize = thirdGroceryList.size();
            assertEquals(expectedOriginalListSize, originalListSize);

            GroceryItem expectedItem = new GroceryItem("pears", "PRODUCE", 5);
            int indexOfExpectedItem = thirdGroceryList.indexOf(expectedItem);

            resultantItem = thirdGroceryList.remove(indexOfExpectedItem);
            assertEquals(expectedItem, resultantItem);
            assertEquals(expectedOriginalListSize - 1, thirdGroceryList.size());
        }

        @Test
        public void removeAnObjectFromAListByTraitsWithNoReturnedObject() {
            // In this case, Java just modifies the current list by removing the found item;
            // no object is returned as is the case when removing by an index.
            assertEquals(10, thirdGroceryList.size());
            item = new GroceryItem("cucumber", "PRODUCE", 4);
            boolean removed = thirdGroceryList.remove(item);

            assertTrue(removed);
            assertEquals(9, thirdGroceryList.size());
        }

        @Test
        public void testRemoveAListOfItemsFromAListItemsReturned() {
            List<Integer> indicesOfItems = new ArrayList<>();
            originalListSize = thirdGroceryList.size();
            assertEquals(10, originalListSize);

            ArrayList<GroceryItem> itemsToRemove = new ArrayList<>(
                List.of(new GroceryItem("butter", "DAIRY", 3),
                    new GroceryItem("cucumber", "PRODUCE", 4),
                    new GroceryItem("milk", "DAIRY", 2))
            );

            for (int i = 0; i < itemsToRemove.size(); i++) {
                GroceryItem desiredGroceryItem = itemsToRemove.get(i);
                for (int j = 0; j < thirdGroceryList.size(); j++) {
                    GroceryItem currentGroceryItem = thirdGroceryList.get(j);
                    if (currentGroceryItem.equals(desiredGroceryItem)) {
                        int index = thirdGroceryList.indexOf(currentGroceryItem);
                        indicesOfItems.add(index);
                        break;
                    }
                }
            }

            for (int i = 0; i < indicesOfItems.size(); i++) {
                int firstRemovalIndex = indicesOfItems.getFirst();
                int removalIndex = indicesOfItems.get(i);
                if (removalIndex > firstRemovalIndex) {
                    if (removalIndex == indicesOfItems.get(1)) {
                        removalIndex -= 1; // Decrement removal index list size drops by one.
                    } else {
                        removalIndex -= 2; // Decrement removal index list size drops by two.
                    }
                }
                GroceryItem expectedItem = itemsToRemove.get(i);
                GroceryItem resultantItem = thirdGroceryList.remove(removalIndex);
                originalListSize -= 1;
                assertEquals(expectedItem, resultantItem);
                assertEquals(originalListSize, thirdGroceryList.size());
            }
        }

        @Test
        public void removeAListFromAList() {
            // To remove a List from a List used the removeAll method
            originalListSize = thirdGroceryList.size();
            assertEquals(10, originalListSize);
            ArrayList<GroceryItem> itemsToRemove = new ArrayList<>(
                List.of(new GroceryItem("butter", "DAIRY", 3),
                    new GroceryItem("cucumber", "PRODUCE", 4),
                    new GroceryItem("milk", "DAIRY", 2))
            );
            // As show above, the removed items need not be in sequential order.
            boolean removed = thirdGroceryList.removeAll(itemsToRemove);
            assertTrue(removed);
            assertEquals(originalListSize - 3, thirdGroceryList.size());
        }

        @Test
        public void retainItemsInAList() {
            ArrayList<GroceryItem> itemsToRetain = new ArrayList<>(
                List.of(
                    new GroceryItem("oranges", "PRODUCE", 5),
                    new GroceryItem("kale", "PRODUCE", 8))
            );
            thirdGroceryList.retainAll(itemsToRetain);
            assertEquals(2, thirdGroceryList.size());
        }

        @Test
        public void clearAList() {
            thirdGroceryList.clear();
            thirdGroceryList.add(new GroceryItem("oranges", "PRODUCE", 5));
            assertEquals(1, thirdGroceryList.size());
        }
    }

    @Nested
    @DisplayName("test modify items in a list")
    class TestModifyItemsInAlist {

        @Test
        public void testReplacingAnItemInAList() {
            item = new GroceryItem("oranges", "PRODUCE", 5);
            assertEquals(item, thirdGroceryList.get(2));

            item = new GroceryItem("kale", "PRODUCE", 8);
            thirdGroceryList.set(2, item);
            assertEquals(item, thirdGroceryList.get(2));
        }

        @Test
        public void testSetFieldsOfAnItemInAList() {
            List<Integer> newList = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5));
            newList.set(3, 10);

            assertEquals(new ArrayList<>(List.of(0, 1, 2, 10, 4, 5)), newList);
        }
    }

    @Nested
    @DisplayName("test convert a list to an array and an array to a list")
    class ConvertListToArrayAndArrayToList {

        @Test
        public void testConvertAListToAnArray() {
            // To convert a List to an Array, use the toArray() method.
            // Passing GroceryItem[]::new (a constructor reference) is the modern way to get a typed array.
            GroceryItem[] array = thirdGroceryList.toArray(GroceryItem[]::new);
            
            assertEquals("GroceryItem[]", array.getClass().getSimpleName());
            assertEquals(10, array.length);
            assertEquals("milk", array[0].name());
        }

        @Test
        public void testConvertAnArrayToAnMutableList() {
        /*
            In this case we have a list backed by an array; a change to either one
            is reflected in the other.  We can change elements on either the list
            or the array such changes will be reflected in both objects.

            Basically, we turn an array into a list so we can tap into list functionality.
            Arrays.asList() -> List returned is NOT resizable but is muteable.
            List.of() -> List returned is immutable.
        */
            String[] originalArray = {"First", "Second", "Third"};
            var originalList = Arrays.asList(originalArray);
            assertEquals("First", originalList.getFirst());
            assertEquals("First", originalArray[0]);

            originalArray[0] = "one";
            assertEquals("one", originalList.getFirst());
            assertEquals("one", originalArray[0]);
        }

        @Test
        public void testConvertAnArrayToAImmutableList() {
            String[] originalArray = {"First", "Second", "Third"};
            List<String> originalList = List.of(originalArray);

            // Find the class of the new list.
            String type = originalList.getClass().toString();
            String[] listType = type.split("\\$")[0].split("\\.");
            String listTypeClass = listType[listType.length - 1];
            assertEquals("ImmutableCollections", listTypeClass);

            UnsupportedOperationException unsupportedOperationException =
                assertThrows(
                UnsupportedOperationException.class,
                () -> originalList.set(1, "Many")
            );

            assertEquals(
                null,
                unsupportedOperationException.getMessage()
            );
        }

        @Test
        public void testConvertAnArrayToAnIndependentMutableList() {
            // The instance field 'groceryArray' is an array (GroceryItem[]).
            // Arrays do not have a toArray() method; that method belongs to the List interface.
            
            // To create a truly independent and mutable list from an array, 
            // we use List.of() or Arrays.asList() and wrap it in a new ArrayList.
            assertEquals(3, groceryArray.length);
            List<GroceryItem> independentList = new ArrayList<>(List.of(groceryArray));

            // Now we can add items to it. Note that we must add a GroceryItem object, not a String.
            independentList.add(new GroceryItem("Fourth", "PRODUCE", 1));

            assertEquals(4, independentList.size());
            assertEquals("Fourth", independentList.getLast().name());

            // groceryArray remains unchanged.
            assertEquals(3, groceryArray.length);
        }
    }
}
