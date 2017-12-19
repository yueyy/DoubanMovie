package com.example.yueuy.doubanmovie;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button btnSearch;
    private EditText edtSearch;
    private ListView mListView;
    private List<Map<String ,String >> mList = new ArrayList<Map<String,String>>();
    private MyAdapter mMyAdapter;
    private static final String TAG = "DoubanMovie";
    private static final String PATH = "https://api.douban.com/v2/movie/top250";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        new DoubanTask().execute();
    }

    private void init(){
        btnSearch = (Button)findViewById(R.id.btn_search);
        edtSearch = (EditText)findViewById(R.id.edt_movie_name);
        mListView = (ListView)findViewById(R.id.list_view);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        setupAdapter();
    }

    private void setupAdapter(){
        mListView.setAdapter(mMyAdapter);
    }

    private class DoubanTask extends AsyncTask<Void, Void, List<Map<String,String>>>{

        @Override
        protected List<Map<String,String>> doInBackground(Void... params){
            try{
                new Douban().sendRequest(PATH);
                Log.i(TAG, "Fetched contents of URL: ");

            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Map<String,String>> list){
            mList = list;
            setupAdapter();
        }
    }
}
