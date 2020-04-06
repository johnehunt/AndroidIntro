package com.jjh.intentdemo3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private TextView resultTextView;

    private final int REQUEST_CODE = 111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        resultTextView = findViewById(R.id.resultTextView);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new ButtonHandler());
    }

    protected void onActivityResult(int returnedRequestCode, int resultCode, Intent data) {
        super.onActivityResult(returnedRequestCode, resultCode, data);
        try {
            // check that these results are for me
            if (REQUEST_CODE == returnedRequestCode) {
                // SubActivity is over - see what happened
                if (resultCode == Activity.RESULT_OK) {
                    Bundle bundle = data.getExtras();
                    String result = bundle.getString("result");
                    resultTextView.setText(result);
                } else {
                    // user pressed the BACK button
                    textView.setText("Selection CANCELLED!");
                }
            }
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private class ButtonHandler implements OnClickListener {
        public void onClick(View v) {
            try {
                // create an Intent to talk to Sub-Activity
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                // Bundle allows multiple data items to be sent simply
                Bundle bundle = new Bundle();
                bundle.putString("msg", textView.getText().toString());
                // bind the Bundle and the Intent that talks to Activity2
                intent.putExtras(bundle);
                // call Activity2 and wait for results
                startActivityForResult(intent, REQUEST_CODE);
            } catch (Exception e) {
                Toast.makeText(getBaseContext(), e.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        }
    }
}
