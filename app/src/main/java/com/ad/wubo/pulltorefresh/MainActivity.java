package com.ad.wubo.pulltorefresh;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;

/**
 * 目标：实现上拉和下拉皆可刷新
 */
public class MainActivity extends AppCompatActivity {

    private PullToRefreshListView lv;
    private MusicAdapter musicAdapter;
    private ArrayList<Music> musics = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadDatas();

        lv = (PullToRefreshListView) findViewById(R.id.pull_to_refresh_listView);
        //实现可下拉亦可上拉的刷新效果
        lv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                //刷新--> 异步加载数据
                new LoadDataAsyncTask().execute();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                new LoadDataAsyncTask().execute();
            }
        });
        lv.setMode(PullToRefreshBase.Mode.BOTH); //可上拉可下拉

        musicAdapter = new MusicAdapter(this,musics);
        lv.setAdapter(musicAdapter);

    }

    class LoadDataAsyncTask extends AsyncTask<Void,Void,String>{

        @Override
        protected String doInBackground(Void... voids) {
            try {
                //让其休眠2秒
                Thread.sleep(2000);
                loadDatas();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "success";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if ("success".equals(s)){
                musicAdapter.notifyDataSetChanged();
                lv.onRefreshComplete();
            }
        }
    }

    private int count =1;
    public void loadDatas(){
        for (int i=0;i<5;i++){
            musics.add(new Music("歌曲-"+count,"---歌手-"+count+" ==>上拉下拉皆可刷新"));
            count++;
        }
    }
}
