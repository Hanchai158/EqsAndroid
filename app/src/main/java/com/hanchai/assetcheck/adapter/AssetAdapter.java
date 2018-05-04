package com.hanchai.assetcheck.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hanchai.assetcheck.R;
import com.hanchai.assetcheck.model.AssetDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kogoeru on 4/26/2018.
 */

public class AssetAdapter extends RecyclerView.Adapter<AssetViewHolder>{
    ArrayList<AssetDao> asset;

    public AssetAdapter(ArrayList<AssetDao> asset) {
        this.asset = asset;
    }

    @Override
    public AssetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.from(parent.getContext())
                .inflate(R.layout.card_view_asset, parent, false);
        AssetViewHolder pv = new AssetViewHolder(view);
        return pv;
    }

    @Override
    public void onBindViewHolder(AssetViewHolder holder, int position) {
        AssetDao assetDao = asset.get(position);
        holder.AssetCode.setText(assetDao.getCode());
    }

    @Override
    public int getItemCount() {
        if(asset != null)
            return asset.size();
        return 0;
    }
}
