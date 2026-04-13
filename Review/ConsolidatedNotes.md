### Final Code
```java
package org.example;

import java.util.Objects;

public class Book {

    private final String title, author;
    private final int pages;

    public Book(String title, String author, int pages) {
        this.title = this.validateTitleAndReturn(title);
        this.author = this.validateAuthorAndReturn(author);
        this.pages = this.validatePagesAndReturn(pages);
    }

    public String getAuthor() {
        return this.author;
    }

    public int getPages() {
        return this.pages;
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public String toString() {

        return "Title = " + this.getTitle() + ", " +
                "Author = " + this.getAuthor() + ", " +
                "Number of pages = " + this.getPages();
    }

    private String validateAuthorAndReturn(String author) {
        return Objects.requireNonNull(author, "Null value assigned to author");
    }

    private int validatePagesAndReturn(int pages) {
        // This message was introduced so the markdown viewer does not truncate text
        String message = "Number of pages assigned to book is less than zero";
        if (pages < 0) {
            throw new IllegalArgumentException(message);
        }
        return pages;
    }

    private String validateTitleAndReturn(String title) {
        return Objects.requireNonNull(title, "Null value assigned to title");
    }
}
```
```java
package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    private Book book;
    /*
        The variable below was introduced to prevent the Markdown editor from
        truncating the text.
    */
    String message;

    @BeforeEach
    public void setUp() {
        book = new Book("Pride and Prejudice", "Jane Austin", 480);
    }

    @Test
    public void testBookNullValueForAuthorInConstructor() {
        NullPointerException thrown = assertThrows(
                NullPointerException.class,
                () -> new Book("Heart of Darkness", null, 300)
        );
        assertEquals("Null value assigned to author", thrown.getMessage());
    }

    @Test
    public void testBookNegativeEntryForPagesInConstructor() {
        message = "Number of pages assigned to book is less than zero";
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Book("Heart of Darkness", "Joseph Conrad", -1)
        );
        assertEquals(message, thrown.getMessage());
    }

    @Test
    public void testBookNullValueForTitleInConstructor() {
        NullPointerException thrown = assertThrows(
                NullPointerException.class,
                () -> new Book(null, "Heart of Darkness", 150)
        );
        assertEquals("Null value assigned to title", thrown.getMessage());
    }

    @Test
    public void testBookToString() {
        message =
            "Title = Pride and Prejudice, Author = Jane Austin, Number of pages = 480";
        var expectedToString = message;
        var actualToString = book.toString();

        assertEquals(expectedToString, actualToString);
    }
}
```
```java
package org.example;

import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public record BookRecord(String title, String author, int pages) {

    public BookRecord(String title, String author, int pages) {
        this.title = Objects.requireNonNull(title, "Null value assigned to title");
        this.author = Objects.requireNonNull(author, "Null value assigned to author");
        // This message was introduced so the markdown editor does not truncate the text.
        String message = "Number of pages assigned to book is less than zero";
        if (pages < 0) {
            throw new IllegalArgumentException(message);
        } else {
            this.pages = pages;
        }
    }

    @Override
    @NotNull
    public String toString() {
        return
                "Title = " + this.title() + ", " +
                "Author = " + this.author() + ", " +
                "Number of pages = " + this.pages();
    }
}
```
```java
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
```

