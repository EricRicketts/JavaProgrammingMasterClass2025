package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    private Book book;
    String message;

    private final static String author = "Joseph Conrad";

    private final static String title = "Heart of Darkness";

    private final static int pages = 300;

    @BeforeEach
    public void setUp() {
        book = new Book("Pride and Prejudice", "Jane Austin", 480);
    }

    @Nested
    @DisplayName("Title checks")
    class TitleChecks {

        @Test
        public void testBookNullValueForTitleInConstructor() {
            assertEquals(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_TITLE.getErrorMessage(),
                    assertThrows(
                            NullPointerException.class,
                            () -> new Book(null, author, pages)
                    ).getMessage()
            );
        }

        @Test
        public void testBookEmptyValueForTitleInConstructor() {
            assertEquals(
                    ErrorMessages.EMPTY_VALUE_MESSAGE_FOR_TITLE.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Book("", author, pages)
                    ).getMessage()
            );
        }

        @Test
        public void testBookBlankValueForTitleInConstructor() {
            assertEquals(
                    ErrorMessages.BLANK_VALUE_MESSAGE_FOR_TITLE.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Book("   ", author, pages)
                    ).getMessage()
            );
        }
    }

    @Nested
    @DisplayName("Author checks")
    class AuthorChecks {

        @Test
        public void testBookNullValueForAuthorInConstructor() {
            assertEquals(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_AUTHOR.getErrorMessage(),
                    assertThrows(
                            NullPointerException.class,
                            () -> new Book(title, null, pages)
                    ).getMessage()
            );
        }

        @Test
        public void testBookEmptyValueForAuthorInConstructor() {
            assertEquals(
                    ErrorMessages.EMPTY_VALUE_MESSAGE_FOR_AUTHOR.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Book(title, "", pages)
                    ).getMessage()
            );
        }

        @Test
        public void testBookBlankValueForAuthorInConstructor() {
            assertEquals(
                    ErrorMessages.BLANK_VALUE_MESSAGE_FOR_AUTHOR.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Book(title, "  ", pages)
                    ).getMessage()
            );
        }
    }

    @Test
    public void testBookNegativeEntryForPagesInConstructor() {
        message = "Number of pages assigned to book is less than zero";
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Book("Heart of Darkness", "Joseph Conrad", -1)
        );
        assertEquals(message, thrown.getMessage());
    }


    @Test
    public void testBookToString() {
        message =
            "Title = Pride and Prejudice, Author = Jane Austin, Number of pages = 480";
        var expectedToString = message;
        var actualToString = book.toString();

        assertEquals(expectedToString, actualToString);
    }
}
