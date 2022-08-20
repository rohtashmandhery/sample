package com.rohtash.lifecycle.life_cycle;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.rohtash.lifecycle.R;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d("###","SecondActivity OnCreate");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("###","SecondActivity OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("###","SecondActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("###","SecondActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("###","SecondActivity onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("###","SecondActivity onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("###","SecondActivity onDestroy");
    }


}
