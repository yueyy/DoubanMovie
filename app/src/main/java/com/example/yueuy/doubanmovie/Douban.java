package com.example.yueuy.doubanmovie;

import com.example.yueuy.doubanmovie.bean.Casts;
import com.example.yueuy.doubanmovie.bean.Directors;
import com.example.yueuy.doubanmovie.bean.Movies;
import com.example.yueuy.doubanmovie.bean.Subjects;

import org.json.JSONArray;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yueuy on 17-12-17.
 */

public class Douban {
    private static final String TAG = "DoubanMovie";

    public List<Subjects> result = new ArrayList<>();

    public List<Subjects> JSONAnalysis(String data)throws Exception{
        try{
            JSONObject obj = new JSONObject(data);
            JSONArray array = obj.getJSONArray("subjects");
            for (int i = 0; i < array.length(); i++) {
                Subjects subjects = new Subjects();
                JSONObject objMovies = array.getJSONObject(i);
                String title = objMovies.getString("title");
                int collect_count = objMovies.getInt("collect_count");
                JSONObject objRating = objMovies.getJSONObject("rating");
                String rating = objRating.getString("average");

                subjects.setTitle(title);
                subjects.setRating(rating);
                subjects.setCollect_count(collect_count);

//                JSONArray arrDirectors = objMovies.getJSONArray("directors");
//                List<Directors> d = new ArrayList<>();
//                for (int j = 0; j < arrDirectors.length(); j++) {
//                    Directors directors = new Directors();
//                    JSONObject objDir = arrDirectors.getJSONObject(j);
//                    String director = objDir.getString("name");
//                    directors.setName(director);
//                    d.add(directors);
//                }
//                subjects.setDirectors(d);

//                JSONArray arrCasts = objMovies.getJSONArray("casts");
//                for (int j = 0; j <arrCasts.length() ; j++) {
////                    List<Casts> casts = new ArrayList<>();
////                    Casts c = new Casts();
//                    JSONObject objCasts = arrCasts.getJSONObject(j);
//                    String cast = objCasts.getString("name");
////                    c.setName(cast);
////                    casts.set(i,c);
//                    subjects.setCastses(cast);
//                }
                result.add(subjects);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }

        return result;
    }

    public List<Subjects> get(String path) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(path);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(10000);

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStream = connection.getInputStream();
                byte[] data = readStream(inputStream);
                String jsonData = new String(data);
                result = JSONAnalysis(jsonData);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static byte[] readStream(InputStream inputStream) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            bout.write(buffer, 0, len);
        }
        bout.close();
        inputStream.close();
        return bout.toByteArray();
    }
}
