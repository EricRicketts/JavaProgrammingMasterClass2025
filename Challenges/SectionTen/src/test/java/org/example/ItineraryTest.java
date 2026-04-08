package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItineraryTest {

    private Itinerary itinerary;
    String expected, result;
    Record expectedRecord, resultantRecord;
    int[] distances;

    @BeforeEach
    public void setUp() {
        LinkedList<Place> places = new LinkedList<>();
        distances = new int[]{102, 81, 208, 204, 98, 99, 38, 48, 148, 343};
        String[] towns = new String[]{
                "Richmond", "Charlottesville", "Roanoke", "Virginia Beach",
                "Harrisonburg", "Staunton", "Culpepper", "Fredericksburg",
                "Williamsburg", "Bristol"
        };
        for (int i = 0; i < distances.length; i++) {
            Place place = new Place(towns[i], distances[i]);
            places.add(place);
        }
        itinerary = new Itinerary(places);
    }

    @Test
    public void testListPlaces() {
        expected =
                    "name = Richmond, distance = 102\n" +
                    "name = Charlottesville, distance = 81\n" +
                    "name = Roanoke, distance = 208\n" +
                    "name = Virginia Beach, distance = 204\n" +
                    "name = Harrisonburg, distance = 98\n" +
                    "name = Staunton, distance = 99\n" +
                    "name = Culpepper, distance = 38\n" +
                    "name = Fredericksburg, distance = 48\n" +
                    "name = Williamsburg, distance = 148\n" +
                    "name = Bristol, distance = 343";
        result = itinerary.listPlaces();
        assertEquals(expected, result);
    }

    @Test
    public void testMoveForward() {
        expectedRecord = new Place("Staunton", 99);
        itinerary.resetItineraryCursor();
        for (int i = 0; i < 6; i++) {
            resultantRecord = itinerary.moveForward();
        }
        assertEquals(expectedRecord, resultantRecord);
    }

    @Test
    public void testMoveBackward() {
        expectedRecord = new Place("Culpepper", 38);
        for (int i = 0; i < distances.length; i++) {
            resultantRecord = itinerary.moveForward();
        }

        for (int i = 0; i < 4; i++) {
            resultantRecord = itinerary.moveBackward();
        }
        assertEquals(expectedRecord, resultantRecord);
    }

    @Test
    public void testShowMenu() {
        expected ="""
               (F)orward
               (B)ackward
               (L)ist places
               (M)enu
               (Q)uit""";
        result = itinerary.showMenu();
        assertEquals(expected, result);
    }
}