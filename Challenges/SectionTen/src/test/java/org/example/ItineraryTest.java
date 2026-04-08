package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
public class ItineraryTest {

    private Itinerary itinerary;
    String expected, result;
    Record expectedRecord, resultantRecord;
    LinkedList<Place> places;
    AtomicBoolean exited;
    int[] distances;

    @BeforeEach
    public void setUp() {
        exited = new AtomicBoolean(false);
        places = new LinkedList<>();
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

    @Order(1)
    @Test
    public void testListPlaces() {
            expected = """
            name = Richmond, distance = 102
            name = Charlottesville, distance = 81
            name = Roanoke, distance = 208
            name = Virginia Beach, distance = 204
            name = Harrisonburg, distance = 98
            name = Staunton, distance = 99
            name = Culpepper, distance = 38
            name = Fredericksburg, distance = 48
            name = Williamsburg, distance = 148
            name = Bristol, distance = 343"""
                    .stripIndent().stripTrailing();

            result = itinerary.listPlaces();
            assertEquals(expected, result);
    }

    @Order(2)
    @Test
    public void testMoveForward() {
        expectedRecord = new Place("Staunton", 99);
        itinerary.resetItineraryCursor();
        for (int i = 0; i < 6; i++) {
            resultantRecord = itinerary.moveForward();
        }
        assertEquals(expectedRecord, resultantRecord);
    }

    @Order(3)
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


    @Order(4)
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


    @Order(5)
    @Test
    public void testQuit() {
        QuitException exception = assertThrows(QuitException.class, () -> itinerary.quit());
        assertEquals("Quit requested", exception.getMessage());
    }
}