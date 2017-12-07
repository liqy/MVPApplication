package com.bwie.mvpapplication.model;

import com.bwie.mvpapplication.data.Article;
import com.bwie.mvpapplication.data.BaseResponse;
import com.bwie.mvpapplication.data.source.ArticlesRepository;

import org.reactivestreams.Publisher;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

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



    public <T> FlowableTransformer<BaseResponse<T>, T> handleResult() {
        return new FlowableTransformer<BaseResponse<T>, T>() {
            @Override
            public Publisher<T> apply(Flowable<BaseResponse<T>> upstream) {
                return upstream.flatMap(new Function<BaseResponse<T>, Publisher<T>>() {
                    @Override
                    public Publisher<T> apply(BaseResponse<T> tBaseResponse) throws Exception {
                        if (tBaseResponse.data != null) {
                            return createData(tBaseResponse.data);
                        } else {
                            return Flowable.error(new Exception(tBaseResponse.getMsg()));
                        }
                    }
                });
            }
        };
    }

    private <T> Flowable<T> createData(final T t) {
        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(FlowableEmitter<T> e) throws Exception {
                try {
                    e.onNext(t);
                    e.onComplete();
                } catch (Exception exc) {
                    e.onError(exc);
                }
            }
        }, BackpressureStrategy.BUFFER);
    }

    @Override
    public void getArticle(int dev) {
        repository.getArticle(dev)
                .compose(this.<Article>handleResult())
                .subscribe(articleBaseResponse -> view.showArticle(articleBaseResponse));

    }
}
