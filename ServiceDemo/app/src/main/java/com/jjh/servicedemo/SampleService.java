package com.jjh.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class SampleService extends Service {

    public IBinder onBind(Intent intent) {
        Log.d("SampleService", "onBind()");
        return null;
    }

    public void onCreate() {
        super.onCreate();
        Log.d("SampleService", "onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("SampleService", "onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("SampleService", "onUnbind()");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d("SampleService", "onRebind()");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d("SampleService", "onDestroy()");
    }
}
