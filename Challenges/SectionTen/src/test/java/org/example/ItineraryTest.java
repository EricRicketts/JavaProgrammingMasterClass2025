package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItineraryTest {

    ArrayList<Place> itinerary;
    String expected, result;
    Record expectedRecord, resultantRecord;

    @BeforeEach
    public void setUp() {
        itinerary = new ArrayList<>();
        int[] distances = new int[]{102, 81, 208, 204, 98, 99, 38, 48, 148, 343};
        String[] towns = new String[]{
                "Richmond", "Charlottesville", "Roanoke", "Virginia Beach",
                "Harrisonburg", "Staunton", "Culpepper", "Fredericksburg",
                "Williamsburg", "Bristol"
        };
        for (int i = 0; i < distances.length; i++) {
            Place place = new Place(towns[i], distances[i]);
            itinerary.add(place);
        }
    }

    @Test
    public void testListInitialized() {
        expected = "[" +
                "Place[name=Richmond, distance=102], Place[name=Charlottesville, distance=81], " +
                "Place[name=Roanoke, distance=208], Place[name=Virginia Beach, distance=204], " +
                "Place[name=Harrisonburg, distance=98], Place[name=Staunton, distance=99], " +
                "Place[name=Culpepper, distance=38], Place[name=Fredericksburg, distance=48], " +
                "Place[name=Williamsburg, distance=148], Place[name=Bristol, distance=343]" +
                "]";
        result = itinerary.toString();
        assertEquals(expected, result);
    }

    @Test
    public void testMoveForwardAndBackwards() {
        Place place;
        var itineraryIterator = itinerary.listIterator();
        // Move forward through the list via an iterator.
        while (itineraryIterator.hasNext()) {
            place = itineraryIterator.next();
            if (place.name().equals("Staunton")) {
                expectedRecord = new Place("Staunton", 99);
                resultantRecord = place;
                assertEquals(expectedRecord, resultantRecord);
            }
        }
        // Move backwards through the list via an iterator.
        while (itineraryIterator.hasPrevious()) {
            place = itineraryIterator.previous();
            if (place.name().equals("Harrisonburg")) {
                expectedRecord = new Place("Harrisonburg", 98);
                resultantRecord = place;
                assertEquals(expectedRecord, resultantRecord);
            }
        }
    }

    @Test
    public void moveThreePlacesForwardAndOnePlaceBackwardsInTheList() {
        /*
        Remember, upon initialization the iterator pointer is before the first element of the list.
        Upon advancing, it goes to a location between the first and second element of the list.
        In the code below the iterator pointer will end up between the third and fourth element of the
        list, and if asked for an element will return the third element.  At i = 0, resultantRecord is Richmond;
        at i = 1, resultantRecord is Charlottesville, at i = 2 resultantRecord is Roanoke.  The next() method
        returns the element in front of the iterator pointer (the 3rd element if the pointer is between
        the second and third element). Then it advances the pointer to the next location, which would be
        be between the third and fourth element.
        */
        var itineraryIterator = itinerary.listIterator();
        for (int i = 0; i < 3; i++) {
            resultantRecord = itineraryIterator.next();
        }
        expectedRecord = new Place("Roanoke", 208);
        assertEquals(expectedRecord, resultantRecord);

        /*
        Move backwards one location on the list.  We have to call the previous() method twice because
        at the end of the previous advancements, the iterator pointer is between the 3rd and 4th elements
        on the list.  So the first call to previous returns Roanoke.  For i = 0 the iterator pointer moves
        between the second and third element of the list, so a call to get an element from the list would
        return the third element.  For i = 1, the iterator pointer moves between the first and second element
        of the list, so the second element would be returned.
        */
        for (int i = 0; i < 2; i++) {
            resultantRecord = itineraryIterator.previous();
        }
        expectedRecord = new Place("Charlottesville", 81);
        assertEquals(expectedRecord, resultantRecord);
    }
}
