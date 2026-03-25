package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {

    Movie movie;
    String expected, result;

    @BeforeEach
    public void setUp() {
        movie = new Movie("Casablanca");
    }

    @Test
    public void testGetTitle() {
        expected = "Casablanca";
        result = movie.getTitle();
        assertEquals(expected, result);
    }

    @Test
    public void testWatchMovie() {
        expected = "The movie title is 'Casablanca' and the movie type is Movie\n";
        result = movie.watchMovie();
        assertEquals(expected, result);
    }
}
