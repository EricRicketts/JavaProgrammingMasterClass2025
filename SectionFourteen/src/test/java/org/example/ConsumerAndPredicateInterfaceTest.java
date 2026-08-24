package org.example;

import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class ConsumerAndPredicateInterfaceTest {

    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer) {
        consumer.accept(t1, t2);
    }
    
    List<List<BigDecimal>> coords;

    @BeforeEach
    public void setUp() {
        coords = new ArrayList<>(
            List.of(
                List.of(new BigDecimal("47.2160"), new BigDecimal("-95.2348")),
                List.of(new BigDecimal("29.1566"), new BigDecimal("-89.2495")),
                List.of(new BigDecimal("35.1556"), new BigDecimal("-90.0659"))
            )
        );
    }
}
