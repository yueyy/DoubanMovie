package com.example.yueuy.doubanmovie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.yueuy.doubanmovie.R;
import com.example.yueuy.doubanmovie.bean.Casts;
import com.example.yueuy.doubanmovie.bean.Directors;
import com.example.yueuy.doubanmovie.bean.Movies;
import com.example.yueuy.doubanmovie.bean.Subjects;

import java.util.List;

/**
 * Created by yueuy on 17-12-18.
 */

public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private List<Subjects> list;
    private LayoutInflater mInflater;

    public MyAdapter(Context context, List<Subjects> list){
        mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.list = list;

    }

    @Override
    public int getCount(){
        return list.size();
    }

    @Override
    public Object getItem(int position){
        return list.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;
        if (convertView == null){
            convertView = mInflater.inflate(R.layout.list, parent
            ,false);
            holder = new ViewHolder();
            holder.title = convertView.findViewById(R.id.title);
            holder.rating = convertView.findViewById(R.id.rating);
            holder.collect_count = convertView.findViewById(R.id.collect_count);
            holder.director = convertView.findViewById(R.id.director);
            holder.casts = convertView.findViewById(R.id.casts);
            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.title.setText(list.get(position).getTitle());
        holder.rating.setText(list.get(position).getRating());
        holder.collect_count.setText(""+list.get(position).getCollect_count());
//        holder.director.setText();
//        holder.casts.setText();
        return convertView;
    }

    class ViewHolder{
        TextView title,rating,collect_count,director,casts;
    }
}
