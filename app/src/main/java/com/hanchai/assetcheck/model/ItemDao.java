package com.hanchai.assetcheck.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hanchai on 21-Apr-18.
 */

public class ItemDao {
    @SerializedName("username")
    private  String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
/*@SerializedName("image_url")
    private  String imageUrl;*/

    /*public ItemDao() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }*/
}
