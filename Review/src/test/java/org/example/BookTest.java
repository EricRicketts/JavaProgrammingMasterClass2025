package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    private Book book;
    private String[] expected, results;

    @BeforeEach
    public void setUp() {
        book = new Book("Pride and Prejudice", "Jane Austin", 480);
    }

    @Test
    public void testBookGetAndSetTitle() {
        expected = new String[]{"Pride and Prejudice", "Treasure Island"};
        var firstTitle = book.getTitle();
        book.setTitle("Treasure Island");
        var secondTitle = book.getTitle();
        results = new String[]{firstTitle, secondTitle};

        assertArrayEquals(expected, results);
    }

    @Test
    public void testBookGetAndSetAuthor() {
        expected = new String[]{"Jane Austin", "Robert Lewis Stevenson"};
        var firstAuthor = book.getAuthor();
        book.setAuthor("Robert Lewis Stevenson");
        var secondAuthor = book.getAuthor();
        results = new String[]{firstAuthor, secondAuthor};

        assertArrayEquals(expected, results);
    }

    @Test
    public void testBookGetAndSetPages() {
        int[] expectedPages = new int[]{480, 500};
        var firstNumberOfPages = book.getPages();
        book.setPages(500);
        var secondNumberOfPages = book.getPages();
        int[] actualPages = new int[]{firstNumberOfPages, secondNumberOfPages};

        assertArrayEquals(expectedPages, actualPages);
    }

    @Test
    public void testBookToString() {
        var expectedToString = "Title = Pride and Prejudice, Author = Jane Austin, Number of pages = 480";
        var actualToString = book.toString();

        assertEquals(expectedToString, actualToString);
    }
}
