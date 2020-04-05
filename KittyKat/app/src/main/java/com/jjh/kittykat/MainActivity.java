package com.jjh.kittykat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


/**
 * Activities are things that can interact with a user. Typically
 * responsible for
 * creating a window in which you can place your UI components.
 */
public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private TextView text;

    /**
     * Used to set up (initialize) the display after the App is
     * created.
     */

    /**
     * Invoked when the user clicks on the button.
     */
    class AddButtonHandler implements OnClickListener {
        public void onClick(View view) {
            count++;
            text.setText(count +"");
        }
    }

    class SubtractButtonHandler implements OnClickListener {
        public void onClick(View view) {
            count--;
            text.setText(count +"");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.textView);

        Button button = (Button) findViewById(R.id.add);
        button.setOnClickListener(new AddButtonHandler());

        button = (Button) findViewById(R.id.sub);
        button.setOnClickListener(new SubtractButtonHandler());

    }

}