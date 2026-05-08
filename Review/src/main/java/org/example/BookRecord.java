package org.example;

import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public record BookRecord(String title, String author, int pages) {

    public BookRecord(String title, String author, int pages) {
        this.title = ValueValidator.validateTitleAndReturn(title);
        this.author = ValueValidator.validateAuthorAndReturn(author);
        this.pages = ValueValidator.validatePagesAndReturn(pages);
    }

    @Override
    @NotNull
    public String toString() {
        return String.format(
                "Title = %s%n" +
                "Author = %s%n" +
                "Number of pages = %s%n",
                title,
                author,
                pages
        ).trim();
    }
}
