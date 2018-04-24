package com.hanchai.assetcheck.singlepage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;

import com.hanchai.assetcheck.R;
import com.hanchai.assetcheck.fragment.Histroy;


public class Histroy_Item extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String s = getIntent().getStringExtra("BuildingName");
        int buildId = getIntent().getIntExtra("BuildingID",1);
        String roomId = getIntent().getStringExtra("RoomID");

        setContentView(R.layout.activity_histroy__item);

        TextView text =  findViewById(R.id.History_title);

        text.setText(s);


        getFragmentManager().beginTransaction().add(R.id.fragment, Histroy.newInstance(String.valueOf(buildId),roomId)).commit();
    }



}
