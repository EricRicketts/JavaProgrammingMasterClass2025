# Java Learning Notebook

## 1) Lesson Info
- **Date: April 17, 2026**
- **Course section / lesson title: Review / Book class and BookRecord**
- **Topics covered:**
- **Difficulty level:** Easy / Medium / Hard

## 2) Main Idea in My Own Words
Write a short summary of what the lesson was about.

- **What did this lesson teach?**
- **What is the key takeaway?**

## 3) Important Concepts
List the main concepts and define them briefly.

- **Concept 1:**
- **Concept 2:**
- **Concept 3:**

## 4) Syntax / Rules I Should Remember
Write down anything you want to remember exactly.

- **Rule 1: Add @Override annotation to toString() method, this tells Java you intend to override the method from `Object`.**
- **Rule 2: Assert on values directly in your unit tests rather than storing them in arrays, this makes your tests more readable and intention revealing.  As a reminder, when I was considering making more than one assertion is a test, I would often put the exepectded and actual values in separate arrays and then assert on the arrays.  Below is how the AI suggested I should restructure my tests.**
    ```java
    assertEquals("Pride and Prejudice", book.getTitle());
    book.setTitle("Treasure Island");
    assertEquals("Treasure Island", book.getTitle());
    ```
- **Rule 3: Always consider whether setters should have validaton logic included.  This is usually a best practice.  An example would be checking for null values or any disallowed numeric values.**
- **Rule 4: As with consistent and descriptive naming of methods in a class, make sure the test method names are consistent and descriptive.**
- **Rule 5: One important general rule of thumb for constructors is that we want a valid object created as the result of the constructor call.  This strongly suggests putting field validation logic in the constructor.**
- **Rule 6: Most often these field validation methods are going to be private.**
- **Rule 7: Putting the validation logic in the setters keeps the validation logic in one place, with reuse in constructor validation.  This is called `Enapsulation with Guardrails`.**

## 5) Code I Rebuilt From Memory
- **Did I pause the video and recreate it myself?** Yes / No
- **What was easy?**
- **What was difficult?**
- **What did I have to look up?**

## 6) Tests I Wrote
- **What behavior did I test?**
- **What did I expect?**
- **Did the test pass?**
- **If not, what was wrong?**

## 7) Mistakes I Made
- **Mistake 1: I was not able to understand why why my test for passing a null value for the Book author's name did not throw an exception**
```java
@Test
    public void testNullValueForSetTitle() {
        book.setTitle(null);
        assertEquals("Pride and Prejudice", book.getTitle());
    }

public void setAuthor(String author) {
        try {
            this.author = Objects.requireNonNull(author);
        } catch (NullPointerException e) {
        }
    }

@Test
    public void testExpectedExceptionNullValueForSetAuthor() {
        NullPointerException thrown = assertThrows(
                NullPointerException.class,
                () -> book.setAuthor(null)
        );
        assertEquals("Null value assigned to author", thrown.getMessage());
    }

package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    private Book book;

    @BeforeEach
    public void setUp() {
        book = new Book("Pride and Prejudice", "Jane Austin", 480);
    }

    @Test
    public void testBookGetAndSetAuthor() {
        assertEquals("Jane Austin", book.getAuthor());
        book.setAuthor("Robert Lewis Stevenson");
        assertEquals("Robert Lewis Stevenson", book.getAuthor());
    }

    @Test
    public void testExpectedExceptionNullValueForSetAuthor() {
        NullPointerException thrown = assertThrows(
                NullPointerException.class,
                () -> book.setAuthor(null)
        );
        assertEquals("Null value assigned to author", thrown.getMessage());
    }

    @Test
    public void testBookGetAndSetPages() {
        assertEquals(480, book.getPages());
        book.setPages(500);
        assertEquals(500, book.getPages());
    }

    @Test
    public void testBookNegativeEntryForPages() {
        book.setPages(-10);
        assertEquals(480, book.getPages());
    }

    @Test
    public void testBookGetAndSetTitle() {
        assertEquals("Pride and Prejudice", book.getTitle());
        book.setTitle("Treasure Island");
        assertEquals("Treasure Island", book.getTitle());
    }

    @Test
    public void testNullValueForSetTitle() {
        book.setTitle(null);
        assertEquals("Pride and Prejudice", book.getTitle());
    }

    @Test
    public void testBookToString() {
        var expectedToString = "Title = Pride and Prejudice, Author = Jane Austin, Number of pages = 480";
        var actualToString = book.toString();

        assertEquals(expectedToString, actualToString);
    }
}
```
Assistant:
You’re very close — the reason is in your setAuthor() implementation:
```java
try {
    this.author = Objects.requireNonNull(author);
  } catch (NullPointerException e) {
}
```
## What’s happening

```Objects.requireNonNull(author)``` does throw a ```NullPointerException``` when ```author``` is ```null```.

But then your ```catch`` block immediately **catches it and swallows it**.

So from the test’s point of view, no exception escapes the method, which means:

* ```assertThrows(...)``` fails, because nothing is thrown outward
* the test cannot see the exception anymore

## In plain English

Your method is doing this:

1. null comes in
2. ```java requireNonNull(...)``` throws NullPointerException
3. your catch block grabs it
4. the method ends quietly
5. the test sees no exception
6. That’s why it’s not behaving as expected.

## How to fix it

### Option 1: Let the exception propagate

If you want the test to pass with assertThrows, remove the try/catch:

```java
public void setAuthor(String author) {
    this.author = Objects.requireNonNull(author, "Null value assigned to author");
}
```
Then your test can assert the exception message too.

### Option 2: Throw your own exception

If you want a custom message, do it explicitly:
```java
public void setAuthor(String author) {
    if (author == null) {
        throw new NullPointerException("Null value assigned to author");
    }
    this.author = author;
}
```
I chose the second option, I threw my own exception

- **Why it happened: This situation happened because I did not have a good understanding of the potential impact of the ```try/catch``` on testing.**
- **As discussed above I threw my own exception and then asserted on the presence of an exception in my test.**

## 8) Things I Added or Changed
- **What feature did I add?**
- **Why did I add it?**
- **Did it work as expected?**

## 9) Questions I Still Have
- **Question 1:**
- **Question 2:**
- **Question 3:**

## 10) One-Sentence Summary
- **Today I learned that...**