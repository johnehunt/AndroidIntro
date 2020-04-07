package com.jjh.countertestapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Instance variable to hold reference to counter
    // and text view (label) used to display the count
    private Counter counter = new Counter();
    private TextView text;
    private TextView message;

    // Inner classes to handle user button clicks
    class AddButtonHandler implements View.OnClickListener {
        public void onClick(View view) {
            counter.increment();
            text.setText(counter.getCount() +"");
        }
    }

    class SubtractButtonHandler implements View.OnClickListener {
        public void onClick(View view) {
            counter.decrement();
            text.setText(counter.getCount() +"");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtain reference to text view label
        text = findViewById(R.id.textView);

        // Set up buttons with handlers
        Button addButton = findViewById(R.id.add);
        addButton.setOnClickListener(new AddButtonHandler());

        Button subButton = findViewById(R.id.sub);
        subButton.setOnClickListener(new SubtractButtonHandler());
    }

}

