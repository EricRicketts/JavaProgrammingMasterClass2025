package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkerTest {

    Worker worker;

    @BeforeEach
    public void setUp() {
        worker = new Worker("Elmer Fudd", "3/11/1930", "4/12/2035");
    }

    @Test
    public void testGetAgeInYears() {
        /*
            The expected age will vary based on the current date.  At the time this code
            was written, the date was 3/22/2026.  The birthdate shown above is 3/11/1930.
        */
        int expectedAge = 96;
        int result = worker.getAge();
        assertEquals(expectedAge, result);
    }

    @Test
    public void testCollectPay() {
        assertEquals(0, worker.collectPay());
    }

    @Test
    public void testSetEndDate() {
        String expected = "4/20/2026";
        worker.terminate(expected);
        assertEquals(expected, worker.getEndDate());
    }

    @Test
    public void testWorkerNoArgumentsConstructor() {
        Worker defaultWorker = new Worker();
        String[] expected = new String[]{"Anonymous", "No Birth Date", "No End Date"};
        String[] result = new String[]{
                defaultWorker.getName(),
                defaultWorker.getBirthDate(),
                defaultWorker.getEndDate()
        };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testWorkerToString() {
        String expected = "Worker{name='Elmer Fudd', birthDate='3/11/1930', endDate='4/12/2035'}";
        String result = worker.toString();
        assertEquals(expected, result);
    }
}