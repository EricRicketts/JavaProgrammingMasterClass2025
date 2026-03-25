package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieFactoryTest {

    String[] expected, results;

    @BeforeEach
    public void setUp() {
        expected = new String[]{
                "The movie title is 'Raiders of the Lost Ark' and the movie type is Adventure",
                "The movie title is 'The Naked Gun' and the movie type is Comedy",
                "The movie title is 'Dune' and the movie type is ScienceFiction"
        };
    }

    @Test
    public void testMovies() {
        String[][] inputs = new String[][]{
                {"Adventure", "Raiders of the Lost Ark"},
                {"Comedy", "The Naked Gun"},
                {"ScienceFiction", "Dune"}
        };
        Movie[] movies = new Movie[]{
                Movie.getMovie(inputs[0][0], inputs[0][1]),
                Movie.getMovie(inputs[1][0], inputs[1][1]),
                Movie.getMovie(inputs[2][0], inputs[2][1])
        };
        results = new String[]{
                movies[0].watchMovie().split("\n")[0],
                movies[1].watchMovie().split("\n")[0],
                movies[2].watchMovie().split("\n")[0],
        };
        assertArrayEquals(expected, results);
    }
}
