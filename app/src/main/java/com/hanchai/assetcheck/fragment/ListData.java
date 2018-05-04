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

import com.github.brnunes.swipeablerecyclerview.SwipeableRecyclerViewTouchListener;
import com.hanchai.assetcheck.R;
import com.hanchai.assetcheck.adapter.AssetAdapter;
import com.hanchai.assetcheck.model.AssetDao;
import com.hanchai.assetcheck.singlepage.ListAsset;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListData extends Fragment {
    RecyclerView rvAssetText;
    private ArrayList<AssetDao> CodeList ;
    private AssetAdapter assetAdapter;

    public ListData() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {

            CodeList = args.getParcelableArrayList("arraylist");

            //getArguments().getParcelableArrayList();

        }
    }

    public static ListData newInstance(ArrayList<AssetDao> CodeList) {
        ListData fragment = new ListData();
        Bundle args = new Bundle();

        args.putParcelableArrayList("arraylist",CodeList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //Bundle extras = getActivity().getIntent().getExtras();
        if(CodeList == null)
             CodeList = new ArrayList<AssetDao>();
//        CodeList = extras.getParcelableArrayList("arraylist");
        View v = inflater.inflate(R.layout.fragment_list_data, container, false);
        rvAssetText = v.findViewById(R.id.rv_asset_item);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rvAssetText.setLayoutManager(manager);
       // CodeList.add(new AssetDao("Test"));
        for (AssetDao Code : CodeList){
            Log.d("Code name: ", Code.getCode());
        }
        assetAdapter = new AssetAdapter(CodeList);
        rvAssetText.setAdapter(assetAdapter);

        SwipeableRecyclerViewTouchListener swipeTouchListener =
                new SwipeableRecyclerViewTouchListener(rvAssetText,
                        new SwipeableRecyclerViewTouchListener.SwipeListener() {

                            @Override
                            public boolean canSwipeLeft(int position) {

                                return true;
                            }

                            @Override
                            public boolean canSwipeRight(int position) {
                                return true;
                            }

                            @Override
                            public void onDismissedBySwipeLeft(RecyclerView recyclerView, int[] reverseSortedPositions) {
                                for (int position : reverseSortedPositions) {
                                    CodeList.remove(position);
                                    assetAdapter.notifyItemRemoved(position);
                                    ((ListAsset)getActivity()).updateCode(CodeList);
                                }
                                assetAdapter.notifyDataSetChanged();
                            }

                            @Override
                            public void onDismissedBySwipeRight(RecyclerView recyclerView, int[] reverseSortedPositions) {
                                for (int position : reverseSortedPositions) {
                                    CodeList.remove(position);
                                    assetAdapter.notifyItemRemoved(position);
                                    ((ListAsset)getActivity()).updateCode(CodeList);

                                }
                                assetAdapter.notifyDataSetChanged();
                            }
                        });

        rvAssetText.addOnItemTouchListener(swipeTouchListener);
        return v;
    }

//    public ArrayList<AssetDao> SetCode(){
//        ArrayList<AssetDao> list = new ArrayList<>();
//        for (int i=0; i < 10 ; i++){
//            AssetDao item = new AssetDao("test"+i);
//            list.add(item);
//        }
//        return list;
//    }
}
