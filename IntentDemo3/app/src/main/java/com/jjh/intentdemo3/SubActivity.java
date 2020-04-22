package com.jjh.intentdemo3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    private EditText text;

    // Hold data sent by parent
    private String data;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_activity);

        // bind UI variables to Java code
        text = findViewById(R.id.editText);

        // Retrieve data sent by parent
        Bundle myBundle = getIntent().getExtras();
        // Extract the individual data parts of the bundle
        data = myBundle.getString("msg");
    }

    public void onCLickSendResponse(View v) {
            finish();
        }

    @Override
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("result", data + " " + text.getText());
        setResult(Activity.RESULT_OK, intent);
        super.finish();
    }
}
