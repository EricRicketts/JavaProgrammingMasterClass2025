package org.example;

import java.util.Objects;

public class Book {

    private final String title, author;
    private final int pages;

    public Book(String title, String author, int pages) {
        this.title = this.validateTitleAndReturn(title);
        this.author = this.validateAuthorAndReturn(author);
        this.pages = this.validatePagesAndReturn(pages);
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
    public String toString() {

        return "Title = " + this.getTitle() + ", " +
                "Author = " + this.getAuthor() + ", " +
                "Number of pages = " + this.getPages();
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
}
