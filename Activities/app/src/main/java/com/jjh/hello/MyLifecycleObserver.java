package com.jjh.hello;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MyLifecycleObserver implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void logOnCreate() {
        Log.d("MyLifecycleObserver","logOnCreate");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void logOnStart() {
        Log.d("MyLifecycleObserver", "logOnStart");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void logOnResume() {
        Log.d("MyLifecycleObserver", "logOnResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void logOnPause() {
        Log.d("MyLifecycleObserver", "logOnPause");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void logOnStop() {
        Log.d("MyLifecycleObserver", "logOnStop");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void logOnDestroy() {
        Log.d("MyLifecycleObserver", "logOnDestroy");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void logOnAny() {
        Log.d("MyLifecycleObserver", "logOnAny");
    }

}
