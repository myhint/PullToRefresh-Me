package com.ad.wubo.pulltorefresh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/7.
 */
public class MusicAdapter extends BaseAdapter {

    private ArrayList<Music> musics;
    private ViewHolder viewHolder;
    private Context context;

    public MusicAdapter(Context context,ArrayList<Music> musics){
        this.context = context;
        this.musics = musics;
    }

    @Override
    public int getCount() {
        return musics.size();
    }

    @Override
    public Object getItem(int i) {
        return musics.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item,null);
            viewHolder = new ViewHolder();
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tvSinger = (TextView) convertView.findViewById(R.id.tvSinger);
            //设置标记tag
            convertView.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) convertView.getTag();
        Music music = musics.get(position);
        viewHolder.tvTitle.setText(music.getTitle());
        viewHolder.tvSinger.setText(music.getSinger());

        return convertView;
    }

    class ViewHolder{

        private TextView tvTitle;
        private TextView tvSinger;

        public TextView getTvTitle() {
            return tvTitle;
        }

        public TextView getTvSinger() {
            return tvSinger;
        }
    }
}
