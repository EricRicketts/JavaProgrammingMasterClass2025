package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdventureTest {

    Movie movie;
    String expected, result;

    @BeforeEach
    public void setUp() {
        movie = new Adventure("North By Northwest");
    }

    @Test
    public void testGetTitle() {
        expected = "North By Northwest";
        result = movie.getTitle();
        assertEquals(expected, result);
    }

    @Test
    public void testWatchMovie() {
        expected = "The movie title is 'North By Northwest' and the movie type is Adventure\n" +
                ".. Pleasant Scene\n" + ".. Scary Music\n" + ".. Something Bad Happens\n";
        result = movie.watchMovie();
        assertEquals(expected, result);
    }
}
