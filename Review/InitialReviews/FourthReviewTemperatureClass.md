```java
package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * Stores a Celsius temperature, provides conversion to Kelvin and Fahrenheit.
 * @author Eric Ricketts
 * @version 1.0-SNAPSHOT
 */
public class Temperature {
    private static final BigDecimal CONVERSION_TO_FAHRENHEIT_MULTIPLIER =
            new BigDecimal("9.00").divide(new BigDecimal("5.00"), RoundingMode.HALF_UP);

    private static final BigDecimal CONVERSION_TO_FAHRENHEIT_ADDEND = BigDecimal.valueOf(32);

    private static final BigDecimal CONVERSION_TO_KELVIN_ADDEND = BigDecimal.valueOf(273.15);

    private BigDecimal celsius = BigDecimal.valueOf(0.00);

    public static final String TEMPERATURE_VALUE_TOO_LOW =
            "Upon conversion to Kelvin, entered temperature is below absolute zero.";

    public static final String NULL_VALUE_NOT_ALLOWED =
            "Null value is not allowed for a temperature entry";

    public static final String SCALE_FACTOR_VALUE_NEGATIVE =
            "Negative value is not allowed for scale factor";

    public static final String SCALE_FACTOR_VALUE_TOO_LARGE =
            "Scale factor is too large, keep to four decimals or less";

    private final int scaleFactor;

    public BigDecimal convertToFahrenheit() {
            BigDecimal rawConversion =
            this.getCelsius().multiply(CONVERSION_TO_FAHRENHEIT_MULTIPLIER).add(CONVERSION_TO_FAHRENHEIT_ADDEND);

            return NumberUtils.setScale(rawConversion, scaleFactor);
    }

    public BigDecimal convertToKelvin() {
        BigDecimal rawConversion = this.getCelsius().add(CONVERSION_TO_KELVIN_ADDEND);
        return NumberUtils.setScale(rawConversion, getScaleFactor());
    }

    /**
     * a referenced constructor in a constructor chaining
     * scale factor is checked for negative values, and for excessive accuracy
     * temperature value is checked for null values and below absolute zero
     * @param celsius stored temperature
     * @param scaling stored scaling value
     */
    public Temperature(BigDecimal celsius, int scaling) {
        scaleFactor = this.validateScaleFactor(scaling);
        BigDecimal validTemperature = this.validateCelsius(celsius);
        this.celsius = NumberUtils.setScale(
                validTemperature,
                scaleFactor
        );
    }

    public Temperature(BigDecimal celsius) {
        this(celsius, 2);
    }

    public Temperature() {
        this(BigDecimal.valueOf(0.00), 2);
    }

    public BigDecimal getCelsius() {
        return celsius;
    }

    public void setCelsius(BigDecimal celsius) {
        this.celsius = this.scaleValidatedCelsius(celsius);
    }

    public int getScaleFactor() {
        return scaleFactor;
    }

    /**
     * Celsius temperature is first checked for null value and then checked if it is under absolute zero
     * @param celsius - proposed temperature for the object
     * @return a valid temperature, if the temperature is invalid, an exception is thrown
     */
    private BigDecimal validateCelsius(BigDecimal celsius) {
        if (Objects.isNull(celsius)) {
            throw new NullPointerException(NULL_VALUE_NOT_ALLOWED);
        } else if (celsius.add(CONVERSION_TO_KELVIN_ADDEND).compareTo(BigDecimal.valueOf(0.00)) < 0) {
            throw new IllegalArgumentException(TEMPERATURE_VALUE_TOO_LOW);
        } else {
            return celsius;
        }
    }

    /**
     * input temperature is first validated and then returned after applying the object's scale factor
     * @param celsius - Celsius temperature to be validated and scaled
     * @return Validated temperature with scaling
     */
    private BigDecimal scaleValidatedCelsius(BigDecimal celsius) {
        return NumberUtils.setScale(
                this.validateCelsius(celsius),
                scaleFactor
        );
    }

    /**
     * checks that the scale factor is not negative and within the accuracy bounds
     * @param scaleFactor - proposed decimal accuracy for the object
     * @return validated decimal accuracy for use by the object
     */
    private int validateScaleFactor(int scaleFactor) {
        if (scaleFactor < 0) {
            throw new IllegalArgumentException(SCALE_FACTOR_VALUE_NEGATIVE);
        } else if (scaleFactor > 4) {
            throw new IllegalArgumentException(SCALE_FACTOR_VALUE_TOO_LARGE);
        } else {
            return scaleFactor;
        }
    }
}
```
Attachment Name: Information about open file in the editor
Attachments Kind: Visible
Attachments Source: CurrentFileRetriever / CurrentFileChatAttachment
Attachments Text:
```java
package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TemperatureTest {

    private Temperature temperature;

    @BeforeEach
    @DisplayName("set up temperature object for tests")
    public void setUp() {
        temperature = new Temperature(new BigDecimal("12.34"), 2);
    }

    @Nested
    @DisplayName("test getters and setters")
    class TestTemperatureGettersAndSetters {

        @Test
        public void testTemperatureGetter() {
            assertEquals(
                    new BigDecimal("12.34"),
                    temperature.getCelsius()
            );
        }

        @Test
        public void testTemperatureSetter() {
            temperature.setCelsius(new BigDecimal("45.67"));
            assertEquals(
                    new BigDecimal("45.67"),
                    temperature.getCelsius()
            );
        }

        @Test
        public void testScaleFactorGetter() {
            assertEquals(
                    2,
                    temperature.getScaleFactor()
            );
        }
    }

    @Nested
    @DisplayName("test convert Celsius to Fahrenheit")
    class TestConvertCelsiusToFahrenheit {

        @ParameterizedTest
        @CsvSource(
            {
                "54.34, 1, 129.7",
                "54.35, 1, 129.9",
                "25.73, 2, 78.31",
                "-47.56, 2, -53.61",
                "25.733, 3, 78.319",
                "-47.561, 3, -53.610",
                "25.7334, 4, 78.3201",
                "-47.5612, 4, -53.6102"
            }
        )

        public void testConvertCelsiusToFahrenheitAllScaleFactors(
            String temperatureValue, int scaleFactor, String expected
        ) {
            temperature = new Temperature(new BigDecimal(temperatureValue), scaleFactor);
            assertEquals(
                new BigDecimal(expected),
                temperature.convertToFahrenheit()
            );
        }
    }

    @Nested
    @DisplayName("test convert Celsius to Kelvin")
    class TestConvertCelsiusToKelvin {

        @Test
        public void testConvertPositiveCelsiusToKelvin() {
            assertEquals(
                    new BigDecimal("285.49"),
                    temperature.convertToKelvin()
            );
        }

        @Test
        public void testConvertNegativeCelsiusToKelvin() {
            temperature.setCelsius(new BigDecimal("-123.45"));
            assertEquals(
                    new BigDecimal("149.70"),
                    temperature.convertToKelvin()
            );
        }
    }

    @Nested
    @DisplayName("check temperature floor for Celsius")
    class TestAbsoluteZeroBoundary {

        @Test
        public void testAbsoluteZeroForSetterAndConstructor() {
            assertAll("Absolute zero is a valid temperature",
                () -> {
                    temperature.setCelsius(new BigDecimal("-273.15"));
                    assertEquals(new BigDecimal("-273.15"), temperature.getCelsius());
                },
                () -> {
                    temperature = new Temperature(new BigDecimal("-273.15"), 2);
                    assertEquals(new BigDecimal("-273.15"), temperature.getCelsius());
                }
            );
        }

        @Test
        public void testBelowAbsoluteZeroForSetterAndConstructor() {
            assertAll("Under absolute zero is not allowed",
                () -> assertEquals(
                    Temperature.TEMPERATURE_VALUE_TOO_LOW,
                    assertThrows(
                        IllegalArgumentException.class,
                        () -> temperature.setCelsius(new BigDecimal("-273.16"))
                    ).getMessage()
                ),
                () -> assertEquals(
                    Temperature.TEMPERATURE_VALUE_TOO_LOW,
                    assertThrows(
                        IllegalArgumentException.class,
                        () -> new Temperature(new BigDecimal("-273.16"), 2)
                    ).getMessage()
                )
            );
        }
    }

    @Nested
    @DisplayName("zero, one and two argument constructor tests")
    class TestTemperatureConstructors {

        @Test
        public void testAllConstructors() {
            assertAll("all constructor variations tested for valid object creation",
                () -> {
                    temperature = new Temperature();
                    assertEquals(new BigDecimal("0.00"), temperature.getCelsius());
                    assertEquals(2, temperature.getScaleFactor());
                },
                () -> {
                    temperature = new Temperature(new BigDecimal("98.76"));
                    assertEquals(new BigDecimal("98.76"), temperature.getCelsius());
                    assertEquals(2, temperature.getScaleFactor());
                },
                () -> {
                    temperature = new Temperature(new BigDecimal("67.89"), 2);
                    assertEquals(new BigDecimal("67.89"), temperature.getCelsius());
                    assertEquals(2, temperature.getScaleFactor());
                }
            );
        }
    }

    @Nested
    @DisplayName("test different scale factors")
    class TestScaleFactorsForTemperature {

        static Stream<Arguments> invalidScaleFactorProvider() {
            return Stream.of(
                arguments("23.45", -2, Temperature.SCALE_FACTOR_VALUE_NEGATIVE),
                arguments("23.45", 5, Temperature.SCALE_FACTOR_VALUE_TOO_LARGE)
            );
        }

        @ParameterizedTest
        @CsvSource({"87.65, 0, 88", "87.45, 0, 87", "87.65, 1, 87.7", "87.64, 1, 87.6"})
        public void testScaleFactorsZeroAndOne (String temperatureValue, int scaleFactor, String result) {
            temperature = new Temperature(new BigDecimal(temperatureValue), scaleFactor);
            assertEquals(
                new BigDecimal(result),
                temperature.getCelsius()
            );
        }

        @ParameterizedTest
        @CsvSource({"34.455, 2, 34.46", "34.454, 2, 34.45", "87.7475, 3, 87.748", "87.7474, 3, 87.747"})
        public void testScaleFactorsTwoAndThree (String temperatureValue, int scaleFactor, String result) {
            temperature = new Temperature(new BigDecimal(temperatureValue), scaleFactor);
            assertEquals(
                new BigDecimal(result),
                temperature.getCelsius()
            );
        }

        @ParameterizedTest
        @CsvSource({"12.34565, 4, 12.3457", "12.34564, 4, 12.3456"})
        public void testScaleFactorFour(String temperatureValue, int scaleFactor, String result) {
            temperature = new Temperature(new BigDecimal(temperatureValue), scaleFactor);
            assertEquals(
                new BigDecimal(result),
                temperature.getCelsius()
            );
        }

        @ParameterizedTest
        @MethodSource("invalidScaleFactorProvider")
        public void testScaleFactorsNegativeAndTooLarge(String temperatureValue, int scaleFactor, String expected) {
            assertEquals(
                expected,
                assertThrows(
                    IllegalArgumentException.class,
                    () -> new Temperature(new BigDecimal(temperatureValue), scaleFactor)
                ).getMessage()
            );
        }
    }

    @Nested
    @DisplayName("test exact freezing and boiling points")
    class TestFreezingAndBoilingPoints {

        @Test
        public void testFreezingAndBoilingPoints() {
            assertAll("Freezing and boiling points in Fahrenheit and Kelvin",
                () -> {
                    temperature = new Temperature(new BigDecimal("0.00"), 2);
                    assertEquals(new BigDecimal("32.00"), temperature.convertToFahrenheit());
                    assertEquals(new BigDecimal("273.15"), temperature.convertToKelvin());
                },
                () -> {
                    temperature = new Temperature(new BigDecimal("100.00"), 2);
                    assertEquals(new BigDecimal("212.00"), temperature.convertToFahrenheit());
                    assertEquals(new BigDecimal("373.15"), temperature.convertToKelvin());
                },
                () -> {
                    temperature = new Temperature(new BigDecimal("-40.00"), 2);
                    assertEquals(new BigDecimal("-40.00"), temperature.convertToFahrenheit());
                }
            );
        }
    }

    @Nested
    @DisplayName("test null values in setters and constructors")
    class TestNullValuesInSettersAndConstructors {

        @Test
        public void testNullValuesInSettersAndOneAndTwoArgumentConstructors() {
            assertAll("Null values not allowed in setters and constructors",
                () -> assertEquals(
                    Temperature.NULL_VALUE_NOT_ALLOWED,
                    assertThrows(
                        NullPointerException.class,
                        () -> temperature.setCelsius(null)
                    ).getMessage()
                ),
                () -> assertEquals(
                    Temperature.NULL_VALUE_NOT_ALLOWED,
                    assertThrows(
                        NullPointerException.class,
                        () -> new Temperature(null)
                    ).getMessage()
                ),
                () -> assertEquals(
                    Temperature.NULL_VALUE_NOT_ALLOWED,
                    assertThrows(
                        NullPointerException.class,
                        () -> new Temperature(null, 2)
                    ).getMessage()
                )
            );
        }
    }
}
```
==== SimpleCompletableMessage #2 ====
Assistant: 
# Instructor-Style Grading Sheet: `Temperature` and `TemperatureTest`

## Overall Grade: **A- / B+**

You have a strong submission overall. The `Temperature` class is functional, reasonably well organized, and demonstrates good use of `BigDecimal`, validation, constructor chaining, constants, and unit testing. Your test suite is especially thorough and shows that you are thinking carefully about edge cases such as absolute zero, null inputs, scale factors, and rounding behavior.

The main areas holding the work back from a full A are mostly **code style consistency**, **minor design choices**, and **a few testing/design refinements** rather than major correctness problems.

---

## Grading Breakdown

| Category | Score | Comments |
|---|---:|---|
| Correctness | **23 / 25** | Temperature conversion logic appears correct. Celsius-to-Fahrenheit and Celsius-to-Kelvin conversions are implemented properly. Absolute zero validation is handled well. |
| Use of `BigDecimal` / Precision | **18 / 20** | Good decision to use `BigDecimal` for decimal temperature values. String constructors are used in tests, which is excellent. A few constants use `BigDecimal.valueOf(double)` where string-based construction would be slightly clearer and safer. |
| Class Design / Encapsulation | **17 / 20** | Good encapsulation with private fields and public getters/setters. Validation is centralized in helper methods. `scaleFactor` being `final` is a good choice. Some public constants expose implementation details intended primarily for tests. |
| Validation / Error Handling | **14 / 15** | Strong validation for null temperatures, absolute zero, and scale factor limits. Exception messages are clear. Consider whether `IllegalArgumentException` may be preferable to `NullPointerException` for invalid method arguments. |
| Unit Testing | **24 / 25** | Very thorough test coverage. Good use of nested test classes, parameterized tests, `assertAll`, and boundary testing. Some tests could be separated further for readability and diagnostics. |
| Style / Readability | **8 / 10** | Code is readable and understandable. Minor indentation issues and line wrapping problems appear in a few places. Javadocs are helpful but could be polished. |
| Maintainability | **8 / 10** | Constants and helper methods improve maintainability. Some magic limits, such as maximum scale factor of `4`, could be named with a constant. |

## Final Score: **112 / 125 — 89.6%**

Approximate letter grade: **B+ / A-**

---

# Strengths

## 1. Strong validation logic

Your `Temperature` class does a good job protecting its internal state. Both the constructor and setter validate Celsius values before assigning them, which prevents invalid temperatures from being stored.

Especially good:

- Rejecting values below absolute zero
- Accepting exactly `-273.15`
- Rejecting `null`
- Validating the scale factor before using it
- Reusing validation methods instead of duplicating logic

This is a strong design habit.

---

## 2. Good use of constructor chaining

The constructors are nicely chained:

```java
public Temperature(BigDecimal celsius) {
    this(celsius, 2);
}

public Temperature() {
    this(BigDecimal.valueOf(0.00), 2);
}
```

This avoids duplicating initialization logic and ensures all constructors go through the same validation and scaling process. That is exactly the right idea.

---

## 3. Effective use of constants

The conversion values and exception messages are stored as constants, which improves readability and maintainability.

Examples:

```java
private static final BigDecimal CONVERSION_TO_FAHRENHEIT_ADDEND = BigDecimal.valueOf(32);

public static final String TEMPERATURE_VALUE_TOO_LOW =
        "Upon conversion to Kelvin, entered temperature is below absolute zero.";
```

This makes the class easier to update and makes the tests less dependent on repeated string literals.

---

## 4. Thorough unit test coverage

Your `TemperatureTest` class is one of the stronger parts of the submission. You test:

- Getters and setters
- Celsius to Fahrenheit conversion
- Celsius to Kelvin conversion
- Positive and negative Celsius values
- Absolute zero boundary
- Below absolute zero rejection
- Zero-, one-, and two-argument constructors
- Scale factor behavior
- Invalid scale factors
- Freezing and boiling points
- Null values

That is excellent coverage for a class of this size.

---

## 5. Good use of parameterized tests

Your parameterized tests are a good sign of mature testing style. For example, testing several Fahrenheit conversions with varying scale factors is much cleaner than writing many nearly identical test methods.

```java
@ParameterizedTest
@CsvSource(
    {
        "54.34, 1, 129.7",
        "54.35, 1, 129.9",
        "25.73, 2, 78.31",
        "-47.56, 2, -53.61"
    }
)
```

This is readable and efficient.

---

# Areas for Improvement

## 1. Be careful with `BigDecimal.valueOf(double)`

You frequently use `new BigDecimal("...")` in your tests, which is excellent. In the main class, however, some constants are created using `BigDecimal.valueOf(...)`.

For many values, `BigDecimal.valueOf(double)` is safer than `new BigDecimal(double)`, but for consistency and clarity, string literals are often preferred when the exact decimal value matters.

For example, this:

```java
private static final BigDecimal CONVERSION_TO_KELVIN_ADDEND = BigDecimal.valueOf(273.15);
```

could be written as:

```java
private static final BigDecimal CONVERSION_TO_KELVIN_ADDEND = new BigDecimal("273.15");
```

This makes it completely clear that the exact decimal value is intended.

---

## 2. Consider using named constants for limits

The value `4` in this method is meaningful:

```java
} else if (scaleFactor > 4) {
```

A named constant would make the intent clearer:

```java
private static final int MAX_SCALE_FACTOR = 4;
```

Then the validation reads more clearly:

```java
} else if (scaleFactor > MAX_SCALE_FACTOR) {
```

This is a small maintainability improvement.

---

## 3. Public exception-message constants are convenient but expose internals

Your tests compare against public constants such as:

```java
Temperature.TEMPERATURE_VALUE_TOO_LOW
```

That works, but it also means the production class exposes strings mainly for test convenience. In a larger application, exception messages are often considered implementation details.

This is not a serious issue for an assignment, but as a design principle, you might instead test:

- the exception type,
- the object state after failure,
- or a meaningful part of the message if required.

For this assignment, your approach is acceptable and clear.

---

## 4. Formatting inconsistency in `convertToFahrenheit`

This method has some indentation and line-wrapping issues:

```java
public BigDecimal convertToFahrenheit() {
        BigDecimal rawConversion =
        this.getCelsius().multiply(CONVERSION_TO_FAHRENHEIT_MULTIPLIER).add(CONVERSION_TO_FAHRENHEIT_ADDEND);

        return NumberUtils.setScale(rawConversion, scaleFactor);
}
```

The logic is correct, but the formatting makes it slightly harder to read. It would be cleaner as:

```java
public BigDecimal convertToFahrenheit() {
    BigDecimal rawConversion = this.getCelsius()
            .multiply(CONVERSION_TO_FAHRENHEIT_MULTIPLIER)
            .add(CONVERSION_TO_FAHRENHEIT_ADDEND);

    return NumberUtils.setScale(rawConversion, scaleFactor);
}
```

This improves readability without changing behavior.

---

## 5. `NullPointerException` vs. `IllegalArgumentException`

You currently throw:

```java
throw new NullPointerException(NULL_VALUE_NOT_ALLOWED);
```

This is technically acceptable, and Java itself often uses `NullPointerException` for null values. However, for user-supplied invalid method arguments, many instructors and codebases prefer:

```java
throw new IllegalArgumentException(NULL_VALUE_NOT_ALLOWED);
```

Either can be defended, but consistency matters. If the assignment expects `NullPointerException`, keep it. Otherwise, I would consider `IllegalArgumentException` for all invalid inputs.

---

## 6. Some tests combine many behaviors into one test method

For example, this test method checks all constructors:

```java
public void testAllConstructors()
```

It works, and `assertAll` is used well, but from a diagnostics perspective, separate tests can be clearer:

- `testNoArgumentConstructor`
- `testOneArgumentConstructor`
- `testTwoArgumentConstructor`

That way, when a test fails, the failure message immediately identifies which constructor has the issue.

This is a minor testing-style improvement, not a correctness issue.

---

# Comments on `Temperature.java`

## Positive Comments

- The class has a clear purpose.
- Fields are properly private.
- Conversion constants improve readability.
- Constructors are chained correctly.
- Validation is not duplicated unnecessarily.
- `scaleFactor` being `final` is appropriate because it should not change after construction.
- Helper methods are logically named and easy to understand.

## Suggested Improvements

- Clean up indentation in `convertToFahrenheit`.
- Consider string-based `BigDecimal` constants for exact decimal values.
- Add a named constant for the maximum scale factor.
- Consider documenting what rounding mode `NumberUtils.setScale` uses, since rounding is central to this class.
- Consider whether exception-message constants need to be public.
- Make Javadocs a little more formal and consistent.

---

# Comments on `TemperatureTest.java`

## Positive Comments

- Excellent breadth of test coverage.
- Good use of `@Nested` to organize related tests.
- Good use of `@ParameterizedTest`.
- Tests cover both normal and edge cases.
- Boundary testing around absolute zero is very good.
- Tests verify constructor behavior thoroughly.
- Null handling is tested in setter and constructors.
- Scale factor rounding is tested at multiple precisions.

## Suggested Improvements

- Consider splitting very large `assertAll` tests into smaller tests.
- Add parameterized tests for Kelvin conversion across multiple scale factors.
- Consider testing that a failed setter call does not modify the previous valid state.
- Consider adding display names to individual tests for clearer test output.
- Some test method names could be more descriptive about expected behavior.

For example, instead of:

```java
public void testScaleFactorFour(...)
```

you might write something like:

```java
public void testConstructorRoundsCelsiusToFourDecimalPlaces(...)
```

That name communicates the behavior being tested more clearly.

---

# Suggested Additional Tests

These are not required, but they would make the test suite even stronger.

## 1. Failed setter should preserve old value

If setting an invalid value throws an exception, the object should still retain its previous valid Celsius value.

```java
@Test
public void testInvalidSetterDoesNotChangeExistingTemperature() {
    temperature.setCelsius(new BigDecimal("25.00"));

    assertThrows(
            IllegalArgumentException.class,
            () -> temperature.setCelsius(new BigDecimal("-273.16"))
    );

    assertEquals(new BigDecimal("25.00"), temperature.getCelsius());
}
```

---

## 2. Kelvin conversion with different scale factors

You test Fahrenheit at many scale factors, but Kelvin only at scale factor `2`.

```java
@ParameterizedTest
@CsvSource({
    "0.00, 0, 273",
    "0.00, 1, 273.2",
    "0.00, 2, 273.15",
    "0.00, 3, 273.150",
    "0.00, 4, 273.1500"
})
public void testConvertToKelvinWithDifferentScaleFactors(
        String temperatureValue,
        int scaleFactor,
        String expected
) {
    Temperature temperature = new Temperature(new BigDecimal(temperatureValue), scaleFactor);

    assertEquals(
            new BigDecimal(expected),
            temperature.convertToKelvin()
    );
}
```

---

## 3. Setter should apply scale factor

You test constructor scaling well, but the setter also uses scaling. A focused setter scaling test would be useful.

```java
@Test
public void testSetterAppliesScaleFactor() {
    Temperature temperature = new Temperature(new BigDecimal("0.00"), 2);

    temperature.setCelsius(new BigDecimal("12.345"));

    assertEquals(new BigDecimal("12.35"), temperature.getCelsius());
}
```

---

# Final Instructor Comments

This is a well-developed assignment with strong evidence of testing discipline. The `Temperature` class performs the required conversions, validates input appropriately, and uses helper methods to keep the logic organized. The test suite is comprehensive and demonstrates an understanding of boundary cases and parameterized testing.

To move this from a strong B+/A- into a clear A, focus on polish:

1. Clean up formatting and indentation.
2. Use named constants for meaningful numeric limits.
3. Consider exact string-based `BigDecimal` constants.
4. Split a few broad tests into smaller behavior-specific tests.
5. Add a few tests for setter scaling and object state after failed validation.

Overall, this is very solid work.

kotlin.Unit

