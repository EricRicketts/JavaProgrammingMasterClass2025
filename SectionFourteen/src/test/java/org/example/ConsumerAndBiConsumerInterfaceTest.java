package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsumerAndBiConsumerInterfaceTest {

    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer) {
        consumer.accept(t1, t2);
    }

    public static <T> T calculator(BinaryOperator<T> function, T value1, T value2) {
        return function.apply(value1, value2);
    }
    
    List<List<BigDecimal>> coords;
    BiConsumer<String, String> p1;
    List<String> outputResults;

    @BeforeEach
    public void setUp() {
        coords = new ArrayList<>(
            List.of(
                List.of(new BigDecimal("47.2160"), new BigDecimal("-95.2348")),
                List.of(new BigDecimal("29.1566"), new BigDecimal("-89.2495")),
                List.of(new BigDecimal("35.1556"), new BigDecimal("-90.0659"))
            )
        );

        outputResults = new ArrayList<>();

        p1 = (lat, lng) -> {
            String result = "Latitude: ".concat(lat).concat(" ")
                .concat("Longitude: ").concat(lng).concat("\n");
            outputResults.add(result);
        };
    }

    @Nested
    @DisplayName("test BiConsumer interface")
    class TestBiConsumerInterface {

        @Test
        public void testBiConsumerInterface() {
            String latitude = coords.getFirst().getFirst().
                setScale(2, RoundingMode.HALF_UP).toString();
            String longitude = coords.getFirst().getLast()
                .setScale(2, RoundingMode.HALF_UP).toString();

            processPoint(latitude, longitude, p1);
            assertEquals(1, outputResults.size());
            assertEquals(
                "Latitude: 47.22 Longitude: -95.23\n",
                outputResults.getFirst()
            );
        }
    }
}