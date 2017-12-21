package com.example.yueuy.doubanmovie.Movies;

import java.util.List;

/**
 * Created by yueuy on 17-12-21.
 */

public class Subjects {
    private String title;
    private Rating rating;
    private List<Casts> mCastses;
    private List<Directors> mDirectorses;
    private int collect_count;
    private String alt;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public List<Casts> getCastses() {
        return mCastses;
    }

    public void setCastses(List<Casts> castses) {
        mCastses = castses;
    }

    public List<Directors> getDirectorses() {
        return mDirectorses;
    }

    public void setDirectorses(List<Directors> directorses) {
        mDirectorses = directorses;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }
}
