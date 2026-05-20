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
    class TestTemperatureGettersAndSetters {

        @Test
        public void testTemperatureGetter() {
            assertEquals(
                    BigDecimal.valueOf(12.34),
                    temperature.getCelsius()
            );
        }

        @Test
        public void testTemperatureSetter() {
            temperature.setCelsius(BigDecimal.valueOf(45.67));
            assertEquals(
                    BigDecimal.valueOf(45.67),
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
    class TestConvertValidTemperaturesCelsiusToKelvin {

        @Test
        public void testConvertPositiveCelsiusToKelvin() {
            assertEquals(
                    BigDecimal.valueOf(285.49),
                    temperature.convertToKelvin()
            );
        }

        @Test
        public void testConvertNegativeCelsiusToKelvin() {
            temperature.setCelsius(BigDecimal.valueOf(-123.45));
            assertEquals(
                    NumberUtils.setScale(BigDecimal.valueOf(149.70), 2),
                    temperature.convertToKelvin()
            );
        }
    }

    @Nested
    @DisplayName("check temperature floor for Celsius")
    class TestAbsoluteZeroBoundaryForCelsius {

        @Test
        public void testSetAbsoluteZeroForCelsius() {
            temperature.setCelsius(BigDecimal.valueOf(-273.15));
            assertEquals(
                    BigDecimal.valueOf(-273.15),
                    temperature.getCelsius()
            );
        }

        @Test
        public void testSetLessThanAbsoluteZeroForCelsius() {
            assertEquals(
                    Temperature.TEMPERATURE_VALUE_VIOLATION,
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> temperature.setCelsius(BigDecimal.valueOf(-273.16))
                    ).getMessage()
            );
        }

        @Test
        public void testInitializeAbsoluteZeroForCelsius() {
            Temperature temperature = new Temperature(BigDecimal.valueOf(-273.15), 2);
            assertEquals(
                    BigDecimal.valueOf(-273.15),
                    temperature.getCelsius()
            );
        }

        @Test
        public void testInitializeLessThanAbsoluteZeroForCelsius() {
            assertEquals(
                    Temperature.TEMPERATURE_VALUE_VIOLATION,
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Temperature(BigDecimal.valueOf(-273.16), 2)
                    ).getMessage()
            );
        }

        @Test
        public void testSetAbsoluteZeroForFahrenheit() {
            temperature.setCelsius(BigDecimal.valueOf(-273.15));
            assertEquals(
                    BigDecimal.valueOf(-459.67),
                    temperature.convertToFahrenheit()
            );
        }
    }

    @Nested
    @DisplayName("zero and one argument constructor tests")
    class TestTemperatureConstructors {

        @Test
        public void testNoArgumentTemperatureConstructor() {
            Temperature temperature = new Temperature();
            assertEquals(
                BigDecimal.valueOf(100.13),
                temperature.getCelsius()
            );
        }

        @Test
        public void testSingleArgumentTemperatureConstructor() {
            Temperature temperature = new Temperature(BigDecimal.valueOf(98.76));
            assertEquals(
                    NumberUtils.setScale(BigDecimal.valueOf(98.76), 2),
                    temperature.getCelsius()
            );
        }
    }

    @Nested
    @DisplayName("test different scale factors")
    class TestScaleFactorsForTemperature {

        @Test
        public void testSingleDigitScaleFactorRoundUp() {
            Temperature temperature = new Temperature(BigDecimal.valueOf(87.65), 1);
            assertEquals(
                    BigDecimal.valueOf(87.7),
                    temperature.getCelsius()
            );
        }

        @Test
        public void testSingleDigitScaleFactorRoundDown() {
            Temperature temperature = new Temperature(BigDecimal.valueOf(87.64), 1);
            assertEquals(
                    BigDecimal.valueOf(87.6),
                    temperature.getCelsius()
            );
        }

        @Test
        public void testThreeDigitScaleFactorRoundUp() {
            Temperature temperature = new Temperature(BigDecimal.valueOf(87.7475), 3);
            assertEquals(
                    BigDecimal.valueOf(87.748),
                    temperature.getCelsius()
            );
        }

        @Test
        public void testThreeDigitScaleFactorRoundDown() {
            Temperature temperature = new Temperature(BigDecimal.valueOf(87.7474), 3);
            assertEquals(
                    BigDecimal.valueOf(87.747),
                    temperature.getCelsius()
            );
        }
    }

    @Nested
    @DisplayName("test exact freezing and boiling points")
    class TestFreezingAndBoilingPointsForAllTemperatureScales {

        @Test
        public void testFreezingPoint() {
            Temperature temperature = new Temperature(BigDecimal.valueOf(0.00), 2);
            assertEquals(
                    NumberUtils.setScale(BigDecimal.valueOf(32.00), 2),
                    temperature.convertToFahrenheit()
            );
            assertEquals(
                    BigDecimal.valueOf(273.15),
                    temperature.convertToKelvin()
            );
        }

        @Test
        public void testBoilingPoint() {
            Temperature temperature = new Temperature(BigDecimal.valueOf(100.00), 2);
            assertEquals(
                    NumberUtils.setScale(BigDecimal.valueOf(212.00), 2),
                    temperature.convertToFahrenheit()
            );
            assertEquals(
                    BigDecimal.valueOf(373.15),
                    temperature.convertToKelvin()
            );
        }

        @Test
        public void testTheOneSharedTemperatureBetweenCelsiusAndFahrenheit() {
            Temperature temperature = new Temperature(BigDecimal.valueOf(-40.00), 2);
            assertEquals(
                    NumberUtils.setScale(BigDecimal.valueOf(-40.00), 2),
                    temperature.convertToFahrenheit()
            );
            assertEquals(
                    BigDecimal.valueOf(233.15),
                    temperature.convertToKelvin()
            );
        }
    }

    @Nested
    @DisplayName("test null values in setters and constructors")
    class TestNullValuesInSettersAndConstructors {

        @Test
        public void testNullValueInSetter() {
            assertEquals(
                    Temperature.NULL_VALUE_VIOLATION,
                    assertThrows(
                            NullPointerException.class,
                            () -> temperature.setCelsius(null)
                    ).getMessage()
            );
        }

        @Test
        public void testNullValueInSingleArgumentConstructor() {
            assertEquals(
                    Temperature.NULL_VALUE_VIOLATION,
                    assertThrows(
                            NullPointerException.class,
                            () -> new Temperature(null)
                    ).getMessage()
            );
        }

        @Test
        public void testNullValueInTwoArgumentConstructor() {
            assertEquals(
                    Temperature.NULL_VALUE_VIOLATION,
                    assertThrows(
                            NullPointerException.class,
                            () -> new Temperature(null, 2)
                    ).getMessage()
            );
        }
    }
}
```
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

    private final int scaleFactor;

    public final static String TEMPERATURE_VALUE_VIOLATION =
            "Upon conversion to Kelvin, entered temperature is below absolute zero.";

    public final static String NULL_VALUE_VIOLATION =
            "Null value is not allowed for a temperature entry";

    public BigDecimal convertToFahrenheit() {
        if (this.convertToKelvin().compareTo(BigDecimal.valueOf(0.00)) < 0) {
            throw new IllegalArgumentException(TEMPERATURE_VALUE_VIOLATION);
        } else {
            BigDecimal rawConversion =
                    this.getCelsius().multiply(CONVERSION_TO_FAHRENHEIT_MULTIPLIER)
                            .add(CONVERSION_TO_FAHRENHEIT_ADDEND);
            return NumberUtils.setScale(rawConversion, scaleFactor);
        }
    }

    public BigDecimal convertToKelvin() {
        BigDecimal rawConversion = this.getCelsius().add(CONVERSION_TO_KELVIN_ADDEND);
        if (rawConversion.compareTo(BigDecimal.valueOf(0.00)) < 0) {
            throw new IllegalArgumentException(TEMPERATURE_VALUE_VIOLATION);
        } else {
            return NumberUtils.setScale(rawConversion, getScaleFactor());
        }
    }

    public Temperature(BigDecimal celsius, int scaling) {
        scaleFactor = scaling;
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
        this(BigDecimal.valueOf(100.13), 2);
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
            throw new NullPointerException(NULL_VALUE_VIOLATION);
        } else if (celsius.add(CONVERSION_TO_KELVIN_ADDEND).compareTo(BigDecimal.valueOf(0.00)) < 0) {
            throw new IllegalArgumentException(TEMPERATURE_VALUE_VIOLATION);
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
}
```

Assistant: 
## Evaluation: `Temperature`

### Strengths

- **Good use of `BigDecimal`** for temperature calculations where decimal precision matters.
- **Centralized constants** for Fahrenheit/Kelvin conversion values and error messages.
- **Constructor chaining is clean**, especially:
  - no-argument constructor
  - single-argument constructor
  - two-argument constructor
- **Validation for absolute zero** is handled consistently before storing Celsius values.
- **Null handling is explicit** and tested with a clear custom message.
- **Scale factor support** is a nice design choice and works well with the tests.

### Areas to Improve

- `convertToFahrenheit()` calls `convertToKelvin()` only to check validity, but Celsius is already validated when set or constructed. This is somewhat redundant.
- There is no validation for the `scaleFactor`.
  - Negative scale values could cause unexpected behavior.
  - Extremely large scale values may be unreasonable.
- The default Celsius value is `100.13`, which seems arbitrary. If this was required by the assignment, it is fine; otherwise, `0.00` might be a more natural default.
- Formatting issue: there should be a blank line between `setCelsius()` and `getScaleFactor()` for readability.
- `public final static` is usually written as `public static final` by Java convention.

### Suggested Grade: **A- / 90%**

The class is functional, well-structured, and handles the main domain rules correctly. The biggest missing piece is validation of the scale factor, plus a few style and redundancy issues.

---

## Evaluation: `TemperatureTest`

### Strengths

- **Very strong test coverage overall.**
- Tests include:
  - getters and setters
  - Celsius-to-Fahrenheit conversion
  - Celsius-to-Kelvin conversion
  - positive and negative temperatures
  - absolute zero boundary cases
  - constructor behavior
  - scale factor rounding
  - freezing, boiling, and `-40` crossover point
  - null handling
- Excellent use of `@Nested` classes to organize related tests.
- Good use of `assertThrows()` to verify exception behavior.
- Tests check both exception types and messages, which is thorough.
- Boundary testing around absolute zero is especially good.

### Areas to Improve

- Some expected values rely on `BigDecimal.valueOf(double)`, which is usually safer than `new BigDecimal(double)`, but using string values like `new BigDecimal("78.31")` would be even clearer and more precise.
- The tests use `NumberUtils.setScale(...)` in some expected values. That means the tests partially depend on the same helper logic as the implementation. Ideally, expected values should be independent.
- There are no tests for invalid scale factors, though the current class also does not validate them.
- Some method names are long, but they are descriptive, so this is a minor issue.
- The default constructor test expects `100.13`, which is fine if that value is required, but otherwise it may encode an arbitrary implementation detail.

### Suggested Grade: **A / 94%**

The test suite is well-organized and covers the core behavior very thoroughly. The main improvement would be making expected `BigDecimal` values more independent from helper methods and adding tests for scale-factor edge cases if scale validation is added.

---

## Overall Assessment

| File | Grade | Summary |
|---|---:|---|
| `Temperature` | **A- / 90%** | Solid implementation with good validation and conversion logic; needs scale-factor validation and minor cleanup. |
| `TemperatureTest` | **A / 94%** | Very thorough and well-organized tests; could improve independence of expected values and add scale edge cases. |

Overall, this is a strong submission. The implementation and tests work well together, and the test suite demonstrates careful attention to boundaries and rounding behavior.

