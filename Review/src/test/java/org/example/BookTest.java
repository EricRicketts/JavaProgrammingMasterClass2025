package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    private Book book;
    String message;

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
                            () -> new Book(null, "Joseph Conrad", 300)
                    ).getMessage()
            );
        }
    }

    @Test
    public void testBookNullValueForAuthorInConstructor() {
        assertEquals(
                ErrorMessages.NULL_VALUE_MESSAGE_FOR_AUTHOR.getErrorMessage(),
                assertThrows(
                        NullPointerException.class,
                        () -> new Book("Heart of Darkness", null, 300)
                ).getMessage()
        );
    }

    @Test
    public void testBookEmptyValueForAuthorInConstructor() {

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
