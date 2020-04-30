package com.jjh.android.intentservicedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Lifecycle methods

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Button handler methods

    public void onClickStartService(View v) {
        // Create intent to launch service
        Intent intent = new Intent(this, LoggerIntentService.class);
        startService(intent);
    }

}
