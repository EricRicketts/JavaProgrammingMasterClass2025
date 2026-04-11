package org.example;

public class Book {

    private final String title, author;
    private final int pages;

    public Book(String title, String author, int pages) {
        this.nullValueCheck(title);
        this.title = title;
        this.nullValueCheck(author);
        this.author = author;
        this.lessThanZeroPagesCheck(pages);
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

    private void nullValueCheck(String authorOrTitle) {
        if (authorOrTitle == null) {
            throw new NullPointerException("Null value assigned to author or title");
        }
    }

    private void lessThanZeroPagesCheck(int pages) {
        if (pages < 0) {
            throw new IllegalArgumentException("Number of pages assigned to book is less than zero");
        }
    }

}
