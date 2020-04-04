package com.jjh.servicedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private TextView message;
    private Intent sampleServiceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message = findViewById(R.id.message);
        Button btnStartService = findViewById(R.id.startService);
        btnStartService.setOnClickListener(new StartButtonHandler());
        Button btnStopService = findViewById(R.id.stopService);
        btnStopService.setOnClickListener(new StopButtonHandler());
        Log.d("<<ServiceDemo1Activity>>", "Ready!");
    }

    class StartButtonHandler implements View.OnClickListener {
        public void onClick(View v) {
            try {
                Log.d("<<ServiceDemo1Activity>>", "Starting service!");
                sampleServiceIntent = new Intent(MainActivity.this, SampleService.class);
                startService(sampleServiceIntent);
                message.setText("Started Service");
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), 1).show();
            }
        }
    }

    class StopButtonHandler implements View.OnClickListener {
        public void onClick(View v) {
            try {
                Log.d("<<ServiceDemo1Activity>>", "Stopping service!");
                stopService(sampleServiceIntent);
                message.setText("Stopped Service");
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), 1).show();
            }
        }
    }
}
