package com.jjh.android.dynamicfragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";

    class FragmentOneButtonHandler implements View.OnClickListener {

        private static final String FRAG_TAG = "Fragment1ButtonHandler";

        @Override
        public void onClick(View v) {
            Log.d(FRAG_TAG , "onClick()");
            FragmentOne fragment = new FragmentOne();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.displaylayout, fragment);
            transaction.commit();
        }
    }

    class FragmentTwoButtonHandler implements View.OnClickListener {

        private static final String FRAG_TAG = "Fragment2ButtonHandler";

        @Override
        public void onClick(View v) {
            Log.d(FRAG_TAG , "onClick()");
            FragmentTwo fragment = new FragmentTwo();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.displaylayout, fragment);
            transaction.commit();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate()");
        setContentView(R.layout.activity_main);

        Button showFragmentOneButton = findViewById(R.id.button1);
        showFragmentOneButton.setOnClickListener(new FragmentOneButtonHandler());

        Button showFragmentTwoButton = findViewById(R.id.button2);
        showFragmentTwoButton.setOnClickListener(new FragmentTwoButtonHandler());

    }
}
