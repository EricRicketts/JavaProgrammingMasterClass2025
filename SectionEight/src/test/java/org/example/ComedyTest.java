package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComedyTest {

    Movie movie;
    String expected, result;

    @BeforeEach
    public void setUp() {
        movie = new Comedy("Blazing Saddles");
    }

    @Test
    public void testGetTitle() {
        expected = "Blazing Saddles";
        result = movie.getTitle();
        assertEquals(expected, result);
    }

    @Test
    public void testWatchMovie() {
        expected = "The movie title is 'Blazing Saddles' and the movie type is Comedy\n" +
                ".. Something Funny Happens\n" + ".. Something Even Funnier Happens\n" +
                ".. Happy Ending\n";
        result = movie.watchMovie();
        assertEquals(expected, result);
    }
}
