package org.example;

public record Book(String title, String author, int pages) {

    public Book(String title, String author, int pages) {
        this.title = validateTitleAndReturn(title);
        this.author = validateAuthorAndReturn(author);
        this.pages = validatePagesAndReturn(pages);
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
