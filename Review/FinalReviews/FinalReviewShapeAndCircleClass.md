## Instructor Review: `Shape`, `Circle`, and `CircleTest`
Overall, this is a **strong improvement**. You successfully moved `Circle` into an inheritance relationship with `Shape`, used `@Override` correctly, validated constructor/setter input, and wrote a fairly complete test suite around both normal behavior and invalid input.
You are showing good growth in:
- inheritance
- abstract classes
- method overriding
- validation
- constructor chaining
- JUnit nested tests
- `BigDecimal` usage
- separation of production code and test code

# 1. `Shape` Review
``` java
package org.example;

import java.math.BigDecimal;

public abstract class Shape {

    public abstract BigDecimal area();
}
```

Instructor Comments
What is good
This is clean and appropriate for the current stage of the assignment.
You correctly made Shape abstract:
``` java
public abstract class Shape
```

That makes sense because a generic Shape does not have enough information to calculate its own area.
You also correctly made `area()` abstract:
``` java
public abstract BigDecimal area();
```

This forces child classes such as Circle, and later Square, to provide their own area implementation.
This is exactly the right basic use of inheritance here:
A Circle is a Shape, but each kind of shape calculates area differently.
Possible future improvement
Right now, Shape only defines `area()`. That is perfectly fine for this assignment.
Later, you may consider whether other common shape behavior belongs here, such as:
``` java
public abstract BigDecimal perimeter();
```

or possibly:
``` java
public abstract BigDecimal circumference();
```

However, be careful: `circumference()` is usually a circle-specific term, while `perimeter()` is more general. So if you wanted a shared shape method, `perimeter()` would probably be the better abstract method name.
For now, your Shape class is simple, correct, and focused.
Shape Grade
Grade: A
Very good for the assignment scope.
 
# 2. `Circle` Review
``` java
package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Circle extends Shape {

    private BigDecimal radius;

    private int scaleFactor;

    public Circle(BigDecimal radius, int scaleFactor) {
        this.radius = ValueValidator.validateNonNegativeBigDecimalAndReturn(radius, "radius");
        this.scaleFactor = ValueValidator.validateNonNegativeIntAndReturn(scaleFactor, "scale factor");
    }

    public Circle() {
        this(new BigDecimal("1.54"), 2);
    }

    public int getScaleFactor() {
        return scaleFactor;
    }

    public void setScaleFactor(int scaleFactor) {
        this.scaleFactor = ValueValidator.validateNonNegativeIntAndReturn(scaleFactor, "scale factor");
    }

    public BigDecimal getRadius() {
        return radius;
    }

    public void setRadius(BigDecimal radius) {
        this.radius = ValueValidator.validateNonNegativeBigDecimalAndReturn(radius, "radius");
    }

    @Override
    public BigDecimal area() {
        BigDecimal radiusSquared = this.getRadius().multiply(this.getRadius());
        BigDecimal unscaledArea = BigDecimal.valueOf(Math.PI).multiply(radiusSquared);

        return unscaledArea.setScale(scaleFactor, RoundingMode.HALF_UP);
    }

    public BigDecimal circumference() {
        BigDecimal unscaledCircumference =
            new BigDecimal("2").multiply(new BigDecimal(Math.PI)).multiply(this.getRadius());

        return unscaledCircumference.setScale(scaleFactor, RoundingMode.HALF_UP);
    }
}
```
Instructor Comments
What is good
Your Circle class is much improved.
The inheritance is now correct:
``` java
public class Circle extends Shape
```

This is a good example of an **is-a** relationship:
A Circle is a Shape.
You also correctly override the abstract method from Shape:
``` java
@Override
public BigDecimal area()
```

That is an important detail. The @Override annotation shows that you understand this method is fulfilling a parent-class contract.
Your constructor is also good:
``` java
public Circle(BigDecimal radius, int scaleFactor) {
    this.radius = ValueValidator.validateNonNegativeBigDecimalAndReturn(radius, "radius");
    this.scaleFactor = ValueValidator.validateNonNegativeIntAndReturn(scaleFactor, "scale factor");
}
```

This protects the object from invalid state at construction time.
Your no-argument constructor correctly uses constructor chaining:
``` java
public Circle() {
    this(new BigDecimal("1.54"), 2);
}
```

That is a strong design choice because the real initialization logic stays in one constructor.
Your setter methods also validate input, which is good encapsulation:
``` java
public void setRadius(BigDecimal radius) {
    this.radius = ValueValidator.validateNonNegativeBigDecimalAndReturn(radius, "radius");
}
```

and:
``` java
public void setScaleFactor(int scaleFactor) {
    this.scaleFactor = ValueValidator.validateNonNegativeIntAndReturn(scaleFactor, "scale factor");
}
```

That means the object is protected not only during construction, but also after construction.
 
Main issue: should scale factor allow zero?
Your Circle currently uses:
``` java
ValueValidator.validateNonNegativeIntAndReturn(scaleFactor, "scale factor");
```

That means this is allowed:
``` java
new Circle(new BigDecimal("4.53"), 0);
```

A scale factor of 0 would produce whole-number rounded output.
That may or may not be what you want.
For example, the area could become:
``` text
64
```

instead of:
``` text
64.49
```

If your assignment expects a positive scale factor, then you should use positive validation instead of non-negative validation.
Conceptually, I would probably expect scaleFactor to be non-negative, because Java’s `BigDecimal.setScale(0, ...)` is valid and meaningful. So your design is defensible.
However, if the rest of your project treats scale factor as something that must be at least 1, then Circle should follow the same rule for consistency.
Instructor note
This is not necessarily wrong. It depends on your intended rule:
Rule
Validator
Scale factor may be 0
`validateNonNegativeIntAndReturn`
Scale factor must be 1 or greater
`validatePositiveIntAndReturn`
Right now your tests only reject negative scale factors. So your current implementation and tests are consistent.
 
BigDecimal / Math.PI concern
You use:
``` java
BigDecimal.valueOf(Math.PI)
```

in `area()`.
That is better than:
``` java
new BigDecimal(Math.PI)
```

because `BigDecimal.valueOf(double)` handles the conversion more cleanly.
However, in `circumference()` you use:
``` java
new BigDecimal(Math.PI)
```

This is less ideal.
It would be better to be consistent and write:
``` java
BigDecimal.valueOf(Math.PI)
```

So this line:
``` java
new BigDecimal("2").multiply(new BigDecimal(Math.PI)).multiply(this.getRadius());
```

would be better as:
``` java
BigDecimal.valueOf(2).multiply(BigDecimal.valueOf(Math.PI)).multiply(this.getRadius());
```

This is not a major assignment-level problem, but it is a good habit to build.
 
Minor style improvement
This line is fine:
``` java
BigDecimal radiusSquared = this.getRadius().multiply(this.getRadius());
```

But since you are inside the class, you could also simply use:
```java
BigDecimal radiusSquared = radius.multiply(radius);
```

Your current approach is not wrong. In fact, using getters internally can be acceptable, especially while learning.
 
Circle Grade
Grade: A-
Strong work. The inheritance and override are correct. Validation is good. The only meaningful issue is the inconsistent BigDecimal construction around Math.PI, plus the design question about whether scaleFactor should allow zero.
 
# 3. `CircleTest` Review
``` java
package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CircleTest {

    private Circle circle;

    private Circle zeroCircle;

    private final int scaleFactor = 2;

    @BeforeEach
    public void setUp() {
        circle = new Circle(new BigDecimal("4.53"), scaleFactor);
        zeroCircle = new Circle(new BigDecimal("0.00"), scaleFactor);
    }

    // tests...
}
```
Instructor Comments
Your test class is much better organized now.
What is good
You are using:
``` java
@BeforeEach
```

correctly to create reusable test objects.
You are also using nested test classes:
``` java
@Nested
@DisplayName("test circle constructor validates radius")
class TestCircleConstructorValidatesRadius
```

This gives your test suite a clear structure.
You test:
constructor rejects null radius
constructor rejects negative radius
constructor rejects negative scale factor
no-argument constructor values
setter rejects null radius
setter rejects negative radius
setter rejects negative scale factor
getter behavior
area calculation
circumference calculation
zero-radius area
zero-radius circumference
That is a very solid range of coverage.
 
Strong improvement: exception testing
This pattern is good:
``` java
NullPointerException exception =
    assertThrows(
        NullPointerException.class,
        () -> new Circle(null, scaleFactor)
    );

assertEquals(
    ErrorMessages.nullValue("radius"),
    exception.getMessage()
);
```

This is clearer than trying to put everything inside one large assertEquals.
It separates:
the action that should throw
the expected exception type
the expected exception message
That is good test readability.
 
Main test issue: this test does not test the object you think it tests
You wrote:
``` java
@Test
public void testCircleConstructorGetScaleFactor() {
    assertEquals(scaleFactor, new Circle().getScaleFactor());
}
```

This passes because scaleFactor is 2, and the no-argument constructor also uses 2.
But the test name says:
``` text
testCircleConstructorGetScaleFactor
```

and it is inside:
``` text
test circle radius and scale factor getters
```

Since you already created this object in setUp():
``` java
circle = new Circle(new BigDecimal("4.53"), scaleFactor);
```

this test would be more direct as:
``` java
assertEquals(scaleFactor, circle.getScaleFactor());
```

The current version is not harmful, but it accidentally tests the no-argument constructor again instead of the main constructor object.
Recommended correction
``` java
@Test
public void testCircleConstructorGetScaleFactor() {
    assertEquals(scaleFactor, circle.getScaleFactor());
}
```

 
Missing test: zero scale factor decision
Because your implementation allows non-negative scale factors, you may want to add a test showing that 0 is allowed.
For example, if this is intentional:
``` java
@Test
public void testCircleConstructorAllowsZeroScaleFactor() {
    Circle circle = new Circle(new BigDecimal("4.53"), 0);

    assertEquals(0, circle.getScaleFactor());
}
```

That would document your design decision.
If zero should not be allowed, then you should instead update both production code and tests to reject zero.
Right now, the absence of a zero-scale-factor test makes the intended rule slightly unclear.
 
Area and circumference tests
Your area test is logically good:
``` java
BigDecimal unscaledExpectedArea =
    BigDecimal.valueOf(Math.PI)
        .multiply(circle.getRadius())
        .multiply(circle.getRadius());

BigDecimal scaledExpectedArea =
    unscaledExpectedArea.setScale(scaleFactor, RoundingMode.HALF_UP);

assertEquals(scaledExpectedArea, circle.area());
```

This checks the formula and scale.
Your circumference test also checks the formula correctly:
``` java
BigDecimal unscaledExpectedCircumference =
    new BigDecimal("2")
        .multiply(new BigDecimal(Math.PI))
        .multiply(circle.getRadius());
```

However, because your production code also uses new `BigDecimal(Math.PI)` in `circumference()`, the test mirrors the implementation very closely.
That means if the implementation has a questionable choice, the test repeats the same questionable choice and still passes.
For beginner assignments, this is acceptable. Later, you may want expected values that are more independent, such as:
``` java
assertEquals(new BigDecimal("28.46"), circle.circumference());
```

That kind of test checks the final expected behavior rather than duplicating the method’s internal calculation.
 
Zero circle tests
These are good:
``` java
@Test
public void testZeroCircleArea() {
    assertEquals(
        new BigDecimal("0.00"),
        zeroCircle.area().setScale(scaleFactor, RoundingMode.HALF_UP)
    );
}
```

and:
``` java
@Test
public void testZeroCircleCircumference() {
    assertEquals(
        new BigDecimal("0.00"),
        zeroCircle.circumference().setScale(scaleFactor, RoundingMode.HALF_UP)
    );
}
```

Because your Circle allows a radius of zero, testing zero-radius behavior is important.
Small note: since `area()` and `circumference()` already return scaled values, this part is probably unnecessary:
``` java
.setScale(scaleFactor, RoundingMode.HALF_UP)
```

You could simply write:
``` java
assertEquals(new BigDecimal("0.00"), zeroCircle.area());
```

and:
``` java
assertEquals(new BigDecimal("0.00"), zeroCircle.circumference());
```

Your current version is still okay, but the simpler version would test the actual returned scale more directly.
 
Suggested Small Fixes
Fix CircleTest getter test
``` java
// ... existing code ...
    @Nested
    @DisplayName("test circle radius and scale factor getters")
    class TestCircleRadiusGetter {

        @Test
        public void testCircleConstructorGetRadius() {
            assertEquals(new BigDecimal("4.53"), circle.getRadius());
        }

        @Test
        public void testCircleConstructorGetScaleFactor() {
            assertEquals(scaleFactor, circle.getScaleFactor());
        }
    }
// ... existing code ...
```

Improve Circle circumference BigDecimal usage
``` java
// ... existing code ...
    public BigDecimal circumference() {
        BigDecimal unscaledCircumference =
            BigDecimal.valueOf(2).multiply(BigDecimal.valueOf(Math.PI)).multiply(this.getRadius());

        return unscaledCircumference.setScale(scaleFactor, RoundingMode.HALF_UP);
    }
}
```

Optional formatting version:
``` java
// ... existing code ...
    public BigDecimal circumference() {
        BigDecimal unscaledCircumference =
            BigDecimal.valueOf(2)
                .multiply(BigDecimal.valueOf(Math.PI))
                .multiply(this.getRadius());

        return unscaledCircumference.setScale(scaleFactor, RoundingMode.HALF_UP);
    }
}
```

 
Overall Grade
Shape: A
Clean, simple, correct abstract base class.
Circle: A-
Correct inheritance, correct override, good validation, good constructor chaining. Minor issue with new BigDecimal(Math.PI) and a design question around zero scale factor.
CircleTest: A-
Very good coverage and organization. One test accidentally checks the no-argument constructor instead of the test fixture object. Could also clarify whether scale factor zero is allowed.
 
Final Instructor Summary
You are doing well. This version shows that you understand the purpose of an abstract superclass and how a subclass fulfills that contract through overriding.
The biggest conceptual win here is this:
``` java
public class Circle extends Shape
```

combined with:
``` java
@Override
public BigDecimal area()
```

That is the core inheritance lesson.
You are also starting to write tests that verify both valid behavior and invalid behavior, which is a major step toward professional-quality code.
Final combined grade: A-
This is strong assignment work with only minor refinement needed.