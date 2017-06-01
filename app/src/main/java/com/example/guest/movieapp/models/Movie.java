package com.example.guest.movieapp.models;

/**
 * Created by Guest on 6/1/17.
 */

public class Movie {
    private String mTitle;
    private String mPhoto;
    private String mOverview;
    private String mReleaseDate;
    private String mRating;

    public Movie() {

    }

    //constructor
    public Movie(String title, String photo, String overview, String releaseDate, String rating) {
        this.mTitle = title;
        this.mPhoto = "https://image.tmdb.org/t/p/w500/" + photo;
        this.mOverview = overview;
        this.mReleaseDate = releaseDate;
        this.mRating = rating;
    }


    public String getTitle() {
        return mTitle;
    }

    public String getPhoto() {
        return mPhoto;
    }

    public String getOverview() {
        return mOverview;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public String getRating() {
        return mRating;
    }

}
