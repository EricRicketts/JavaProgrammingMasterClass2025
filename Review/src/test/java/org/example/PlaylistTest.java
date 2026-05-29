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
    @DisplayName("test get songs by either track number or title")
    class GetSongFromPlaylist {

        @Test
        public void testGetSongByZeroTrackNumber() {
            assertThrows(
                IndexOutOfBoundsException.class,
                () -> playlist.getSong(0)
            );
        }

        @Test
        public void testGetSongByNegativeTrackNumber() {
            assertThrows(
                IndexOutOfBoundsException.class,
                () -> playlist.getSong(-1)
            );
        }

        @Test
        public void testGetSongByValidTrackNumber() {
            Song song = playlist.getSong(4);

            assertEquals("Stayin' Alive", song.getTitle());
        }

        @Test
        public void testGetSongByTitle() {
            Song song = playlist.getSong("Eagle");

            assertEquals("Eagle", song.getTitle());
        }
    }

    @Nested
    @DisplayName("test add a song to a playlist")
    class AddSongToPlaylist {

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
    }

    @Nested
    @DisplayName("test valid song removal")
    class TestValidSongRemoval {

        @Test
        public void testRemoveSongByTrackNumber() {
            assertEquals(INITIAL_NUMBER_OF_SONGS, playlist.numberOfSongs());
            playlist.removeSong(2);

            assertEquals(INITIAL_NUMBER_OF_SONGS - 1, playlist.numberOfSongs());
        }

        @Test
        public void testRemoveSongByTitle() {
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
    @DisplayName("test invalid song removal")
    class TestInvalidSongRemoval {

         @Test
         public void testRemoveSongTrackNumberTooLarge() {
             assertEquals(INITIAL_NUMBER_OF_SONGS, playlist.numberOfSongs());
             assertThrows(
                 IndexOutOfBoundsException.class,
                 () -> playlist.removeSong(INITIAL_NUMBER_OF_SONGS + 1)
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
    }

    @Nested
    @DisplayName("test remove a song which does not exist in the playlist")
    class TestRemoveNonExistentSongFromPlaylist {

         @Test
         public void testRemoveSongByTitleSongNotFound() {
             assertEquals(INITIAL_NUMBER_OF_SONGS, playlist.numberOfSongs());
             String title = "You Make Loving Fun";

             assertFalse(playlist.removeSong(title));
             assertEquals(INITIAL_NUMBER_OF_SONGS, playlist.numberOfSongs());
         }
    }
}