package com.bwie.mvpapplication.model.home;

import com.bwie.mvpapplication.BasePresenter;
import com.bwie.mvpapplication.BaseView;

/**
 * 关于主页的接口合约
 * Created by liqy on 2017/12/6.
 */

public interface HomeContract {

    /**
     * 业务接口
     */
    interface Presenter extends BasePresenter {

    }

    /**
     * UI更新接口
     */
    public interface View extends BaseView{
        public void updateList();
    }
}

