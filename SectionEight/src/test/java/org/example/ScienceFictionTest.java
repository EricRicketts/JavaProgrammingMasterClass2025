package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScienceFictionTest {

    Movie movie;
    String expected, result;

    @BeforeEach
    public void setUp() {
        movie = new ScienceFiction("Dune");
    }

    @Test
    public void testGetTitle() {
        expected = "Dune";
        result = movie.getTitle();
        assertEquals(expected, result);
    }

    @Test
    public void testWatchMovie() {
        expected = "The movie title is 'Dune' and the movie type is ScienceFiction\n" +
                ".. Bad Aliens Do Bad Stuff\n" + ".. Space Guys Chase Aliens\n" +
                ".. Planet Blows Up\n";
        result = movie.watchMovie();
        assertEquals(expected, result);
    }
}
