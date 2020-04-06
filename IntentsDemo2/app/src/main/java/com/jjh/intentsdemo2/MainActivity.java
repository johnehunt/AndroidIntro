package com.jjh.intentsdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView label;
    private EditText text;
    private Button pickContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        label = findViewById(R.id.label);
        text = findViewById(R.id.editText);
        pickContact = findViewById(R.id.pickContact);
        pickContact.setOnClickListener(new ClickHandler());
    }

    private class ClickHandler implements View.OnClickListener {
        public void onClick(View v) {
            // Tell it that its requestCode (nickname) is 222
            String myData = text.getText().toString();
            Intent intent = new Intent(Intent.ACTION_PICK, Uri.parse(myData));
            startActivityForResult(intent, 222);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // use requestCode to find out who is talking to us
        switch (requestCode) {
            case (222): {
                // 222 is our friendly contact-picker activity
                if (resultCode == Activity.RESULT_OK) {
                    String selectedContact = data.getDataString();
                    // it will return an URI that looks like:
                    // content://contacts/people/n where n is the selected contacts' ID
                    label.setText(selectedContact.toString());
                } else {
                    // user pressed the BACK button
                    label.setText("Selection CANCELLED " + requestCode + " " + resultCode);
                }
                break;
            }
        }
    }

}
