package com.jjh.intentdemo3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
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
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new ClickButtonHandler());

        // Retrieve data sent by parent
        Bundle myBundle = getIntent().getExtras();
        // Extract the individual data parts of the bundle
        data = myBundle.getString("msg");
    }

    private class ClickButtonHandler implements OnClickListener {
        public void onClick(View v) {
            finish();
        }
    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("result", data + " " + text.getText());
        setResult(Activity.RESULT_OK, intent);
        super.finish();
    }
}
