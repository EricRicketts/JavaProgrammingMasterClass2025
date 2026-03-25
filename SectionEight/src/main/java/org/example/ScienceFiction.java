package org.example;

public class ScienceFiction extends Movie {

    public ScienceFiction(String title) {
        super(title);
    }

    public String watchMovie() {
        String movieMessage = String.format(".. %s%n".repeat(3),
                "Bad Aliens Do Bad Stuff",
                "Space Guys Chase Aliens",
                "Planet Blows Up"
        );
        return super.watchMovie() + movieMessage;
    }
}
