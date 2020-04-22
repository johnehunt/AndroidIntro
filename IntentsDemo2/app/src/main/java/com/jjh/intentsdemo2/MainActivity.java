package com.jjh.intentsdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final static int REQUEST_CODE = 222;

    private TextView label;
    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        label = findViewById(R.id.label);
        text = findViewById(R.id.editText);
    }

    public void onPickContactClick(View v) {
        // Tell it that its requestCode (nickname) is 222
        String myData = text.getText().toString();
        Intent intent = new Intent(Intent.ACTION_PICK, Uri.parse(myData));
        startActivityForResult(intent, REQUEST_CODE);
    }

    protected void onActivityResult(int returnedRequestCode, int resultCode, Intent data) {
        super.onActivityResult(returnedRequestCode, resultCode, data);
        // use requestCode to find out who is talking to us
        if (returnedRequestCode == REQUEST_CODE) {
            // 222 is our friendly contact-picker activity
            if (resultCode == Activity.RESULT_OK) {
                String selectedContact = data.getDataString();
                // it will return an URI that looks like:
                // content://contacts/people/n where n is the selected contacts' ID
                label.setText(selectedContact);
            } else {
                // user pressed the BACK button
                label.setText("Selection CANCELLED " + returnedRequestCode + ", " + resultCode);
            }
        }
    }
}

