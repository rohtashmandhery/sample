package com.rohtash.lifecycle.life_cycle;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MainActivityObserver implements LifecycleObserver {

    String TAG = MainActivityObserver.class.getName();


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreateEvent() {
        Log.d("###", "Observer On Create Event");
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStartEvent() {
        Log.d("###", "Observer On Start Event");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResumeEvent() {
        Log.d("###", "Observer On Resume Event");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPauseEvent() {
        Log.d("###", "Observer On Pause Event");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStopEvent() {
        Log.d("###","Observer On Stop Event");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroyEvent(){
        Log.d("###","Observer On Destroy Event");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void onAny(){
        Log.d("###","Observer On Any Event");
    }

}
