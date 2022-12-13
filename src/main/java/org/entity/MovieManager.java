package org.entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class MovieManager {
    private HashMap<Integer, Movie>mMovieManager = new HashMap<>();

    public void createMovie(String aAuthorFirstName, String aAuthorLastName, String aMovieName, Double aRating){
        Movie movie = new Movie(aAuthorFirstName,aAuthorLastName, aMovieName, aRating);
        mMovieManager.put(movie.getmId(), movie);
        System.out.println("Created Movie:");
        System.out.println("-".repeat(15));
        System.out.println(movie);
    }
    public void readMovie(int aId){
        Movie movie = mMovieManager.get(aId);
        if (movie == null) throw new NoSuchElementException();
        System.out.println(mMovieManager.get(aId).toString());
    }
    public void readAllMovie(){
        System.out.println(mMovieManager.toString());
    }
    public void updateMovie(int aId, String aAuthorFirstName, String aAuthorLastName, String aMovieName, Double aRating){
        Movie movie = mMovieManager.get(aId);
        System.out.println("updated Movie");
        System.out.println(movie);
        if (movie == null) throw new NoSuchElementException();
        movie.update(aAuthorFirstName,aAuthorLastName,aMovieName,aRating);
        System.out.println("to");
        System.out.println(movie);
    }

    public void updateMovieRating(int aId, Double aRating){
        Movie movie = mMovieManager.get(aId);
        System.out.println("Updated Movie rating from:");
        System.out.println(movie);
        if (movie == null) throw new NoSuchElementException();
        movie.updateRating(aRating);
        System.out.println("to");
        System.out.println(movie);
    }
    public void deleteMovie(int aId){
        Movie movie = mMovieManager.get(aId);
        if (movie == null) throw new NoSuchElementException();
        mMovieManager.remove(aId);
        System.out.println("Removed");
        System.out.println(movie);
    }
}
