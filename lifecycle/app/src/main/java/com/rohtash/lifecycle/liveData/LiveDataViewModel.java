package com.rohtash.lifecycle.liveData;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class LiveDataViewModel extends ViewModel {
    private MutableLiveData<DataModel> mutableLiveData;


    public MutableLiveData<DataModel> getNumber(){
        if(mutableLiveData==null){
            Log.d("###","Live Data Initalized");
            mutableLiveData=new MutableLiveData<>();
            createNumber();
        }
        return mutableLiveData;
    }

    public void createNumber(){
        Log.d("###","Number generated");
        Random random=new Random();
        DataModel data=new DataModel();
        data.setRandomNumber(""+random.nextInt(10-1)+1);

        mutableLiveData.setValue(data);
    }
}
