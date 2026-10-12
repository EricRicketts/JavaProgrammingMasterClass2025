package org.example;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecondSupplierTest {

    @Test
    public void testSeedingThePlainOldArray() {

        int count = 10;
        Supplier<PlainOld> reference = PlainOld::new;

        PlainOld[] testArray = PlainOld.seedArray(reference, count);

        for (int index = 0; index < testArray.length; index+=1) {
            assertEquals(index + 1, testArray[index].getId());
        }
    }
}
