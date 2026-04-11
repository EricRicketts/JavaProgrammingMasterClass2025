package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BookTest {

    private Book book;
    private String[] expected, results;

    @BeforeEach
    public void setUp() {
        book = new Book("Pride and Prejudice", "Jane Austin", 480);
    }

    @Test
    public void testGetAndSetTitle() {
        expected = new String[]{"Pride and Prejudice", "Treasure Island"};
        var firstTitle = book.getTitle();
        book.setTitle("Treasure Island");
        var secondTitle = book.getTitle();
        results = new String[]{firstTitle, secondTitle};

        assertArrayEquals(expected, results);
    }

}
