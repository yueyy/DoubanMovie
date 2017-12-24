package com.example.yueuy.doubanmovie;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.yueuy.doubanmovie.adapter.MyAdapter;
import com.example.yueuy.doubanmovie.bean.Subjects;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnSearch;
    private SearchView mSearchView;
    private ListView mListView;
    private MyAdapter mAdapter;
    private List<Subjects> mList;
    private static final String TAG = "DoubanMovie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        new DoubanTask().execute();
    }

    private void init(){
        btnSearch = (Button)findViewById(R.id.btn_search);
        mSearchView = (SearchView) findViewById(R.id.search_movies);
        mListView = (ListView)findViewById(R.id.list_view);

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)){
                    mListView.setFilterText(newText);
                }else {
                    mListView.clearTextFilter();
                }
                return false;
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void setupAdapter(List<Subjects> list){
        MyAdapter myAdapter = new MyAdapter(MainActivity.this,list);
        mListView.setAdapter(myAdapter);
    }

    private class DoubanTask extends AsyncTask<Void, Void, List<Subjects>>{

        @Override
        protected List<Subjects> doInBackground(Void... params){

            return new Douban().get("https://api.douban.com/v2/movie/top250");
        }

        @Override
        protected void onPostExecute(List<Subjects> list){
            setupAdapter(list);
        }
    }
}
