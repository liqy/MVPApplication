package com.bwie.mvpapplication.model;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bwie.mvpapplication.R;
import com.bwie.mvpapplication.data.Article;

public class MainActivity extends AppCompatActivity implements ArticleContract.View {

    ArticlePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new ArticlePresenter();

        presenter.subscribe(this);

        presenter.getArticle(1);

    }

    @Override
    public void showArticle(Article article) {
        Log.d(getLocalClassName(),article.toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.unsubscribe();
    }
}
