package com.example.yueuy.doubanmovie;

import android.text.LoginFilter;
import android.util.Log;

import com.example.yueuy.doubanmovie.Movies.Directors;
import com.example.yueuy.doubanmovie.Movies.Movies;
import com.example.yueuy.doubanmovie.Movies.Subjects;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Created by yueuy on 17-12-17.
 */

public class Douban {
    private static final String TAG = "DoubanMovie";

    public List<Map<String ,String>> result = new ArrayList<>();

    public List<Map<String,String >> JSONAnalysis(String data)throws Exception{
        try{
            JSONObject object = new JSONObject(data);
        }catch (JSONException e){
            e.printStackTrace();
        }

        JSONObject obj = new JSONObject(data);
        JSONArray array = obj.getJSONArray("subjects");
        for (int i = 0; i < array.length(); i++) {
            Map<String, String> map = new HashMap<String, String>();
            JSONObject objMovies = array.getJSONObject(i);
            String title = objMovies.getString("title");
            int collect_count = objMovies.getInt("collect_count");
            JSONObject objRating = objMovies.getJSONObject("rating");
            String rating = objRating.getString("average");

//            JSONArray arrDirectors = objMovies.getJSONArray("directors");
//            for (int j = 0; j <arrDirectors.length(); j++) {
//                JSONObject objDir = arrDirectors.getJSONObject(i);
//                String directors = objDir.getString("name");
//                map.put("directors",directors);
//            }
//
//            JSONArray arrCasts = objMovies.getJSONArray("casts");
//            for (int j = 0; j <arrCasts.length() ; j++) {
//                JSONObject objCasts = arrCasts.getJSONObject(i);
//                String casts = objCasts.getString("name");
//                map.put("casts",casts);
//            }

            map.put("title",title);
            map.put("rating",rating+"");
            map.put("collect_count",collect_count+"");
            result.add(map);

        }
        return result;
    }

    public List<Map<String,String>> get(String path) {
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
                String json = new String(data);
                result = JSONAnalysis(json);

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
