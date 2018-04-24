package com.hanchai.assetcheck.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hanchai.assetcheck.adapter.ItemAdapter;
import com.hanchai.assetcheck.R;
import com.hanchai.assetcheck.model.ItemCollectionDao;
import com.hanchai.assetcheck.service.HttpManager;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class Histroy extends Fragment {

    RecyclerView rvListItem;
    String strtext;
    String buildId = "-1";
    String roomId = "-1";
    private static final String ARG_BUILDID = "ARG_BUILDID";
    private static final String ARG_ROOMID = "ARG_ROOMID";

    public Histroy() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            buildId = getArguments().getString(ARG_BUILDID);
            roomId = getArguments().getString(ARG_ROOMID);

        }
        Log.d("buildId","::"+buildId+" roomId ::"+roomId);
    }

    public static Histroy newInstance(String buildId, String roomId) {
        Histroy fragment = new Histroy();
        Bundle args = new Bundle();
        args.putString(ARG_BUILDID, buildId);
        args.putString(ARG_ROOMID,roomId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //setContentView(R.layout.activity_histroy__item);
        View v = inflater.inflate(R.layout.fragment_histroy, container, false);
        rvListItem =  v.findViewById(R.id.rv_list_item);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rvListItem.setLayoutManager(manager);


        serviceItem(buildId,roomId);
        return v;
    }
    private void serviceItem(String buildId, String roomId){
        int buID = Integer.parseInt(buildId);
        int romId = Integer.parseInt(roomId);
        Call<List<ItemCollectionDao>> call = HttpManager.getInstance("http://10.80.39.17/TSP58/nursing/index.php/eqs/service_mobile/AndroidApi/").getService().getItemList(buID,romId);
        call.enqueue(new Callback<List<ItemCollectionDao>>(){
            @Override
            public void onResponse(Call<List<ItemCollectionDao>> call, Response<List<ItemCollectionDao>> response) {
                if(response.isSuccessful()){
                      List<ItemCollectionDao> history = response.body();
//                    Log.d("serviceText","response.isSuccessful :: "+photo.getData().get(0).getUsername());

                    ItemAdapter historyAdapter = new ItemAdapter(history);
                    rvListItem.setAdapter(historyAdapter);

                }else{
                    try {
                        Log.d("servicePhoto","else :: "+response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ItemCollectionDao>> call, Throwable t) {
                Log.d("servicePhoto","onFailure :: "+t);
            }
        });
    }
}
