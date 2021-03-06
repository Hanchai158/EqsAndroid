package com.hanchai.assetcheck.singlepage;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.hanchai.assetcheck.R;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.Manifest.permission.CAMERA;

public class QR_Barcode extends AppCompatActivity implements ZXingScannerView.ResultHandler{
    private  static final int REQUEST_CAMERA = 1;
    private ZXingScannerView scannerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //scannerView = new ZXingScannerView(this);

        setContentView(R.layout.activity_qr__barcode);
        scannerView = findViewById(R.id.zxscan);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(checkPermission()){
                Toast.makeText(QR_Barcode.this,"Permission is granted!", Toast.LENGTH_LONG).show();
            }else{
                requestPermissions();
            }
        }
    }

    private boolean checkPermission(){
        return (ContextCompat.checkSelfPermission(QR_Barcode.this, CAMERA) == PackageManager.PERMISSION_GRANTED);
    }

    private  void requestPermissions(){
        ActivityCompat.requestPermissions(this, new String[]{CAMERA}, REQUEST_CAMERA);
    }

    public void onRequestPermissionResult(final int requestCode, String permission[], int grantResults[]){
        switch(requestCode){
            case REQUEST_CAMERA :
                if(grantResults.length > 0){
                    boolean cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if(cameraAccepted){
                        Toast.makeText(QR_Barcode.this, "Permission Granted", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(QR_Barcode.this, "Permission Denied", Toast.LENGTH_LONG).show();
                        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                            if(shouldShowRequestPermissionRationale(CAMERA)){
                                displayAlertMessage("You need to allow access for both permissions",
                                        new DialogInterface.OnClickListener(){
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i){
                                                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                    requestPermissions(new String[]{CAMERA}, REQUEST_CAMERA);
                                                }
                                            }
                                        });
                                return;
                            }
                        }
                    }
                    break;
                }
        }
    }

    public void displayAlertMessage(String message, DialogInterface.OnClickListener listener){

       new AlertDialog.Builder(QR_Barcode.this)
                .setMessage(message)
                .setPositiveButton("OK", (DialogInterface.OnClickListener) listener)
                .setNegativeButton("Cancel",null)
                .create()
                .show();
    }

    @Override
    public void  onResume(){
        super.onResume();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(checkPermission()){
                if(scannerView == null){
                    scannerView = new ZXingScannerView(this);
                    setContentView(scannerView);
                }
                scannerView.setResultHandler(this);
                scannerView.startCamera();
            }else{
                requestPermissions();
            }
        }
    }

    @Override
    public  void onDestroy(){
        super.onDestroy();
        scannerView.stopCamera();
    }

    @Override
    public void handleResult(com.google.zxing.Result result) {
        final String scanResult = result.getText();

        // put the String to pass back into an Intent and close this activity
        Intent intent = new Intent();
        intent.putExtra("Code", scanResult);
        setResult(RESULT_OK, intent);
        finish();

//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Scan Result");
//        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                scannerView.resumeCameraPreview(QR_Barcode.this);
//            }
//        });
//
//        builder.setPositiveButton("Visit", new DialogInterface.OnClickListener(){
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Intent intent = new Intent(Intent.ACTION_VIEW , Uri.parse(scanResult));
//                startActivity(intent);
//            }
//        });
//        builder.setMessage(scanResult);
//        AlertDialog alert = builder.create();
//        alert.show();
    }

}
