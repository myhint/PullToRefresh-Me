package com.ad.wubo.pulltorefresh;

/**
 * Created by Administrator on 2016/8/7.
 */
public class Music {

    private String title;
    private String singer;

    //无参构造函数
    public Music() {

    }

    //有参构造函数
    public Music(String title, String singer) {
        this.title = title;
        this.singer = singer;

    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
