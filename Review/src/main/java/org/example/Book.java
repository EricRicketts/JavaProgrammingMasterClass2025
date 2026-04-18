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
        return ValueValidator.checkForNull(author, "Null value assigned to author");
    }

    private int validatePagesAndReturn(int pages) {
        String message = "Number of pages assigned to book is less than zero";
        return ValueValidator.checkForNegativeValue(pages, message);
    }

    private String validateTitleAndReturn(String title) {
        return ValueValidator.checkForNull(title, "Null value assigned to title");
    }
}
