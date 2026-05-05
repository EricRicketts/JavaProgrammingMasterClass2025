package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookRecordTest {

    private static final String author = "Charles Dickens";

    private static final String title = "Oliver Twist";

    private static final int pages = 608;

    private BookRecord bookRecord;

    @BeforeEach
    public void setUp() {
        bookRecord = new BookRecord("Oliver Twist", "Charles Dickens", 608);
    }

    @Nested
    @DisplayName("Title checks")
    class TitleChecks {

        @Test
        public void testBookRecordNullValueForTitleInConstructor() {
            assertEquals(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_TITLE.getErrorMessage(),
                    assertThrows(
                            NullPointerException.class,
                            () -> new BookRecord(null, author, pages)
                    ).getMessage()
            );
        }

        @Test
        public void testBookRecordEmptyValueForTitleInConstructor() {
            assertEquals(
                    ErrorMessages.EMPTY_VALUE_MESSAGE_FOR_TITLE.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new BookRecord("", author, pages)
                    ).getMessage()
            );
        }

        @Test
        public void testBookRecordBlankValueForTitleInConstructor() {
            assertEquals(
                    ErrorMessages.BLANK_VALUE_MESSAGE_FOR_TITLE.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new BookRecord("  ", author, pages)
                    ).getMessage()
            );
        }
    }

    @Nested
    @DisplayName("Author checks")
    class AuthorChecks {

        @Test
        public void testBookRecordNullValueForAuthorInConstructor() {
            assertEquals(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_AUTHOR.getErrorMessage(),
                    assertThrows(
                            NullPointerException.class,
                            () -> new BookRecord(title, null, pages)
                    ).getMessage()
            );
        }

        @Test
        public void testBookRecordEmptyValueForAuthorInConstructor() {
            assertEquals(
                    ErrorMessages.EMPTY_VALUE_MESSAGE_FOR_AUTHOR.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new BookRecord(title, "", pages)
                    ).getMessage()
            );
        }

        @Test
        public void testBookRecordBlankValueForAuthorInConstructor() {
            assertEquals(
                    ErrorMessages.BLANK_VALUE_MESSAGE_FOR_AUTHOR.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new BookRecord(title, "  ", pages)
                    ).getMessage()
            );
        }
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
        String message = "Number of pages assigned to book is less than zero";
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
