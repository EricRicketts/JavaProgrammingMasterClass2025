package org.example;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Book {

    private String title;

    private String author;

   private int pages;

    public Book(String title, String author, int pages) {
        this.title = validateTitleAndReturn(title);
        this.author = validateAuthorAndReturn(author);
        this.pages = validatePagesAndReturn(pages);
    }

    public Book() {
        this("Unknown Title", "Unknown Author", 0);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = validateTitleAndReturn(title);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = validateAuthorAndReturn(author);
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = validatePagesAndReturn(pages);
    }

    @Override
    @NotNull
    public String toString() {
        return "Book{title = " + title + " author = " + author + " pages = " + pages + "}";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (!(object instanceof Book)) return false;
        return (Objects.equals(this.title, ((Book) object).getTitle()) &&
            Objects.equals(this.author, ((Book) object).getAuthor()) &&
            this.pages == ((Book) object).getPages());
    }
    private static String validateAuthorAndReturn(String author) {
        return ValueValidator.validateTextAndReturn(author, "author");
    }

    private static int validatePagesAndReturn(int pages) {
        return ValueValidator.validatePositiveIntAndReturn(pages, "pages");
    }

    private static String validateTitleAndReturn(String title) {
        return ValueValidator.validateTextAndReturn(title, "title");
    }
}
