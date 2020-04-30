package com.jjh.android.boundservicedemo;

import android.app.Service;
import android.os.Binder;
import android.os.IBinder;
import android.content.Intent;
import android.util.Log;

import java.util.Date;

public class BoundService extends Service {

    private static final String TAG = "BoundService";

    // Binding support
    private IBinder binder = new DemoBinder();

    public class DemoBinder extends Binder {
        BoundService getService() {
            return BoundService.this;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind()");
        return binder;
    }
    @Override
    public void onRebind(Intent intent) {
        Log.d(TAG, "onRebind()");
        super.onRebind(intent);
    }
    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind()");
        return true;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }

    // Functionality offered by service
    public Date getDate() {
        Log.d(TAG, "getDate()");
        return new Date();
    }

}
