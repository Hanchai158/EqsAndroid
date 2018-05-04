package com.hanchai.assetcheck.service;

import com.hanchai.assetcheck.model.BuildingCollectionDao;
import com.hanchai.assetcheck.model.ItemCollectionDao;
import com.hanchai.assetcheck.model.RoomCollectionDao;
import com.hanchai.assetcheck.model.RoomDetailDao;

import java.lang.reflect.Array;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by Hanchai on 21-Apr-18.
 */

public interface ApiService {
    @POST("getHistory_Equipments/{idBu}/{idRo}")
    Call<List<ItemCollectionDao>> getItemList(@Path("idBu") int idBu, @Path("idRo") int idRo);
    @POST("getBuilding")
    Call<List<BuildingCollectionDao>> getBuildingList();

    @POST("getRoom/{id}")
    Call<List<RoomDetailDao>> getRoom(@Path("id") int id);

    @POST("update_Equipment/{Code}/{idBu}/{idRo}")
    Call<Boolean> insertCode(@Part("Code") String Code, @Part("idBu") int idBu, @Part("idRo") int idRo);
}
