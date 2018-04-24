package com.hanchai.assetcheck.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.hanchai.assetcheck.R;

/**
 * Created by Hanchai on 21-Apr-18.
 */
class ItemViewHolder extends RecyclerView.ViewHolder {

    TextView title_name;
    TextView title_code;
    TextView title_type;
    public ItemViewHolder(View itemView) {
        super(itemView);
        title_name = itemView.findViewById(R.id.item_name);
        title_code = itemView.findViewById(R.id.item_code);
        title_type = itemView.findViewById(R.id.item_type);
    }

}