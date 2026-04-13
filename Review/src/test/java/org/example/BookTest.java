package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    private Book book;
    /*
        The variable below was introduced to prevent the Markdown editor from
        truncating the text.
    */
    String message;

    @BeforeEach
    public void setUp() {
        book = new Book("Pride and Prejudice", "Jane Austin", 480);
    }

    @Test
    public void testBookNullValueForAuthorInConstructor() {
        NullPointerException thrown = assertThrows(
                NullPointerException.class,
                () -> new Book("Heart of Darkness", null, 300)
        );
        assertEquals("Null value assigned to author", thrown.getMessage());
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
    public void testBookNullValueForTitleInConstructor() {
        NullPointerException thrown = assertThrows(
                NullPointerException.class,
                () -> new Book(null, "Heart of Darkness", 150)
        );
        assertEquals("Null value assigned to title", thrown.getMessage());
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
