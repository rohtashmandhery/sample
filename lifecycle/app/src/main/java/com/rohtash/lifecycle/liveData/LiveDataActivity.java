package com.rohtash.lifecycle.liveData;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rohtash.lifecycle.R;

public class LiveDataActivity extends AppCompatActivity {
    TextView numberTV;
    Button changeBT;
    LiveDataViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);
        init();
        model= ViewModelProviders.of(this).get(LiveDataViewModel.class);
        LiveData<DataModel> liveData=model.getNumber();

        liveData.observe(this, new Observer<DataModel>() {
            @Override
            public void onChanged(DataModel dataModel) {
                Log.d("###","Change Observed");
                numberTV.setText(dataModel.getRandomNumber());
            }
        });

    }

    private void init(){
        numberTV=findViewById(R.id.numberTV);
        changeBT=findViewById(R.id.changeBT);
        changeBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("###","Made Changes in data");
                model.createNumber();
            }
        });
    }
}