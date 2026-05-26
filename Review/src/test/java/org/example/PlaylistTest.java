package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlaylistTest {

    private static final String SONG_REMOVED =
        " successfully removed.";

    private static final String SONG_NOT_FOUND =
        " not found.";

    private int INITIAL_NUMBER_OF_SONGS;

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

        INITIAL_NUMBER_OF_SONGS = playlist.numberOfSongs();
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
        assertEquals(INITIAL_NUMBER_OF_SONGS, playlist.numberOfSongs());
        playlist.removeSong(2);

        assertEquals(INITIAL_NUMBER_OF_SONGS - 1, playlist.numberOfSongs());
    }

    @Test
    public void testRemoveSongTrackNumberTooLarge() {
        assertEquals(INITIAL_NUMBER_OF_SONGS, playlist.numberOfSongs());
        assertThrows(
            IndexOutOfBoundsException.class,
            () -> playlist.removeSong(4)
        );

       assertEquals(INITIAL_NUMBER_OF_SONGS, playlist.numberOfSongs());
    }

    @Test
    public void testRemoveSongTrackNumberZero() {
        assertEquals(INITIAL_NUMBER_OF_SONGS, playlist.numberOfSongs());
        assertThrows(
            IndexOutOfBoundsException.class,
            () -> playlist.removeSong(0)
        );

        assertEquals(INITIAL_NUMBER_OF_SONGS, playlist.numberOfSongs());
    }

    @Test
    public void testRemoveSongTrackNumberNegative() {
        assertEquals(INITIAL_NUMBER_OF_SONGS, playlist.numberOfSongs());
        assertThrows(
            IndexOutOfBoundsException.class,
            () -> playlist.removeSong(-1)
        );

        assertEquals(INITIAL_NUMBER_OF_SONGS, playlist.numberOfSongs());
    }

    @Test
    public void testRemoveSongByTitle() {
        boolean found = false;
        String title = playlist.getSong(2).getTitle();

        assertEquals(INITIAL_NUMBER_OF_SONGS, playlist.numberOfSongs());
        assertEquals(title.concat(SONG_REMOVED), playlist.removeSong(title));

        assertEquals(INITIAL_NUMBER_OF_SONGS - 1, playlist.numberOfSongs());
        for (int index = 0; index < this.playlist.numberOfSongs(); index++) {
            if (this.playlist.getSong(index + 1).getTitle().equals(title)) {
                found = true;
                break;
            }
        }
        assertFalse(found);
    }

    @Test
    public void testRemoveSongByTitleSongNotFound() {
        assertEquals(INITIAL_NUMBER_OF_SONGS, playlist.numberOfSongs());
        String title = "You Make Loving Fun";

        assertEquals(title.concat(SONG_NOT_FOUND), playlist.removeSong(title));
        assertEquals(INITIAL_NUMBER_OF_SONGS, playlist.numberOfSongs());
    }
}
