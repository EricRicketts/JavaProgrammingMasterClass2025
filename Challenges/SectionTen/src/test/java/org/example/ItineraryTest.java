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

    @Test
    public void testMoveForwardTraversesAndWraps() {
        Place[] expectedPlaces = {
            new Place("Richmond", 102),
            new Place("Charlottesville", 81),
            new Place("Roanoke", 208),
            new Place("Virginia Beach", 204),
            new Place("Harrisonburg", 98),
            new Place("Staunton", 99),
            new Place("Culpepper", 38),
            new Place("Fredericksburg", 48),
            new Place("Williamsburg", 148),
            new Place("Bristol", 343)
        };
        for (Place expected : expectedPlaces) {
            assertEquals(expected, itinerary.moveForward());
        }

        // Demonstrate wrap-around behavior once the end of the list is reached.
        assertEquals(new Place("Richmond", 102), itinerary.moveForward());
        assertEquals(new Place("Charlottesville", 81), itinerary.moveForward());
    }

    @Test
    public void testMoveBackwardTraversesAndWraps() {
        Place[] expectedPlaces = {
            new Place("Bristol", 343),
            new Place("Williamsburg", 148),
            new Place("Fredericksburg", 48),
            new Place("Culpepper", 38),
            new Place("Staunton", 99),
            new Place("Harrisonburg", 98),
            new Place("Virginia Beach", 204),
            new Place("Roanoke", 208),
            new Place("Charlottesville", 81),
            new Place("Richmond", 102)
        };

        for (int i = 0; i < distances.length; i++) {
            itinerary.moveForward();
        }

        for (Place expected : expectedPlaces) {
            assertEquals(expected, itinerary.moveBackward());
        }

        // Demonstrate wrap-around behavior once the beginning of the list is reached.
        assertEquals(new Place("Bristol", 343), itinerary.moveBackward());
        assertEquals(new Place("Williamsburg", 148), itinerary.moveBackward());
    }

    @Test
    public void testNullPlacesAreIgnored() {
        LinkedList<Place> route = new LinkedList<>();
        route.add(new Place("Richmond", 102));
        route.add(null);
        route.add(new Place("Charlottesville", 81));

        Itinerary itinerary = new Itinerary(route);

        String expected = """
            name = Richmond, distance = 102
            name = Charlottesville, distance = 81""".stripIndent().stripTrailing();

        assertEquals(expected, itinerary.listPlaces());
    }

    @Test
    public void testNullPlaceNamesAreIgnored() {
        LinkedList<Place> route = new LinkedList<>();
        route.add(new Place("Richmond", 102));
        route.add(new Place(null, 155));
        route.add(new Place("Charlottesville", 81));

        Itinerary itinerary = new Itinerary(route);

        String expected = """
            name = Richmond, distance = 102
            name = Charlottesville, distance = 81""".stripIndent().stripTrailing();

        assertEquals(expected, itinerary.listPlaces());
    }

    @Test
    public void testDuplicatePlacesAreIgnored() {
        LinkedList<Place> route = new LinkedList<>();
        route.add(new Place("Richmond", 102));
        route.add(new Place("Charlottesville", 81));
        route.add(new Place("Richmond", 102));
        route.add(new Place("Bristol", 343));

        Itinerary itinerary = new Itinerary(route);

        String expected = """
            name = Richmond, distance = 102
            name = Charlottesville, distance = 81
            name = Bristol, distance = 343""".stripIndent().stripTrailing();

        assertEquals(expected, itinerary.listPlaces());
    }

    @Test
    public void testShowMenu() {
        expected = """
           (F)orward
           (B)ackward
           (L)ist places
           (M)enu
           (Q)uit"""
                .stripIndent().stripTrailing();
        result = itinerary.showMenu();
        assertEquals(expected, result);
    }


    @Test
    public void testQuit() {
        QuitException exception = assertThrows(QuitException.class, () -> itinerary.quit());
        assertEquals("Quit requested", exception.getMessage());
    }
}