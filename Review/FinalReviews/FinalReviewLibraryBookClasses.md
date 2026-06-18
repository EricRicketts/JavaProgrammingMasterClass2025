## Instructor Review: Phase 7 — Composition, Exercise 13: `Library` / `Book`
### Overall Grade: **A / 94%**
This is a major improvement from the earlier version. You addressed the most important composition/encapsulation issue: the `Library` now owns and protects its internal list rather than exposing a mutable list directly.
The assignment goal was:
A Library has books, and the Library should manage adding/removing/listing books.
Your revised version now demonstrates that very clearly. The `Library` is no longer just a thin wrapper around a list; it is acting as the manager of its composed `Book` objects.
### `Library` Class Grade: **A / 95%**
### What Improved Significantly
### 1. Excellent move from record to class
Changing `Library` from a record to a normal class was the right design choice here.
A `Library` is not merely a transparent data carrier. It has responsibilities:
- storing books
- adding books
- removing books
- validating input
- protecting its internal list
- producing a listing of books

That makes a class more appropriate than a record.
This shows better judgment about when to use records versus normal classes.
### 2. Strong encapsulation of the book list
This is the most important improvement:
``` java
private final List<Book> books;
```

and:
``` java
public List<Book> getBooks() {
    return List.copyOf(books);
}
```

This is exactly the kind of design I wanted to see.
The internal list is private, and callers receive an unmodifiable copy. That means outside code cannot do this anymore:
``` java
library.getBooks().clear();
```

and damage the internal state of the Library.
This is a very good example of composition plus encapsulation.
 
1. Defensive copy in the constructor
``` java
this.books = new ArrayList<>(validateBooksNotNullElements(books));
```

This protects the Library from changes to the original list passed into the constructor.
That means the Library has its own internal collection, rather than depending on outside code to maintain the list responsibly. This is exactly the right instinct.
 
4. Better naming
The old validation method name was less precise. This is much clearer:
``` java
validateBooksNotNullElements
```

That name better describes what the method actually checks: the list should not contain null Book elements.
Good improvement.
 
5. Improved null handling in addBook
This is also better:
``` java
this.books.add(Objects.requireNonNull(book, NULL_BOOK_IN_LIBRARY));
```

Now the exception message is meaningful and consistent with the rest of your validation style.
 
6. Cleaner `toString()` implementation
Using StringBuilder is an improvement:
``` java
StringBuilder libraryString = new StringBuilder("List of library books:\n");
```

This is cleaner and more efficient than repeated string concatenation in a loop.
For a small exercise, performance is not the main issue, but this is still the better habit.
 
Minor Issues / Suggestions
1. Your Library currently requires at least one starting book
The constructor rejects an empty list:
``` java
if (nonNullBooks.isEmpty()) {
    throw new IllegalArgumentException(EMPTY_LIST_OF_BOOKS);
}
```

This is not necessarily wrong if it is a design rule you chose. However, conceptually, a real library could reasonably start with zero books and then have books added later.
For this exercise, either design is acceptable, but be aware of the implication:
If a Library can be empty, allow List.of() in the constructor.
If a Library must start with at least one book, your current validation is fine.
Because you also have logic for removing from an empty library, allowing an empty library might make the class more flexible.
This is not a major grade deduction, just a design consideration.
 
2. removeBook removes the first matching title only
Your method searches by title and removes the first matching book. That is perfectly acceptable for this exercise.
However, in a more realistic system, titles may not be unique. A library could contain multiple books with the same title but different authors or editions.
For now, this is fine. Later, you might remove by:
exact Book
title plus author
ID number
ISBN
For Phase 7, title-based removal is acceptable.
 
3. Exception type consistency
Your constructor throws:
`NullPointerException` for a null list
`IllegalArgumentException` for an empty list
`NullPointerException` for a null book element
That is reasonable. Just make sure your tests expect the same exception types your class actually throws.
There is one test issue I’ll mention below where the expected exception type does not match the implementation.
 
**Book Class Grade: A- / 91%**
The Book class is solid and supports the composition exercise well. It gives the Library meaningful objects to manage.
What You Did Well
1. Clear state
The class has the expected fields:
``` java
private String title;
private String author;
private int pages;
```

This is exactly appropriate for the exercise.
 
2. Validation is centralized
The validation methods keep your constructor and setters clean:
```java
private static String validateAuthorAndReturn(String author)
private static int validatePagesAndReturn(int pages)
private static String validateTitleAndReturn(String title)
```

That is a good design pattern. It avoids duplicating validation logic across the constructor and setters.
 
3. Good use of getters and setters
The getters are simple and clear, and the setters preserve validation. This matters because a setter should not allow invalid object state.
For example, this is good:
```java
public void setTitle(String title) {
    this.title = validateTitleAndReturn(title);
}
```

You are not merely assigning the field. You are protecting the object’s state.
 
4. `equals()` supports meaningful tests
Overriding `equals()` lets your tests compare two different Book instances based on their contents rather than their memory addresses.
That is useful here:
``` java
assertEquals(expectedBook, removedBook);
```

Good choice.
 
Suggestions for Improvement
1. If you override `equals()`, also override `hashCode()`
In Java, the general rule is:
If two objects are equal according to `equals()`, they should return the same `hashCode()`.
Your current `equals()` works for your tests, but if you later use `Book` in a `HashSet`, `HashMap`, or other hash-based collection, missing `hashCode()` can cause incorrect behavior.
So I would add:
```java
@Override
public int hashCode() {
    return Objects.hash(title, author, pages);
}
```

This is the main reason I would not give the Book class a full A.
 
2. The no-argument constructor may conflict with your validation rules
Your no-argument constructor uses:
``` java
public Book() {
    this("Unknown Title", "Unknown Author", 0);
}
```

But your page validation appears to reject zero pages.
If zero pages are invalid, then the default constructor is creating an invalid default state and may throw an exception.
You have two clean options:
Option A: Make the default book valid
Use a positive page count:
``` java
public Book() {
    this("Unknown Title", "Unknown Author", 1);
}
```

Option B: Remove the no-argument constructor
If every Book should always have meaningful data, then requiring the full constructor is reasonable.
For this exercise, I would probably choose Option A or remove the default constructor entirely.
 
3. Minor formatting issue
There is a small indentation issue:
``` java
private int pages;
```

It appears slightly misaligned compared with the other fields. Very minor, but clean formatting helps readability.
 
**LibraryTest Grade: A- / 92%**
Your test suite improved a lot. The added constructor, defensive copy, and immutability tests show that you understood the earlier feedback and applied it well.
What You Did Well
1. Excellent use of nested test classes
Your tests are grouped clearly:
add book error checks
add book behavior
remove error checks
remove book behavior
toString
constructor tests
encapsulation/defensive copy tests
This structure is easy to read and gives the test file a strong organization.
 
2. Strong testing of encapsulation
These tests are exactly the kind of tests that show deeper OOP understanding:
``` java
testChangesToCopiedBookListDoesNotAlterLibraryBookList()
```

and:
``` java
testLibraryBookListIsImmutable()
```

These are not just testing “does the method return a value?” They are testing object design.
That is a big step forward.
 
3. Good test focus on the object under test
You improved this from the earlier version. You now use:
``` java
library.getBooks().size()
```

instead of checking only the original setup list.
That keeps the tests focused on the Library object itself.
 
4. Good testing of add/remove behavior
You verify that adding:
increases the count
places the book at the end
You verify that removing:
returns the removed book
decreases the count
shifts following elements left
throws when the title is not found
That is very solid coverage.
 
5. Good exception message testing
You check not only that an exception is thrown, but also that the message is correct.
That is thorough and helps ensure your validation behavior is intentional.
 
Test Issues to Fix
1. One constructor test expects the wrong exception type
This test says:
``` java
assertThrows(
    IllegalArgumentException.class,
    () -> new Library(Arrays.asList(new Book(), null))
);
```

But your Library class throws a NullPointerException when the list contains a null book:
``` java
throw new NullPointerException(NULL_BOOK_IN_LIBRARY);
```

So the test should expect NullPointerException, not IllegalArgumentException.
Also, because `new Book()` may itself be invalid if pages cannot be zero, this test may fail before the Library constructor even receives the list.
A cleaner version would use a definitely valid book:
``` java
assertThrows(
    NullPointerException.class,
    () -> new Library(Arrays.asList(new Book("Valid Title", "Valid Author", 100), null))
);
```

That would test the Library behavior directly.
 
2. Constructor tests should also check messages
You check messages in many remove/add tests, which is good. The constructor tests currently only check exception types.
To be consistent, you could also check messages for:
null library list
empty initial list
null book in list
This is not required, but it would make the constructor tests match the quality of the rest of the suite.
 
3. `toString()` test is acceptable but still somewhat broad
The `toString()` test checks that the result contains each book’s title, author, and page count. That is fine.
If you wanted stricter testing, you could assert the exact full output. However, for a `toString()` method, checking meaningful content is often enough.
I would leave this as acceptable.
 
**BookTest Grade: A- / 91%**
The BookTest class is thorough and shows strong testing habits.
Strengths
You test:
constructor validation for title
constructor validation for author
constructor validation for pages
equality
non-equality
getters
setters
setter validation
state preservation after failed setter calls
toString()
That is very good.
The state preservation checks are especially valuable:
``` java
assertEquals(TEST_TITLE, book.getTitle());
```

after a failed setter call. That confirms the object did not enter a bad state.
 
Suggestions
1. Add tests for `hashCode()` if you add `hashCode()`
If you add `hashCode()` to Book, you can add a simple test:
``` java
Book firstBook = new Book(TEST_TITLE, TEST_AUTHOR, TEST_PAGES);
Book secondBook = new Book(TEST_TITLE, TEST_AUTHOR, TEST_PAGES);

assertEquals(firstBook.hashCode(), secondBook.hashCode());
```

This reinforces the `equals()/hashCode()` contract.
 
2. Review the no-argument constructor behavior
If `Book()` is intended to be valid, add a test for it. If it is not needed, remove it.
Right now, it is a little unclear whether a zero-page default book should be allowed.
 
3. Minor naming issue
This test name appears to reference title but tests author:
``` java
testBookTitleSetterRejectsNullValue()
```

inside the author setter test group.
It should probably be renamed to something like:
``` java
testBookAuthorSetterRejectsNullValue()
```

Very small issue, but names matter in tests because they act as documentation.
 
Conceptual Grades:

Grouped By:

1.  Category
2.  Grade
3.  Comments

**Composition**
### A
Library clearly has and manages Book objects. Good “has-a” modeling.

**Encapsulation**
### A
Private internal list, defensive copy, and unmodifiable getter are strong improvements.

**Validation**
### A-
Strong validation overall. A few exception/test consistency issues remain.

**Testing**
### A-
Very good coverage and organization. One test exception mismatch should be fixed.

**Code Style**
### A-
Clean overall, with minor formatting/naming issues.

**Object Design**
### A-
Good class choice for Library; Book should add hashCode() and reconsider default constructor.
 
Final Instructor Comments
This revision shows real learning. You took the earlier feedback and improved the design in exactly the right direction.
The biggest conceptual improvement is that Library now truly controls its books. That is the heart of this exercise. You are no longer allowing external code to directly mutate the library’s internal collection, and your tests now prove that.
The remaining issues are relatively small:
Add `hashCode()` to Book because you overrode `equals()`.
Fix the constructor test that expects IllegalArgumentException instead of NullPointerException.
Reconsider whether `Book()` should create a zero-page book.
Optionally add constructor exception message checks.
### Final Grade: A / 94%
Excellent improvement. This is now a strong Phase 7 composition exercise with meaningful encapsulation and a much better test suite.