package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    private static final String REMOVE_NULL_VALUE =
        "Attempting to remove a book of null value is not allowed.";

    private static final String REMOVE_EMPTY_VALUE =
        "Attempting to remove a book of empty value is not allowed.";

    private static final String REMOVE_BLANK_VALUE =
        "Attempting to remove a book of blank value is not allowed.";

    List<Book> books;

    Library library;

    @BeforeEach
    public void setUp() {
        books = Arrays.asList(
            new Book("Sense and Sensibility", "Jane Austen", 304),
            new Book("Pride and Prejudice", "Jane Austen", 320),
            new Book("Mansfield Park", "Jane Austen", 520)
        );
        library = new Library(books);
    }

    @Nested
    @DisplayName("test features of books in library")
    class TestBookFeatures {

        @Test
        public void testBookTitles() {
            List<String> expectedTitles = Arrays.asList(
                "Sense and Sensibility",
                "Pride and Prejudice",
                "Mansfield Park"
            );

            books = library.getBooks();

            for (int index = 0; index < books.size(); index++) {
                String expectedTitle = expectedTitles.get(index);
                Book book = books.get(index);

                assertEquals(expectedTitle, book.title());
            }
        }

        @Test
        public void testBookAuthors() {
            String expectedAuthor = "Jane Austen";

            books = library.getBooks();

            for (Book book : books) {
                assertEquals(expectedAuthor, book.author());
            }
        }

        @Test
        public void testBookPages() {
            List<Integer> expectedPages = Arrays.asList(304, 320, 520);

            for(int index = 0; index < books.size(); index++) {
                Book book = books.get(index);
                Integer pages = expectedPages.get(index);

                assertEquals(pages, book.pages());
            }
        }
    }

    @Nested
    @DisplayName("test add a book to the library")
    class AddBookToLibrary {

        @Test
        public void testAddNewBookInstanceToLibraryIncreasesBookCountByOne() {
            int expectedBookCount = 3;
            assertEquals(expectedBookCount, books.size());

            library.addBook(new Book("Persuasion", "Jane Austen", 208));

            assertEquals(expectedBookCount + 1, library.getBooks().size());
        }

        @Test
        public void testAddNewBookInstanceToLibraryPlacesBookAtEndOfLibrary() {
            String expectedTitle = "Persuasion";
            String expectedAuthor = "Jane Austen";
            int expectedPages = 208;

            library.addBook(new Book("Persuasion", "Jane Austen", 208));

            Book book = library.getBooks().getLast();

            assertEquals(expectedTitle, book.title());
            assertEquals(expectedAuthor, book.author());
            assertEquals(expectedPages, book.pages());
        }

        @Test
        public void testLibraryRejectsAddingANullBookValue() {
            NullPointerException nullPointerException =
                assertThrows(
                    NullPointerException.class,
                    () -> library.addBook(null)
                );

            assertNull(nullPointerException.getMessage());
        }
    }

    @Nested
    @DisplayName("test remove a book from the library")
    class RemoveBookFromLibrary {

        @Test
        public void testLibraryRejectsRemovalOfNullBookTitle() {
            NullPointerException nullPointerException =
                assertThrows(
                    NullPointerException.class,
                    () -> library.removeBook(null)
                );

            assertEquals(
                REMOVE_NULL_VALUE,
                nullPointerException.getMessage()
            );
        }

        @Test
        public void testLibraryRejectsRemovalOfEmptyBookTitle() {
            IllegalArgumentException illegalArgumentException =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> library.removeBook("")
                );

            assertEquals(
                REMOVE_EMPTY_VALUE,
                illegalArgumentException.getMessage()
            );
        }

        @Test
        public void testLibraryRejectsRemovalOfBlankBookTitle() {
            IllegalArgumentException illegalArgumentException =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> library.removeBook("  ")
                );

            assertEquals(
                REMOVE_BLANK_VALUE,
                illegalArgumentException.getMessage()
            );
        }

        @Test
        public void testRemoveBookFromLibraryReturnsRemovedBook() {
            Book expectedBook =
                new Book("Pride and Prejudice", "Jane Austen", 320);

            Book removedBook = library.removeBook("Pride and Prejudice");

            assertEquals(expectedBook, removedBook);
        }

        @Test
        public void testRemoveBookFromLibraryDecreasesBooksInLibraryByOne() {
            int expectedNumberOfBooks = 3;
            assertEquals(expectedNumberOfBooks, library.getBooks().size());

            library.removeBook("Pride and Prejudice");

            assertEquals(expectedNumberOfBooks - 1, library.getBooks().size());
        }
    }
}
