package com.rohtash.lifecycle.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.Random;

public class DataModel extends ViewModel {
   private String randomNumber;


   public String getNumber(){
       if(randomNumber==null){
           createNumber();
       }
       return randomNumber;
   }

   public void createNumber(){
       Random random=new Random();
       randomNumber=""+random.nextInt(10-1)+1;
   }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("###","View Model Cleared");
    }
}
