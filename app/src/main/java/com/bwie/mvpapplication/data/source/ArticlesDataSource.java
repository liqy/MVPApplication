package com.bwie.mvpapplication.data.source;

import com.bwie.mvpapplication.data.Article;
import com.bwie.mvpapplication.data.BaseResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by liqy on 2017/12/6.
 */


public interface ArticlesDataSource {

    @GET("article/today")
    Flowable<BaseResponse<Article>> getArticle(@Query("dev") int dev);

}
