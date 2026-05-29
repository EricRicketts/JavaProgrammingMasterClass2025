package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlaylistTest {

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

        playlist.addSong( new Song(
            "Stayin' Alive",
            "Saturday Night Fever Soundtrack",
            "Barry Gibb, Robin Gibb and Maurice Gibb",
            "December 1977")
        );

        playlist.addSong(new Song(
            "Knowing Me, Knowing You",
            "Arrival",
            "Benny Andersson, Björn Ulvaeus, and Stig Anderson",
            "February 1977")
        );

        playlist.addSong(new Song(
            "Eagle",
            "ABBA: The Album",
            "Benny Andersson and Björn Ulvaeus",
            "December 1977")
        );

        playlist.addSong(new Song(
            "Dancing Queen",
            "Arrival",
            " Benny Andersson, Björn Ulvaeus, and Stig Anderson.",
            "February 1977")
        );


        INITIAL_NUMBER_OF_SONGS = playlist.numberOfSongs();
    }

    @Nested
    @DisplayName("test get songs by track number")
    class TestGetSongFromPlaylistByTrackNumber {

        @Test
        public void testGetSongByZeroTrackNumberFromPlaylistThrowsException() {
            assertThrows(
                IndexOutOfBoundsException.class,
                () -> playlist.getSong(0)
            );
        }

        @Test
        public void testGetSongByNegativeTrackNumberFromPlaylistThrowsException() {
            assertThrows(
                IndexOutOfBoundsException.class,
                () -> playlist.getSong(-1)
            );
        }

        @Test
        public void testGetSongByTooLargeATrackNumberFromPlaylistThrowsException() {
            assertThrows(
                IndexOutOfBoundsException.class,
                () -> playlist.getSong(INITIAL_NUMBER_OF_SONGS + 1)
            );
        }

        @Test
        public void testGetSongByValidTrackNumberFromPlaylist() {
            Song song = playlist.getSong(4);

            assertEquals("Stayin' Alive", song.getTitle());
        }
    }

    @Nested
    @DisplayName("test get songs by title")
    class TestGetSongFromPlaylistByTitle {

        @Test
        public void testGetSongFromPlaylistByExistentTitle() {
            Song song = playlist.getSong("Eagle");

            assertEquals("Eagle", song.getTitle());
        }

        @Test
        public void testGetSongFromPlaylistByNonExistentTitleThrowsException() {
            assertThrows(
                IllegalArgumentException.class,
                () -> playlist.getSong("Nonexistent Song")
            );
        }
    }

    @Nested
    @DisplayName("test add a song to a playlist")
    class TestAddSongToPlaylist {

        @Test
        public void testAddSongToPlaylist() {
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
    }

    @Nested
    @DisplayName("test existing song removal")
    class TestRemoveExistingSongFromPlaylist {

        @Test
        public void testRemoveExistingSongFromPlaylistByTrackNumber() {
            assertEquals(INITIAL_NUMBER_OF_SONGS, playlist.numberOfSongs());
            playlist.removeSong(2);

            assertEquals(INITIAL_NUMBER_OF_SONGS - 1, playlist.numberOfSongs());
        }

        @Test
        public void testRemoveExistingSongFromPlaylistByTitle() {
            boolean found = false;
            String title = playlist.getSong(2).getTitle();

            assertEquals(INITIAL_NUMBER_OF_SONGS, playlist.numberOfSongs());
            assertTrue(playlist.removeSong(title));

            assertEquals(INITIAL_NUMBER_OF_SONGS - 1, playlist.numberOfSongs());
            for (int index = 0; index < playlist.numberOfSongs(); index++) {
                if (playlist.getSong(index + 1).getTitle().equals(title)) {
                    found = true;
                    break;
                }
            }
            assertFalse(found);
        }
    }

    @Nested
    @DisplayName("test invalid song removal by track number")
    class TestInvalidSongRemovalFromPlaylistByTrackNumber {

         @Test
         public void testInvalidSongRemovalFromPlaylistTrackNumberTooLarge() {
             assertEquals(INITIAL_NUMBER_OF_SONGS, playlist.numberOfSongs());
             assertThrows(
                 IndexOutOfBoundsException.class,
                 () -> playlist.removeSong(INITIAL_NUMBER_OF_SONGS + 1)
             );

            assertEquals(INITIAL_NUMBER_OF_SONGS, playlist.numberOfSongs());
         }

         @Test
         public void testInvalidSongRemovalFromPlaylistTrackNumberZero() {
             assertEquals(INITIAL_NUMBER_OF_SONGS, playlist.numberOfSongs());
             assertThrows(
                 IndexOutOfBoundsException.class,
                 () -> playlist.removeSong(0)
             );

             assertEquals(INITIAL_NUMBER_OF_SONGS, playlist.numberOfSongs());
         }

         @Test
         public void testInvalidSongRemovalFromPlaylistTrackNumberNegative() {
             assertEquals(INITIAL_NUMBER_OF_SONGS, playlist.numberOfSongs());
             assertThrows(
                 IndexOutOfBoundsException.class,
                 () -> playlist.removeSong(-1)
             );

             assertEquals(INITIAL_NUMBER_OF_SONGS, playlist.numberOfSongs());
         }
    }

    @Nested
    @DisplayName("test remove a non-existent song by title from the playlist")
    class TestInvalidSongRemovalFromPlaylistByTitle {

         @Test
         public void testInvalidSongRemovalFromPlaylistByTitle() {
             assertEquals(INITIAL_NUMBER_OF_SONGS, playlist.numberOfSongs());
             String title = "You Make Loving Fun";

             assertFalse(playlist.removeSong(title));
             assertEquals(INITIAL_NUMBER_OF_SONGS, playlist.numberOfSongs());
         }
    }
}