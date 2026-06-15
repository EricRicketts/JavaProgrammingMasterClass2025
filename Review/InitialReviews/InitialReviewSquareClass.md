## Instructor-Style Review: Phase 6, Exercise 12 — `Square`
You asked me to focus only on the `Square` class and its tests, so I’ll keep the review centered there.
Overall, this is a strong submission. The class is clean, readable, validates its inputs, uses `BigDecimal` appropriately for decimal arithmetic, overrides `area()`, and adds a sensible `perimeter()` method. Your tests are also much stronger than basic “happy path only” tests: you check constructors, setters, invalid inputs, default values, rounding behavior, zero scale factor, and zero side length.
Your decision to add a mutable `scaleFactor` is defensible. Making it `final` would also be reasonable, but allowing it to change through a validated setter is not a design error. Since `side` is already mutable, having `scaleFactor` mutable is consistent with the style of the class.
# `Square` Class Review
## Grade: **A- / B+**
I would place the class around an **A-**, with a few minor design and robustness considerations keeping it from a full A.
## What You Did Well
### 1. Good encapsulation
``` java
private BigDecimal side;
private int scaleFactor;
```

Both fields are private and exposed through controlled getters and setters. That is exactly what I would expect at this stage of the course.
You are not allowing outside code to directly assign invalid state to the object.
 
### 1. Constructor validation is good
``` java
public Square(BigDecimal side, int scaleFactor) {
    this.scaleFactor = ValueValidator.validateNonNegativeIntAndReturn(scaleFactor, "scale factor");
    this.side = ValueValidator.validateNonNegativeBigDecimalAndReturn(side, "side");
}
```

This is good defensive programming. You validate both incoming values before storing them.
A square with a negative side length should not exist, and your class prevents that.
 
### 2. Default constructor uses constructor chaining
``` java
public Square() {
    this(BigDecimal.valueOf(2), 2);
}
```

Excellent. This avoids duplicated assignment logic and keeps the validation path consistent.
This is exactly the right use of constructor chaining.
 
### 3. Setter validation is consistent with constructor validation
``` java
public void setScaleFactor(int scaleFactor) {
    this.scaleFactor = ValueValidator.validateNonNegativeIntAndReturn(scaleFactor, "scale factor");
}

public void setSide(BigDecimal side) {
    this.side = ValueValidator.validateNonNegativeBigDecimalAndReturn(side, "side");
}
```

This is important. A common beginner mistake is validating constructor parameters but forgetting that setters can later put the object into an invalid state.
You avoided that.
 
### 4. Correct area() override
``` java
@Override
public BigDecimal area() {
    BigDecimal unscaledArea = side.multiply(side);

    return unscaledArea.setScale(scaleFactor, RoundingMode.HALF_UP);
}
```

The calculation is correct:
area of square = side * side
result is rounded using the instance’s scaleFactor
@Override is correctly used
This demonstrates the main point of the exercise: overriding inherited behavior.
 
### 5. perimeter() is a logical addition
``` java
public BigDecimal perimeter() {
    BigDecimal unscaledPerimeter = BigDecimal.valueOf(4).multiply(side);

    return unscaledPerimeter.setScale(scaleFactor, RoundingMode.HALF_UP);
}
```

Adding perimeter makes sense for a shape class. The method is simple, readable, and mathematically correct.
I also like that you applied the same rounding policy to both area() and perimeter().
 
Design Notes and Improvement Areas

### 1. Consider whether zero side length should be allowed
Right now, this is allowed:
``` java
new Square(BigDecimal.ZERO, 3)
```

That creates a square with area and perimeter of zero.
This is not necessarily wrong. Mathematically, a degenerate square with side 0 can exist. But from a modeling perspective, you could argue that a real square should require a positive side length.

So this depends on intent:
If you want to allow “empty” or “zero” shapes, your current validation is fine.
If you want only physically meaningful squares, validate side as positive, not merely non-negative.
Given your tests include a zero square, your design appears intentional. I would not mark this as an error.
 
### 2. Scale factor may need an upper limit eventually
You validate that scaleFactor is not negative, which is good.
However, this means a user could technically do:
``` java
new Square(BigDecimal.valueOf(5), 1000000)
```

That is probably not useful and could lead to performance or memory issues depending on how extreme the value is.
For this exercise, non-negative validation is probably enough. But in a more production-style class, I would expect a maximum allowed scale.
Something like:
``` java
private static final int MAX_SCALE_FACTOR = 10;
```

Then reject anything above it.
Again, not a major issue for this course phase, but worth thinking about.
 
### 3. The scale factor design is reasonable
You mentioned this yourself:
It could be argued the scale factor should be final, but I decided the user might want to change the scale factor on a given instance.
That is a valid design choice.
There are two reasonable models here:
Immutable scale factor model
The scale is part of how the object is constructed and cannot change.
``` java
private final int scaleFactor;
```

This makes the object more stable and predictable.
Mutable scale factor model
The square’s side and rounding precision can both change after construction.
``` java
public void setScaleFactor(int scaleFactor)
```

This makes the object more flexible.
Since your class already has a setSide() method, mutability is already part of the object’s design. So a mutable scaleFactor is consistent.
I would not penalize you for this.
 
### 4. Possible improvement: avoid repeated rounding logic
Both area() and perimeter() do this:
``` java
return value.setScale(scaleFactor, RoundingMode.HALF_UP);
```

For a small class, that is fine. But if more methods are added, you might eventually create a private helper:
``` java
private BigDecimal applyScale(BigDecimal value) {
    return value.setScale(scaleFactor, RoundingMode.HALF_UP);
}
```

Then:
``` java
@Override
public BigDecimal area() {
    return applyScale(side.multiply(side));
}

public BigDecimal perimeter() {
    return applyScale(BigDecimal.valueOf(4).multiply(side));
}
```

This is not required, but it would slightly reduce duplication and make the rounding rule easier to change later.
 
Class Grade Breakdown
Category
Grade
Notes
Encapsulation
A
Private fields with controlled access
Constructor design
A
Good constructor chaining and validation
Validation
A-
Good non-negative validation; possible max scale discussion
Method correctness
A
area() and perimeter() are correct
Inheritance/overriding
A
Correct use of @Override
Design clarity
B+ / A-
Mutable scale factor is defensible, but worth documenting
Readability
A
Clean and easy to follow
Class Grade: A-
This is a well-written class for the level of the exercise.
 
SquareTest Review
Grade: A-
The tests are thorough, organized, and demonstrate that you understand both normal behavior and invalid input behavior. You are testing more than the minimum required, which is good.
 
What You Did Well in the Tests
### 1. Good use of nested test classes
``` java
@Nested
@DisplayName("test square constructor validates side")
class TestSquareConstructorValidatesSide {
    ...
}
```

This makes the test file easier to navigate. You grouped related tests logically:
constructor validation
default constructor
setter validation
getters
area
perimeter
That is a strong testing habit.
 
### 2. Good use of @BeforeEach
``` java
@BeforeEach
public void setUp() {
    square = new Square(SIDE, SCALE_FACTOR);
    defaultSquare = new Square();
}
```

This reduces repetition and ensures each test starts with a fresh object.
Good.
 
### 3. You test constructor validation
You test null side:
``` java
() -> new Square(null, SCALE_FACTOR)
```

You test negative side:
``` java
() -> new Square(BigDecimal.valueOf(-4), SCALE_FACTOR)
```

You test negative scale factor:
``` java
() -> new Square(BigDecimal.valueOf(4), -1)
```

That is exactly the kind of testing I want to see for constructors.
 
### 4. You test setter validation
You correctly check that invalid values are rejected after object creation:
``` java
() -> square.setSide(null)
```

``` java
() -> square.setSide(BigDecimal.valueOf(-4.56))
```

``` java
() -> square.setScaleFactor(-5)
```

This matters because invalid state can enter through setters as well as constructors.
Good coverage.
 
### 5. You test default constructor values
``` java
assertEquals(BigDecimal.valueOf(2), defaultSquare.getSide());
assertEquals(2, defaultSquare.getScaleFactor());
```

This verifies that the no-argument constructor produces the expected default object.
Good.
 
### 6. You test computed area and perimeter
For area:
``` java
BigDecimal unscaledArea = side.multiply(side);
BigDecimal scaledArea =
    unscaledArea.setScale(SCALE_FACTOR, RoundingMode.HALF_UP);

assertEquals(scaledArea, square.area());
```

For perimeter:
``` java
BigDecimal unscaledPerimeter = BigDecimal.valueOf(4).multiply(side);
BigDecimal scaledPerimeter =
    unscaledPerimeter.setScale(SCALE_FACTOR, RoundingMode.HALF_UP);

assertEquals(scaledPerimeter, square.perimeter());
```

This is a good testing pattern because you are calculating the expected value independently inside the test.
 
### 7. You test zero scale factor
``` java
square = new Square(BigDecimal.valueOf(20.543), 0);

assertEquals(BigDecimal.valueOf(422), square.area());
```

And:
``` java
square = new Square(BigDecimal.valueOf(23.456), 0);

assertEquals(BigDecimal.valueOf(94), square.perimeter());
```

These are useful because scaleFactor = 0 changes the result noticeably.
You are verifying rounding behavior, not just arithmetic.
 
### 8. You test zero side length
``` java
square = new Square(new BigDecimal("0.000"), SCALE_FACTOR);

assertEquals(new BigDecimal("0.000"), square.area());
```

And similarly for perimeter.
This confirms your chosen rule that zero side length is allowed.
 
Test Improvement Areas
### 1. Avoid storing exception objects as fields
You currently have:
``` java
private NullPointerException nullPointerException;

private IllegalArgumentException illegalArgumentException;
```

Then inside tests:
``` java
nullPointerException = assertThrows(...);
```

This works, but it is usually cleaner to keep exception variables local to each test:
``` java
NullPointerException exception = assertThrows(
    NullPointerException.class,
    () -> new Square(null, SCALE_FACTOR)
);
```

Why local variables are better:
the exception belongs only to that test
avoids unnecessary mutable test class state
makes each test more self-contained
reduces the chance of accidental reuse later
This is not a correctness problem, but it is a style improvement.
 
### 2. Constants should usually be static final
These are currently instance fields:
``` java
private final String literalSide = "side";

private final String literalScaleFactor = "scale factor";
```

Since they are fixed test constants, I would make them:
``` java
private static final String LITERAL_SIDE = "side";
private static final String LITERAL_SCALE_FACTOR = "scale factor";
```

This is more idiomatic Java style.
 
### 3. Some test indentation is off
In a few tests, the body is indented more than expected:
``` java
@Test
public void testSquareConstructorRejectsNullSideValue() {
        nullPointerException = assertThrows(
            NullPointerException.class,
            () -> new Square(null, SCALE_FACTOR)
        );
```

The extra indentation does not affect execution, but it affects readability.
It should be formatted like:
``` java
@Test
public void testSquareConstructorRejectsNullSideValue() {
    NullPointerException exception = assertThrows(
        NullPointerException.class,
        () -> new Square(null, SCALE_FACTOR)
    );

    assertEquals(
        ErrorMessages.nullValue(LITERAL_SIDE),
        exception.getMessage()
    );
}
```

Small style issue, not a logic issue.
 
### 4. Add tests that setters actually update valid values
You test that setters reject invalid values, but you do not currently test that setters accept valid values and update the object.
You should consider adding:
``` java
@Test
public void testSetSideUpdatesSide() {
    BigDecimal newSide = BigDecimal.valueOf(10.25);

    square.setSide(newSide);

    assertEquals(newSide, square.getSide());
}
```

And:
``` java
@Test
public void testSetScaleFactorUpdatesScaleFactor() {
    int newScaleFactor = 5;

    square.setScaleFactor(newScaleFactor);

    assertEquals(newScaleFactor, square.getScaleFactor());
}
```

This would complete the setter testing.
Right now your setter tests prove:
invalid values are rejected
But they do not prove:
valid values are accepted and assigned
 
### 5. Consider testing that changing scale factor affects area/perimeter
Since you intentionally made scaleFactor mutable, it would be good to test the behavior that justifies that design.
For example:
``` java
@Test
public void testChangingScaleFactorChangesAreaScale() {
    square = new Square(BigDecimal.valueOf(2.555), 2);

    square.setScaleFactor(1);

    assertEquals(BigDecimal.valueOf(6.5), square.area());
}
```

This test would show that setScaleFactor() affects later calculations.
That would strengthen your argument that scaleFactor is intentionally mutable.
 
### 6. Be careful with BigDecimal.valueOf(double)
You use examples like:
``` java
BigDecimal.valueOf(56.98)
```

This is generally safer than new BigDecimal(56.98), so you avoided the worst version of the mistake.
However, when exact decimal readability matters, I still often prefer string construction:
``` java
new BigDecimal("56.98")
```

For test values, string-based BigDecimal creation makes the intended value visually exact.
That said, BigDecimal.valueOf(double) internally uses the canonical string representation of the double, so it is usually acceptable for tests like these. I would not mark this wrong.
 
Test Grade Breakdown
Category
Grade
Notes
Constructor validation tests
A
Null, negative side, negative scale
Setter validation tests
A-
Invalid values tested; valid updates missing
Getter/default constructor tests
A
Good coverage
Area tests
A
Normal, zero scale, zero side
Perimeter tests
A
Normal, zero scale, zero side
Organization
A
Nested classes and display names help
Style/readability
B+
Exception fields and minor indentation issues
Edge cases
A-
Good edge cases; could add mutable scale behavior
Test Grade: A-
The tests are very solid. With a few style cleanups and valid setter-update tests, they would be excellent.
 
Suggested Additional Tests
I would add these to improve coverage:
``` java
@Test
public void testSetSideUpdatesSide() {
    BigDecimal newSide = BigDecimal.valueOf(10.25);

    square.setSide(newSide);

    assertEquals(newSide, square.getSide());
}
```

``` java
@Test
public void testSetScaleFactorUpdatesScaleFactor() {
    int newScaleFactor = 5;

    square.setScaleFactor(newScaleFactor);

    assertEquals(newScaleFactor, square.getScaleFactor());
}
```

``` java
@Test
public void testChangingScaleFactorChangesAreaScale() {
    square = new Square(BigDecimal.valueOf(2.555), 2);

    square.setScaleFactor(1);

    assertEquals(BigDecimal.valueOf(6.5), square.area());
}
```

``` java
@Test
public void testChangingScaleFactorChangesPerimeterScale() {
    square = new Square(BigDecimal.valueOf(2.555), 2);

    square.setScaleFactor(1);

    assertEquals(BigDecimal.valueOf(10.2), square.perimeter());
}
```

One note: those last two expected values should be double-checked based on your rounding rule.
For 2.555 * 2.555 = 6.528025, scaled to 1 decimal gives 6.5.
For 4 * 2.555 = 10.220, scaled to 1 decimal gives 10.2.
So those are correct with RoundingMode.HALF_UP.
 
Final Grades
Square Class: A-
A clean, correct, well-encapsulated implementation. Strong use of validation, constructor chaining, overriding, and BigDecimal.
Main improvement areas:
consider whether side should be positive rather than non-negative
consider an upper bound for scaleFactor
consider a private helper for repeated scaling logic
optionally document the mutable scale factor design choice
 
SquareTest Class: A-
Very good coverage and organization. You test both normal behavior and invalid input. The test suite shows real thought.
Main improvement areas:
use local exception variables instead of exception fields
make string constants static final
fix minor indentation issues
add tests proving setters accept valid values
add tests showing changed scaleFactor affects future calculations
 
Overall Assessment
This is a strong submission. You are no longer just writing the minimum class to satisfy the exercise — you are starting to think like a designer:
What values should be valid?
Should this field be mutable?
What precision should calculations return?
How should default objects behave?
How do I test invalid state?
That is exactly the kind of thinking this phase is meant to build.
Overall grade for the Square class and tests together: A-.