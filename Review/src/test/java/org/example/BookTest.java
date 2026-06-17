package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    private Book book;

    private final static String AUTHOR = "Joseph Conrad";

    private final static String TITLE = "Heart of Darkness";

    private final static int PAGES = 300;

    private final static String AUTHOR_LITERAL = "author";

    private final static String TITLE_LITERAL = "title";

    private final static String PAGES_LITERAL = "pages";

    @BeforeEach
    public void setUp() {
        book = new Book("Pride and Prejudice", "Jane Austin", 480);
    }

    @Nested
    @DisplayName("Title checks")
    class TitleChecks {

        @Test
        public void testBookNullValueForTitleInConstructor() {
            NullPointerException nullPointerException =
                assertThrows(
                    NullPointerException.class,
                    () -> new Book(null, AUTHOR, PAGES)
                );

                assertEquals(
                    ErrorMessages.nullValue(TITLE_LITERAL),
                    nullPointerException.getMessage()
                );
        }

        @Test
        public void testBookEmptyValueForTitleInConstructor() {
            IllegalArgumentException illegalArgumentException =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> new Book("", AUTHOR, PAGES)
                );

                assertEquals(
                    ErrorMessages.emptyValue(TITLE_LITERAL),
                    illegalArgumentException.getMessage()
                );
        }

        @Test
        public void testBookBlankValueForTitleInConstructor() {
            IllegalArgumentException illegalArgumentException =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> new Book("   ", AUTHOR, PAGES)
                );

                assertEquals(
                    ErrorMessages.blankValue(TITLE_LITERAL),
                    illegalArgumentException.getMessage()
                );
            }
    }

    @Nested
    @DisplayName("Author checks")
    class AuthorChecks {

        @Test
        public void testBookNullValueForAuthorInConstructor() {
            NullPointerException nullPointerException =
                assertThrows(
                    NullPointerException.class,
                    () -> new Book(TITLE, null, PAGES)
                );

                assertEquals(
                    ErrorMessages.nullValue(AUTHOR_LITERAL),
                    nullPointerException.getMessage()
                );
        }

        @Test
        public void testBookEmptyValueForAuthorInConstructor() {
            IllegalArgumentException illegalArgumentException =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> new Book(TITLE, "", PAGES)
                );

                assertEquals(
                    ErrorMessages.emptyValue(AUTHOR_LITERAL),
                    illegalArgumentException.getMessage()
                );
        }

        @Test
        public void testBookBlankValueForAuthorInConstructor() {
            IllegalArgumentException illegalArgumentException =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> new Book(TITLE, "  ", PAGES)
                );

                assertEquals(
                    ErrorMessages.blankValue(AUTHOR_LITERAL),
                    illegalArgumentException.getMessage()
                );
        }
    }

    @Nested
    @DisplayName("Number of pages checks")
    class PagesChecks {

        @Test
        public void testBookNegativeValueForPagesInConstructor() {
            IllegalArgumentException illegalArgumentException =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> new Book(TITLE, AUTHOR, -50)
                );

                assertEquals(
                    ErrorMessages.negativeValue(PAGES_LITERAL),
                    illegalArgumentException.getMessage()
                );
        }

        @Test
        public void testBookZeroValueForPagesInConstructor() {
            IllegalArgumentException illegalArgumentException =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> new Book(TITLE, AUTHOR, 0)
                );

            assertEquals(
                ErrorMessages.zeroValue(PAGES_LITERAL),
                illegalArgumentException.getMessage()
            );
        }
    }

    @Nested
    @DisplayName("test equal books")
    class TestEqualBooks {

        @Test
        public void testEqualBooks() {
            Book firstBook =
                new Book("Pride and Prejudice", "Jane Austin", 480);
            Book secondBook =
                new Book("Pride and Prejudice", "Jane Austin", 480);

            assertEquals(firstBook, secondBook);
        }

        @Test
        public void testNonEqualBooks() {
            Book firstBook =
                new Book("Pride and Prejudice", "Jane Austin", 480);
            Book secondBook =
                new Book("Sense and Sensibility", "Jane Austin", 304);

            assertNotEquals(firstBook, secondBook);
        }
    }

    @Nested
    @DisplayName("Getters and toString")
    class GetterAndToStringChecks {

        @Test
        public void testBookGetTitle() {
            assertEquals(
                "Pride and Prejudice",
                book.title()
            );
        }

        @Test
        public void testBookGetAuthor() {
            assertEquals(
                "Jane Austin",
                book.author()
            );
        }

        @Test
        public void testBookGetPages() {
            assertEquals(
                480,
                book.pages()
            );
        }

        @Test
        public void testBookToString() {
            String bookInformation = book.toString();

            assertTrue(bookInformation.contains("Pride and Prejudice"));
            assertTrue(bookInformation.contains("Jane Austin"));
            assertTrue(bookInformation.contains("480"));
        }
    }
}
