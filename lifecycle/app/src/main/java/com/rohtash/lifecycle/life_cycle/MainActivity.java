package com.rohtash.lifecycle.life_cycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.rohtash.lifecycle.R;

public class MainActivity extends AppCompatActivity {
    TextView helloTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("###","Owners On Create");
        init();
       // getLifecycle().addObserver(new MainActivityObserver());
    }

    public void init(){
        helloTV=findViewById(R.id.helloTV);
        helloTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, SecondActivity.class);
                MainActivity.this.startActivity(intent);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("###","Owner OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("###","Owner onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("###","Owner onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("###","Owner onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("###","Owner onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("###","Owner onDestroy");
    }
}
