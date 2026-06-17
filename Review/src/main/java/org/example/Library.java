package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Library {

    private static final String EMPTY_LIBRARY =
        "No books can be removed from an empty library.";

    private static final String NULL_LIBRARY =
        "A null value is not allowed for a library's list of books.";

    private static final String EMPTY_LIST_OF_BOOKS =
        "The initial list of books for a library must have at least one book.";

    private static final String NULL_BOOK_IN_LIBRARY =
        "A null value for a book is not allowed in a library.";

    private static final String BOOK_NOT_FOUND =
        "No book with the given title exists in this library";

    private static final String REMOVE_NULL_VALUE =
        "Attempting to remove a book of null value is not allowed.";

    private static final String REMOVE_EMPTY_VALUE =
        "Attempting to remove a book of empty value is not allowed.";

    private static final String REMOVE_BLANK_VALUE =
        "Attempting to remove a book of blank value is not allowed.";

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
        String validTitle = validateTitleNotNullEmptyOrBlank(title);
        validateLibraryIsNotEmpty(books);

        int indexOfBook = findBook(validTitle);
        if (indexOfBook == -1) {
            throw new NoSuchElementException(BOOK_NOT_FOUND);
        }
        return books.remove(indexOfBook);
    }

    private List<Book> validateBooksNotNull(List<Book> books) {
        if (books == null) {
            throw new NullPointerException(NULL_LIBRARY);
        }

        return books;
    }

    private List<Book> validateBooksNotEmpty(List<Book> books) {
        List<Book> nonNullBooks = validateBooksNotNull(books);

        if (nonNullBooks.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_LIST_OF_BOOKS);
        }

        return nonNullBooks;
    }

    private List<Book> validateBooksNotBlank(List<Book> books) {
        List<Book> nonEmptyBooks = validateBooksNotEmpty(books);

        if(nonEmptyBooks.stream().anyMatch(Objects::isNull)) {
            throw new NullPointerException(NULL_BOOK_IN_LIBRARY);
        }

        return nonEmptyBooks;
    }

    private String validateTitleNotNullEmptyOrBlank(String title) {
        if (title == null) {
            throw new NullPointerException(REMOVE_NULL_VALUE);
        } else if (title.isEmpty()) {
            throw new IllegalArgumentException(REMOVE_EMPTY_VALUE);
        } else if (title.isBlank()) {
            throw new IllegalArgumentException(REMOVE_BLANK_VALUE);
        } else {
            return title;
        }
    }

    private void validateLibraryIsNotEmpty(List<Book> books) {
        if (books.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_LIBRARY);
        }
    }
    private int findBook(String title) {
        for (int index = 0; index < books.size(); index++) {
            Book currentBook = books.get(index);

            if(Objects.equals(currentBook.title(), title)) {
                return index;
            }
        }
        return -1;
    }
}
