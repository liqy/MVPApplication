package com.bwie.mvpapplication.data;

import android.text.TextUtils;

/**
 * Created by liqy on 2017/12/6.
 */

public class BaseResponse <T> {
    public String msg;
    public T data;

    public String getMsg(){
        if (TextUtils.isEmpty(msg)){
            return "网络异常";
        }else {
            return msg;
        }
    }

}
