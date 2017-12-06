package com.bwie.mvpapplication;

/**
 * Created by liqy on 2017/12/6.
 */

public interface BasePresenter<V> {
    /**
     * 对应onCreate
     */
    void subscribe(V view);

    /**
     * OnDestroy
     */
    void unsubscribe();
}
