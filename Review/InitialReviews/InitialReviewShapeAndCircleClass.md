# Instructor Evaluation Sheet
## Phase 6, Exercise 12 — `Shape` and `Circle`
**Exercise Goal:**
Create a base `Shape` class with an `area()` method, then create subclasses such as `Circle` and `Square` that override `area()`.
## Overall Grade: **A- / 90%**
You demonstrated a strong understanding of **inheritance**, **method overriding**, **constructors**, **encapsulation**, and **unit testing**. The `Circle` class is more developed than the minimum exercise requirement, and your explanation for adding a scale factor is reasonable. The main issues are relatively small: one test appears to check the wrong method, and the current `Shape.area()` implementation is somewhat artificial for a base class.
# Category Breakdown

| Category | Grade | Comments |
| --- | --- | --- |
| `Shape` base class | **B** | Correctly provides an `area()` method for subclasses to override, but the hardcoded `1.5` return value feels arbitrary for a general `Shape`. |
| `Circle` inheritance | **A** | `Circle extends Shape` correctly and overrides `area()`. This directly satisfies the central learning objective of Phase 6, Exercise 12. |
| `Circle.area()` implementation | **A-** | Correct formula and appropriate use of `BigDecimal` scaling. Minor precision concern from using `Math.PI`, but acceptable at this level. |
| Constructors | **A** | Good use of a full constructor and no-argument constructor through constructor chaining. |
| Encapsulation | **A-** | Fields are private, getters/setters are present, and validation is used. Good defensive design. |
| Validation | **A** | Radius and scale factor validation are thoughtful and go beyond the minimum requirement. |
| Testing | **B+** | Tests are organized and cover many important cases. One test seems to check circumference when its name says area. Some duplication was reasonably avoided. |
| Extension beyond requirements | **A** | Adding `circumference()` is a useful and logical enhancement. The scale factor addition is justified by decimal-place handling. |
# Detailed Instructor Comments
## 1. `Shape` Class
### Grade: **B**
Your `Shape` class satisfies the basic structural requirement:
``` java
public class Shape {
    public BigDecimal area() {
        return new BigDecimal("1.5");
    }
}
```

This gives subclasses a method to override, which is the key idea for this phase.
Strengths
The class is simple and clear.
The `area()` method gives Circle something to override.
The test verifies the current behavior of `Shape.area()`.
Main concern
For a generic Shape, returning 1.5 is not conceptually meaningful. A generic shape usually does not have a calculable area unless we know what kind of shape it is.
At this stage, it is acceptable because the exercise is focused on overriding, but as your design skills develop, you may eventually prefer one of these designs:
make `Shape.area()` return `BigDecimal.ZERO`
make `Shape.area()` throw an unsupported-operation exception
make Shape abstract and require subclasses to implement `area()`
For your current phase, I would not penalize this heavily, but I would note it as a design improvement for later.
 
2. Circle Class
Grade: A-
Your Circle class is well beyond the minimum requirements of the exercise.
You correctly used:
inheritance with extends Shape
method overriding with `@Override`
private fields
constructor chaining
validation
getters and setters
BigDecimal for numeric results
rounding through a scale factor
This is strong work.
 
3. Method Overriding
Grade: A
This is the most important part of Phase 6, Exercise 12, and you handled it correctly.
``` java
@Override
public BigDecimal area() {
    BigDecimal radiusSquared = this.getRadius().multiply(this.getRadius());
    BigDecimal unscaledArea = BigDecimal.valueOf(Math.PI).multiply(radiusSquared);

    return unscaledArea.setScale(scaleFactor, RoundingMode.HALF_UP);
}
```

This demonstrates that you understand that a subclass can provide its own version of a method inherited from a parent class.
Instructor comment
This is exactly the kind of implementation the exercise is designed to practice. The `@Override` annotation is also good practice because it lets the compiler help you catch mistakes.
 
4. Use of Scale Factor
Grade: A-
Your explanation for adding the scale factor is reasonable:
You added the scale factor because you had to deal with decimal places when calculating area and circumference.
That is a valid design choice, especially since circle calculations involve π and can produce many decimal places.
Strengths
The scale factor gives the class predictable output.
It makes tests easier to write and compare.
It gives users of the class control over precision.
Minor concern
You currently validate the scale factor as a positive integer, which means 0 is rejected. That is fine if you intentionally require at least one decimal place. However, mathematically and programmatically, a scale of 0 can be valid if someone wants whole-number rounding.
This is not wrong, but it is a design decision worth being aware of.
 
5. Circumference Method
Grade: A
Adding circumference() was not required, but it is a sensible enhancement.
``` java
public BigDecimal circumference() {
    BigDecimal unscaledCircumference =
        new BigDecimal("2").multiply(new BigDecimal(Math.PI)).multiply(this.getRadius());

    return unscaledCircumference.setScale(scaleFactor, RoundingMode.HALF_UP);
}
```

Instructor comment
This was a good extension because circumference is another major property of a circle. It also gave you another chance to practice:
instance methods
mathematical formulas
BigDecimal
rounding
unit testing
This addition shows curiosity and initiative.
 
6. Constructors
Grade: A
Your constructor design is strong.
``` java
public Circle(BigDecimal radius, int scaleFactor) {
    this.radius = ValueValidator.validateNonNegativeBigDecimalAndReturn(radius, "radius");
    this.scaleFactor = ValueValidator.validatePositiveIntAndReturn(scaleFactor, "scale factor");
}

public Circle() {
    this(new BigDecimal("1.54"), 2);
}
```

Strengths
The full constructor initializes all important fields.
The no-argument constructor uses constructor chaining.
Validation happens during construction.
Default values are clearly centralized through the full constructor.
Your note about only testing the no-argument constructor for radius and scale factor is reasonable. Since the no-argument constructor delegates to the main constructor, duplicating all validation tests for it would not add much value.
 
Testing Evaluation
Grade: B+
Your test suite is thorough and well organized. The use of nested test classes and descriptive display names is a strength.
You tested:
null radius
negative radius
zero scale factor
negative scale factor
no-argument constructor defaults
setters
getters
area calculation
circumference calculation
zero-radius behavior
That is very good coverage.
 
Strong Testing Choices
1. Constructor validation tests
You tested invalid construction cases well:
null radius
negative radius
zero scale factor
negative scale factor
This shows good understanding that constructors should prevent invalid objects from being created.
 
2. Setter validation tests
You also correctly tested setters for invalid input.
This is important because even if the object starts valid, setters could later put it into an invalid state unless guarded.
 
3. Area and circumference tests
Your expected values are calculated independently in the test, then compared to the actual method result. That is a reasonable testing approach here.
 
Testing Issue to Fix
`testZeroCircleArea()` appears to test circumference
This test name says area:
``` java
@Test
public void testZeroCircleArea() {
    Circle zeroCircle = new Circle(new BigDecimal("0.00"), scaleFactor);

    assertEquals(
        new BigDecimal("0.00"),
        zeroCircle.circumference().setScale(scaleFactor, RoundingMode.HALF_UP)
    );
}
```

But the method being tested is:
``` java
zeroCircle.circumference()
```

That means the test is not actually testing zero circle area. It should probably call:
``` java
zeroCircle.area()
```

Suggested correction
The test should check area in `testZeroCircleArea()` and circumference in `testZeroCircleCircumference()`.
This is a small but important issue because test names should accurately describe what is being verified.
 
Conceptual Understanding
Grade: A-
You are showing good understanding of the Phase 6 concepts.
This exercise was mainly about:
overriding
inheritance
parent-child class relationships
runtime method behavior
Your Circle class clearly demonstrates overriding because `Circle.area()` replaces the inherited behavior from `Shape.area()`.
You also went beyond the narrow requirement by thinking about realistic class behavior: radius, precision, validation, and circumference.
That is a good sign. You are not merely completing the syntax of the exercise; you are starting to design useful classes.
 
Instructor Notes on Your Explanation
Your note about not duplicating constructor tests
That decision is reasonable.
Because your no-argument constructor delegates to the full constructor:
``` java
public Circle() {
    this(new BigDecimal("1.54"), 2);
}
```

it is enough to test that the no-argument constructor correctly sets the expected default radius and scale factor.
Testing all the same validation paths again would be mostly duplication because the no-argument constructor does not receive external input.
So your judgment here is sound.
 
Your note about adding scale factor
This is also reasonable.
Circle area and circumference involve π, so decimal-place handling becomes unavoidable. Adding scaleFactor is a legitimate design choice, especially because you are using BigDecimal.
The only caution is that adding scale factor makes the class more complex than the original exercise required. That is not bad, but it does mean you took on extra responsibility:
validating scale factor
testing scale factor behavior
deciding whether zero scale is valid
applying the scale consistently
You handled most of that well.
 
Your note about adding circumference
This is a good enhancement.
It was not required, but it fits naturally with the domain. It also gives you more practice with method design and testing.
I would not penalize this. I would treat it as a positive extension.
 
Main Corrections Recommended
1. Fix the zero-area test
The test named `testZeroCircleArea()` should call `area()`, not `circumference()`.
Current issue:
``` java
zeroCircle.circumference()
```

Should likely be:
``` java
zeroCircle.area()
```

 
2. Consider whether Shape.area() should be abstract later
For now, your implementation is acceptable. But eventually this design:
``` java
public BigDecimal area() {
    return new BigDecimal("1.5");
}
```

may feel unnatural because a generic shape does not have a fixed area.
When you learn abstract classes, this would be a good candidate for:
``` java
public abstract class Shape {
    public abstract BigDecimal area();
}
```

But if abstract classes have not been covered yet, your current approach is fine for practicing overriding.
 
3. Check consistency with Square
The Phase 6 exercise asks for subclasses such as Circle and Square to override `area()`. Your Circle does extend Shape, but the provided Square class does not appear to extend Shape.
If Exercise 12 specifically requires both Circle and Square as subclasses of Shape, then Square should also extend Shape and mark its `area()` method with `@Override`.
That is separate from the Circle work, but relevant to the full exercise requirement.
 
Final Grade Summary
Shape: B
Meets the requirement structurally, but the hardcoded area value is not very meaningful from a design perspective.
Circle: A-
Strong implementation. Correct inheritance and overriding. Good validation, constructors, and useful extra functionality.
Tests: B+
Very good coverage and organization. One mislabeled/misdirected zero-area test should be corrected.
Overall: A- / 90%
Excellent work for this phase. You demonstrated the main concept — method overriding through inheritance — and also showed initiative by improving the realism of the Circle class with radius validation, scale factor control, and circumference calculation. The remaining issues are mostly refinement-level rather than fundamental misunderstandings.