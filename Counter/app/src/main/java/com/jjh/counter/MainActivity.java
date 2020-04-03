package com.jjh.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Instance variable to hold reference to counter
    // and text view (label) used to display the count
    private int count = 0;
    private TextView text;

    // Inner classes to handle user button clicks
    class AddButtonHandler implements View.OnClickListener {
        public void onClick(View view) {
            count++;
            text.setText(count +"");
        }
    }

    class SubtractButtonHandler implements View.OnClickListener {
        public void onClick(View view) {
            count--;
            text.setText(count +"");
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtain reference to textview label
        text = (TextView) findViewById(R.id.textView);

        // Set up buttons with handlers
        Button addButton = (Button) findViewById(R.id.add);
        addButton.setOnClickListener(new AddButtonHandler());

        Button subButton = (Button) findViewById(R.id.sub);
        subButton.setOnClickListener(new SubtractButtonHandler());
    }
}
