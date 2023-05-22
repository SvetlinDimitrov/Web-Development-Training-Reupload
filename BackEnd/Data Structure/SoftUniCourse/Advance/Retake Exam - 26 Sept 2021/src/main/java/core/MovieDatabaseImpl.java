package core;

import models.Movie;

import java.util.*;
import java.util.stream.Collectors;

public class MovieDatabaseImpl implements MovieDatabase {
    Map<String , Movie> movieMap;
    Map<String , Set<Movie>> actorMap;

    public MovieDatabaseImpl() {
        this.movieMap = new LinkedHashMap<>();
        actorMap= new LinkedHashMap<>();
    }

    @Override
    public void addMovie(Movie movie) {
        Movie movie1 = movieMap.get(movie.getId());
        if(movie1 != null){return;}
        movieMap.putIfAbsent(movie.getId() , movie);
        for (String actor : movie.getActors()) {
            actorMap.putIfAbsent(actor , new HashSet<>());
            actorMap.get(actor).add(movie);
        }
    }

    @Override
    public void removeMovie(String movieId) {
        Movie movie = movieMap.get(movieId);
        if(movie == null){throw new IllegalArgumentException();}
        movieMap.remove(movieId);
        for (String actor : movie.getActors()) {
            actorMap.get(actor).remove(movie);
        }
    }

    @Override
    public int size() {
        return movieMap.size();
    }

    @Override
    public boolean contains(Movie movie) {
        return movieMap.containsKey(movie.getId());
    }

    @Override
    public Iterable<Movie> getMoviesByActor(String actorName) {

        Set<Movie> collect = actorMap.get(actorName);
        if(collect == null || collect.isEmpty()){throw new IllegalArgumentException();}


        return collect.stream().
                sorted((f, s) -> {
            if (Double.compare(s.getRating(), f.getRating()) != 0) {
                return Double.compare(s.getRating(), f.getRating());
            }
            if (Integer.compare(s.getReleaseYear(), f.getReleaseYear()) != 0) {
                return Integer.compare(s.getReleaseYear(), f.getReleaseYear());
            }
            return Double.compare(f.getRating(), s.getRating());
        }).collect(Collectors.toList());
    }

    @Override
    public Iterable<Movie> getMoviesByActors(List<String> actors) {

        List<Movie> collect = movieMap.values().stream()
                .filter(e -> new HashSet<>(e.getActors()).containsAll(actors))
                .sorted((f, s) -> {
                    if (Double.compare(s.getRating(), f.getRating()) != 0) {
                        return Double.compare(s.getRating(), f.getRating());
                    }
                    if (Integer.compare(s.getReleaseYear(), f.getReleaseYear()) != 0) {
                        return Integer.compare(s.getReleaseYear(), f.getReleaseYear());
                    }
                    return Double.compare(f.getRating(), s.getRating());
                }).collect(Collectors.toList());

        if(collect.isEmpty()){throw new IllegalArgumentException();}

        return collect;
    }

    @Override
    public Iterable<Movie> getMoviesByYear(Integer releaseYear) {
        return movieMap.values().stream()
                .filter(e -> e.getReleaseYear() == releaseYear)
                .sorted((f, s) -> {
                    if (Double.compare(s.getRating(), f.getRating()) != 0) {
                        return Double.compare(s.getRating(), f.getRating());
                    }
                    return Double.compare(f.getRating(), s.getRating());
                }).collect(Collectors.toList());
    }

    @Override
    public Iterable<Movie> getMoviesInRatingRange(double lowerBound, double upperBound) {
        return movieMap.values().stream()
                .filter(e -> Double.compare(e.getRating() , lowerBound) >= 0 &&  Double.compare(upperBound ,e.getRating()) >=0)
                .sorted((f, s) -> {
                    if (Double.compare(s.getRating(), f.getRating()) != 0) {
                        return Double.compare(s.getRating(), f.getRating());
                    }
                    return Double.compare(f.getRating(), s.getRating());
                }).collect(Collectors.toList());
    }

    @Override
    public Iterable<Movie> getAllMoviesOrderedByActorPopularityThenByRatingThenByYear() {
        return movieMap.values().stream()
                .sorted((f,s) ->{
                    int fActtorMovieCount = 0;
                    for (String actor : f.getActors()) {
                        fActtorMovieCount+=actorMap.get(actor).size();
                    }

                    int sActrorMovieCount =0;
                    for (String actor : s.getActors()) {
                        sActrorMovieCount+=actorMap.get(actor).size();
                    }
                    if(Integer.compare(fActtorMovieCount , sActrorMovieCount) != 0){
                        return  Integer.compare(sActrorMovieCount , fActtorMovieCount);
                    }
                    if (Double.compare(s.getRating(), f.getRating()) != 0) {
                        return Double.compare(s.getRating(), f.getRating());
                    }
                    if (Integer.compare(s.getReleaseYear(), f.getReleaseYear()) != 0) {
                        return Integer.compare(s.getReleaseYear(), f.getReleaseYear());
                    }
                    return Double.compare(f.getRating(), s.getRating());
                }).collect(Collectors.toList());

    }
}
