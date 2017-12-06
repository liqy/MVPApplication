package com.bwie.mvpapplication.model;

import com.bwie.mvpapplication.data.Article;
import com.bwie.mvpapplication.data.BaseResponse;
import com.bwie.mvpapplication.data.source.ArticlesRepository;

import io.reactivex.functions.Consumer;

/**
 * Created by liqy on 2017/12/6.
 */

public class ArticlePresenter implements ArticleContract.Presenter<MainActivity> {

    ArticlesRepository repository;

    ArticleContract.View view;

    @Override
    public void subscribe(ArticleContract.View view) {
        repository = new ArticlesRepository();
        this.view = view;
    }

    @Override
    public void unsubscribe() {


    }

    @Override
    public void getArticle(int dev) {
        repository.getArticle(dev).subscribe(new Consumer<BaseResponse<Article>>() {
            @Override
            public void accept(BaseResponse<Article> articleBaseResponse) throws Exception {
                view.showArticle(articleBaseResponse.data);
            }
        });

    }
}
