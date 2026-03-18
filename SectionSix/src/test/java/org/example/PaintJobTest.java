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
        double[][] inputs = {{-1.5, 2.0, 3.3}, {2.0, -1.5, 3.3}, {3.3, 2.0, -1.5}};
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

}
