package com.example.yueuy.doubanmovie.bean;

import java.util.List;

/**
 * Created by yueuy on 17-12-23.
 */

public class Subjects {
    private String title;
    private String rating;
    private List<Subjects.Casts> mCastses;
    private List<Subjects.Directors> mDirectorses;
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

    public List<Subjects.Casts> getCastses() {
        return mCastses;
    }

    public void setCastses(List<Subjects.Casts> castses) {
        mCastses = castses;
    }

    public List<Subjects.Directors> getDirectorses() {
        return mDirectorses;
    }

    public void setDirectorses(List<Subjects.Directors> directorses) {
        mDirectorses = directorses;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public class Rating{
        private int average;

        public int getAverage() {
            return average;
        }

        public void setAverage(int average) {
            this.average = average;
        }
    }

    public class Casts {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public class Directors {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
