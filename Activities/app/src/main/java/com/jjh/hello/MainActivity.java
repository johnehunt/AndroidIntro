package com.jjh.hello;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLifecycle().addObserver(new MyLifecycleObserver());
        Log.d("MainActivity Lifecycle","onCreate()");
        if (savedInstanceState != null) {
            String msg = savedInstanceState.getString("msg");
            Log.d("MainActivity Lifecycle", "onCreate() - " + msg);
        }
    }

    // Restoring / Saving Dynamic State
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("MainActivity Lifecycle","onRestoreInstanceState()");
        String msg = savedInstanceState.getString("msg");
        Log.d("MainActivity Lifecycle","onRestoreInstanceState() - " + msg);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("msg", "Hello Message " + new Date());
        Log.d("MainActivity Lifecycle","onSaveInstanceState()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity Lifecycle","onStart()");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity Lifecycle","onResume()");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity Lifecycle","onPause()");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity Lifecycle","onStop()");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity Lifecycle","onRestart()");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity Lifecycle","onDestroy()");
    }
}
