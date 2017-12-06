package com.bwie.mvpapplication.data;

import java.util.List;

/**
 * Created by liqy on 2017/12/6.
 */

public class Article {
    public PublishDate date;
    public String author;
    public String title;
    public String digest;
    public String content;
    public String wc;

    @Override
    public String toString() {
        return "Article{" +
                "date=" + date +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", digest='" + digest + '\'' +
                ", content='" + content + '\'' +
                ", wc='" + wc + '\'' +
                '}';
    }
}
