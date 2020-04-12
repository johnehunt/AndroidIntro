package com.jjh.android.dynamicfragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    class FragmentOneButtonHandler implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            FragmentOne fragment = new FragmentOne();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.displaylayout, fragment);
            transaction.commit();
        }
    }

    class FragmentTwoButtonHandler implements View.OnClickListener {

        @Override
        public void onClick(View v) {
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
        setContentView(R.layout.activity_main);

        Button showFragmentOneButton = findViewById(R.id.button1);
        showFragmentOneButton.setOnClickListener(new FragmentOneButtonHandler());

        Button showFragmentTwoButton = findViewById(R.id.button2);
        showFragmentTwoButton.setOnClickListener(new FragmentTwoButtonHandler());

    }
}
