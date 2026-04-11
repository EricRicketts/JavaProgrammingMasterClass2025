package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookRecordTest {

    private BookRecord bookRecord;

    private NullPointerException thrown;

    @BeforeEach
    public void setUp() {
        bookRecord = new BookRecord("Oliver Twist", "Charles Dickens", 608);
    }

    @Test
    public void testBookRecordNullValueForAuthorInConstructor() {
        thrown = assertThrows(
                NullPointerException.class,
                () -> new BookRecord("Oliver Twist", null, 608)
        );
        assertEquals("Null value assigned to author", thrown.getMessage());
    }

    @Test
    public void testBookRecordNegativeEntryForPagesInConstructor() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new BookRecord("Oliver Twist", "Charles Dickens", -1)
        );
        assertEquals("Number of pages assigned to book is less than zero", thrown.getMessage());
    }

    @Test
    public void testBookRecordNullValueForTitleInConstructor() {
        thrown = assertThrows(
                NullPointerException.class,
                () -> new BookRecord(null, "Charles Dickens", 608)
        );
        assertEquals("Null value assigned to title", thrown.getMessage());
    }
}
