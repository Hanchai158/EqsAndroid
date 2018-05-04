package com.hanchai.assetcheck.model;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import com.hanchai.assetcheck.R;

import com.hanchai.assetcheck.singlepage.Histroy_Item;
import com.hanchai.assetcheck.service.HttpManager;
import com.hanchai.assetcheck.singlepage.ListAsset;
import com.hanchai.assetcheck.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class SelectBuilding extends Fragment {
    Spinner BuildingSpinner;
    Spinner RoomSpinner;
    ArrayList<String> building = new ArrayList<String>();
    ArrayList<String> room = new ArrayList<String>();
    ArrayList<Integer> buildingId = new ArrayList<Integer>();
    ArrayList<String> roomId = new ArrayList<String>();
    Button btn_check;
    Button btn_histroy;
    public SelectBuilding() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_select_building, container, false);

        BuildingSpinner = view.findViewById(R.id.spinner_building);
        RoomSpinner = view.findViewById(R.id.spinner_room);

        serviceBuilding();

        CreateBuildingSpinnerData();
        CreateRoomSpinnerData();

        ArrayAdapter<String> adapterBuilding = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_dropdown_item_1line, building);
        BuildingSpinner.setAdapter(adapterBuilding);

        ArrayAdapter<String> adapterRoom = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, room);
        RoomSpinner.setAdapter(adapterRoom);


        BuildingSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getRoomService(buildingId.get(position));
                //Toast.makeText(view.getContext(), "Select: "+ building.get(position),Toast.LENGTH_SHORT).show();
            }

            private void getRoomService(int buildingId) {
                Call<List<RoomDetailDao>> call = HttpManager.getInstance("http://10.80.39.17/TSP58/nursing/index.php/eqs/service_mobile/AndroidApi/").getService().getRoom(buildingId);
                call.enqueue(new Callback<List<RoomDetailDao>>() {
                    @Override
                    public void onResponse(Call<List<RoomDetailDao>> call, Response<List<RoomDetailDao>> response) {
                        if(response.isSuccessful()){
                            List<RoomDetailDao> roomDao = response.body();
                            room.clear();
                            roomId.clear();
                            if(roomDao.size() != 0) {
                                for (RoomDetailDao ro : roomDao) {
                                    room.add(ro.getRmId() + ro.getRmName());
                                    roomId.add(ro.getRmId());
//                                    ArrayAdapter<String> adapterRoom = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, room);
//                                    RoomSpinner.setAdapter(adapterRoom);
                                    Log.d("getRoomService :", "getRmId : " + ro.getRmId() + " getRmName :" + ro.getRmName());
                                }
                                RoomSpinner.setEnabled(true);
                            }else{
                                room.add(getContext().getString(R.string.StartRoomSpinner));
                                roomId.add("0");
                                RoomSpinner.setEnabled(false);

                            }
                            ArrayAdapter<String> adapterRoom = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, room);
                            RoomSpinner.setAdapter(adapterRoom);
                            Log.d("getRoomService :" ,""+roomDao.size());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<RoomDetailDao>> call, Throwable t) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        RoomSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(view.getContext(), "Select: "+ room.get(position),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn_check = (Button) view.findViewById(R.id.btn_check);
        btn_check.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /*((MainActivity) getActivity()).ChangeFrament(new ListData(),"listdata");*/
                        if(BuildingSpinner.getSelectedItem().toString() != getContext().getString(R.string.StartBuildingSpinner)) {
                            openActivity_List();
                        }else{
                            Toast.makeText(view.getContext(),getContext().getString(R.string.StartBuildingSpinner),Toast.LENGTH_SHORT).show();

                        }

                    }
                }
        );

        btn_histroy = (Button) view.findViewById(R.id.btn_history);
        btn_histroy.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(BuildingSpinner.getSelectedItem().toString() != getContext().getString(R.string.StartBuildingSpinner)) {
                            openActivity_Histroy();
                        }else{
                            Toast.makeText(view.getContext(),getContext().getString(R.string.StartBuildingSpinner),Toast.LENGTH_SHORT).show();

                        }
                    }
                }
        );
        return view;
    }

    public void openActivity_List(){
        Intent intent = new Intent(getContext(),ListAsset.class);
        String Room = "";
        String roomID = "";
        String Building = "";
        Integer buildId = -1;

        if(RoomSpinner.getSelectedItem().toString() != null) {
            Room = RoomSpinner.getSelectedItem().toString();
            roomID = roomId.get(RoomSpinner.getSelectedItemPosition());
        }else{
            Room = "";
            roomID = "";
        }


        if(BuildingSpinner.getSelectedItem().toString() != getContext().getString(R.string.StartBuildingSpinner)){
            Building = BuildingSpinner.getSelectedItem().toString();
            buildId = buildingId.get(BuildingSpinner.getSelectedItemPosition());
        }else{
            Building = "";
            buildId = -1;

        }
        if(Room == "ไม่มีห้อง") {
            Room = "-";
        }
        String Text = "อาคาร : " + Building + " ห้อง : " + Room;
        intent.putExtra("BuildingName", Text);
        intent.putExtra("BuildingID",buildId);
        intent.putExtra("RoomID",roomID);
        startActivity(intent);
    }

    public void openActivity_Histroy(){
        Intent intent = new Intent(getContext(),Histroy_Item.class);
        String Room = "";
        String roomID = "";
        String Building = "";
        Integer buildId = -1;

        if(RoomSpinner.getSelectedItem().toString() != null) {
            Room = RoomSpinner.getSelectedItem().toString();
            roomID = roomId.get(RoomSpinner.getSelectedItemPosition());
        }else{
            Room = "";
            roomID = "";
        }


        if(BuildingSpinner.getSelectedItem().toString() != getContext().getString(R.string.StartBuildingSpinner)){
            Building = BuildingSpinner.getSelectedItem().toString();
            buildId = buildingId.get(BuildingSpinner.getSelectedItemPosition());
        }else{
            Building = "";
            buildId = -1;

        }

        if(Room == "ไม่มีห้อง") {
            Room = "-";
        }
        String Text = "อาคาร : " + Building + " ห้อง : " + Room;
        intent.putExtra("BuildingName", Text);
        intent.putExtra("BuildingID",buildId);
        intent.putExtra("RoomID",roomID);
        startActivity(intent);
    }

    private void CreateBuildingSpinnerData(){
        building.add(getContext().getString(R.string.StartBuildingSpinner));
        buildingId.add(-1);
    }

    private void CreateRoomSpinnerData(){
        room.add(getContext().getString(R.string.StartRoomSpinner));
        roomId.add("0");
    }

    //service
    private void serviceBuilding(){
        Call<List<BuildingCollectionDao>> call = HttpManager.getInstance("http://10.80.39.17/TSP58/nursing/index.php/eqs/service_mobile/AndroidApi/").getService().getBuildingList();
        call.enqueue(new Callback<List<BuildingCollectionDao>>() {
            @Override
            public void onResponse(Call<List<BuildingCollectionDao>> call, Response<List<BuildingCollectionDao>> response) {
                if(response.isSuccessful()){
                    List<BuildingCollectionDao> Building = response.body();
                    Log.d("serviceText","response.isSuccessful :: "+Building.get(0).getBd_name_abbr());


                    for (BuildingCollectionDao bu : Building) {
                        building.add(bu.getBd_id()+bu.getBd_name_abbr());
                        buildingId.add(bu.getBd_id());
                    }
//                    ItemAdapter photoAdapter = new ItemAdapter(photo);
//                    rvListText.setAdapter(photoAdapter);

                }else{
                    try {
                        Log.d("serviceBuilding","else :: "+response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<BuildingCollectionDao>> call, Throwable t) {

            }
        });


    }
}
