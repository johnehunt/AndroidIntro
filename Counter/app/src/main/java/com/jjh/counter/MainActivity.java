package com.jjh.counter;

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
    private int count = 0;
    private TextView text;
    private TextView message;

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

    class ToastButtonHandler implements View.OnClickListener {
        public void onClick(View view) {
            Toast toast = Toast.makeText(
                    MainActivity.this,
                    "Clicked " + count,
                    Toast.LENGTH_LONG
            );
            toast.setGravity(Gravity.CENTER,
                    toast.getXOffset() / 2,
                    toast.getYOffset() / 2);
            toast.show();
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

        Button showButton = findViewById(R.id.show);
        showButton.setOnClickListener(new ToastButtonHandler());

        setupDialogButton();
    }

    private void setupDialogButton() {
        message = findViewById(R.id.message);
        Button button = findViewById(R.id.dialogButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Exit");
                builder.setMessage("Do you wish to Exit?");
                // set three option buttons
                builder.setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                String msg = "YES " + Integer.toString(whichButton);
                                message.setText(msg);
                            }
                        });
                builder.setNeutralButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                String msg = "CANCEL " + Integer.toString(whichButton);
                                message.setText(msg);
                            }
                        });
                builder.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                String msg = "NO " + Integer.toString(whichButton);
                                message.setText(msg);
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
