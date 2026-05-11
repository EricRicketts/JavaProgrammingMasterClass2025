package org.example;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

public class Book {

    private final String title;

    private final String author;

    private final int pages;

    public Book(String title, String author, int pages) {
        this.title = validateTitleAndReturn(title);
        this.author = validateAuthorAndReturn(author);
        this.pages = validatePagesAndReturn(pages);
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

    public static String validateAuthorAndReturn(String author) {
        return ValueValidator.validateTextAndReturn(author, "author");
    }

    public static int validatePagesAndReturn(int pages) {
        return ValueValidator.validatePositiveIntAndReturn(pages, "pages");
    }

    public static String validateTitleAndReturn(String title) {
        return ValueValidator.validateTextAndReturn(title, "title");
    }
}
