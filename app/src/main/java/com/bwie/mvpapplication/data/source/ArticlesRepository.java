package com.bwie.mvpapplication.data.source;

import com.bwie.mvpapplication.data.Article;
import com.bwie.mvpapplication.data.BaseResponse;
import com.bwie.mvpapplication.data.source.net.RetrofitHelper;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by liqy on 2017/12/6.
 */

public class ArticlesRepository implements ArticlesDataSource{

    @Override
    public Flowable<BaseResponse<Article>> getArticle(int dev) {
        return RetrofitHelper.getStoreAPI().getArticle(dev)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                ;
    }
}
