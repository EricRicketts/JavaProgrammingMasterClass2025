package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlbumTest {

    private List<Album> albums;
    private Album firstAlbum, secondAlbum;
    private LinkedList<Song> playList;

    @BeforeEach
    public void setUp() {

        albums = new ArrayList<>();
        playList = new LinkedList<>();

        firstAlbum = new Album("Stormbringer", "Deep Purple");
        firstAlbum.addSong("Stormbringer", new BigDecimal("4.60"));
        firstAlbum.addSong("Love don't mean a thing", new BigDecimal("4.22"));
        firstAlbum.addSong("Holy man", new BigDecimal("4.30"));
        firstAlbum.addSong("Hold on", new BigDecimal("5.60"));
        firstAlbum.addSong("Lady double dealer", new BigDecimal("3.21"));
        firstAlbum.addSong("You can't do it right", new BigDecimal("6.23"));
        firstAlbum.addSong("High ball shooter", new BigDecimal("4.27"));
        firstAlbum.addSong("The gypsy", new BigDecimal("4.20"));
        firstAlbum.addSong("Soldier of fortune", new BigDecimal("3.13"));
        albums.add(firstAlbum);

        secondAlbum = new Album("For those about to rock", "AC/DC");
        secondAlbum.addSong("For those about to rock", new BigDecimal("5.44"));
        secondAlbum.addSong("I put the finger on you", new BigDecimal("3.25"));
        secondAlbum.addSong("Lets go", new BigDecimal("3.45"));
        secondAlbum.addSong("Inject the venom", new BigDecimal("3.33"));
        secondAlbum.addSong("Snowballed", new BigDecimal("4.51"));
        secondAlbum.addSong("Evil walks", new BigDecimal("3.45"));
        secondAlbum.addSong("C.O.D.", new BigDecimal("5.25"));
        secondAlbum.addSong("Breaking the rules", new BigDecimal("5.32"));
        secondAlbum.addSong("Night of the long knives", new BigDecimal("5.12"));
        albums.add(secondAlbum);

        albums.getFirst().addToPlayList("You can't do it right", playList);
        albums.getFirst().addToPlayList("Holy man", playList);
        albums.getFirst().addToPlayList("Soldier of fortune", playList);
        albums.getFirst().addToPlayList("Speed king", playList);  // Does not exist
        albums.getFirst().addToPlayList(9, playList);
        albums.getLast().addToPlayList(8, playList);
        albums.getLast().addToPlayList(3, playList);
        albums.getLast().addToPlayList(2, playList);
        albums.getLast().addToPlayList(24, playList);  // There is no track 24
    }

    @Nested
    @DisplayName("test first Album contents")
    class TestFirstAlbumContents {

        @Test
        public void testGetFirstAlbumName() {
            assertEquals("Stormbringer", firstAlbum.getName());
        }

        @Test
        public void testGetFirstAlbumArtist() {
            assertEquals("Deep Purple", firstAlbum.getArtist());
        }

        @Test
        public void testGetFirstAlbumSongTitles() {
            String[] expectedSongTitles = {
                "Stormbringer", "Love don't mean a thing",
                "Holy man", "Hold on",
                "Lady double dealer", "You can't do it right",
                "High ball shooter", "The gypsy",
                "Soldier of fortune"
            };

            List<Song> songs = firstAlbum.getSongs();
            for (int index = 0; index < songs.size(); index+=1) {
                Song currentSong = songs.get(index);
                String expectedSongTitle = expectedSongTitles[index];
                String resultantSongTitle = currentSong.getTitle();

                assertEquals(expectedSongTitle, resultantSongTitle);
            }
        }

        @Test
        public void testGetFirstAlbumSongDurations() {
            BigDecimal[] expectedSongDurations = {
                new BigDecimal("4.60"), new BigDecimal("4.22"),
                new BigDecimal("4.30"), new BigDecimal("5.60"),
                new BigDecimal("3.21"), new BigDecimal("6.23"),
                new BigDecimal("4.27"), new BigDecimal("4.20"),
                new BigDecimal("3.13")
            };

            List<Song> songs = firstAlbum.getSongs();
            for (int index = 0; index < songs.size(); index+=1) {
                Song currentSong = songs.get(index);
                BigDecimal expectedSongDuration = expectedSongDurations[index];
                BigDecimal resultantSongDuration = currentSong.getDuration();

                assertEquals(expectedSongDuration, resultantSongDuration);
            }
        }
    }

    @Nested
    @DisplayName("test second Album contents")
    class TestSecondAlbumContents {

        @Test
        public void testGetSecondAlbumName() {
            assertEquals("For those about to rock", secondAlbum.getName());
        }

        @Test
        public void testGetSecondAlbumArtist() {
            assertEquals("AC/DC", secondAlbum.getArtist());
        }

        @Test
        public void testGetSecondAlbumSongTitles() {
            String[] expectedSongTitles = {
                "For those about to rock", "I put the finger on you",
                "Lets go", "Inject the venom",
                "Snowballed", "Evil walks",
                "C.O.D.", "Breaking the rules",
                "Night of the long knives"
            };

            List<Song> songs = secondAlbum.getSongs();
            for (int index = 0; index < songs.size(); index+=1) {
                Song currentSong = songs.get(index);
                String expectedSongTitle = expectedSongTitles[index];
                String resultantSongTitle = currentSong.getTitle();

                assertEquals(expectedSongTitle, resultantSongTitle);
            }
        }

        @Test
        public void testGetSecondAlbumSongDurations() {
            BigDecimal[] expectedSongDurations = {
                new BigDecimal("5.44"), new BigDecimal("3.25"),
                new BigDecimal("3.45"), new BigDecimal("3.33"),
                new BigDecimal("4.51"), new BigDecimal("3.45"),
                new BigDecimal("5.25"), new BigDecimal("5.32"),
                new BigDecimal("5.12")
            };

            List<Song> songs = secondAlbum.getSongs();
            for (int index = 0; index < songs.size(); index+=1) {
                Song currentSong = songs.get(index);
                BigDecimal expectedSongDuration = expectedSongDurations[index];
                BigDecimal resultantSongDuration = currentSong.getDuration();

                assertEquals(expectedSongDuration, resultantSongDuration);
            }
        }
    }

    @Nested
    @DisplayName("test content of albums")
    class TestAlbumsContent {

        @Test
        public void testNumberOfAlbums() {
            assertEquals(2, albums.size());
        }

        @Test
        public void testGetNameOfFirstAlbum() {
            assertEquals("Stormbringer", albums.getFirst().getName());
        }

        @Test
        public void testGetArtistOfFirstAlbum() {
            assertEquals("Deep Purple", albums.getFirst().getArtist());
        }

        @Test
        public void testGetTitleOfFirstSongOnFirstAlbum() {
            Song firstSongOnFirstAlbum = albums.getFirst().getSongs().getFirst();
            assertEquals(
                "Stormbringer",
                firstSongOnFirstAlbum.getTitle()
            );
        }

        @Test
        public void testGetDurationOfFirstSongOnFirstAlbum() {
            Song firstSongOnFirstAlbum = albums.getFirst().getSongs().getFirst();
            assertEquals(
                new BigDecimal("4.60"),
                firstSongOnFirstAlbum.getDuration()
            );
        }

        @Test
        public void testGetTitleOfMiddleSongOnFirstAlbum() {
            Song middleSongOfFirstAlbum = albums.getFirst().getSongs().get(4);
            assertEquals(
                "Lady double dealer",
                middleSongOfFirstAlbum.getTitle()
            );
        }

        @Test
        public void testGetDurationOfMiddleSongOnFirstAlbum() {
            Song middleSongOfFirstAlbum = albums.getFirst().getSongs().get(4);
            assertEquals(
                new BigDecimal("3.21"),
                middleSongOfFirstAlbum.getDuration()
            );
        }

        @Test
        public void testGetTitleOfLastSongOnFirstAlbum() {
            Song firstSongOnFirstAlbum = albums.getFirst().getSongs().getLast();
            assertEquals(
                "Soldier of fortune",
                firstSongOnFirstAlbum.getTitle()
            );
        }

        @Test
        public void testGetDurationOfLastSongOnFirstAlbum() {
            Song firstSongOnFirstAlbum = albums.getFirst().getSongs().getLast();
            assertEquals(
                new BigDecimal("3.13"),
                firstSongOnFirstAlbum.getDuration()
            );
        }

        @Test
        public void testGetNameOfSecondAlbum() {
            assertEquals("For those about to rock", albums.getLast().getName());
        }

        @Test
        public void testGetArtistOfSecondAlbum() {
            assertEquals("AC/DC", albums.getLast().getArtist());
        }

        @Test
        public void testGetTitleOfFirstSongOnSecondAlbum() {
            Song firstSongOnSecondAlbum = albums.getLast().getSongs().getFirst();
            assertEquals(
                "For those about to rock",
                firstSongOnSecondAlbum.getTitle()
            );
        }

        @Test
        public void testGetDurationOfFirstSongOnSecondAlbum() {
            Song firstSongOnSecondAlbum = albums.getLast().getSongs().getFirst();
            assertEquals(
                new BigDecimal("5.44"),
                firstSongOnSecondAlbum.getDuration()
            );
        }

        @Test
        public void testGetTitleOfMiddleSongOnSecondAlbum() {
            Song middleSongOfSecondAlbum = albums.getLast().getSongs().get(4);
            assertEquals(
                "Snowballed",
                middleSongOfSecondAlbum.getTitle()
            );
        }

        @Test
        public void testGetDurationOfMiddleSongOnSecondAlbum() {
            Song middleSongOfSecondAlbum = albums.getLast().getSongs().get(4);
            assertEquals(
                new BigDecimal("4.51"),
                middleSongOfSecondAlbum.getDuration()
            );
        }

        @Test
        public void testGetTitleOfLastSongOnSecondAlbum() {
            Song lastSongOnSecondAlbum = albums.getLast().getSongs().getLast();
            assertEquals(
                "Night of the long knives",
                lastSongOnSecondAlbum.getTitle()
            );
        }

        @Test
        public void testGetDurationOfLastSongOnSecondAlbum() {
            Song lastSongOnSecondAlbum = albums.getLast().getSongs().getLast();
            assertEquals(
                new BigDecimal("5.12"),
                lastSongOnSecondAlbum.getDuration()
            );
        }
    }
}