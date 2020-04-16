package com.jjh.mediaplayerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button pause, play;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup buttons
        pause = findViewById(R.id.pause);
        play = findViewById(R.id.play);

        // Setup Handlers
        pause.setOnClickListener(new PauseHandler());
        play.setOnClickListener(new PlayHandler());

        // Determine which buttons are enabled at start
        pause.setEnabled(false);

        // Setup Media Player - note must manually add raw folder
        // under the res folder on your project
        // place song.mp3 file in here
        mediaPlayer = MediaPlayer.create(this, R.raw.song);
    }

    class PlayHandler implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "Playing sound", Toast.LENGTH_SHORT).show();
            mediaPlayer.start();

            // Enable / Disable appropriate buttons
            pause.setEnabled(true);
            play.setEnabled(false);
        }
    }

    class PauseHandler implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "Pausing sound", Toast.LENGTH_SHORT).show();
            mediaPlayer.pause();

            // Enable / Disable buttons
            pause.setEnabled(false);
            play.setEnabled(true);
        }

    }

}
