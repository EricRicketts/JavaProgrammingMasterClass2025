package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class AlbumAndPlaylistTest {

    private ArrayList<Album> albums = new ArrayList<>();
    private LinkedList<Song> playList = new LinkedList<Song>();

    @BeforeEach
    public void setUp() {
        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", new BigDecimal("4.6"));
        album.addSong("Love don't mean a thing", new BigDecimal("4.22"));
        album.addSong("Holy man", new BigDecimal("4.3"));
        album.addSong("Hold on", new BigDecimal("5.6"));
        album.addSong("Lady double dealer", new BigDecimal("3.21"));
        album.addSong("You can't do it right", new BigDecimal("6.23"));
        album.addSong("High ball shooter", new BigDecimal("4.27"));
        album.addSong("The gypsy", new BigDecimal("4.2"));
        album.addSong("Soldier of fortune", new BigDecimal("3.13"));
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", new BigDecimal("5.44"));
        album.addSong("I put the finger on you", new BigDecimal("3.25"));
        album.addSong("Lets go", new BigDecimal("3.45"));
        album.addSong("Inject the venom", new BigDecimal("3.33"));
        album.addSong("Snowballed", new BigDecimal("4.51"));
        album.addSong("Evil walks", new BigDecimal("3.45"));
        album.addSong("C.O.D.", new BigDecimal("5.25"));
        album.addSong("Breaking the rules", new BigDecimal("5.32"));
        album.addSong("Night of the long knives", new BigDecimal("5.12"));
        albums.add(album);

        albums.getFirst().addToPlayList("You can't do it right", playList);
        albums.getFirst().addToPlayList("Holy man", playList);
        albums.getFirst().addToPlayList("Speed king", playList);  // Does not exist
        albums.getFirst().addToPlayList(9, playList);
        albums.getLast().addToPlayList(3, playList);
        albums.getLast().addToPlayList(2, playList);
    }

    @Nested
    @DisplayName("test size, name, and artist of first album")
    class TestSizeNameAndArtistOfFirstAlbum {

        @Test
        public void testSizeOfFirstAlbum() {
            assertEquals(9, albums.getFirst().getSongs().size());
        }

        @Test
        public void testNameOfFirstAlbum() {
            assertEquals("Stormbringer", albums.getFirst().getName());
        }

        @Test
        public void testArtistOfFirstAlbum() {
            assertEquals("Deep Purple", albums.getFirst().getArtist());
        }
    }

    @Nested
    @DisplayName("test size, name, and artist of second album")
    class TestSizeNameAndArtistOfSecondAlbum {

        @Test
        public void testSizeOfSecondAlbum() {
            assertEquals(9, albums.getLast().getSongs().size());
        }

        @Test
        public void testNameOfSecondAlbum() {
            assertEquals("For those about to rock", albums.getLast().getName());
        }

        @Test
        public void testArtistOfSecondAlbum() {
            assertEquals("AC/DC", albums.getLast().getArtist());
        }
    }

    @Nested
    @DisplayName("Test retrieve songs from the first album")
    class TestRetrieveSongsFromFirstAlbum {

        @Test
        public void testRetrieveFirstSongFromFirstAlbum() {
            Song expectedSong = new Song("Stormbringer", new BigDecimal("4.6"));
            Song resultantSong = albums.getFirst().getSongs().getFirst();

            assertEquals(expectedSong, resultantSong);
        }

        @Test
        public void testRetrieveFifthSongFromFirstAlbum() {
            Song expectedSong = new Song("Lady double dealer", new BigDecimal("3.21"));
            Song resultantSong = albums.getFirst().getSongs().get(4);

            assertEquals(expectedSong, resultantSong);
        }
    }

    @Nested
    @DisplayName("Test retrieve songs from the last album")
    class TestRetrieveSongsFromLastAlbum {

        @Test
        public void testRetrieveLastSongFromLastAlbum() {
            Song expectedSong = new Song("Night of the long knives", new BigDecimal("5.12"));
            Song resultantSong = albums.getLast().getSongs().getLast();

            assertEquals(expectedSong, resultantSong);
        }

        @Test
        public void testRetrieveThirdSongFromLastAlbum() {
            Song expectedSong = new Song("Lets go", new BigDecimal("3.45"));
            Song resultantSong = albums.getLast().getSongs().get(2);

            assertEquals(expectedSong, resultantSong);
        }
    }

    @Nested
    @DisplayName("test get songs on the playlist from the first and second albums album")
    class TestGetSongsFromThePlayListFromTheFirstAndSecondAlbums {

        @Test
        public void testGetSongFromPlaylistThatIsOnTheFirstAlbum() {
            Song expectedSong = new Song("Soldier of fortune", new BigDecimal("3.13"));
            Song resultantSong = playList.get(2);

            assertEquals(expectedSong, resultantSong);
            assertTrue(albums.getFirst().getSongs().contains(expectedSong));
            assertFalse(albums.getLast().getSongs().contains(expectedSong));
        }

        @Test
        public void testGetSongFromPlaylistThatIsOnTheSecondAlbum() {
            Song expectedSong = new Song("I put the finger on you", new BigDecimal("3.25"));
            Song resultantSong = playList.get(4);

            assertEquals(expectedSong, resultantSong);
            assertTrue(albums.getLast().getSongs().contains(expectedSong));
            assertFalse(albums.getFirst().getSongs().contains(expectedSong));
        }

        @Test
        public void testCannotAddSongToPlaylistThatDoesNotExistOnAlbumTrackNumberTooBig() {
            assertEquals(5, playList.size());

            albums.getLast().addToPlayList(24, playList);
            assertEquals(5, playList.size());
        }

        @Test
        public void testCannotAddSongToPlaylistThatDoesNotExistOnAlbumTrackNumberTooSmall() {
            assertEquals(5, playList.size());

            albums.getFirst().addToPlayList(0, playList);
            assertEquals(5, playList.size());
        }
    }
}
