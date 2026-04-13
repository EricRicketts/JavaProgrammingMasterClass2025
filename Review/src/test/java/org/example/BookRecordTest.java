package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookRecordTest {

    private BookRecord bookRecord;
    /*
        The variable below was introduced so that the markdown application would not
        truncate any text.
    */
    String message;

    @BeforeEach
    public void setUp() {
        bookRecord = new BookRecord("Oliver Twist", "Charles Dickens", 608);
    }

    @Test
    public void testBookRecordNullValueForAuthorInConstructor() {
        NullPointerException thrown = assertThrows(
                NullPointerException.class,
                () -> new BookRecord("Oliver Twist", null, 608)
        );
        assertEquals("Null value assigned to author", thrown.getMessage());
    }

    @Test
    public void testBookRecordNegativeEntryForPagesInConstructor() {
        message = "Number of pages assigned to book is less than zero";
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new BookRecord("Oliver Twist", "Charles Dickens", -1)
        );
        assertEquals(message, thrown.getMessage());
    }

    @Test
    public void testBookRecordNullValueForTitleInConstructor() {
        NullPointerException thrown = assertThrows(
                NullPointerException.class,
                () -> new BookRecord(null, "Charles Dickens", 608)
        );
        assertEquals("Null value assigned to title", thrown.getMessage());
    }

    @Test
    public void testBookRecordToString() {
        String expected =
            "Title = Oliver Twist, Author = Charles Dickens, Number of pages = 608";
        String result = bookRecord.toString();
        assertEquals(expected, result);
    }
}
