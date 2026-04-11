package org.example;

public class Book {

    private final String title, author;
    private final int pages;

    public Book(String title, String author, int pages) {
        this.validateNotNull(author, title);
        this.author = author;
        this.title = title;
        this.validatePages(pages);
        this.pages = pages;
    }

    // Getters and setters.

    public String getAuthor() {
        return this.author;
    }

    public int getPages() {
        return this.pages;
    }

    public String getTitle() {
        return this.title;
    }

    // Other methods.

    @Override
    public String toString() {

        return "Title = " + this.getTitle() + ", " +
                "Author = " + this.getAuthor() + ", " +
                "Number of pages = " + this.getPages();
    }

    private void validateNotNull(String author, String title) {
        if (author == null) {
            throw new NullPointerException("Null value assigned to author");
        }
        if (title == null) {
            throw new NullPointerException("Null value assigned to title");
        }
    }

    private void validatePages(int pages) {
        if (pages < 0) {
            throw new IllegalArgumentException("Number of pages assigned to book is less than zero");
        }
    }

}
