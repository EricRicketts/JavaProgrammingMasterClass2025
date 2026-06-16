package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    private Book book;

    private final static String author = "Joseph Conrad";

    private final static String title = "Heart of Darkness";

    private final static int pages = 300;

    private final static String authorLiteral = "author";

    private final static String titleLiteral = "title";

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
                    () -> new Book(null, author, pages)
                );

                assertEquals(
                    ErrorMessages.nullValue(titleLiteral),
                    nullPointerException.getMessage()
                );
        }

        @Test
        public void testBookEmptyValueForTitleInConstructor() {
            IllegalArgumentException illegalArgumentException =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> new Book("", author, pages)
                );

                assertEquals(
                    ErrorMessages.emptyValue(titleLiteral),
                    illegalArgumentException.getMessage()
                );
        }

        @Test
        public void testBookBlankValueForTitleInConstructor() {
            IllegalArgumentException illegalArgumentException =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> new Book("   ", author, pages)
                );

                assertEquals(
                    ErrorMessages.blankValue(titleLiteral),
                    illegalArgumentException.getMessage()
                );
            }
    }

    @Nested
    @DisplayName("Author checks")
    class AuthorChecks {

        @Test
        public void testBookNullValueForAuthorInConstructor() {
            assertEquals(
                ErrorMessages.nullValue(authorLiteral),
                assertThrows(
                    NullPointerException.class,
                    () -> new Book(title, null, pages)
                ).getMessage()
            );
        }

        @Test
        public void testBookEmptyValueForAuthorInConstructor() {
            assertEquals(
                ErrorMessages.emptyValue(authorLiteral),
                assertThrows(
                    IllegalArgumentException.class,
                    () -> new Book(title, "", pages)
                ).getMessage()
            );
        }

        @Test
        public void testBookBlankValueForAuthorInConstructor() {
            assertEquals(
                ErrorMessages.blankValue(authorLiteral),
                assertThrows(
                    IllegalArgumentException.class,
                    () -> new Book(title, "  ", pages)
                ).getMessage()
            );
        }
    }

    @Nested
    @DisplayName("Number of pages checks")
    class PagesChecks {

        @Test
        public void testBookNegativeValueForPagesInConstructor() {
            assertEquals(
                ErrorMessages.negativeValue("pages"),
                assertThrows(
                    IllegalArgumentException.class,
                    () -> new Book(title, author, -50)
                ).getMessage()
            );
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
