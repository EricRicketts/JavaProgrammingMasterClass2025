package org.example;

public class Movie {

    private final String title;

    public Movie(String title) {
        this.title = title;
    }

    public String watchMovie() {
        return "The movie title is '" + this.getTitle() +
                "' and the movie type is " + this.getClass().getSimpleName() + "\n";
    }

    public String getTitle() {
        return title;
    }

    public static Movie getMovie(String type, String title) {
        /*
            This is a software pattern, known as a "Factory Method" as it
            takes inputs and returns an object.  The underlying code has no
            need to know about the movie type it just produces the Movie or
            any one of its subclasses, based on the input type.
        */
        return switch(type.toUpperCase().charAt(0)) {
            case 'A' -> new Adventure(title);
            case 'C' -> new Comedy(title);
            case 'S' -> new ScienceFiction(title);
            default  -> new Movie(title);
        };
    }
}
