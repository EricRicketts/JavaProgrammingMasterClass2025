package org.example;

import java.util.Objects;

public record BookRecord(String title, String author, int pages) {

    public BookRecord(String title, String author, int pages) {
        this.title = this.validateTitleAndReturn(title);
        this.author = this.validateAuthorAndReturn(author);
        this.pages = pages;
    }

    private String validateAuthorAndReturn(String author) {
        return Objects.requireNonNull(author, "Null value assigned to author");
    }
    private String validateTitleAndReturn(String title) {
        return Objects.requireNonNull(title, "Null value assigned to title");
    }
}
