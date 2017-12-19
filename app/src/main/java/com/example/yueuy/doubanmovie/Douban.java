package com.example.yueuy.doubanmovie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yueuy on 17-12-17.
 */

public class Douban {
    private static final String TAG = "DoubanMovie";
    private static final String PATH = "https://api.douban.com/v2/movie/top250";

    public static List<Map<String,String >> JSONAnalysis(String data)throws Exception{
        JSONObject object = null;
        try{
            object = new JSONObject(data);
        }catch (JSONException e){
            e.printStackTrace();
        }
        JSONObject jsonObject = new JSONObject(data);
        int total = jsonObject.getInt("total");

        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, String> map = null;
        JSONArray array = jsonObject.getJSONArray("subjects");
        for (int i = 1; i < array.length(); i++) {
            JSONObject arrayJSONObject = array.getJSONObject(i);
            String title = arrayJSONObject.getString("title");
            int rating = arrayJSONObject.optInt("rating");
            int collect_count = arrayJSONObject.optInt("collect_count");
            String directors = arrayJSONObject.optString("directors");
            String casts = arrayJSONObject.optString("casts");
            map = new HashMap<String, String>();
            map.put("title",title);
            map.put("rating",rating+"");
            map.put("collect_count",collect_count+"");
            map.put("directors",directors);
            map.put("casts",casts);
            list.add(map);
        }
        return list;
    }

    public void sendRequest(String path) throws Exception{
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(PATH);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    int code = connection.getResponseCode();
                    if (code ==200){
                        InputStream inputStream = connection.getInputStream();
                        byte[] data = readStream(inputStream);
                        String json = new String(data);
                        JSONAnalysis(json);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
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