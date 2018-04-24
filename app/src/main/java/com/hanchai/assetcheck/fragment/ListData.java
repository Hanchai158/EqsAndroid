package com.hanchai.assetcheck.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hanchai.assetcheck.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListData extends Fragment {
    RecyclerView rvAssetText;

    public ListData() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_list_data, container, false);
//        rvAssetText = v.findViewById(R.id.rv_asset_item);
//        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
//        rvAssetText.setLayoutManager(manager);
        return v;
    }

}
