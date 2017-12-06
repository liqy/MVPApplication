package com.bwie.mvpapplication.data;

import com.google.gson.Gson;

/**
 * Created by liqy on 2017/12/6.
 */

public class PublishDate {

    /**
     * curr : 20171206
     * prev : 20171205
     * next : 20171207
     */

    public String curr;
    public String prev;
    public String next;

    @Override
    public String toString() {
        return "PublishDate{" +
                "curr='" + curr + '\'' +
                ", prev='" + prev + '\'' +
                ", next='" + next + '\'' +
                '}';
    }
}
