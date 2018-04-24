package com.hanchai.assetcheck.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Kogoeru on 4/24/2018.
 */

public class BuildingCollectionDao {
    @SerializedName("bd_id")
    private int bd_id;

    @SerializedName("bd_name_abbr")
    private String bd_name_abbr;

    public int getBd_id() {
        return bd_id;
    }

    public void setBd_id(int bd_id) {
        this.bd_id = bd_id;
    }

    public String getBd_name_abbr() {
        return bd_name_abbr;
    }

    public void setBd_name_abbr(String bd_name_abbr) {
        this.bd_name_abbr = bd_name_abbr;
    }
}
