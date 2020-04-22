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

    private EditText diallerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize dialier text field field
        diallerText = findViewById(R.id.editText);

        // Set up the search button
        Button searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new SearchButtonHandler());
    }

    // Handler method for DIal Button
    public void onDialButtonClick(View v) {
        String myData = diallerText.getText().toString();
        // Creates an Intent to trigger dialler
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(myData));
        startActivity(intent);
    }

    // Inner class iused to handle search button
    class SearchButtonHandler implements View.OnClickListener {
        public void onClick(View v) {
            // triggers web search activity
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, "MG F Car");
            startActivity(intent);
        }
    }

}
