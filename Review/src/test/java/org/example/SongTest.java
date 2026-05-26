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

    @Test
    public void testGetSongAlbum() {
        assertEquals("Rumours", song.getAlbum());
    }

    @Test
    public void testGetSongArtist() {
        assertEquals("Lindsey Buckingham", song.getArtist());
    }

    @Test
    public void testGetSongReleaseDate() {
        assertEquals("February 1977", song.getReleaseDate());
    }
}
