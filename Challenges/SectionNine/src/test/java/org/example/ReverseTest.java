package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReverseTest {

    int[] original, expected, result;

    @Nested
    @DisplayName("test reverse array original code")
    class TestReverseArrayOriginalCode {

        @Test
        public void testReverseEvenArray() {
            original = new int[]{0, 1, 2, 3, 4, 5};
            expected = new int[]{5, 4, 3, 2, 1, 0};
            result = ArrayWork.reverse(original);
            assertArrayEquals(expected, result);
        }

        @Test
        public void testReverseOddArray() {
            original = new int[]{0, 1, 2, 3, 4, 5, 6};
            expected = new int[]{6, 5, 4, 3, 2, 1, 0};
            result = ArrayWork.reverse(original);
            assertArrayEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test reverse array newest code")
    class TestReverseArrayNewestCode {

        @Test
        public void testMyReverseEvenArray() {
            original = new int[]{0, 1, 2, 3, 4, 5};
            expected = new int[]{5, 4, 3, 2, 1, 0};
            result = ArrayWork.myReverse(original);
            assertArrayEquals(expected, result);
        }

        @Test
        public void testMyReverseOddArray() {
            original = new int[]{0, 1, 2, 3, 4, 5, 6};
            expected = new int[]{6, 5, 4, 3, 2, 1, 0};
            result = ArrayWork.myReverse(original);
            assertArrayEquals(expected, result);
        }
    }
}
