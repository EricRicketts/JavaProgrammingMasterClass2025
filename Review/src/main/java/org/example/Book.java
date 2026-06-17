package org.example;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public record Book(String title, String author, int pages) {

    public Book(String title, String author, int pages) {
        this.title = validateTitleAndReturn(title);
        this.author = validateAuthorAndReturn(author);
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
        return (Objects.equals(this.title, ((Book) object).title()) &&
            Objects.equals(this.author, ((Book) object).author()) &&
            this.pages == ((Book) object).pages());
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
