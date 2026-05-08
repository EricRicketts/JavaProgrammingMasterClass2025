package org.example;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

public class Book {

    private final String title, author;

    private final int pages;

    public Book(String title, String author, int pages) {
        this.title = ValueValidator.validateTitleAndReturn(title);
        this.author = ValueValidator.validateAuthorAndReturn(author);
        this.pages = ValueValidator.validatePagesAndReturn(pages);
    }

    public String getAuthor() {
        return this.author;
    }

    public int getPages() {
        return this.pages;
    }

    public String getTitle() {
        return this.title;
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
