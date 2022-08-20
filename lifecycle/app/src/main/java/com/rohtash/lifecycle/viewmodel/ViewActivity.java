package com.rohtash.lifecycle.viewmodel;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.rohtash.lifecycle.R;


public class ViewActivity extends AppCompatActivity {
    TextView numberTV;
    Button changeBT;
    DataModel model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmodel);
        init();
        model= ViewModelProviders.of(this).get(DataModel.class);
        numberTV.setText(model.getNumber());
    }

    private void init(){
        numberTV=findViewById(R.id.numberTV);
        changeBT=findViewById(R.id.changeBT);
        changeBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.createNumber();
            }
        });
    }



}
