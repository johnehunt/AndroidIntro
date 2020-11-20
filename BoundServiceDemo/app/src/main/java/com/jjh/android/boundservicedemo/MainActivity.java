package com.jjh.android.boundservicedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.Context;
import android.content.ComponentName;
import android.os.IBinder;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private BoundService service;
    private TextView message;
    /** Defines callbacks for service binding, passed to bindService() */
    private ServiceConnection connection = new ServiceConnectionHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
        setContentView(R.layout.activity_main);
        message = findViewById(R.id.message);
    }

    public void unbindServiceButtonClick(View v) {
        Log.d("Unbind Service button", "onClick()");
        if (service != null) {
            // Disconnect from service - if only one 'may' stop
            unbindService(connection);
            service = null;
        }
    }

    public void onPrintDataButtonClick(View v) {
        Log.d(TAG, "onClick()");
        if (service != null) {
            message.setText(service.getDate().toString());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
        // Create intent to bind to service
        Intent intent = new Intent(this, BoundService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
        if (service != null) {
            // Unbind from service is still using it
            unbindService(connection);
        }
    }

    // Inner classes

    private class ServiceConnectionHandler implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder binder) {
            Log.d(TAG, "onServiceConnected()");
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            BoundService.DemoBinder demoBinder = (BoundService.DemoBinder) binder;
            service = demoBinder.getService();
            Log.d("ServiceConnection", "service bound");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    }

}
