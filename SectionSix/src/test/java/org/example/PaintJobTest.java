package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaintJobTest {

    int numberOfBuckets = 0;

    @Test
    public void testInvalidInputsFourParameters() {
        double[][] inputs = {{-1.5, 2.0, 3.3, 1}, {2.0, -1.5, 3.3, 1}, {3.3, 2.0, -1.5, 1}, {3.3, 2.0, 1.5, -1}};
        for (double[] params : inputs) {
            numberOfBuckets = PaintJob.getBucketCount(params[0], params[1], params[2], (int) params[3]);
            assertEquals(-1, numberOfBuckets);
        }
    }

    @Test
    public void testInvalidInputsThreeParameters() {
        double[][] inputs =  {{-1.5, 2.0, 3.3}, {2.0, -1.5, 3.3}, {3.3, 2.0, -1.5}};
        for (double[] params : inputs) {
            numberOfBuckets = PaintJob.getBucketCount(params[0], params[1], params[2]);
            assertEquals(-1, numberOfBuckets);
        }
    }

    @Test
    public void testInvalidInputsTwoParameters() {
        double[][] inputs = {{-1.5, 2.3}, {2.0, -1.2}};
        for (double[] params : inputs) {
            numberOfBuckets = PaintJob.getBucketCount(params[0], params[1]);
            assertEquals(-1, numberOfBuckets);
        }
    }

    @Test
    public void testValidInputsFourParameters() {
        double[][] inputs = {{3.4, 2.1, 1.5, 2}, {2.75, 3.25, 2.5, 1}, {15.56, 14.72, 2.3, 3}};
        int[] expectedBuckets = {3, 3, 97};
        for (int index = 0; index < inputs.length; index++) {
            double[] params = inputs[index];
            int expected = expectedBuckets[index];
            int result =
                    PaintJob.getBucketCount(params[0], params[1], params[2], (int) params[3]);
            assertEquals(expected, result);
        }
    }

    @Test
    public void testValidInputsThreeParameters() {
        double[][] inputs = {{3.4, 2.1, 1.5}, {7.25, 4.3, 2.35}, {11.34, 17.12, 3.12}};
        int[] expectedBuckets = {5, 14, 63};
        for (int index = 0; index < inputs.length; index++) {
            double[] params = inputs[index];
            int expected = expectedBuckets[index];
            int result = PaintJob.getBucketCount(params[0], params[1], params[2]);
            assertEquals(expected, result);
        }
    }

    @Test
    public void testValidInputsTwoParameters() {
        double[][] inputs = {{3.4, 1.5}, {6.26, 1.9}, {3.26, 0.75}};
        int[] expectedBuckets = {3, 4, 5};
        for (int index = 0; index < inputs.length; index++) {
            double[] params = inputs[index];
            int expected = expectedBuckets[index];
            int result = PaintJob.getBucketCount(params[0], params[1]);
            assertEquals(expected, result);
        }
    }

}
