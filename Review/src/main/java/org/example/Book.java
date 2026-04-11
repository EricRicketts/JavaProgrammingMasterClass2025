package org.example;

import java.util.Objects;

public class Book {

    private String title, author;
    private int pages;

    public Book(String title, String author, int pages) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPages(pages);
    }

    // Getters and setters.

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        if (author == null) {
            throw new NullPointerException("Null value assigned to author");
        }
        this.author = author;
    }

    public int getPages() {
        return this.pages;
    }

    public void setPages(int pages) {
        if (pages < 0) {
            throw new IllegalArgumentException("Assigned pages to book less than zero");
        }
        this.pages = pages;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        if (title == null) {
            throw new NullPointerException("Null value assigned to title");
        }
        this.title = title;
    }

    // Other methods.

    @Override
    public String toString() {

        return "Title = " + this.getTitle() + ", " +
                "Author = " + this.getAuthor() + ", " +
                "Number of pages = " + this.getPages();
    }

}
