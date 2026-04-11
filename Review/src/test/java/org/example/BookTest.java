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
    public void testExpectedExceptionNullValueForSetAuthor() {
        NullPointerException thrown = assertThrows(
                NullPointerException.class,
                () -> book.setAuthor(null)
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
    public void testBookNegativeEntryForPages() {
        book.setPages(-10);
        assertEquals(480, book.getPages());
    }

    @Test
    public void testBookGetAndSetTitle() {
        assertEquals("Pride and Prejudice", book.getTitle());
        book.setTitle("Treasure Island");
        assertEquals("Treasure Island", book.getTitle());
    }

    @Test
    public void testNullValueForSetTitle() {
        book.setTitle(null);
        assertEquals("Pride and Prejudice", book.getTitle());
    }

    @Test
    public void testBookToString() {
        var expectedToString = "Title = Pride and Prejudice, Author = Jane Austin, Number of pages = 480";
        var actualToString = book.toString();

        assertEquals(expectedToString, actualToString);
    }
}
