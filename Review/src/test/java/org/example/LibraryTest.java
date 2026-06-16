package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTest {

    List<Book> books;

    Library library;

    @BeforeEach
    public void setUp() {
        books = Arrays.asList(
            new Book("Sense and Sensibility", "Jane Austen", 304),
            new Book("Pride and Prejudice", "Jane Austen", 320),
            new Book("Mansfield Park", "Jane Austen", 520)
        );
        library = new Library(books);
    }

    @Nested
    @DisplayName("test features of books in library")
    class TestBookFeatures {

        @Test
        public void testBookTitles() {
            List<String> expectedTitles = Arrays.asList(
                "Sense and Sensibility",
                "Pride and Prejudice",
                "Mansfield Park"
            );

            books = library.getBooks();

            for (int index = 0; index < books.size(); index++) {
                String expectedTitle = expectedTitles.get(index);
                Book book = books.get(index);

                assertEquals(expectedTitle, book.title());
            }
        }

        @Test
        public void testBookAuthors() {
            String expectedAuthor = "Jane Austen";

            books = library.getBooks();

            for (Book book : books) {
                assertEquals(expectedAuthor, book.author());
            }
        }

        @Test
        public void testBookPages() {
            List<Integer> expectedPages = Arrays.asList(304, 320, 520);

            for(int index = 0; index < books.size(); index++) {
                Book book = books.get(index);
                Integer pages = expectedPages.get(index);

                assertEquals(pages, book.pages());
            }
        }
    }
}
