package com.jjh.android.boundservicedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.Context;
import android.content.ComponentName;
import android.os.IBinder;

public class MainActivity extends AppCompatActivity {

    private BoundService service;
    private TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity", "onCreate()");
        setContentView(R.layout.activity_main);
        message = findViewById(R.id.message);

        Button printButton = findViewById(R.id.printButton);
        Button stopServiceButon = findViewById(R.id.stopButton);
        printButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Print Date button", "onClick()");
                if (service != null) {
                    message.setText(service.getDate().toString());
                }
            }
        });
        stopServiceButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Stop Service button", "onClick()");
                if (service != null) {
                    unbindService(connection);
                    service = null;
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart()");
        Intent intent = new Intent(this, BoundService.class);
        startService(intent);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop()");
        if (service != null) {
            unbindService(connection);
        }
    }

    /** Defines callbacks for service binding, passed to bindService() */
    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder binder) {
            Log.d("ServiceConnection", "onServiceConnected()");
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            BoundService.DemoBinder demoBinder = (BoundService.DemoBinder) binder;
            service = demoBinder.getService();
            Log.d("ServiceConnection", "service bound");
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
        }
    };

}
