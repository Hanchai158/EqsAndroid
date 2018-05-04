package com.hanchai.assetcheck.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hanchai.assetcheck.R;
import com.hanchai.assetcheck.model.ItemCollectionDao;

import java.util.List;

/**
 * Created by Hanchai on 21-Apr-18.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    List<ItemCollectionDao> asset;

    public ItemAdapter(List<ItemCollectionDao> asset) {

        this.asset = asset;

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.from(parent.getContext())
                .inflate(R.layout.crad_view_histroy, parent, false);
        ItemViewHolder pv = new ItemViewHolder(view);
        return pv;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        ItemCollectionDao itemCollectionDao = asset.get(position);
        holder.title_name.setText(itemCollectionDao.getEqsName());
        holder.title_code.setText(itemCollectionDao.getEqsCodeOld());
        holder.title_type.setText(itemCollectionDao.getFmstAbbr());
    }

    @Override
    public int getItemCount() {
        if(asset != null)
        return asset.size();

        return 0;
    }
}

