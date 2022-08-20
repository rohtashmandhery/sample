package com.rohtash.lifecycle.intentServices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.rohtash.lifecycle.R;



public class ServiceActivity extends AppCompatActivity {
    public static final String FILTER_ACTION_KEY = "any_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        Intent serviceIntent=new Intent(this,MyIntentService.class);
        startService(serviceIntent);
        Log.d("###","intent service started");
    }


}