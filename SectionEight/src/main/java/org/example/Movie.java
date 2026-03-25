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
}
