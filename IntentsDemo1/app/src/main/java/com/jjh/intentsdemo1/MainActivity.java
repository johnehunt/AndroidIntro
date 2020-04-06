package com.jjh.intentsdemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = findViewById(R.id.editText);

        // Set up the buttons
        Button dialButton = findViewById(R.id.dialButton);
        dialButton.setOnClickListener(new DialButtonHandler());
        Button searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new SearchButtonHandler());
    }

    private class DialButtonHandler implements View.OnClickListener {
        public void onClick(View v) {
            String myData = text1.getText().toString();
            // Creates an Intent to trigger dialler
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(myData));
            startActivity(intent);
        }
    }

    private class SearchButtonHandler implements View.OnClickListener {
        public void onClick(View v) {
            // triggers web search activity
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, "MG F Car");
            startActivity(intent);
        }
    }

}
