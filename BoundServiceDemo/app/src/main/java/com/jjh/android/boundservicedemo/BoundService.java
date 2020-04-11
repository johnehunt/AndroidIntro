package com.jjh.android.boundservicedemo;

import android.app.Service;
import android.os.Binder;
import android.os.IBinder;
import android.content.Intent;
import android.util.Log;

import java.util.Date;

public class BoundService extends Service {

    // Binding support
    private IBinder binder = new DemoBinder();

    public class DemoBinder extends Binder {
        BoundService getService() {
            return BoundService.this;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("BoundService", "onBind()");
        return binder;
    }
    @Override
    public void onRebind(Intent intent) {
        Log.d("BoundService", "onRebind()");
        super.onRebind(intent);
    }
    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("BoundService", "onUnbind()");
        return true;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("BoundService", "onCreate()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("BoundService", "onDestroy()");
    }

    // Functionality offered by service
    public Date getDate() {
        Log.d("BoundService", "getDate()");
        return new Date();
    }

}
