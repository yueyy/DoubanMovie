package com.example.yueuy.doubanmovie.bean;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yueuy on 17-12-23.
 */

public class Subjects {
    private String title;
    private String rating;
    private List<Casts> mCasts;
    private List<Directors> mDirectors;
    private int collect_count;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public List<Casts> getCasts() {
        return mCasts;
    }

    public void setCastses(List<Casts> castses) {
        mCasts = castses;
    }

    public List<Directors> getDirectors() {
        return mDirectors;
    }

    public void setDirectors(List<Directors> directors) {
        mDirectors = directors;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

}
