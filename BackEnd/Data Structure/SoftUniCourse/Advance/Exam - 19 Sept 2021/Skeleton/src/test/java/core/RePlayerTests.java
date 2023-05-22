package core;

import models.Track;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

public class RePlayerTests {
    private RePlayer rePlayer;

    private Track getRandomTrack() {
        return new Track(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                (int) Math.min(1, Math.random() * 1_000_000_000),
                (int) Math.min(10, Math.random() * 10_000));
    }

    @Before
    public void setup() {
        this.rePlayer = new RePlayerImpl();
    }

    @Test
    public void testAddTrack_WithExistentAlbum_ShouldSuccessfullyaddTrack() {
        this.rePlayer.addTrack(this.getRandomTrack(), "randomAlbum");
        this.rePlayer.addTrack(this.getRandomTrack(), "randomAlbum");

        assertEquals(2, this.rePlayer.size());
    }

    @Test
    public void testContains_WithExistentTrack_ShouldReturnTrue() {
        Track randomTrack = this.getRandomTrack();

        this.rePlayer.addTrack(randomTrack, "randomAlbum");

        assertTrue(this.rePlayer.contains(randomTrack));
    }

    @Test
    public void testGetTracksOrderedByMultiCriteria_WithCorrectData_ShouldReturnCorrectResults() {
        Track track = new Track("asd", "bsd", "csd", 4000, 400);
        Track track2 = new Track("dsd", "esd", "fsd", 5000, 400);
        Track track3 = new Track("hsd", "isd", "jsd", 5000, 500);
        Track track4 = new Track("ksd", "lsd", "msd", 5000, 600);
        Track track5 = new Track("nsd", "osd", "psd", 6000, 100);

        this.rePlayer.addTrack(track, "randomAlbum");
        this.rePlayer.addTrack(track2, "bandomAlbum");
        this.rePlayer.addTrack(track3, "aandomAlbum2");
        this.rePlayer.addTrack(track4, "aandomAlbum2");
        this.rePlayer.addTrack(track5, "aandomAlbum2");

        List<Track> list =
                StreamSupport.stream(this.rePlayer.getTracksOrderedByAlbumNameThenByPlaysDescendingThenByDurationDescending().spliterator(), false)
                        .collect(Collectors.toList());

        assertEquals(5, list.size());
        assertEquals(track5, list.get(0));
        assertEquals(track4, list.get(1));
        assertEquals(track3, list.get(2));
        assertEquals(track2, list.get(3));
        assertEquals(track, list.get(4));
    }

    @Test
    public void testContains_With1000000Results_ShouldPassInstantly() {
        int count = 1000000;

        Track trackToContain = null;

        for (int i = 0; i < count; i++)
        {
            Track track = new Track(i + "", "Title" + i, "Artist" + i, i * 100, i * 10);

            this.rePlayer.addTrack(track, "randomAlbum");

            if (i == 800000)
            {
                trackToContain = track;
            }
        }

        long start = System.currentTimeMillis();

        this.rePlayer.contains(trackToContain);

        long stop = System.currentTimeMillis();
        long elapsedTime = stop - start;

        assertTrue(elapsedTime <= 1);
    }

    @Test
    public void testRemoveTrack_With1000000ResultsAndQueue_ShouldPassQuickly() {
        int count = 1000000;

        Track actual = null;

        for (int i = count; i >= 0; i--)
        {
            Track track = new Track(i + "", "Title" + i, "Artist" + i, i * 1000, i * 100);

            String album = null;

            if (i <= 50000)
            {
                album = "randomAlbum5";
            }
            else if (i <= 30000)
            {
                album = "randomAlbum3";
            }
            else
            {
                album = "randomAlbum";
            }

            this.rePlayer.addTrack(track, album);

            if (i == 50000)
            {
                actual = track;
            }

            if (i <= 75000 && i >= 25000)
            {
                this.rePlayer.addToQueue(track.getTitle(), album);
            }
        }

        long start = System.currentTimeMillis();

        this.rePlayer.removeTrack(actual.getTitle(), "randomAlbum5");

        long stop = System.currentTimeMillis();

        long elapsedTime = stop - start;

        assertTrue(elapsedTime <= 5);

        while (true) {
            try {
                assertNotEquals(this.rePlayer.play(), actual);
            }
            catch (IllegalArgumentException e) {
                break;
            }
        }
    }
}
