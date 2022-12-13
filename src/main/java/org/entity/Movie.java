package org.entity;

public class Movie {
    private static int sNextId = 1;

    private int mId;
    private Author mAuthor;
    private String mMovieName;
    private Double mRating;

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
