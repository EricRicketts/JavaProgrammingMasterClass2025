package org.example;

import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public record BookRecord(String title, String author, int pages) {

    public BookRecord(String title, String author, int pages) {
        this.title = Objects.requireNonNull(title, "Null value assigned to title");
        this.author = Objects.requireNonNull(author, "Null value assigned to author");
        // This message was introduced so the markdown editor does not truncate the text.
        String message = "Number of pages assigned to book is less than zero";
        if (pages < 0) {
            throw new IllegalArgumentException(message);
        } else {
            this.pages = pages;
        }
    }

    @Override
    @NotNull
    public String toString() {
        return
                "Title = " + this.title() + ", " +
                "Author = " + this.author() + ", " +
                "Number of pages = " + this.pages();
    }
}
