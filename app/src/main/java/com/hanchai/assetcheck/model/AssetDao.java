package com.hanchai.assetcheck.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.stream.Stream;


/**
 * Created by Kogoeru on 4/26/2018.
 */

public class AssetDao extends ArrayList<Parcelable> implements Parcelable {
    private String Code;

    public AssetDao(String code) {
        Code = code;
    }

    protected AssetDao(Parcel in) {
        Code = in.readString();
    }

    public static final Creator<AssetDao> CREATOR = new Creator<AssetDao>() {
        @Override
        public AssetDao createFromParcel(Parcel in) {
            return new AssetDao(in);
        }

        @Override
        public AssetDao[] newArray(int size) {
            return new AssetDao[size];
        }
    };

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Code);
    }

    @Override
    public Stream<Parcelable> stream() {
        return null;
    }

    @Override
    public Stream<Parcelable> parallelStream() {
        return null;
    }
}
