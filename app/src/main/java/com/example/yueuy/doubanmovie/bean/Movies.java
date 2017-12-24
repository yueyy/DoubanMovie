package com.example.yueuy.doubanmovie.bean;

import java.util.List;

/**
 * Created by yueuy on 17-12-21.
 */

public class Movies {
    private List<Subjects> mSubjectses;

    public List<Subjects> getSubjectses() {
        return mSubjectses;
    }

    public void setSubjects(List<Subjects> subjectses) {
        mSubjectses = subjectses;
    }
}
//    public class Subjects {
//        private String title;
//        private int rating;
//        private List<Casts> mCastses;
//        private List<Directors> mDirectorses;
//        private int collect_count;
//
//        public String getTitle() {
//            return title;
//        }
//
//        public void setTitle(String title) {
//            this.title = title;
//        }
//
//        public int getRating() {
//            return rating;
//        }
//
//        public void setRating(int rating) {
//            this.rating = rating;
//        }
//
//        public List<Casts> getCastses() {
//            return mCastses;
//        }
//
//        public void setCastses(List<Casts> castses) {
//            mCastses = castses;
//        }
//
//        public List<Directors> getDirectorses() {
//            return mDirectorses;
//        }
//
//        public void setDirectorses(List<Directors> directorses) {
//            mDirectorses = directorses;
//        }
//
//        public int getCollect_count() {
//            return collect_count;
//        }
//
//        public void setCollect_count(int collect_count) {
//            this.collect_count = collect_count;
//        }
//
//        public class Rating{
//            private int average;
//
//            public int getAverage() {
//                return average;
//            }
//
//            public void setAverage(int average) {
//                this.average = average;
//            }
//        }
//
//        public class Casts {
//
//            private String name;
//
//            public String getName() {
//                return name;
//            }
//
//            public void setName(String name) {
//                this.name = name;
//            }
//        }
//
//            public class Directors {
//            private String name;
//
//            public String getName() {
//                return name;
//            }
//
//            public void setName(String name) {
//                this.name = name;
//            }
//        }
//
//    }
//}
