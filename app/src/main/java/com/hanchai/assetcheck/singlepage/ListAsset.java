package com.hanchai.assetcheck.singlepage;

import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hanchai.assetcheck.R;
import com.hanchai.assetcheck.fragment.Histroy;
import com.hanchai.assetcheck.fragment.ListData;
import com.hanchai.assetcheck.model.AssetDao;
import com.hanchai.assetcheck.model.ItemCollectionDao;
import com.hanchai.assetcheck.service.HttpManager;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Callback;
import retrofit2.Response;

public class ListAsset extends AppCompatActivity {
    Button btn_scan;
    private int buildId;
    private String roomId;
    private ArrayList<AssetDao> ListCode;
    private TextView TitleText;
    private EditText Code;
    private static final int SUB_ACTIVITY_REQUEST_CODE = 1;
    private Button addbutton;
    private Button sentbutton;
    private Fragment fragment;
    private Fragment previousFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String text = getIntent().getStringExtra("BuildingName");
        buildId = getIntent().getIntExtra("BuildingID",1);
        roomId = getIntent().getStringExtra("RoomID");
        setContentView(R.layout.activity_list_asset);
        TitleText = findViewById(R.id.Asset_title);
        TitleText.setText(text);
        Code = findViewById(R.id.Code_here);
        ListCode = new ArrayList<AssetDao>();
        sentbutton = findViewById(R.id.Asset_Button);
        addbutton = findViewById(R.id.addbutton);

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Code = findViewById(R.id.Code_here);
                String CodeForAdd = Code.getText().toString();
                AssetDao list = new AssetDao(CodeForAdd);
                ListCode.add(list);
                Toast.makeText(getApplication().getBaseContext(), "Add "+CodeForAdd, Toast.LENGTH_SHORT).show();
                if(ListCode != null) {
                    for (AssetDao Code:ListCode) {
                        Log.d("CodeActivity",":: "+Code.getCode());

                    }
                }
                fragment = new ListData();
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("arraylist", ListCode);
                fragment.setArguments(bundle);

                //getFragmentManager().beginTransaction().add(R.id.fragment, Histroy.newInstance(String.valueOf(buildId),roomId)).commit();
            if(previousFragment != null)
                    getFragmentManager().beginTransaction().remove(previousFragment).commit();
                android.app.FragmentManager manager = getFragmentManager();
                manager.beginTransaction()
                        .add(R.id.Asset_fragment, fragment)
                        .replace(R.id.Asset_fragment,fragment)
                        .addToBackStack(null)
                        .commit();
                previousFragment = fragment;
            }
        });
        sentbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int build = buildId;
                int room = Integer.parseInt(roomId);
                if(ListCode != null) {
                    for (AssetDao Code:ListCode) {
                        HttpManager.getInstance("http://10.80.39.17/TSP58/nursing/index.php/eqs/service_mobile/AndroidApi/").getService().insertCode(Code.getCode(),build,room)
                                .enqueue(new Callback<Boolean>() {
                                    @Override
                                    public void onResponse(retrofit2.Call<Boolean> call, Response<Boolean> response) {

                                    }

                                    @Override
                                    public void onFailure(retrofit2.Call<Boolean> call, Throwable t) {

                                    }
                                });
                        //Log.d("CodeActivity",":: "+Code.getCode());
                    }
                }

                //    Call<List<ItemCollectionDao>> call = HttpManager.getInstance("http://10.80.39.17/TSP58/nursing/index.php/eqs/service_mobile/AndroidApi/").getService().getItemList(buID,romId);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_qr, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_scan){
            Intent intent = new Intent(this,QR_Barcode.class);
            startActivityForResult(intent,SUB_ACTIVITY_REQUEST_CODE);
        }
        return true;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is the SecondActivity with an OK result
        if (requestCode == SUB_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) { // Activity.RESULT_OK

                // get String data from Intent
                String returnString = data.getStringExtra("Code");

                // set text view with string
                AssetDao list = new AssetDao(returnString);
                ListCode.add(list);
                Toast.makeText(getApplication().getBaseContext(), "Add "+returnString, Toast.LENGTH_SHORT).show();

                fragment = new ListData();
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("arraylist", ListCode);
                fragment.setArguments(bundle);

                //getFragmentManager().beginTransaction().add(R.id.fragment, Histroy.newInstance(String.valueOf(buildId),roomId)).commit();
                if(previousFragment != null)
                    getFragmentManager().beginTransaction().remove(previousFragment).commit();
                android.app.FragmentManager manager = getFragmentManager();
                manager.beginTransaction()
                        .add(R.id.Asset_fragment, fragment)
                        .replace(R.id.Asset_fragment,fragment)
                        .addToBackStack(null)
                        .commit();
                previousFragment = fragment;
            }
        }
    }

    public void updateCode(ArrayList<AssetDao> codeList) {
        ListCode = codeList;
    }
}
