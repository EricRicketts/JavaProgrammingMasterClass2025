package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SongTest {

    private Song song;

    @BeforeEach
    public void setUp() {
        song = new Song("Dreams", new BigDecimal("5.43"));
    }

    @Test
    public void testGetTitle() {
        assertEquals("Dreams", song.title());
    }

    @Test
    public void testGetDuration() {
        assertEquals(new BigDecimal("5.43"), song.duration());
    }

    @Test
    public void testToString() {
        String expected = "Dreams: 5.43";
        assertEquals(expected, song.toString());
    }
}
