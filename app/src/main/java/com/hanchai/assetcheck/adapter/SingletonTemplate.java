package com.hanchai.assetcheck.adapter;

/**
 * Created by Hanchai on 21-Apr-18.
 */

public class SingletonTemplate {
    private static SingletonTemplate instance;

    public static SingletonTemplate getInstance() {
        if (instance == null)
            instance = new SingletonTemplate();
        return instance;
    }

    /*private Context mContext;

    private SingletonTemplate() {
        mContext = Contextor.getInstance().getContext();
    }*/
}
