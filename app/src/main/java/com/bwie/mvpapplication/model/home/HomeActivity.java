package com.bwie.mvpapplication.model.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bwie.mvpapplication.R;

/**
 * 初始化 控制器
 */
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activity);
    }
}
