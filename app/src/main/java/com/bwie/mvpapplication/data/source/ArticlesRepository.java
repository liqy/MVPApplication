package com.bwie.mvpapplication.data.source;

import com.bwie.mvpapplication.data.Article;
import com.bwie.mvpapplication.data.BaseResponse;
import com.bwie.mvpapplication.data.source.net.RetrofitHelper;
import com.bwie.mvpapplication.data.source.net.RxSchedulers;

import io.reactivex.Flowable;

/**
 * Created by liqy on 2017/12/6.
 */

public class ArticlesRepository implements ArticlesDataSource {

    @Override
    public Flowable<BaseResponse<Article>> getArticle(int dev) {
        return RetrofitHelper.getStoreAPI().getArticle(dev)
                .compose(RxSchedulers.<BaseResponse<Article>>io_main())
                ;
    }
}
