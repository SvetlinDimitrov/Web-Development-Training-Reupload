package core;

import models.Track;

import java.util.*;
import java.util.stream.Collectors;

public class RePlayerImpl implements RePlayer {

    Map<String , Track> trackMap;
    Map<String , Map<String , Track>>albumMap;
    ArrayDeque<Track> que;



    public RePlayerImpl() {
        this.trackMap = new LinkedHashMap<>();
        albumMap = new LinkedHashMap<>();
        que = new ArrayDeque<>();

    }

    @Override
    public void addTrack(Track track, String album) {
        trackMap.putIfAbsent(track.getId() , track);
        albumMap.putIfAbsent(album ,new HashMap<>());
        albumMap.get(album).putIfAbsent(track.getTitle() , track);
    }

    @Override
    public void removeTrack(String trackTitle, String albumName) {
        Track track = getTrack(trackTitle, albumName);
        que.remove(track);
        trackMap.remove(track.getId());
        albumMap.remove(track.getTitle());
        Map<String, Track> stringTrackMap = albumMap.get(albumName);
        if(stringTrackMap.isEmpty()){
            albumMap.remove(albumName);
        }
    }

    @Override
    public boolean contains(Track track) {
        return trackMap.containsKey(track.getId());
    }

    @Override
    public int size() {
        return trackMap.size();
    }

    @Override
    public Track getTrack(String title, String albumName) {
        Map<String, Track> stringSetMap = albumMap.get(albumName);
        if(stringSetMap == null){throw new IllegalArgumentException();}
        Track track = stringSetMap.get(title);
        if(track == null){throw new IllegalArgumentException();}
        return track;
    }

    @Override
    public Iterable<Track> getAlbum(String albumName) {
        Map<String, Track> stringTrackMap = albumMap.get(albumName);
        if(stringTrackMap == null || stringTrackMap.isEmpty()){throw new IllegalArgumentException();}
        return albumMap.get(albumName).values().stream()
                .sorted((f,s) ->s.getPlays()-f.getPlays())
                .collect(Collectors.toList());
    }

    @Override
    public void addToQueue(String trackName, String albumName) {
        Track track = getTrack(trackName, albumName);
        que.offer(track);
    }

    @Override
    public Track play() {
        boolean empty = que.isEmpty();
        if(empty){throw new IllegalArgumentException();}
        Track track = que.poll();
        track.setPlays(track.getPlays() +1);
        return track;
    }

    @Override
    public Iterable<Track> getTracksInDurationRangeOrderedByDurationThenByPlaysDescending(int lowerBound, int upperBound) {
        return trackMap.values().stream()
                .filter(e->e.getDurationInSeconds() >= lowerBound && upperBound >= e.getDurationInSeconds())
                .sorted((f,s) -> {
                    if(f.getDurationInSeconds() != s.getDurationInSeconds()){
                        return f.getDurationInSeconds() - s.getDurationInSeconds();
                    }
                    return s.getPlays() - f.getPlays();
                })
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Track> getTracksOrderedByAlbumNameThenByPlaysDescendingThenByDurationDescending() {
        return null;
    }

    @Override
    public Map<String, List<Track>> getDiscography(String artistName) {

        return null;
    }
}
