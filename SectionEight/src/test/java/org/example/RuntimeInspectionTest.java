package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RuntimeInspectionTest {

    private String generateScienceFictionString(String title) {
        return "The movie title is " + "'" + title + "'" + " and the movie type is ScienceFiction\n" +
            ".. Bad Aliens Do Bad Stuff\n" + ".. Space Guys Chase Aliens\n" +
            ".. Planet Blows Up\n";

    }

    private String generateComedyString(String title) {
        return "The movie title is " + "'" + title + "'" + " and the movie type is Comedy\n" +
            ".. Something Funny Happens\n" + ".. Something Even Funnier Happens\n" +
            ".. Happy Ending\n";

    }

    private String generateAdventureString(String title) {
        return "The movie title is " + "'" + title + "'" + " and the movie type is Adventure\n" +
            ".. Pleasant Scene\n" + ".. Scary Music\n" +
            ".. Something Bad Happens\n";

    }

    String expected, results;

    private String watchUnknownMovie(Object unknownObject) {
        // All the below code works because I am doing a specific cast to the desire type from Object.
        // Since the original type was Comedy or Adventure or Science Fiction, then that specific type
        // is recoverable with a cast.
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
        expected = generateScienceFictionString("Star Wars");
        results = watchUnknownMovie(unknownObjectOne);

        assertEquals(expected, results);
    }

    @Test
    public void testComedyRuntime() {
        expected = generateComedyString("Airplane");
        results = watchUnknownMovie(unknownObjectTwo);

        assertEquals(expected, results);
    }

    @Test
    public void testAdventureRuntime() {
        expected = generateAdventureString("King Kong");
        results = watchUnknownMovie(unknownObjectThree);

        assertEquals(expected, results);
    }

    @Test
    public void testMovieRuntime() {
        String expected = "The movie title is 'The African Queen' and the movie type is Movie\n";
        results = watchUnknownMovie(unknownObjectFour);

        assertEquals(expected, results);
    }

    @Nested
    @DisplayName("subclass movie types are allowed in a movie variable")
    class TestSubclassMovieTypesAllowedForMovieVariable {

        @Test
        public void testScienceFictionIsAMovieType() {
            Movie movie = new ScienceFiction("Star Wars");
            expected = generateScienceFictionString("Star Wars");
            results = movie.watchMovie();

            assertEquals(expected, results);
//            assertEquals("Watch a Science Fiction movie.", movie.watchScienceFiction());
//            Java will flag a compiler error on the above test, because though a Science Fiction movie is a Movie,
//            the Movie Parent class does not have a watchScienceFiction() method, but does have a watchMovie() method.
//            So even though instantiated as a ScienceFiction movie, its casting as a Movie essentially removes
//            the methods of the child class and only allows calling the Parent class methods.
        }

        @Test
        public void testAdventureIsAMovieType() {
//            Adventure adventure = Movie.getMovie("A", "King Kong"); this produces a compile time error as the
//            compiler is bound to return an Adventure type, but does not know at compile time which type is called
//            for on the left-hand side of the equals.  As seen below, a case of (Adventure) will fix this.
            Adventure adventure = (Adventure) Movie.getMovie("A", "King Kong");

            assertEquals("Watching an Adventure movie.", adventure.watchAdventure());
        }

        @Test
        public void testComedyIsAMovieType() {
            // A Comedy type cannot be cast to an Adventure type.
            expected = "class org.example.Comedy cannot be cast to class org.example.Adventure";
            ClassCastException classCastException =
                assertThrows(
                    ClassCastException.class,
                    () -> {
                        Adventure adventure = (Adventure) Movie.getMovie("C", "Airplane");
                    }
                );

            assertTrue(classCastException.getMessage().contains(expected));
        }

        @Test
        public void testComedyCastWithVar() {
            Object comedy = Movie.getMovie("C", "Airplane");
//            comedy.watchComedy(); this will not compile as the Object class has no knowledge of the watchComedy()
//            method in the Comedy class.
            Comedy comedyMovie = (Comedy) comedy;  // The casting works, but we had to define a new variable.
            assertEquals("Watching a Comedy movie.", comedyMovie.watchComedy());

            var anotherComedy = Movie.getMovie("C", "Blazing Saddles");
            expected = generateComedyString("Blazing Saddles");
            results = anotherComedy.watchMovie();

            assertEquals(expected, results);
        }
    }
}
