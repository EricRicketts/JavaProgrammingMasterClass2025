package org.example;

public class Comedy extends Movie {

    public Comedy(String title) {
        super(title);
    }

    public String watchComedy() {
        return "Watching a Comedy movie.";
    }

    @Override
    public String watchMovie() {
        String movieMessage = String.format(".. %s%n".repeat(3),
                "Something Funny Happens",
                "Something Even Funnier Happens",
                "Happy Ending"
        );
        return super.watchMovie() + movieMessage;
    }
}
