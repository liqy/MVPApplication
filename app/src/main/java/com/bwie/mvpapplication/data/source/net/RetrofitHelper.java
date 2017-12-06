package com.bwie.mvpapplication.data.source.net;

import com.bwie.mvpapplication.data.source.ArticlesDataSource;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by liqy on 2017/12/6.
 */

public class RetrofitHelper {

    private static OkHttpClient okHttpClient;

    static {
        initOkHttpClient();
    }

    private static void initOkHttpClient() {
        if (okHttpClient == null) {
            synchronized (RetrofitHelper.class) {
                if (okHttpClient == null) {
                    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                    logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                    okHttpClient = new OkHttpClient.Builder()
                            .addInterceptor(logging)
                            .addInterceptor(new UserAgentInterceptor())//添加一个应用拦截器
                            .build();

                }
            }
        }
    }

    public static <T> T createAPI(Class<T> clzss, String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(clzss);

    }

    /**
     * 添加UA拦截器，B站请求API需要加上UA才能正常使用
     */
    private static class UserAgentInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();

            Request requestWithUserAgent = originalRequest.newBuilder()
                    .removeHeader("User-Agent")
                    .addHeader("User-Agent", "Mozilla/5.0 (Linux; Android 5.1.1; Nexus 6 Build/LYZ28E) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Mobile Safari/537.36")
                    .build();

            return chain.proceed(requestWithUserAgent);
        }
    }

    public static ArticlesDataSource getStoreAPI() {
        return createAPI(ArticlesDataSource.class, "https://interface.meiriyiwen.com/");
    }


}
