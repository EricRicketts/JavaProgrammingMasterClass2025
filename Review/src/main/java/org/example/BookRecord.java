package org.example;

import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public record BookRecord(String title, String author, int pages) {

    public BookRecord(String title, String author, int pages) {
        this.title = this.validateTitleAndReturn(title);
        this.author = this.validateAuthorAndReturn(author);
        this.pages = this.validatePagesAndReturn(pages);
    }

    private String validateAuthorAndReturn(String author) {
        return Objects.requireNonNull(author, "Null value assigned to author");
    }

    private int validatePagesAndReturn(int pages) {
        if (pages < 0) {
            throw new IllegalArgumentException("Number of pages assigned to book is less than zero");
        }
        return pages;
    }
    private String validateTitleAndReturn(String title) {
        return Objects.requireNonNull(title, "Null value assigned to title");
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
