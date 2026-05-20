```java
package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TemperatureTest {

    private Temperature temperature;

    @BeforeEach
    @DisplayName("set up temperature object for tests")
    public void setUp() {
        temperature = new Temperature(BigDecimal.valueOf(12.34), 2);
    }

    @Nested
    @DisplayName("test getters and setters")
    class TestTemperatureGetterAndSetter {

        @Test
        public void testTemperatureGetter() {
            assertEquals(
                    BigDecimal.valueOf(12.34),
                    temperature.getCurrentTemperature()
            );
        }

        @Test
        public void testTemperatureSetter() {
            temperature.setCurrentTemperature(BigDecimal.valueOf(45.67));
            assertEquals(
                    BigDecimal.valueOf(45.67),
                    temperature.getCurrentTemperature()
            );
        }
    }

    @Nested
    @DisplayName("test valid temperature conversions Celsius to Fahrenheit")
    class TestConvertValidTemperaturesCelsiusToFahrenheit {

        @Test
        public void testConvertPositiveCelsiusToFahrenheitRoundDown() {
            assertEquals(
                    BigDecimal.valueOf(78.31),
                    new Temperature(BigDecimal.valueOf(25.73), 2).convertToFahrenheit()
            );
        }

        @Test
        public void testConvertNegativeCelsiusToFahrenheitRoundUp() {
            assertEquals(
                    BigDecimal.valueOf(-53.61),
                    new Temperature(BigDecimal.valueOf(-47.56), 2).convertToFahrenheit()
            );
        }
    }

    @Nested
    @DisplayName("test valid temperature conversions Celsius to Kelvin")
    class TestConvertValidTemperaturesFahrenheitToKelvin {

        @Test
        public void testConvertPositiveCelsiusToKelvin() {
            assertEquals(
                    BigDecimal.valueOf(285.49),
                    temperature.convertToKelvin()
            );
        }

        @Test
        public void testConvertNegativeCelsiusToKelvin() {
            temperature.setCurrentTemperature(BigDecimal.valueOf(-123.45));
            assertEquals(
                    NumberUtils.setScale(BigDecimal.valueOf(149.70), 2),
                    temperature.convertToKelvin()
            );
        }
    }

    @Nested
    @DisplayName("check temperature floor for Celsius")
    class TestNegativeFloorForFahrenheitToCelsius {

        @Test
        public void testSetLowestTemperatureForCelsius() {
            temperature.setCurrentTemperature(BigDecimal.valueOf(-273.15));
            assertEquals(
                    BigDecimal.valueOf(-273.15),
                    temperature.getCurrentTemperature()
            );
        }

        @Test
        public void testSetLessThanLowestTemperatureForCelsius() {
            assertEquals(
                    Temperature.TEMPERATURE_VIOLATION,
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> temperature.setCurrentTemperature(BigDecimal.valueOf(-273.16))
                    ).getMessage()
            );
        }

        @Test
        public void testInitializeLowestTemperatureForCelsius() {
            Temperature temperature = new Temperature(BigDecimal.valueOf(-273.15), 2);
            assertEquals(
                    BigDecimal.valueOf(-273.15),
                    temperature.getCurrentTemperature()
            );
        }

        @Test
        public void testInitializeLessThanLowestTemperatureForCelsius() {
            assertEquals(
                    Temperature.TEMPERATURE_VIOLATION,
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Temperature(BigDecimal.valueOf(-273.16), 2)
                    ).getMessage()
            );
        }
    }
}

```
```java
package org.example;

import java.math.BigDecimal;

public class Temperature {

    private final BigDecimal CONVERSION_TO_FAHRENHEIT_MULTIPLIER = BigDecimal.valueOf(9.00/5.00);

    private final BigDecimal CONVERSION_TO_FAHRENHEIT_ADDEND = BigDecimal.valueOf(32);

    private final BigDecimal CONVERSION_TO_KELVIN_ADDEND = BigDecimal.valueOf(273.15);

    private BigDecimal currentTemperature = BigDecimal.valueOf(0.00);

    private final int scaleFactor;

    public final static String TEMPERATURE_VIOLATION =
            "Upon conversion to Kelvin, entered temperature is below absolute zero.";

    public BigDecimal convertToFahrenheit() {
        if (this.convertToKelvin().compareTo(BigDecimal.valueOf(0.00)) < 0) {
            throw new IllegalArgumentException(TEMPERATURE_VIOLATION);
        } else {
            BigDecimal rawConversion =
                    this.getCurrentTemperature().multiply(CONVERSION_TO_FAHRENHEIT_MULTIPLIER)
                            .add(CONVERSION_TO_FAHRENHEIT_ADDEND);
            return NumberUtils.setScale(rawConversion, scaleFactor);
        }
    }

    public BigDecimal convertToKelvin() {
        BigDecimal rawConversion = this.getCurrentTemperature().add(CONVERSION_TO_KELVIN_ADDEND);
        if (rawConversion.compareTo(BigDecimal.valueOf(0.00)) < 0) {
            throw new IllegalArgumentException(TEMPERATURE_VIOLATION);
        } else {
            return NumberUtils.setScale(rawConversion, getScaleFactor());
        }
    }

    public Temperature(BigDecimal C, int scaling) {
        scaleFactor = scaling;
        BigDecimal validTemperature = this.checkForValidTemperature(C);
        this.currentTemperature = NumberUtils.setScale(
                validTemperature,
                scaleFactor
        );
    }

    public Temperature(BigDecimal C) {
        this(C, 2);
    }

    public Temperature() {
        this(BigDecimal.valueOf(100.00), 2);
    }

    private int getScaleFactor() {
        return scaleFactor;
    }

    public BigDecimal getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(BigDecimal currentTemperature) {
        this.currentTemperature = this.checkForValidTemperatureAndScale(currentTemperature);
    }

    private BigDecimal checkForValidTemperature(BigDecimal C) {
        BigDecimal kelvinConversion = C.add(CONVERSION_TO_KELVIN_ADDEND);
        if (kelvinConversion.compareTo(BigDecimal.valueOf(0.00)) < 0) {
            throw new IllegalArgumentException(TEMPERATURE_VIOLATION);
        } else {
            return C;
        }
    }

    private BigDecimal checkForValidTemperatureAndScale(BigDecimal C) {
        return NumberUtils.setScale(
                this.checkForValidTemperature(C),
                scaleFactor
        );
    }
}
```
Assistant: 
# Instructor-Style Grading Sheet: `Temperature` Class

## Overall Grade: **A- / B+**

The `Temperature` class is a strong implementation overall. It demonstrates good understanding of **encapsulation**, **constructors**, **validation**, **method behavior**, and **unit testing**. The tests cover the most important behavior, especially valid conversions and invalid temperatures below absolute zero.

The main issues are not major functional failures, but rather **naming clarity**, **style consistency**, a little **unnecessary logic**, and some **missing test cases** around constructors, scale behavior, and boundary conversions.

---

# 1. Meeting Requirements

## Grade: **A-**

### Expected Requirements

Based on the assignment/review goal, the class should:

- Store a temperature in Celsius privately
- Provide a way to get/set the Celsius temperature
- Convert Celsius to Fahrenheit
- Convert Celsius to Kelvin
- Reject temperatures below absolute zero
- Demonstrate encapsulation
- Use constructors appropriately

### Evaluation

| Requirement | Status | Notes |
|---|---:|---|
| Stores Celsius temperature privately | ✅ Met | `currentTemperature` is private. |
| Provides getter | ✅ Met | `getCurrentTemperature()` works. |
| Provides setter | ✅ Met | `setCurrentTemperature()` validates input. |
| Converts Celsius to Fahrenheit | ✅ Met | Formula is correct: `C * 9/5 + 32`. |
| Converts Celsius to Kelvin | ✅ Met | Formula is correct: `C + 273.15`. |
| Rejects below absolute zero | ✅ Met | Constructor and setter both validate. |
| Uses constructor overloading | ✅ Met | Three constructors are present. |
| Uses constructor chaining | ✅ Met | The one-argument and no-argument constructors chain properly. |
| Encapsulation | ✅ Mostly met | Good use of private fields and validation. |
| Uses `BigDecimal` | ✅ Met | Good precision-conscious choice. |

### Instructor Comments

This class meets the core assignment well. The strongest part is that invalid temperature values are rejected both during construction and when using the setter. That shows a good understanding of protecting object state.

The design would be a little clearer if the internal Celsius field had a more explicit name, such as `celsius` or `currentTemperatureCelsius`, because right now `currentTemperature` does not immediately tell the reader what scale it uses.

---

# 2. Correctness of Logic

## Grade: **A-**

### Fahrenheit Conversion

```java
Celsius * 9 / 5 + 32
```

The implementation correctly uses:

```java
this.getCurrentTemperature().multiply(CONVERSION_TO_FAHRENHEIT_MULTIPLIER)
        .add(CONVERSION_TO_FAHRENHEIT_ADDEND);
```

This is correct.

### Kelvin Conversion

```java
Celsius + 273.15
```

The implementation correctly uses:

```java
this.getCurrentTemperature().add(CONVERSION_TO_KELVIN_ADDEND);
```

This is also correct.

### Absolute Zero Validation

The class rejects values where:

```java
C + 273.15 < 0
```

That means it rejects Celsius values below `-273.15`, which is correct.

### Minor Logic Issue

In `convertToFahrenheit()`, this check is unnecessary:

```java
if (this.convertToKelvin().compareTo(BigDecimal.valueOf(0.00)) < 0)
```

Because:

1. The constructor already rejects invalid temperatures.
2. The setter already rejects invalid temperatures.
3. `convertToKelvin()` itself already throws if the value is invalid.
4. `convertToKelvin()` returns a scaled value and will never return a negative value without throwing first.

So the check does not hurt the class, but it is redundant.

A cleaner `convertToFahrenheit()` method would simply perform the Fahrenheit conversion.

---

# 3. Encapsulation and Object Design

## Grade: **A-**

### Strengths

The class does a good job hiding internal data:

```java
private BigDecimal currentTemperature;
```

The setter protects the object from entering invalid state:

```java
public void setCurrentTemperature(BigDecimal currentTemperature) {
    this.currentTemperature = this.checkForValidTemperatureAndScale(currentTemperature);
}
```

This is a good example of encapsulation.

### Good Design Choices

- Validation is centralized in helper methods.
- Constructors validate before assigning.
- The field is private.
- The scale factor is final.
- The class prevents temperatures below absolute zero.

### Areas to Improve

The constants should probably be `static final`, because they are shared conversion constants and do not need to belong separately to each object.

Current:

```java
private final BigDecimal CONVERSION_TO_FAHRENHEIT_MULTIPLIER = BigDecimal.valueOf(9.00/5.00);
```

Better style:

```java
private static final BigDecimal CONVERSION_TO_FAHRENHEIT_MULTIPLIER = BigDecimal.valueOf(1.8);
```

Or even better:

```java
private static final BigDecimal CONVERSION_TO_FAHRENHEIT_MULTIPLIER =
        BigDecimal.valueOf(9).divide(BigDecimal.valueOf(5));
```

For this course level, the current version is acceptable, but as Java style improves, constants should usually be `static final`.

---

# 4. Constructor Design

## Grade: **A**

### Constructors Present

```java
public Temperature(BigDecimal C, int scaling)
public Temperature(BigDecimal C)
public Temperature()
```

This is good constructor overloading.

### Constructor Chaining

```java
public Temperature(BigDecimal C) {
    this(C, 2);
}

public Temperature() {
    this(BigDecimal.valueOf(100.00), 2);
}
```

This is good. The class has one main constructor and the other constructors delegate to it.

### Instructor Comment

This is one of the stronger areas of the submission. Constructor chaining is used correctly and cleanly.

### Minor Naming Issue

The parameter name `C` should be improved. Java variable names should generally be lower camel case.

Current:

```java
public Temperature(BigDecimal C, int scaling)
```

Better:

```java
public Temperature(BigDecimal celsius, int scaling)
```

This is not a logic issue, but it is a style/readability issue.

---

# 5. Method Names

## Grade: **B+**

### Good Method Names

These are clear:

```java
convertToFahrenheit()
convertToKelvin()
getCurrentTemperature()
setCurrentTemperature()
```

They communicate the purpose of the methods.

### Method Names That Could Improve

#### `getCurrentTemperature()`

This method works, but it does not identify the unit.

Since the object stores Celsius, a clearer name would be:

```java
getCelsius()
```

or:

```java
getCurrentTemperatureCelsius()
```

#### `setCurrentTemperature()`

Same issue. Better:

```java
setCelsius(BigDecimal celsius)
```

or:

```java
setCurrentTemperatureCelsius(BigDecimal celsius)
```

#### `checkForValidTemperature()`

This name is acceptable, but slightly vague. It checks specifically for Celsius values below absolute zero.

A clearer name would be:

```java
validateCelsiusAboveAbsoluteZero()
```

or:

```java
validateCelsiusTemperature()
```

#### `checkForValidTemperatureAndScale()`

This method is accurate but a bit long and procedural. Still understandable.

### Instructor Comment

The method names are mostly good. The main improvement would be to include the word **Celsius** somewhere in the getter/setter or field name so future readers know the internal unit.

---

# 6. Test Method Names

## Grade: **B+**

The individual test method names are mostly descriptive and useful.

### Strong Test Names

Examples:

```java
testConvertPositiveCelsiusToFahrenheitRoundDown()
testConvertNegativeCelsiusToFahrenheitRoundUp()
testSetLessThanLowestTemperatureForCelsius()
testInitializeLessThanLowestTemperatureForCelsius()
```

These are clear and explain the scenario being tested.

### Naming Problems

Some nested class names refer to the wrong conversion direction.

Example:

```java
class TestConvertValidTemperaturesFahrenheitToKelvin
```

But the tests are actually converting **Celsius to Kelvin**, not Fahrenheit to Kelvin.

Better:

```java
class TestConvertValidTemperaturesCelsiusToKelvin
```

Another example:

```java
class TestNegativeFloorForFahrenheitToCelsius
```

But this section is checking the lower bound for Celsius values.

Better:

```java
class TestAbsoluteZeroBoundaryForCelsius
```

### Instructor Comment

The test method names are mostly good, but some nested class names contain unit mismatches. This is important because test names serve as documentation. If the test name says Fahrenheit but the code is using Celsius, it creates confusion even if the test itself is correct.

---

# 7. Test Coverage

## Grade: **B+**

### Covered Well

The test suite covers:

- Getter behavior
- Setter behavior
- Positive Celsius to Fahrenheit conversion
- Negative Celsius to Fahrenheit conversion
- Positive Celsius to Kelvin conversion
- Negative Celsius to Kelvin conversion
- Setting temperature exactly at absolute zero
- Setting temperature below absolute zero
- Initializing temperature exactly at absolute zero
- Initializing temperature below absolute zero

This is a good set of tests.

---

## Missing or Recommended Tests

### 1. Default Constructor Test

The class has:

```java
public Temperature() {
    this(BigDecimal.valueOf(100.00), 2);
}
```

There should be a test confirming that the default constructor creates the expected starting temperature.

Recommended test idea:

```java
@Test
public void testDefaultConstructorSetsTemperatureToOneHundredCelsius() {
    Temperature temperature = new Temperature();

    assertEquals(
            BigDecimal.valueOf(100.00),
            temperature.getCurrentTemperature()
    );
}
```

---

### 2. One-Argument Constructor Test

The class has:

```java
public Temperature(BigDecimal C) {
    this(C, 2);
}
```

There should be a test confirming that the one-argument constructor uses a scale of `2`.

---

### 3. Scale Factor Behavior

Since the class allows a custom scale factor, tests should verify that scaling actually works.

Examples:

- Input with more than two decimals gets rounded/scaled correctly.
- Fahrenheit conversion respects the scale.
- Kelvin conversion respects the scale.

For example, if a temperature is constructed with scale `1`, the output should be rounded to one decimal place.

---

### 4. Exact Freezing/Boiling Point Tests

It would be useful to test common known conversions:

| Celsius | Fahrenheit | Kelvin |
|---:|---:|---:|
| `0.00` | `32.00` | `273.15` |
| `100.00` | `212.00` | `373.15` |
| `-40.00` | `-40.00` | `233.15` |

These make excellent sanity checks because they are easy to verify.

---

### 5. Fahrenheit at Absolute Zero

The tests check Kelvin boundary behavior, but not Fahrenheit conversion at absolute zero.

Expected:

```text
-273.15°C = -459.67°F
```

A test for that would strengthen coverage.

---

# 8. BigDecimal Usage

## Grade: **B+**

### Strengths

Using `BigDecimal` is a good choice for precision-sensitive decimal calculations.

### Minor Concern

This line uses double arithmetic before creating the `BigDecimal`:

```java
BigDecimal.valueOf(9.00/5.00)
```

This evaluates `9.00 / 5.00` as a `double` first, then creates the `BigDecimal`.

In this specific case, it is probably fine because `1.8` is simple and `BigDecimal.valueOf(double)` uses a string conversion internally. However, stylistically, with `BigDecimal`, it is often better to avoid floating-point arithmetic entirely.

Better:

```java
BigDecimal.valueOf(9).divide(BigDecimal.valueOf(5))
```

or simply:

```java
BigDecimal.valueOf(1.8)
```

For this assignment level, this is a minor issue.

---

# 9. Code Style and Readability

## Grade: **B+**

### Strengths

- Code is readable.
- Methods are short.
- Validation is separated into helper methods.
- Constructor chaining is easy to follow.
- Constants make formulas easier to understand.

### Areas to Improve

#### 1. Constants Should Be Static

Current:

```java
private final BigDecimal CONVERSION_TO_KELVIN_ADDEND = BigDecimal.valueOf(273.15);
```

Better:

```java
private static final BigDecimal CONVERSION_TO_KELVIN_ADDEND = BigDecimal.valueOf(273.15);
```

These values are not different per object, so they should belong to the class, not each instance.

#### 2. Field Name Should Mention Celsius

Current:

```java
private BigDecimal currentTemperature;
```

Better:

```java
private BigDecimal currentTemperatureCelsius;
```

or:

```java
private BigDecimal celsius;
```

#### 3. Parameter Name Should Not Be Capitalized

Current:

```java
public Temperature(BigDecimal C, int scaling)
```

Better:

```java
public Temperature(BigDecimal celsius, int scaling)
```

Capitalized identifiers are normally used for classes, interfaces, enums, and type names in Java.

---

# 10. Possible Functional Risks

## Grade: **B+**

There are no major functional risks for normal use.

The main concerns are:

1. **Null input is not handled**
   - `new Temperature(null, 2)` would throw a `NullPointerException`.
   - `setCurrentTemperature(null)` would also throw a `NullPointerException`.

2. **Negative scale values may cause errors**
   - If someone passes a negative `scaling` value, behavior depends on `NumberUtils.setScale`.
   - It may throw an exception or behave unexpectedly.

3. **Redundant validation in `convertToFahrenheit()`**
   - Not harmful, but unnecessary.

These are more advanced robustness issues, not major assignment failures.

---

# 11. Suggested Score Breakdown

| Category | Points | Score |
|---|---:|---:|
| Meets functional requirements | 25 | 23 |
| Constructors and initialization | 15 | 14 |
| Encapsulation | 15 | 14 |
| Method correctness | 15 | 14 |
| Naming and readability | 10 | 8 |
| Test coverage | 15 | 12 |
| Test naming/organization | 5 | 4 |
| **Total** | **100** | **89** |

## Final Score: **89 / 100**

Letter grade: **B+ / A-**

---

# Final Instructor Feedback

This is a strong submission. The class correctly models a Celsius-based temperature, prevents invalid temperatures below absolute zero, and provides correct conversions to Fahrenheit and Kelvin. The tests demonstrate a good effort to verify normal behavior, negative values, and boundary cases.

The biggest improvements would be:

1. Rename fields/methods or parameters to make it clear the stored value is Celsius.
2. Fix test group names that accidentally mention Fahrenheit when testing Celsius/Kelvin behavior.
3. Add tests for the default constructor, one-argument constructor, custom scale behavior, and common known conversions like `0°C`, `100°C`, and `-40°C`.
4. Make conversion constants `static final`.
5. Remove redundant validation from `convertToFahrenheit()`.

Overall, this shows solid progress with classes, constructors, encapsulation, validation, and unit testing. The code is beyond a minimal solution and demonstrates thoughtful design.

kotlin.Unit

## Me
Though it will happen tomorrow, I plan to fix all the issues and resubmit for another grade.  Each time I code I want the final product to be perfect.  I feel it is only by writing correct code over and over that I gain an understanding of what it means to write good code.

## AI Assistant

That is an excellent mindset, with one small adjustment:
Aim for “professional-quality,” not emotionally perfect
Wanting each final product to be as correct, clean, and thoughtful as possible is a very good habit. That is how you build taste as a programmer.
But “perfect” can become a trap if it makes you afraid to write imperfect first drafts. Good programmers usually work like this:
Make it work
Make it correct
Make it clean
Make it well-tested
Review it like someone else will maintain it
That process is how strong code gets written.
Your instinct is right: repeated practice writing correct, readable, tested code is how you develop judgment.
 
For your Temperature resubmission, your goal should be:
1. Correct behavior
The class should clearly and correctly support:
storing Celsius
converting Celsius to Fahrenheit
converting Celsius to Kelvin
rejecting temperatures below absolute zero
respecting the requested scale
using constructor chaining properly
 
2. Clear naming
Make the code explain itself.
For example, prefer names like:``` java
private BigDecimal celsius;
```

or:``` java
private BigDecimal currentTemperatureCelsius;
```

over:``` java
private BigDecimal currentTemperature;
```

Because the second version leaves the reader asking, “Current temperature in what unit?”
That is the kind of naming improvement that separates merely working code from good code.
 
3. Strong validation
Good code protects its own state.
Your Temperature object should not be allowed to represent an impossible temperature. That means validation belongs in:
constructors
setters
You already did this well. Your resubmission can make it cleaner.
 
4. Clean tests
Your tests should read like a checklist of behavior.
A strong test suite might include:
Constructor tests
full constructor stores Celsius correctly
one-argument constructor uses default scale
no-argument constructor uses default value
constructor rejects below absolute zero
Getter/setter tests
getter returns Celsius
setter updates Celsius
setter applies scale
setter rejects below absolute zero
Conversion tests
0°C to Fahrenheit is 32.00°F
100°C to Fahrenheit is 212.00°F
-40°C to Fahrenheit is -40.00°F
0°C to Kelvin is 273.15K
100°C to Kelvin is 373.15K
-273.15°C to Kelvin is 0.00K
-273.15°C to Fahrenheit is -459.67°F
Scale tests
scale 1 returns one decimal place
scale 3 returns three decimal places
 
A good “perfect enough” checklist
Before you resubmit, ask yourself:
Class design
Are fields private?
Are constants private static final?
Do field names clearly describe the unit?
Do constructors chain properly?
Is invalid state prevented?
Method design
Does each method do one clear thing?
Are method names accurate?
Is there any duplicated or redundant logic?
Are helper methods private when only used internally?
Testing
Do tests cover normal cases?
Do tests cover edge cases?
Do tests cover invalid input?
Do test names accurately describe behavior?
Do nested test class names match what they are testing?
Readability
Could another beginner understand this code?
Could future-you understand this code quickly?
Are there any misleading names?
Is the formatting consistent?
 
The deeper learning point
You are not just learning how to make a Temperature class.
You are learning how to think like this:
“What states should this object allow?” “What states should be impossible?” “What should be public?” “What should stay private?” “How do I prove this works?” “Would the names make sense to someone else?”
That is object-oriented programming.
 
My recommendation for tomorrow
When you come back to fix it, do not try to change everything randomly.
Work in this order:
Rename for clarity
make it obvious the stored value is Celsius
Improve constants
make conversion constants static final
Simplify redundant logic
especially in convertToFahrenheit()
Add missing tests
constructor tests
scale tests
known conversion tests
Run tests
make sure the existing tests and new tests pass
Ask for a second grade
I can then grade it again stricter, as a resubmission
 
You are approaching this the right way. If you keep practicing with this level of care, you will start to develop an internal sense for clean code. At first, you need checklists and reviews. Eventually, you will start seeing these issues before anyone points them out.

## Me
Yes, "professional-quality" is less emotional.

## AI Assistant

Exactly. “Professional-quality” is a much healthier and more useful target than “perfect.”
“Perfect” can make every flaw feel personal.
“Professional-quality” turns it into an engineering question:
Does this code meet the requirements? Is it readable? Is it maintainable? Is it tested? Does it prevent invalid state? Would another developer understand it?
That is much more objective.
 
A good mindset shift
Instead of:
“I need this to be perfect.”
Use:
“I want this to be correct, clear, tested, and maintainable.”
That is exactly what professional developers aim for.
 
Professional-quality code usually means:
Correct: it does what it is supposed to do
Readable: the names and structure explain the intent
Maintainable: future changes would be easy
Tested: important behavior is verified
Robust: invalid states are prevented or handled
Consistent: style and formatting match the rest of the project
 
And importantly:
Professional-quality does not mean the first version is great.
It means you know how to improve code through a process:
Write a working version
Test it
Notice weak spots
Refactor
Test again
Review again
That is exactly what you are doing with the Temperature class.


