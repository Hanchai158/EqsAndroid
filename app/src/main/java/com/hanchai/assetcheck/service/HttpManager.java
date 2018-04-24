package com.hanchai.assetcheck.service;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hanchai on 21-Apr-18.
 */
public class HttpManager {

    private static HttpManager instance;

    private HttpManager(String url){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiService.class);
    }

    public static HttpManager getInstance(String Url) {
        if (instance == null)
            instance = new HttpManager(Url);
        return instance;
    }

    private Context mContext;
    private ApiService service;

    public ApiService getService() {
        return service;
    }

    /*private SingletonTemplate() {


    }*/

}