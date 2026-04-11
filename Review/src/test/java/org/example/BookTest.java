package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    private Book book;

    @BeforeEach
    public void setUp() {
        book = new Book("Pride and Prejudice", "Jane Austin", 480);
    }

    @Test
    public void testBookGetAndSetAuthor() {
        assertEquals("Jane Austin", book.getAuthor());
        book.setAuthor("Robert Lewis Stevenson");
        assertEquals("Robert Lewis Stevenson", book.getAuthor());
    }

    @Test
    public void testBookNullValueForSetAuthor() {
        NullPointerException thrown = assertThrows(
                NullPointerException.class,
                () -> book.setAuthor(null)
        );
        assertEquals("Null value assigned to author", thrown.getMessage());
    }

    @Test
    public void testBookNullValueForAuthorInConstructor() {
        NullPointerException thrown = assertThrows(
                NullPointerException.class,
                () -> new Book("Joseph Conrad", null, 300)
        );
        assertEquals("Null value assigned to author", thrown.getMessage());
    }

    @Test
    public void testBookGetAndSetPages() {
        assertEquals(480, book.getPages());
        book.setPages(500);
        assertEquals(500, book.getPages());
    }

    @Test
    public void testBookNegativeEntryForSetPages() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> book.setPages(-10)
        );
        assertEquals("Assigned pages to book less than zero", thrown.getMessage());
    }

    @Test
    public void testBookNegativeEntryForPagesInConstructor() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Book("Heart of Darkness", "Joseph Conrad", -1)
        );
        assertEquals("Assigned pages to book less than zero", thrown.getMessage());
    }

    @Test
    public void testBookGetAndSetTitle() {
        assertEquals("Pride and Prejudice", book.getTitle());
        book.setTitle("Treasure Island");
        assertEquals("Treasure Island", book.getTitle());
    }

    @Test
    public void testBookNullValueForSetTitle() {
        NullPointerException thrown = assertThrows(
                NullPointerException.class,
                () -> book.setTitle(null)
        );
        assertEquals("Null value assigned to title", thrown.getMessage());
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
        var expectedToString = "Title = Pride and Prejudice, Author = Jane Austin, Number of pages = 480";
        var actualToString = book.toString();

        assertEquals(expectedToString, actualToString);
    }
}
