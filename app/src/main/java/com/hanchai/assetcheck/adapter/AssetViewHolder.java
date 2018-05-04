package com.hanchai.assetcheck.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.hanchai.assetcheck.R;

/**
 * Created by Kogoeru on 4/26/2018.
 */

public class AssetViewHolder extends RecyclerView.ViewHolder{
    TextView AssetCode;
    public AssetViewHolder(View AssetView) {
        super(AssetView);
        AssetCode = AssetView.findViewById(R.id.AssetCodeText);
    }
}
