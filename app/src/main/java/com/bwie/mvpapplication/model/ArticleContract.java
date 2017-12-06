package com.bwie.mvpapplication.model;

import android.support.v7.app.AppCompatActivity;

import com.bwie.mvpapplication.BasePresenter;
import com.bwie.mvpapplication.BaseView;
import com.bwie.mvpapplication.data.Article;

/**
 * Created by liqy on 2017/12/6.
 */

public interface ArticleContract {
    /**
     * 业务接口
     */
    interface Presenter<M extends AppCompatActivity> extends BasePresenter<View> {
        public void getArticle(int dev);
    }

    /**
     * UI更新接口
     */
    public interface View extends BaseView {
        public void showArticle(Article article);
    }
}
