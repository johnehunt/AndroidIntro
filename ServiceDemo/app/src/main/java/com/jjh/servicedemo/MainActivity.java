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
        Log.d("<<ServiceDemo1Activity>>", "Ready!");
    }

        public void onStartButtonClick(View v) {
            try {
                Log.d("<<ServiceDemo1Activity>>", "Starting service!");
                sampleServiceIntent = new Intent(this, SampleService.class);
                startService(sampleServiceIntent);
                message.setText("Started Service");
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }


        public void onStopButtonClick(View v) {
            try {
                Log.d("<<ServiceDemo1Activity>>", "Stopping service!");
                stopService(sampleServiceIntent);
                message.setText("Stopped Service");
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), 1).show();
            }
        }

}
