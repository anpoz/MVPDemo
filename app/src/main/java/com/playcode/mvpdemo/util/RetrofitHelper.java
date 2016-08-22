package com.playcode.mvpdemo.util;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/8/20 0020.
 */
public class RetrofitHelper {
    private Retrofit mRetrofit;
    private static final String BASE_URL = "http://news-at.zhihu.com/";
    private static RetrofitHelper ourInstance = new RetrofitHelper();

    public static RetrofitHelper getInstance() {
        return ourInstance;
    }

    private RetrofitHelper() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }
}
