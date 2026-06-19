package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    private Book book;

    private final static String TEST_AUTHOR = "Jane Austen";

    private final static String TEST_TITLE = "Pride and Prejudice";

    private final static int TEST_PAGES = 480;

    private final static String AUTHOR = "Joseph Conrad";

    private final static String TITLE = "Heart of Darkness";

    private final static int PAGES = 300;

    private final static String AUTHOR_LITERAL = "author";

    private final static String TITLE_LITERAL = "title";

    private final static String PAGES_LITERAL = "pages";

    @BeforeEach
    public void setUp() {
        book = new Book("Pride and Prejudice", "Jane Austen", 480);
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
                new Book(TEST_TITLE, TEST_AUTHOR, TEST_PAGES);
            Book secondBook =
                new Book(TEST_TITLE, TEST_AUTHOR, TEST_PAGES);

            assertEquals(firstBook, secondBook);
        }

        @Test
        public void testNonEqualBooks() {
            Book firstBook =
                new Book(TEST_TITLE, TEST_AUTHOR, TEST_PAGES);
            Book secondBook =
                new Book("Sense and Sensibility", TEST_AUTHOR, TEST_PAGES);

            assertNotEquals(firstBook, secondBook);
        }

        @Test
        public void testHashCodeForBook() {
            int firstHashCode =
                new Book(TEST_TITLE, TEST_AUTHOR, TEST_PAGES).hashCode();
            int secondHashCode =
                new Book(TEST_TITLE, TEST_AUTHOR, TEST_PAGES).hashCode();

            assertEquals(firstHashCode, secondHashCode);
        }
    }

    @Nested
    @DisplayName("test getters")
    class TestBookGetters {

        @Test
        public void testBookGetTitle() {
            assertEquals(
                TEST_TITLE,
                book.getTitle()
            );
        }

        @Test
        public void testBookGetAuthor() {
            assertEquals(
                TEST_AUTHOR,
                book.getAuthor()
            );
        }

        @Test
        public void testBookGetPages() {
            assertEquals(
                TEST_PAGES,
                book.getPages()
            );
        }
    }

    @Nested
    @DisplayName("test book title setter")
    class TestBookTitleSetter {

        @Test
        public void testSetBookTitle() {
            assertEquals(TEST_TITLE, book.getTitle());

            book.setTitle(TITLE);

            assertEquals(TITLE, book.getTitle());
        }

        @Test
        public void testBookTitleSetterRejectsNullValue() {
            assertEquals(TEST_TITLE, book.getTitle());

            NullPointerException nullPointerException =
                assertThrows(
                    NullPointerException.class,
                    () -> book.setTitle(null)
                );

            assertEquals(
                ErrorMessages.nullValue(TITLE_LITERAL),
                nullPointerException.getMessage()
            );

            assertEquals(TEST_TITLE, book.getTitle());
        }

        @Test
        public void testBookTitleSetterRejectsEmptyValue() {
            assertEquals(TEST_TITLE, book.getTitle());

            IllegalArgumentException illegalArgumentException =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> book.setTitle("")
                );

            assertEquals(
                ErrorMessages.emptyValue(TITLE_LITERAL),
                illegalArgumentException.getMessage()
            );

            assertEquals(TEST_TITLE, book.getTitle());
        }

        @Test
        public void testBookTitleSetterRejectsBlankValue() {
            assertEquals(TEST_TITLE, book.getTitle());

            IllegalArgumentException illegalArgumentException =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> book.setTitle("  ")
                );

            assertEquals(
                ErrorMessages.blankValue(TITLE_LITERAL),
                illegalArgumentException.getMessage()
            );

            assertEquals(TEST_TITLE, book.getTitle());
        }
    }

    @Nested
    @DisplayName("test book author setter")
    class TestBookAuthorSetter {

        @Test
        public void testSetBookAuthor() {
            assertEquals(TEST_AUTHOR, book.getAuthor());

            book.setAuthor(AUTHOR);

            assertEquals(AUTHOR, book.getAuthor());
        }

        @Test
        public void testBookTitleSetterRejectsNullValue() {
            assertEquals(TEST_AUTHOR, book.getAuthor());

            NullPointerException nullPointerException =
                assertThrows(
                    NullPointerException.class,
                    () -> book.setAuthor(null)
                );

            assertEquals(
                ErrorMessages.nullValue(AUTHOR_LITERAL),
                nullPointerException.getMessage()
            );

            assertEquals(TEST_AUTHOR, book.getAuthor());
        }

        @Test
        public void testBookAuthorSetterRejectsEmptyValue() {
            assertEquals(TEST_AUTHOR, book.getAuthor());

            IllegalArgumentException illegalArgumentException =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> book.setAuthor("")
                );

            assertEquals(
                ErrorMessages.emptyValue(AUTHOR_LITERAL),
                illegalArgumentException.getMessage()
            );

            assertEquals(TEST_AUTHOR, book.getAuthor());
        }

        @Test
        public void testBookAuthorSetterRejectsBlankValue() {
            assertEquals(TEST_AUTHOR, book.getAuthor());

            IllegalArgumentException illegalArgumentException =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> book.setAuthor("  ")
                );

            assertEquals(
                ErrorMessages.blankValue(AUTHOR_LITERAL),
                illegalArgumentException.getMessage()
            );

            assertEquals(TEST_AUTHOR, book.getAuthor());
        }
    }

    @Nested
    @DisplayName("test book pages setter")
    class TestBookPagesSetter {

        @Test
        public void testBookPagesSetter() {
            assertEquals(TEST_PAGES, book.getPages());

            book.setPages(PAGES);

            assertEquals(PAGES, book.getPages());
        }

        @Test
        public void testBookPagesSetterRejectsZeroPages() {
            assertEquals(TEST_PAGES, book.getPages());

            IllegalArgumentException illegalArgumentException =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> book.setPages(0)
                );

            assertEquals(
                ErrorMessages.zeroValue(PAGES_LITERAL),
                illegalArgumentException.getMessage()
            );

            assertEquals(TEST_PAGES, book.getPages());
        }

        @Test
        public void testBookPagesSetterRejectsNegativePages() {
            assertEquals(TEST_PAGES, book.getPages());

            IllegalArgumentException illegalArgumentException =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> book.setPages(-30)
                );

            assertEquals(
                ErrorMessages.negativeValue(PAGES_LITERAL),
                illegalArgumentException.getMessage()
            );

            assertEquals(TEST_PAGES, book.getPages());
        }
    }

    @Nested
    @DisplayName("test book toString")
    class TestBookToString {

        @Test
        public void testBookToString() {
            String bookInformation = book.toString();

            assertTrue(bookInformation.contains("Pride and Prejudice"));
            assertTrue(bookInformation.contains("Jane Austen"));
            assertTrue(bookInformation.contains("480"));
        }
    }
}
