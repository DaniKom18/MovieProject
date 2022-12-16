package org.entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Movie {
    //is overwritten in MovieManager createMovie methode
    //sNextId = mMovieManager.size() + 1;
    //Not really happy with that Choice
    //but it works :)
    private static int sNextId = 1;
    private int mId;
    private Author mAuthor;
    private String mMovieName;
    private Double mRating;

    public Author getmAuthor() {
        return mAuthor;
    }

    public String getmMovieName() {
        return mMovieName;
    }

    public Double getmRating() {
        return mRating;
    }

    public Movie(String aAuthorFirstName, String aAuthorLastName, String aMovieName, Double aRating) {
        this.mId = sNextId;
        sNextId++;
        this.mAuthor = new Author(aAuthorFirstName, aAuthorLastName);
        this.mMovieName = aMovieName;
        this.mRating = aRating;
    }

    public void update(String aAuthorFirstName, String aAuthorLastName, String aMovieName, Double aRating){
        this.mAuthor.setmFirstName(aAuthorFirstName);
        this.mAuthor.setmLastName(aAuthorLastName);
        this.mMovieName = aMovieName;
        this.mRating = aRating;
    }

    public void updateRating(Double aRating) {
        this.mRating = aRating;
    }


    public int getmId() {
        return mId;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "mId=" + mId +
                ", mAuthor=" + mAuthor +
                ", mMovieName='" + mMovieName + '\'' +
                ", mRating=" + mRating +
                '}';
    }

}
