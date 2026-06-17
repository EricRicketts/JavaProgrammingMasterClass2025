## Instructor Review: Phase 7 — Composition, Exercise 13: `Library` / `Book`
### Overall Grade: **A-**
This is a strong implementation of the composition exercise. The main goal of Exercise 13 was to model a **“has-a” relationship**: a `Library` has `Book` objects, and the `Library` manages adding, removing, and listing those books.
You clearly demonstrated that idea. The `Library` stores a `List<Book>`, provides behavior around that list, and the tests verify the major expected operations.
The reason I would mark this as an **A- rather than a full A/A+** is that there are a few design and encapsulation issues that are worth tightening up, especially now that you are practicing composition.
# `Library` Class Comments
## What You Did Well
### 1. Good use of composition
``` java
public record Library(List<Book> books)
```

The Library is built around a collection of Book objects. That correctly models:
A library has books.
This is exactly the kind of relationship composition is meant to represent.
 
1. Constructor makes a defensive copy
``` java
this.books = new ArrayList<>(validateBooksNotBlank(books));
```

This is a very good decision.
Because the constructor receives a list from outside the class, copying it prevents some accidental outside modification of the internal list. For example, if external code later modifies the original list, the library’s internal list is not affected.
That shows good early awareness of encapsulation.
 
3. Strong validation
You check for:
null list
empty list
null book inside the list
null title for removal
empty title for removal
blank title for removal
removing from an empty library
removing a title that does not exist
That is more robust than the minimum expected for the exercise.
 
1. removeBook has clear logic
``` java
public Book removeBook(String title) {
    String validTitle = validateTitleNotNullEmptyOrBlank(title);
    validateLibraryIsNotEmpty(books);

    int indexOfBook = findBook(validTitle);
    if (indexOfBook == -1) {
        throw new NoSuchElementException(BOOK_NOT_FOUND);
    }
    return books.remove(indexOfBook);
}
```

This method is easy to follow:
validate the title
make sure the library is not empty
find the book
throw an exception if missing
remove and return the book
That is a clean sequence.
 
Suggestions for Improvement
1. The biggest issue: the record accessor exposes the mutable list
Because Library is a record, Java automatically provides:
``` java
public List<Book> books()
```

Even though the constructor copies the input list, the accessor still returns the actual internal ArrayList.
That means outside code can do this:
``` java
library.books().clear();
```

or:
``` java
library.books().add(new Book("Bad State", "External Code", 1));
```

This bypasses your addBook and removeBook methods.
For a composition/encapsulation exercise, that matters. Ideally, the Library should control changes to its list.
A better approach would be to override the accessor:
``` java
@Override
public List<Book> books() {
    return List.copyOf(books);
}
```

That would let outside code view the books without directly modifying the internal collection.
 
2. Consider whether Library should be a record
Records are best for mostly transparent data carriers. Your Library is not only data — it has behavior and mutable internal state.
This does work, but conceptually a normal class might be a better fit:
``` java
public class Library {
    private final List<Book> books;

    // constructor
    // addBook
    // removeBook
    // books accessor
}
```

Since this exercise is about composition and managing a collection of objects, a class may communicate the design more clearly than a record.
That said, using a record here is not “wrong”; it just creates a tension between:
records as transparent data carriers
Library as a manager/controller of a mutable collection
 
1. addBook validates null, but does not use your custom message
```java
this.books.add(Objects.requireNonNull(book));
```

This is acceptable Java, but it produces a NullPointerException with a null message.
Since you already have this constant:
``` java
private static final String NULL_BOOK_IN_LIBRARY =
    "A null value for a book is not allowed in a library.";
```

you could use:
``` java
this.books.add(Objects.requireNonNull(book, NULL_BOOK_IN_LIBRARY));
```

That would make your error handling more consistent.
 
1. Method name validateBooksNotBlank is slightly misleading
``` java
private List<Book> validateBooksNotBlank(List<Book> books)
```

A Book is not really “blank” in the same way a String can be blank. This method checks that the list does not contain null books.
A clearer name would be something like:
```java
validateBooksContainNoNulls
```

or:
``` java
validateBooksNotNullElements
```

Small naming issue, but naming is part of readable design.
 
5. toString() works, but string building could be cleaner
This works:
``` java
String libraryString = "List of library books:\n";
for (Book book : books) {
    libraryString = libraryString.concat(book.toString() + "\n");
}
```

For small lists this is fine. Later, you may want to prefer StringBuilder:
``` java
StringBuilder libraryString = new StringBuilder("List of library books:\n");
for (Book book : books) {
    libraryString.append(book).append("\n");
}
return libraryString.toString();
```

This is not a major concern for this exercise, but it is a useful habit.
 
LibraryTest Class Comments
What You Did Well
1. Good test organization
The use of nested test classes is very helpful:
``` java
@Nested
@DisplayName("test add a book to the library")
class AddBookToLibrary
```

This makes the test file easier to read and review. Your groups are logical:
book features
adding books
remove error checking
removing books
toString
That is good test structure.
 
2. Good coverage of normal behavior
You test that adding a book:
increases the count
places the book at the end
You test that removing a book:
returns the removed book
decreases the count
throws an exception when the title is not found
That covers the core behavior of the exercise well.
 
3. Good coverage of invalid remove inputs
You test removing by:
null title
empty title
blank title
That is very thorough.
 
4. toString() test checks meaningful content
Instead of hardcoding the entire output, you check that each book’s important data appears in the string.
That is a reasonable strategy here because it focuses on whether the method includes the meaningful information.
 
Suggestions for Improvement
1. Add constructor validation tests
The Library constructor has meaningful validation, but the tests do not currently cover all of it.
You should add tests for:
null list
empty list
list containing a null book
These are important because the constructor has explicit rules for them.
Example test ideas:
``` java
assertThrows(NullPointerException.class, () -> new Library(null));
assertThrows(IllegalArgumentException.class, () -> new Library(List.of()));
assertThrows(NullPointerException.class, () -> new Library(Arrays.asList(validBook, null)));
```

Since you wrote the validation logic, the tests should prove that it works.
 
2. Add an encapsulation test for defensive copying
Since your constructor copies the input list, it would be good to test that behavior.
For example:
``` java
List<Book> originalBooks = new ArrayList<>();
originalBooks.add(new Book("Book One", "Author One", 100));

Library library = new Library(originalBooks);

originalBooks.add(new Book("Book Two", "Author Two", 200));

assertEquals(1, library.books().size());
```

That would verify that the library is not affected by later changes to the original list.
 
3. Add a test for accessor mutability
This is the test that would reveal the main design issue:
``` java
library.books().clear();

assertEquals(3, library.books().size());
```

Right now, this test would likely fail because books() exposes the internal mutable list.
That is an excellent learning point for composition and encapsulation. The Library should ideally manage its own list instead of letting outside code directly mutate it.
 
4. Some tests inspect Book behavior more than Library behavior
These tests:
``` java
testBookTitles()
testBookAuthors()
testBookPages()
```

are not wrong, but they mostly verify that the setup data contains the expected Book values. They are partly testing Book, not Library.
For the Library exercise, stronger tests would focus on whether the library:
stores the books it was given
preserves order
adds books correctly
removes the correct book
protects its internal list
You can keep these tests, but they are less important than constructor and encapsulation tests.
 
5. Be careful with books vs library.books()
In a few places, the test uses the original books list rather than the library’s list.
For example:
``` java
assertEquals(expectedBookCount, books.size());
```

That checks the setup list, not necessarily the Library.
Usually, in a LibraryTest, prefer checking:
``` java
assertEquals(expectedBookCount, library.books().size());
```

That keeps the test focused on the object under test.
 
Conceptual Understanding Grade
Composition: A
You clearly understand the central idea:
A Library has a collection of Book objects.
The relationship is modeled correctly. You did not misuse inheritance, and the Library provides behavior around its composed objects.
 
Encapsulation: B+
You are thinking in the right direction because you make a defensive copy in the constructor and validate inputs.
The main issue is that the record accessor exposes the internal mutable list. Once you fix that, the encapsulation would be much stronger.
 
Validation/Error Handling: A-
Very good effort here. You went beyond the minimum expected behavior.
The only notable inconsistency is addBook(null), which throws a NullPointerException without your custom message.
 
Testing: B+/A-
Your test suite is organized and covers the main add/remove behavior well.
To move it into the A range, add tests for:
constructor rejects null list
constructor rejects empty list
constructor rejects list containing null
constructor makes a defensive copy
accessor does not expose mutable internal list
 
Final Instructor Comment
This is a well-done Phase 7 exercise. You correctly modeled a has-a relationship, gave the Library meaningful behavior, and wrote a solid set of tests around adding, removing, and listing books.
Your next growth step is to think more deeply about this question:
If Library is supposed to manage its books, should outside code be able to directly modify the book list?
Right now, the answer in your implementation is effectively yes, because library.books() exposes the mutable internal list. Fixing that would make this a much stronger composition and encapsulation example.
Final Grade: A-
Strong work. The core exercise is complete, the logic is clear, and the tests are meaningful. Tighten the encapsulation around the list and add a few constructor/defensive-copy tests, and this would be excellent.