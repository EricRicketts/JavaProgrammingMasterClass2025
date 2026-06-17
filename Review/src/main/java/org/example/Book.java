package org.example;

import java.util.Objects;

public record Book(String title, String author, int pages) {

    public Book(String title, String author, int pages) {
        this.title = validateTitleAndReturn(title);
        this.author = validateAuthorAndReturn(author);
        this.pages = validatePagesAndReturn(pages);
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
