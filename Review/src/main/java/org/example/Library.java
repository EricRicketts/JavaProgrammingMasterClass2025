package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {

    private List<Book> books;

    public Library(List<Book> books) {
        this.books = new ArrayList<>(validateBooksNotBlank(books));
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        this.books.add(Objects.requireNonNull(book));
    }

    public Book removeBook(String title) {
        int indexOfBook = 0;
        for (Book book : books) {
            if (Objects.equals(title, book.title())) {
                indexOfBook = books.indexOf(book);
            }
        }
        return books.remove(indexOfBook);
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
