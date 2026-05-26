package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SongTest {

    private Song song;

    @BeforeEach
    public void setUp() {
        song = new Song("The Chain", "Rumours", "Lindsey Buckingham", "February 1977");
    }

    @Test
    public void testGetSongTitle() {
        assertEquals("The Chain", song.getTitle());
    }
}
