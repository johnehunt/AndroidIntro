package com.jjh.servicedemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Intent sampleServiceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        Button btnStartService = findViewById(R.id.startService);
        btnStartService.setOnClickListener(new StartButtonHandler());
        Button btnStopService = findViewById(R.id.stopService);
        btnStopService.setOnClickListener(new StopButtonHandler());

        // Set up broadcast receiver - programmatically
        // Required as of Android 8.0 (and above) since this version
        // most implicit broadcasts need to be registered to dynamically
        // and not statically (in the manifest).
        IntentFilter filter = new IntentFilter("com.jjh.servicedemo.Message");
        SampleBroadcastReceiver receiver = new SampleBroadcastReceiver();
        registerReceiver(receiver, filter, null, null );

        Log.d("SD - MainActivity", "onCreate()");
    }

    class StartButtonHandler implements View.OnClickListener {
        public void onClick(View v) {
            try {
                Log.d("SD - MainActivity", "Starting service!");
                sampleServiceIntent = new Intent(MainActivity.this, SampleService2.class);
                startService(sampleServiceIntent);
                textView.setText("Started Service");
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    class StopButtonHandler implements View.OnClickListener {
        public void onClick(View v) {
            try {
                Log.d("SD - MainActivity", "Stopping service!");
                stopService(sampleServiceIntent);
                textView.setText("Stopped Service");
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
