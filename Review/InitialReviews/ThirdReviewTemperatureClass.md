Attachment Name: Temperature.java
Attachments Kind: Visible
Attachments Source: User / FileChatAttachment
Attachments Text:
```java
package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Temperature {

    private static final BigDecimal CONVERSION_TO_FAHRENHEIT_MULTIPLIER =
            BigDecimal.valueOf(9.00).divide(BigDecimal.valueOf(5.00), RoundingMode.HALF_UP);

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
                    this.getCelsius().multiply(CONVERSION_TO_FAHRENHEIT_MULTIPLIER)
                            .add(CONVERSION_TO_FAHRENHEIT_ADDEND);
            return NumberUtils.setScale(rawConversion, scaleFactor);
    }

    public BigDecimal convertToKelvin() {
        BigDecimal rawConversion = this.getCelsius().add(CONVERSION_TO_KELVIN_ADDEND);
        return NumberUtils.setScale(rawConversion, getScaleFactor());

    }

    public Temperature(BigDecimal celsius, int scaling) {
        scaleFactor = this.validateScaleFactor(scaling);
        BigDecimal validTemperature = this.validateCelsiusTemperature(celsius);
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
        this.celsius = this.validateCelsiusTemperatureAndScale(celsius);
    }

    public int getScaleFactor() {
        return scaleFactor;
    }

    private BigDecimal validateCelsiusTemperature(BigDecimal celsius) {
        if (Objects.isNull(celsius)) {
            throw new NullPointerException(NULL_VALUE_NOT_ALLOWED);
        } else if (celsius.add(CONVERSION_TO_KELVIN_ADDEND).compareTo(BigDecimal.valueOf(0.00)) < 0) {
            throw new IllegalArgumentException(TEMPERATURE_VALUE_TOO_LOW);
        } else {
            return celsius;
        }
    }

    private BigDecimal validateCelsiusTemperatureAndScale(BigDecimal celsius) {
        return NumberUtils.setScale(
                this.validateCelsiusTemperature(celsius),
                scaleFactor
        );
    }

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
Attachment Name: TemperatureTest.java
Attachments Kind: Visible
Attachments Source: User / FileChatAttachment
Attachments Text:
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

        @Test
        public void testConvertPositiveCelsiusToFahrenheitRoundDown() {
            assertEquals(
                    new BigDecimal("78.31"),
                    new Temperature(new BigDecimal("25.73"), 2).convertToFahrenheit()
            );
        }

        @Test
        public void testConvertNegativeCelsiusToFahrenheitRoundUp() {
            assertEquals(
                    new BigDecimal("-53.61"),
                    new Temperature(new BigDecimal("-47.56"), 2).convertToFahrenheit()
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
        public void testSetAbsoluteZeroForCelsius() {
            temperature.setCelsius(new BigDecimal("-273.15"));
            assertEquals(
                    new BigDecimal("-273.15"),
                    temperature.getCelsius()
            );
        }

        @Test
        public void testSetLessThanAbsoluteZeroForCelsius() {
            assertEquals(
                    Temperature.TEMPERATURE_VALUE_TOO_LOW,
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> temperature.setCelsius(new BigDecimal("-273.16"))
                    ).getMessage()
            );
        }

        @Test
        public void testInitializeAbsoluteZeroForCelsius() {
            Temperature temperature = new Temperature(new BigDecimal("-273.15"), 2);
            assertEquals(
                    new BigDecimal("-273.15"),
                    temperature.getCelsius()
            );
        }

        @Test
        public void testInitializeLessThanAbsoluteZeroForCelsius() {
            assertEquals(
                    Temperature.TEMPERATURE_VALUE_TOO_LOW,
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Temperature(new BigDecimal("-273.16"), 2)
                    ).getMessage()
            );
        }

        @Test
        public void testSetAbsoluteZeroForFahrenheit() {
            temperature.setCelsius(new BigDecimal("-273.15"));
            assertEquals(
                    new BigDecimal("-459.67"),
                    temperature.convertToFahrenheit()
            );
        }
    }

    @Nested
    @DisplayName("zero, one and two argument constructor tests")
    class TestTemperatureConstructors {

        @Test
        public void testNoArgumentTemperatureConstructor() {
            Temperature temperature = new Temperature();
            assertEquals(
                new BigDecimal("0.00"),
                temperature.getCelsius()
            );
            assertEquals(
                    2,
                    temperature.getScaleFactor()
            );
        }

        @Test
        public void testSingleArgumentTemperatureConstructor() {
            Temperature temperature = new Temperature(new BigDecimal("98.76"));
            assertEquals(
                    new BigDecimal("98.76"),
                    temperature.getCelsius()
            );
            assertEquals(
                    2,
                    temperature.getScaleFactor()
            );
        }

        @Test
        public void testTwoArgumentTemperatureConstructor() {
            Temperature temperature = new Temperature(new BigDecimal("67.89"), 2);
            assertEquals(
                    new BigDecimal("67.89"),
                    temperature.getCelsius()
            );
            assertEquals(
                    2,
                    temperature.getScaleFactor()
            );
        }
    }

    @Nested
    @DisplayName("test different scale factors")
    class TestScaleFactorsForTemperature {

        @Test
        public void testSingleDigitScaleFactorRoundUp() {
            Temperature temperature = new Temperature(new BigDecimal("87.65"), 1);
            assertEquals(
                    new BigDecimal("87.7"),
                    temperature.getCelsius()
            );
        }

        @Test
        public void testSingleDigitScaleFactorRoundDown() {
            Temperature temperature = new Temperature(new BigDecimal("87.64"), 1);
            assertEquals(
                    new BigDecimal("87.6"),
                    temperature.getCelsius()
            );
        }

        @Test
        public void testTwoDigitScaleFactorRoundUp() {
            Temperature temperature = new Temperature(new BigDecimal("34.455"), 2);
            assertEquals(
                    new BigDecimal("34.46"),
                    temperature.getCelsius()
            );
        }

        @Test
        public void testTwoDigitScaleFactorRoundDown() {
            Temperature temperature = new Temperature(new BigDecimal("34.454"), 2);
            assertEquals(
                    new BigDecimal("34.45"),
                    temperature.getCelsius()
            );
        }

        @Test
        public void testThreeDigitScaleFactorRoundUp() {
            Temperature temperature = new Temperature(new BigDecimal("87.7475"), 3);
            assertEquals(
                    new BigDecimal("87.748"),
                    temperature.getCelsius()
            );
        }

        @Test
        public void testThreeDigitScaleFactorRoundDown() {
            Temperature temperature = new Temperature(new BigDecimal("87.7474"), 3);
            assertEquals(
                    new BigDecimal("87.747"),
                    temperature.getCelsius()
            );
        }

        @Test
        public void testFourDigitScaleFactorRoundUp() {
            Temperature temperature = new Temperature(new BigDecimal("12.34565"), 4);
            assertEquals(
                    new BigDecimal("12.3457"),
                    temperature.getCelsius()
            );
        }

        @Test
        public void testFourDigitScaleFactorRoundDown() {
            Temperature temperature = new Temperature(new BigDecimal("12.34564"), 4);
            assertEquals(
                    new BigDecimal("12.3456"),
                    temperature.getCelsius()
            );
        }

        @Test
        public void testScaleFactorNegative() {
            assertEquals(
                    Temperature.SCALE_FACTOR_VALUE_NEGATIVE,
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Temperature(new BigDecimal("23.45"), -2)
                    ).getMessage()
            );
        }

        @Test
        public void testScaleFactorTooLarge() {
            assertEquals(
                    Temperature.SCALE_FACTOR_VALUE_TOO_LARGE,
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Temperature(new BigDecimal("23.45"), 5)
                    ).getMessage()
            );
        }
    }

    @Nested
    @DisplayName("test exact freezing and boiling points")
    class TestFreezingAndBoilingPoints {

        @Test
        public void testFreezingPoint() {
            Temperature temperature = new Temperature(new BigDecimal("0.00"), 2);
            assertEquals(
                    new BigDecimal("32.00"),
                    temperature.convertToFahrenheit()
            );
            assertEquals(
                    new BigDecimal("273.15"),
                    temperature.convertToKelvin()
            );
        }

        @Test
        public void testBoilingPoint() {
            Temperature temperature = new Temperature(new BigDecimal("100.00"), 2);
            assertEquals(
                    new BigDecimal("212.00"),
                    temperature.convertToFahrenheit()
            );
            assertEquals(
                    new BigDecimal("373.15"),
                    temperature.convertToKelvin()
            );
        }

        @Test
        public void testSameTemperatureForCelsiusAndFahrenheit() {
            Temperature temperature = new Temperature(new BigDecimal("-40.00"), 2);
            assertEquals(
                    new BigDecimal("-40.00"),
                    temperature.convertToFahrenheit()
            );
        }
    }

    @Nested
    @DisplayName("test null values in setters and constructors")
    class TestNullValuesInSettersAndConstructors {

        @Test
        public void testNullValueInSetter() {
            assertEquals(
                    Temperature.NULL_VALUE_NOT_ALLOWED,
                    assertThrows(
                            NullPointerException.class,
                            () -> temperature.setCelsius(null)
                    ).getMessage()
            );
        }

        @Test
        public void testNullValueInSingleArgumentConstructor() {
            assertEquals(
                    Temperature.NULL_VALUE_NOT_ALLOWED,
                    assertThrows(
                            NullPointerException.class,
                            () -> new Temperature(null)
                    ).getMessage()
            );
        }

        @Test
        public void testNullValueInTwoArgumentConstructor() {
            assertEquals(
                    Temperature.NULL_VALUE_NOT_ALLOWED,
                    assertThrows(
                            NullPointerException.class,
                            () -> new Temperature(null, 2)
                    ).getMessage()
            );
        }
    }
}
```


kotlin.Unit

==== SimpleCompletableMessage #4 ====
Assistant: 
## Instructor-Style Evaluation

### `Temperature` Class Grade: **A- / 91%**

The `Temperature` class is a strong implementation overall. It shows good attention to numeric precision, constructor design, validation, and encapsulation. The improvements from the earlier version are noticeable, especially the addition of scale-factor validation and the more reasonable default temperature.

#### What Works Well

- **Appropriate use of `BigDecimal`**
  - This is a good choice for temperature calculations where rounded decimal output matters.
  - The implementation avoids common floating-point display issues in most places.

- **Good constructor chaining**
  - The no-argument, one-argument, and two-argument constructors are cleanly organized.
  - Default behavior is now more intuitive, using `0.00` Celsius and a scale factor of `2`.

- **Strong validation**
  - Null Celsius values are rejected.
  - Temperatures below absolute zero are rejected.
  - Negative scale factors are rejected.
  - Scale factors above the allowed maximum are rejected.

- **Good encapsulation**
  - The `celsius` field is private.
  - The `scaleFactor` is final, which makes sense because rounding behavior should remain consistent after construction.

- **Readable constants**
  - Error messages are clearly named and reusable.
  - The conversion constants make the formulas easier to understand.

#### Areas for Improvement

- **Formatting issue in `convertToFahrenheit()`**
  - The indentation inside this method is deeper than necessary, which slightly hurts readability.

- **Minor extra whitespace in `convertToKelvin()`**
  - There is an unnecessary blank line before the method closes.

- **Validation method naming could be simplified**
  - `validateCelsiusTemperatureAndScale()` is accurate, but somewhat wordy.
  - A name like `validatedAndScaledCelsius()` or `scaleValidatedCelsius()` might better describe the returned value.

- **Potential precision/style issue with `BigDecimal.valueOf(9.00)` and similar values**
  - Since `BigDecimal.valueOf(9.00)` becomes `9.0`, it still works here, but string-based constants such as `new BigDecimal("273.15")` would make the intended decimal precision clearer.
  - This is minor because your tests confirm the output behavior.

- **Class is missing documentation/comments**
  - The code is readable enough without many comments, but brief comments or JavaDoc for the constructor behavior and scale-factor limit would improve maintainability.

#### Instructor Feedback

This class demonstrates solid object-oriented design and thoughtful handling of invalid input. The logic is correct, validation is comprehensive, and the class is easy to use. Most remaining issues are style or polish rather than correctness problems.

---

## `TemperatureTest` Class Grade: **A / 96%**

The `TemperatureTest` class is excellent. It is organized, readable, and covers a wide range of expected and invalid behaviors. The test suite would give a high level of confidence that the `Temperature` class works correctly.

#### What Works Well

- **Excellent test organization**
  - The use of nested test classes makes the file easy to navigate.
  - Related behaviors are grouped logically:
    - getters/setters
    - conversions
    - absolute zero boundary
    - constructors
    - scale factors
    - freezing/boiling points
    - null handling

- **Strong boundary testing**
  - Testing exactly absolute zero and just below absolute zero is very good.
  - This demonstrates awareness of edge cases, not just normal input.

- **Good scale-factor coverage**
  - The tests cover rounding up and down for scale factors from 1 through 4.
  - Invalid scale factors are also tested.

- **Improved `BigDecimal` usage**
  - Expected values use string-based `BigDecimal` construction, which is precise and appropriate.
  - This is better than using decimal doubles for expected values.

- **Constructor coverage is complete**
  - The no-argument, one-argument, and two-argument constructors are all tested.
  - The tests also verify default scale behavior.

- **Exception testing is strong**
  - The tests verify both the exception type and the message.
  - This is thorough and helps confirm that the failure occurs for the intended reason.

#### Areas for Improvement

- **Could add conversion tests with non-default scale factors**
  - The tests thoroughly check Celsius storage rounding with different scale factors.
  - However, they could also verify that Fahrenheit and Kelvin conversions respect scale factors such as `1`, `3`, and `4`.

- **Could add one test for zero scale**
  - Since scale factor `0` is valid, a test confirming whole-number rounding would complete the scale-factor boundary coverage.

- **Some tests could use `assertAll()`**
  - Constructor tests and freezing/boiling tests check multiple related assertions.
  - `assertAll()` would let all related failures be reported together.

- **The test class is somewhat long**
  - This is not a serious issue because the organization is good, but parameterized tests could reduce repetition in the scale-factor tests.

#### Instructor Feedback

This is a very strong test class. It tests normal cases, edge cases, invalid inputs, constructor behavior, and rounding behavior. The structure is clear and professional. The remaining improvements would mostly make the tests more concise and slightly more comprehensive around conversion scaling.

---

## Overall Grade

| Component | Grade | Score |
|---|---:|---:|
| `Temperature` | **A-** | **91%** |
| `TemperatureTest` | **A** | **96%** |
| Overall | **A- / A** | **94%** |

## Final Instructor Summary

This is a high-quality submission. The `Temperature` class is well-designed, validates its inputs, uses appropriate numeric types, and provides clean constructor behavior. The test suite is especially strong and demonstrates careful attention to correctness, boundary conditions, and rounding.

The main things keeping the implementation from a full A are minor style issues, lack of documentation, and a few opportunities to make the code slightly cleaner. The tests are near excellent, with only small gaps around conversion behavior at alternate scale factors and zero-scale rounding.

kotlin.Unit

