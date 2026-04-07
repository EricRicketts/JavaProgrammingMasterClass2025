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
}
