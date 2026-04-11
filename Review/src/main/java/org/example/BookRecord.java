package org.example;

import java.util.Objects;

public record BookRecord(String title, String author, int pages) {

    public BookRecord(String title, String author, int pages) {
        this.title = this.validateTitleAndReturn(title);
        this.author = author;
        this.pages = pages;
    }

    private String validateTitleAndReturn(String title) {
        return Objects.requireNonNull(title, "Null value assigned to title");
    }
}
