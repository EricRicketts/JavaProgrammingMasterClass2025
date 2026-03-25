package org.example;

public class Adventure extends Movie {
    public Adventure(String title) {
        super(title);
    }

    public String watchMovie() {
        String movieMessage = String.format(".. %s%n".repeat(3),
                "Pleasant Scene",
                "Scary Music",
                "Something Bad Happens"
        );
        return super.watchMovie() + movieMessage;
    }
}
