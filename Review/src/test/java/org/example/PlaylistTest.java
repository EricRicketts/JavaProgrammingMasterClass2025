package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaylistTest {

    private Playlist playlist = new Playlist();

    @Test
    public void testAddSong() {
        assertEquals(0, playlist.numberOfSongs());
        playlist.addSong(new Song(
            "The Chain",
            "Rumours",
            "Lindsey Buckingham",
            "February 1977")
        );

        assertEquals(1, playlist.numberOfSongs());
    }
}
