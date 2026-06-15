## Instructor-Style Review: Updated `Square` and `SquareTest`
You made meaningful improvements since the last review. The class is cleaner, the scale-factor rule is stronger, the repeated rounding logic has been extracted into a helper method, and the tests now cover the intentional mutability of `scaleFactor`.
This is a strong revision.
# `Square` Class Review
## Grade: **A / 94%**
Your updated `Square` class is now very solid for this stage of the course.
## What Improved
### 1. Scale factor now has an upper bound
You added:
``` java
private static final int MAX_SCALE_FACTOR = 10;
```

and:
``` java
private int validateScaleFactorSize(int scaleFactor) {
    if (scaleFactor > MAX_SCALE_FACTOR) {
        throw new IllegalArgumentException(SCALE_FACTOR_ERROR_MESSAGE);
    } else {
        return scaleFactor;
    }
}
```

This is a good improvement. Previously, the class allowed any non-negative scale factor, even an absurdly large one. Now the class has a reasonable domain rule:
A scale factor may be zero or positive, but it may not exceed 10.
That is a better object design.
 
1. Constructor validation is now layered well
``` java
public Square(BigDecimal side, int scaleFactor) {
    int nonNegativeScaleFactor =
        ValueValidator.validateNonNegativeIntAndReturn(scaleFactor, "scale factor");
    this.scaleFactor = validateScaleFactorSize(nonNegativeScaleFactor);
    this.side = ValueValidator.validateNonNegativeBigDecimalAndReturn(side, "side");
}
```

This is clear:
First validate that the scale factor is not negative.
Then validate that it is not too large.
Then validate the side.
That is easy to read and easy to reason about.
 
2. Setter validation matches constructor validation
``` java
public void setScaleFactor(int scaleFactor) {
    int nonNegativeScaleFactor =
        ValueValidator.validateNonNegativeIntAndReturn(scaleFactor, "scale factor");
    this.scaleFactor = validateScaleFactorSize(nonNegativeScaleFactor);
}
```

This is excellent. Your constructor and setter now enforce the same rule.
That means an invalid scale factor cannot enter the object either during construction or later mutation.
This is one of the most important encapsulation habits: do not let setters bypass constructor rules.
 
3. applyScale() is a clean helper method
``` java
private BigDecimal applyScale(BigDecimal value) {
    return value.setScale(scaleFactor, RoundingMode.HALF_UP);
}
```

This is a good extraction.
Now area() is concise:
``` java
@Override
public BigDecimal area() {
    return applyScale(side.multiply(side));
}
```

And perimeter() is also concise:
``` java
public BigDecimal perimeter() {
    return applyScale(BigDecimal.valueOf(4).multiply(side));
}
```

This is cleaner than repeating:
``` java
.setScale(scaleFactor, RoundingMode.HALF_UP)
```

in multiple methods.
It also centralizes your rounding rule. If you later decide to change RoundingMode.HALF_UP to another mode, you only change it in one place.
 
4. area() correctly demonstrates overriding
``` java
@Override
public BigDecimal area() {
    return applyScale(side.multiply(side));
}
```

This remains the core requirement of the exercise. You correctly override the inherited area() behavior.
 
3. perimeter() remains a good addition
The perimeter method is accurate and now benefits from the shared scaling helper.
``` java
public BigDecimal perimeter() {
    return applyScale(BigDecimal.valueOf(4).multiply(side));
}
```

This is clean and mathematically correct.
 
Remaining Class Suggestions
These are mostly minor refinements now.
 
1. Consider making the error message public only if tests need it
Right now the test duplicates this string:
``` java
"Scale factor is too large."
```

In the class, the constant is private:
``` java
private static final String SCALE_FACTOR_ERROR_MESSAGE =
    "Scale factor is too large.";
```

That is fine, but it means the test and class both contain the same literal string. If you ever change the production error message, the test must also be updated.
There are two reasonable approaches:
Option A: Keep it private
This is okay if you want tests to verify the exact public-facing message independently.
Option B: Make it package-private or public
For example:
``` java
static final String SCALE_FACTOR_ERROR_MESSAGE =
    "Scale factor is too large.";
```

Then the test can refer to:
``` java
Square.SCALE_FACTOR_ERROR_MESSAGE
```

However, I would not rush to make constants public just for tests. Keeping implementation details private is usually better.
For this level, your current approach is acceptable.
 
2. Consider removing the else after throw
This method:
``` java
private int validateScaleFactorSize(int scaleFactor) {
    if (scaleFactor > MAX_SCALE_FACTOR) {
        throw new IllegalArgumentException(SCALE_FACTOR_ERROR_MESSAGE);
    } else {
        return scaleFactor;
    }
}
```

Could be slightly simplified:
``` java
private int validateScaleFactorSize(int scaleFactor) {
    if (scaleFactor > MAX_SCALE_FACTOR) {
        throw new IllegalArgumentException(SCALE_FACTOR_ERROR_MESSAGE);
    }

    return scaleFactor;
}
```

Since throw exits the method, the else is not necessary.
This is a style improvement, not a correctness issue.
 
3. Think about whether side should be scaled when stored
Currently, if you create:
``` java
Square square = new Square(new BigDecimal("2.555"), 2);
```

The side itself remains:
``` java
2.555
```

But area and perimeter are scaled when calculated.
That is a valid design.
Another possible design would be to scale the side when storing it:
``` java
this.side = applyScale(validSide);
```

But with your current implementation, the object preserves the original side value and only scales calculated results. That is also reasonable.
The key is consistency. Your tests currently assume the stored side is not automatically rounded except when used in calculations. That is fine.
 
4. Optional: validate applyScale() input for null
Since applyScale() is private and only called internally with known non-null calculations, you do not need a null check.
But in a more defensive utility-style method, you might validate the input. Here, I would leave it as-is.
 
Square Class Grade Breakdown
Category
Grade
Notes
Encapsulation
A
Private fields, controlled access
Constructor design
A
Good validation and constructor chaining
Setter design
A
Setters enforce same rules as constructor
Validation
A
Non-negative and max scale validation
Area override
A
Correct and clean
Perimeter method
A
Correct and well-integrated
Helper method extraction
A
applyScale() improves readability
Style
A-
Minor else after throw; duplicated error string with tests
Square Class Grade: A / 94%
This is a very good implementation.
 
SquareTest Review
Grade: A / 95%
Your test class improved noticeably. The biggest upgrades are:
local exception variables instead of exception fields
BigDecimal string construction for key decimal values
tests for valid setter updates
tests for upper-bound scale-factor validation
tests showing that changing the scale factor changes later calculations
That is a strong test suite.
 
What Improved in the Tests
1. Exception variables are now local
You changed from test-class fields to local variables like:
``` java
IllegalArgumentException illegalArgumentException = assertThrows(
    IllegalArgumentException.class,
    () -> new Square(BigDecimal.valueOf(4), -1)
);
```

This is cleaner and more idiomatic.
Each test now owns its own exception object. Good improvement.
 
2. You added max scale-factor tests
Constructor test:
``` java
@Test
public void testSquareConstructorRejectsTooHighAScaleFactor() {
    IllegalArgumentException illegalArgumentException = assertThrows(
        IllegalArgumentException.class,
        () -> new Square(BigDecimal.valueOf(11.45), 11)
    );

    assertEquals(
        SCALE_FACTOR_ERROR_MESSAGE,
        illegalArgumentException.getMessage()
    );
}
```

Setter test:
``` java
@Test
public void testSquareSetterRejectsTooHighAScaleFactor() {
    IllegalArgumentException illegalArgumentException = assertThrows(
        IllegalArgumentException.class,
        () -> square.setScaleFactor(11)
    );

    assertEquals(
        SCALE_FACTOR_ERROR_MESSAGE,
        illegalArgumentException.getMessage()
    );
}
```

Excellent. You updated the tests to match the new domain rule in both object creation and mutation paths.
 
1. You added valid setter update tests
``` java
@Test
public void testSetSizeUpdatesSide() {
    BigDecimal newSide = new BigDecimal("10.25");

    square.setSide(newSide);

    assertEquals(newSide, square.getSide());
}
```

and:
``` java
@Test
public void testSetSizeUpdatesScaleFactor() {
    int newScaleFactor = 5;

    square.setScaleFactor(newScaleFactor);

    assertEquals(newScaleFactor, square.getScaleFactor());
}
```

This fills a gap from the previous version. Now your tests verify that setters:
reject invalid values
accept valid values
actually update the object state
That is much better coverage.
Small naming issue: these methods say SetSize, but the field is side, not size. I would rename them:
``` java
testSetSideUpdatesSide
testSetScaleFactorUpdatesScaleFactor
```

Not a logic issue, just clarity.
 
2. You improved decimal precision clarity
You changed this:
``` java
BigDecimal.valueOf(56.98)
```

to this:
``` java
new BigDecimal("56.98")
```

That is excellent for test readability and precision clarity.
For values where exact decimal representation matters in tests, string-based BigDecimal construction is usually the clearest option.
 
3. You now test mutable scale-factor behavior
Area test:
``` java
@Test
public void testChangingScaleFactorChangesAreaScale() {
    square = new Square(BigDecimal.valueOf(2.555), 2);

    square.setScaleFactor(1);

    assertEquals(BigDecimal.valueOf(6.5), square.area());
}
```

Perimeter test:
``` java
@Test
public void testChangingScaleFactorChangesPerimeterScale() {
    square = new Square(BigDecimal.valueOf(2.555), 2);

    square.setScaleFactor(1);

    assertEquals(BigDecimal.valueOf(10.2), square.perimeter());
}
```

This is a very good addition because it proves your intentional design choice.
You said you wanted the user to be able to change the scale factor on an existing instance. These tests now demonstrate that behavior.
Excellent.
 
Remaining Test Suggestions
These are minor, but they would make the tests even stronger.
 
1. Rename literalSide and literalScaleFactor
You now have:
``` java
private static final String literalSide = "side";

private static final String literalScaleFactor = "scale factor";
```

Since they are static final constants, Java convention would use uppercase names:
``` java
private static final String LITERAL_SIDE = "side";

private static final String LITERAL_SCALE_FACTOR = "scale factor";
```

This is a style issue, not a functional issue.
 
2. Rename testSetSize... to testSetSide...
These two test names appear to have a typo/concept mismatch:
``` java
testSetSizeUpdatesSide
testSetSizeUpdatesScaleFactor
```

A square has a side, not a size.
Better names:
``` java
testSetSideUpdatesSide
testSetScaleFactorUpdatesScaleFactor
```

This improves readability.
 
3. Consider testing the exact upper boundary
You test that 11 is rejected when the maximum is 10.
That is good.
You could also test that 10 is accepted:
``` java
@Test
public void testSquareConstructorAcceptsMaximumScaleFactor() {
    Square square = new Square(new BigDecimal("4.5"), 10);

    assertEquals(10, square.getScaleFactor());
}
```

And maybe:
``` java
@Test
public void testSquareSetterAcceptsMaximumScaleFactor() {
    square.setScaleFactor(10);

    assertEquals(10, square.getScaleFactor());
}
```

This confirms both sides of the boundary:
10 is valid
11 is invalid
Boundary testing is especially valuable when you have a max limit.
 
4. Use string-based BigDecimal consistently in tests
You already improved several values:
``` java
new BigDecimal("56.98")
new BigDecimal("14.567")
new BigDecimal("87.592")
```

You still have a few like:
``` java
BigDecimal.valueOf(20.543)
BigDecimal.valueOf(23.456)
BigDecimal.valueOf(2.555)
```

These are not terrible because BigDecimal.valueOf(double) is usually acceptable, but for consistency and clarity, you could use strings everywhere:
``` java
new BigDecimal("20.543")
new BigDecimal("23.456")
new BigDecimal("2.555")
```

This is especially nice in tests where exact decimal expectations matter.
 
5. Consider checking object state remains unchanged after invalid setter calls
You currently test that invalid setter calls throw the correct exceptions. That is good.
An even stronger test would also verify the object did not change.
Example:
``` java
@Test
public void testSquareSetterRejectsNegativeScaleFactorAndKeepsOriginalScaleFactor() {
    assertThrows(
        IllegalArgumentException.class,
        () -> square.setScaleFactor(-5)
    );

    assertEquals(SCALE_FACTOR, square.getScaleFactor());
}
```

This is not required, but it tests an important invariant:
Failed setter calls should not mutate the object.
Your implementation already appears to satisfy this because validation happens before assignment. Testing it would make the suite even more robust.
 
SquareTest Grade Breakdown
Category
Grade
Notes
Constructor validation
A
Null side, negative side, negative scale, too-large scale
Setter validation
A
Null/negative side, negative/too-large scale
Valid setter behavior
A
Now tested
Getter/default constructor tests
A
Clear and direct
Area tests
A
Normal, zero scale, zero square, changed scale
Perimeter tests
A
Normal, zero scale, zero square, changed scale
Organization
A
Good nested structure
Boundary testing
A-
Add explicit max-valid scale test for even stronger coverage
Style/readability
A-
Minor naming convention issues
SquareTest Grade: A / 95%
This is a strong test suite.
 
Overall Evaluation
Final Grades
File
Grade
Summary
Square
A / 94%
Clean, validated, well-encapsulated, correct override, good helper method
SquareTest
A / 95%
Thorough, organized, improved style, strong validation and behavior coverage
Overall Grade: A / 95%
This is a very good revision.
You did exactly what a good developer should do after a review:
improved the implementation
updated tests to match the new behavior
added validation for edge cases
tested both constructor and setter paths
tested the mutability decision for scaleFactor
cleaned up exception handling in the tests
At this point, the remaining suggestions are mostly polish: naming conventions, one or two boundary tests, and possibly checking that invalid setter calls leave the object unchanged. The core class design and test coverage are both strong.