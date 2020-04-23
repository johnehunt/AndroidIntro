package com.jjh.android.dynamicfragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";

    public void onFragmentOneButtonClick(View v) {
        Log.d(TAG, "onClick()");
        FragmentOne fragment = new FragmentOne();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.displaylayout, fragment);
        transaction.commit();
    }

    public void onFragmentTwoButtonClick(View v) {
        Log.d(TAG, "onClick()");
        FragmentTwo fragment = new FragmentTwo();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.displaylayout, fragment);
        transaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
        setContentView(R.layout.activity_main);
    }
}
