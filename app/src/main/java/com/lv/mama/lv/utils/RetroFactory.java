package com.lv.mama.lv.utils;

import com.lv.mama.lv.client.Api;
import com.lv.mama.lv.client.ApiServer;
import com.lv.mama.lv.client.LoggingInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 武晓瑞 on 2017/11/8.
 */

public class RetroFactory {
    private RetroFactory() {
    }

    private static OkHttpClient httpClient = new OkHttpClient.Builder()
            .addInterceptor(new LoggingInterceptor()).connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build();
    private static ApiServer retrofitService = new Retrofit.Builder()
            .baseUrl(Api.TYPE_HOME)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .client(httpClient)
            .build()
            .create(ApiServer.class);
    //单列模式
    public static ApiServer getInstance() {
        return retrofitService;
    }
}