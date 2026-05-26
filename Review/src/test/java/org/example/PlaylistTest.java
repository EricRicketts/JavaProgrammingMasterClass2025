package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlaylistTest {

    private final Playlist playlist = new Playlist();

    @BeforeEach
    public void setUp() {
        playlist.addSong( new Song(
            "The Chain",
            "Rumours",
            "Lindsey Buckingham",
            "February 1977")
        );

        playlist.addSong(new Song(
            "Over My Head",
            "Fleetwood Mac",
            "Christine McVie",
            "July 1975")
        );

        playlist.addSong( new Song(
            "Dreams",
            "Rumours",
            "Stevie Nicks",
            "February 1977")
        );

    }

    @Test
    public void testAddSong() {
        Playlist smallPlaylist = new Playlist();
        assertEquals(0, smallPlaylist.numberOfSongs());
        smallPlaylist.addSong(new Song(
            "The Chain",
            "Rumours",
            "Lindsey Buckingham",
            "February 1977")
        );

        assertEquals(1, smallPlaylist.numberOfSongs());
    }

    @Test
    public void testRemoveSongByTrackNumber() {
        assertEquals(3, playlist.numberOfSongs());
        playlist.removeSong(2);

        assertEquals(2, playlist.numberOfSongs());
    }

    @Test
    public void testRemoveSongByTrackNumberTooLarge() {
        assertEquals(3, playlist.numberOfSongs());
        assertThrows(
            IndexOutOfBoundsException.class,
            () -> playlist.removeSong(4)
        );

       assertEquals(3, playlist.numberOfSongs());
    }

    @Test
    public void testRemoveTrackNumberZero() {
        assertEquals(3, playlist.numberOfSongs());
        assertThrows(
            IndexOutOfBoundsException.class,
            () -> playlist.removeSong(0)
        );

        assertEquals(3, playlist.numberOfSongs());
    }

    @Test
    public void testRemoveSongByTitle() {
        boolean found = false;
        String title = playlist.getSong(2).getTitle();

        assertEquals(3, playlist.numberOfSongs());
        assertEquals(title.concat(" successfully removed."), playlist.removeSong(title));

        assertEquals(2, playlist.numberOfSongs());
        for (int index = 0; index < this.playlist.numberOfSongs(); index++) {
            if (this.playlist.getSong(index + 1).getTitle().equals(title)) {
                found = true;
                break;
            }
        }
        assertFalse(found);
    }

}
