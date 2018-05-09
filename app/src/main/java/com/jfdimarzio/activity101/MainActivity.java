package com.jfdimarzio.activity101;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends Activity {
    int request_Code = 1;

    String tag= "Aktivitet";
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(tag,"In the OnCreate() event");

    }
    public void onClick(View view) {
        startActivityForResult(new Intent("com.jfdimarzio.usingintent.SecondActivity"),request_Code);
    }
    public void onActivityResult (int requestCode, int resultCode,Intent data)
    {
       if (requestCode == request_Code){
           if (resultCode == RESULT_OK){
               Toast.makeText(this,data.getData().toString(),
                       Toast.LENGTH_SHORT) .show();
           }
       }
    }

    public void onStart() {
        super.onStart();
        Log.d(tag, "In the OnStart() event");
        progressDialog = ProgressDialog.show(this, "Please Wait", "Processing...", true);
        CountDownTimer timer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                progressDialog.dismiss();
            }
        }.start();

         }
        @Override
        public void onRestart()
        {
            super.onRestart();
            Log.d(tag, "In the onRestart() event");

        }
        @Override
        public void onResume()
        {
            super.onResume();
            Log.d(tag, "In the onResume() event");

        }
        @Override
        public void onPause()
        {
            super.onPause();
            Log.d(tag, "In the onPause() event");

        }
        @Override
        public void onStop()
        {
            super.onStop();
            Log.d(tag, "In the onStop() event");

        }
        @Override
        public void onDestroy()
        {
            super.onDestroy();
            Log.d(tag, "In the onDestroy() event");

        }
    }



