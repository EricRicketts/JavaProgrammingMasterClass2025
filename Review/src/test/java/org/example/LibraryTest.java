package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    private static final String REMOVE_NULL_VALUE =
        "Attempting to remove a book of null value is not allowed.";

    private static final String REMOVE_EMPTY_VALUE =
        "Attempting to remove a book of empty value is not allowed.";

    private static final String REMOVE_BLANK_VALUE =
        "Attempting to remove a book of blank value is not allowed.";

    private static final String BOOK_NOT_FOUND =
        "No book with the given title exists in this library";

    private static final String NULL_BOOK_IN_LIBRARY =
        "A null value for a book is not allowed in a library.";

    private static final String AUTHOR = "Jane Austen";

    private static final String BOOK_TITLE = "Persuasion";

    private static final String NEXT_BOOK_TITLE = "Emma";

    private static final int BOOK_PAGES = 208;

    private static final int NEXT_BOOK_PAGES = 400;

    private static final String REMOVED_BOOK_TITLE = "Pride and Prejudice";

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
    @DisplayName("test error checks when adding a book to the library")
    class ErrorChecksAddBookToLibrary {

        @Test
        public void testLibraryRejectsAddingANullBookValue() {
            NullPointerException nullPointerException =
                assertThrows(
                    NullPointerException.class,
                    () -> library.addBook(null)
                );

            assertEquals(NULL_BOOK_IN_LIBRARY, nullPointerException.getMessage());
        }
    }

    @Nested
    @DisplayName("test add book to library")
    class AddBookToLibrary {

        @Test
        public void testAddNewBookInstanceToLibraryIncreasesBookCountByOne() {
            int expectedBookCount = 3;
            assertEquals(expectedBookCount, library.getBooks().size());

            library.addBook(new Book(BOOK_TITLE, AUTHOR, BOOK_PAGES));

            assertEquals(expectedBookCount + 1, library.getBooks().size());
        }

        @Test
        public void testAddNewBookInstanceToLibraryPlacesBookAtEndOfLibrary() {
            library.addBook(new Book(BOOK_TITLE, AUTHOR, BOOK_PAGES));

            Book book = library.getBooks().getLast();

            assertEquals(BOOK_TITLE, book.getTitle());
            assertEquals(AUTHOR, book.getAuthor());
            assertEquals(BOOK_PAGES, book.getPages());
        }
    }

    @Nested
    @DisplayName("test error checking when removing a book from the library")
    class ErrorChecksRemoveBookFromLibrary {

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
        public void testRemoveNonExistentBookFromLibraryReturnsException() {
            NoSuchElementException noSuchElementException =
                assertThrows(
                    NoSuchElementException.class,
                    () -> library.removeBook("Heart of Darkness")
                );

            assertEquals(
                BOOK_NOT_FOUND,
                noSuchElementException.getMessage()
            );
        }
    }

    @Nested
    @DisplayName("test remove book from library")
    class RemoveBookFromLibrary {

        @Test
        public void testRemoveBookFromLibraryReturnsRemovedBook() {
            Book expectedBook =
                new Book(REMOVED_BOOK_TITLE, AUTHOR, 320);

            Book removedBook = library.removeBook(REMOVED_BOOK_TITLE);

            assertEquals(expectedBook, removedBook);
        }

        @Test
        public void testRemoveBookFromLibraryDecreasesBooksInLibraryByOne() {
            int expectedNumberOfBooks = 3;
            assertEquals(expectedNumberOfBooks, library.getBooks().size());

            library.removeBook(REMOVED_BOOK_TITLE);

            assertEquals(expectedNumberOfBooks - 1, library.getBooks().size());
        }

        @Test
        public void testRemoveBookFromLibraryShiftsFollowingElementsLeft() {
            library.addBook(new Book(BOOK_TITLE, AUTHOR, BOOK_PAGES));
            library.addBook(new Book(NEXT_BOOK_TITLE, AUTHOR, NEXT_BOOK_PAGES));

            assertEquals(5, library.getBooks().size());
            assertEquals(
                new Book(BOOK_TITLE, AUTHOR, BOOK_PAGES),
                library.getBooks().get(3)
            );
            assertEquals(
                new Book(NEXT_BOOK_TITLE, AUTHOR, NEXT_BOOK_PAGES),
                library.getBooks().get(4)
            );

            library.removeBook("Mansfield Park");

            assertEquals(4, library.getBooks().size());
            assertEquals(
                new Book(BOOK_TITLE, AUTHOR, BOOK_PAGES),
                library.getBooks().get(2)
            );
            assertEquals(
                new Book(NEXT_BOOK_TITLE, AUTHOR, NEXT_BOOK_PAGES),
                library.getBooks().get(3)
            );
        }
    }

    @Nested
    @DisplayName("test library toString")
    class LibraryToString {

        @Test
        public void testLibraryToString() {
            String libraryInformation = library.toString();

            for (Book book : books) {
                assertTrue(libraryInformation.contains(book.getTitle()));
                assertTrue(libraryInformation.contains(book.getAuthor()));
                assertTrue(libraryInformation.contains(String.valueOf(book.getPages())));
            }
        }
    }

    @Nested
    @DisplayName("constructor tests")
    class LibraryConstructorTests {

        @Test
        public void testLibraryConstructorRejectsNullValue() {
            assertThrows(
                NullPointerException.class,
                () -> new Library(null)
            );
        }

        @Test
        public void testLibraryConstructorRejectsEmptyValue() {
            assertThrows(
                IllegalArgumentException.class,
                () -> new Library(List.of())
            );
        }

        @Test
        public void testLibraryConstructorRejectsANullBookInTheList() {
            assertThrows(
                IllegalArgumentException.class,
                () -> new Library(Arrays.asList(new Book(), null))
            );
        }
    }

    @Nested
    @DisplayName("encapsulation and defensive copy test")
    class TestEncapsulationAndDefensiveCopy {

        @Test
        public void testChangesToCopiedBookListDoesNotAlterLibraryBookList() {
            List<Book> originalBooks = new ArrayList<>();
            originalBooks.add(new Book("Book One", "Author One", 100));

            Library library = new Library(originalBooks);

            originalBooks.add(new Book("Book Two", "Author Two", 200));
            assertEquals(1, library.getBooks().size());
        }

        @Test
        public void testLibraryBookListIsImmutable() {
            assertEquals(3, library.getBooks().size());

            UnsupportedOperationException unsupportedOperationException =
                assertThrows(
                    UnsupportedOperationException.class,
                    () -> library.getBooks().clear()
                );

            assertNull(unsupportedOperationException.getMessage());

            assertEquals(3, library.getBooks().size());
        }
    }
}
