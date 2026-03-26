package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RuntimeInspectionTest {

    String results;

    private String watchUnknownMovie(Object unknownObject) {
        if (unknownObject.getClass().getSimpleName().equals("Comedy")) {
            var c = (Comedy) unknownObject;
            return c.watchMovie();
        } else if (unknownObject instanceof Adventure) {
            return ((Adventure) unknownObject).watchMovie();
        } else if (unknownObject instanceof ScienceFiction sf) {
            return sf.watchMovie();
        } else {
            var mv = (Movie) unknownObject;
            return mv.watchMovie();
        }
    }
    Object unknownObjectOne, unknownObjectTwo,
            unknownObjectThree, unknownObjectFour;

    @BeforeEach
    public void setUp() {
        unknownObjectOne = Movie.getMovie("S", "Star Wars");
        unknownObjectTwo = Movie.getMovie("C", "Airplane");
        unknownObjectThree = Movie.getMovie("A", "King Kong");
        unknownObjectFour = Movie.getMovie("D", "The African Queen");
    }

    @Test
    public void testScienceFictionRuntime() {
        results = watchUnknownMovie(unknownObjectOne);
        String expectedScienceFiction =
                "The movie title is 'Star Wars' and the movie type is ScienceFiction\n" +
                ".. Bad Aliens Do Bad Stuff\n" + ".. Space Guys Chase Aliens\n" +
                ".. Planet Blows Up\n";
        assertEquals(expectedScienceFiction, results);
    }

    @Test
    public void testComedyRuntime() {
        results = watchUnknownMovie(unknownObjectTwo);
        String expectedComedy =
                "The movie title is 'Airplane' and the movie type is Comedy\n" +
                ".. Something Funny Happens\n" + ".. Something Even Funnier Happens\n" +
                ".. Happy Ending\n";
        assertEquals(expectedComedy, results);
    }

    @Test
    public void testAdventureRuntime() {
        results = watchUnknownMovie(unknownObjectThree);
        String expectedAdventure =
                "The movie title is 'King Kong' and the movie type is Adventure\n" +
                ".. Pleasant Scene\n" + ".. Scary Music\n" +
                ".. Something Bad Happens\n";
        assertEquals(expectedAdventure, results);
    }

    @Test
    public void testMovieRuntime() {
        results = watchUnknownMovie(unknownObjectFour);
        String expected =
                "The movie title is 'The African Queen' and the movie type is Movie\n";
        assertEquals(expected, results);
    }
}
