package com.jjh.android.intentservicedemo;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Date;

public class LoggerIntentService extends IntentService {

    public LoggerIntentService() {
        super(LoggerIntentService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date d = new Date();
        Log.d("LoggerIntentService", "onHandleIntent() - " + d.toString());
    }

}
