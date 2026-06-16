package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {

    private List<Book> books;

    public Library(List<Book> books) {
        this.books = validateBooksNotBlank(books);
    }

    public List<Book> getBooks() {
        return books;
    }

    private List<Book> validateBooksNotNull(List<Book> books) {
        if (books == null) {
            throw new NullPointerException();
        }

        return books;
    }

    private List<Book> validateBooksNotEmpty(List<Book> books) {
        List<Book> nonNullBooks = validateBooksNotNull(books);

        if (nonNullBooks.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return nonNullBooks;
    }

    private List<Book> validateBooksNotBlank(List<Book> books) {
        List<Book> nonEmptyBooks = validateBooksNotEmpty(books);

        if(nonEmptyBooks.stream().anyMatch(Objects::isNull)) {
            throw new NullPointerException();
        }

        return nonEmptyBooks;
    }
}
