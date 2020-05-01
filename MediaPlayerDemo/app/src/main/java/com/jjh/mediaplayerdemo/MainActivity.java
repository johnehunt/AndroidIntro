package com.jjh.mediaplayerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button pause, play, stop;
    MediaPlayer mediaPlayer;

    // Lifecycle Methods

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup button references
        pause = findViewById(R.id.pause);
        play = findViewById(R.id.play);
        stop = findViewById(R.id.stop);

        // Determine which buttons are enabled at start
        pause.setEnabled(false);
        stop.setEnabled(false);

        // Setup Media Player - note must manually add raw folder
        // under the res folder in your project
        // place song.mp3 file in here
        mediaPlayer = MediaPlayer.create(this, R.raw.song);

        // Set up callback listeners
        mediaPlayer.setOnErrorListener(new CustomMediaPlayerOnErrorListener());
        mediaPlayer.setOnInfoListener(new CustomMediaPlayerInfoListener());
        mediaPlayer.setOnPreparedListener(new CustomerMediaPlayerOnPreparedListener());
        mediaPlayer.setOnCompletionListener(new CustomerMediaPlayerOnCompletionListener());
    }

    @Override
    protected void onDestroy() {
        try {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        } catch (Exception exp) {
            Toast.makeText(getApplicationContext(),
                    "Problem starting source " + exp.getMessage(),
                    Toast.LENGTH_LONG).show();
        }
        super.onDestroy();
    }

    // Button Handler methods

    public void onPlayButtonClick(View v) {
        Toast.makeText(getApplicationContext(), "Playing sound", Toast.LENGTH_SHORT).show();
        try {
            // Can throw IllegalStateException if it is called in an invalid state
            mediaPlayer.start();
        } catch (IllegalStateException exp) {
            Toast.makeText(getApplicationContext(),
                    "Problem starting source " + exp.getMessage(),
                    Toast.LENGTH_LONG).show();
        }

        // Enable / Disable appropriate buttons
        pause.setEnabled(true);
        play.setEnabled(false);
        stop.setEnabled(true);
    }

    public void onPauseButtonClick(View v) {
        Toast.makeText(getApplicationContext(), "Pausing sound", Toast.LENGTH_SHORT).show();
        mediaPlayer.pause();

        // Enable / Disable buttons
        pause.setEnabled(false);
        play.setEnabled(true);
        stop.setEnabled(false);
    }

    public void onStopButtonClick(View v) {
        Toast.makeText(getApplicationContext(), "Stopping sound", Toast.LENGTH_SHORT).show();
        try {
            mediaPlayer.stop();
            // Need to prepare mediaPlayer
            // so that it can play another tune
            mediaPlayer.prepare();
        } catch (Exception exp) {
            Toast.makeText(getApplicationContext(),
                    "Problem playing source " + exp.getMessage(),
                    Toast.LENGTH_LONG).show();
        }

        // Enable / Disable buttons
        pause.setEnabled(false);
        play.setEnabled(true);
        stop.setEnabled(false);
    }

    // Media Player callback listeners

    /**
     * Interface definition of a callback to be invoked when there has been an
     * error during an asynchronous operation
     */
    class CustomMediaPlayerOnErrorListener implements MediaPlayer.OnErrorListener {

        /**
         * what - the type of error that has occurred:
         * extra, error code specific to the error. Typically implementation dependent.
         * return - True if the method handled the error, false if it didn't.
         */
        public boolean onError(MediaPlayer mp, int what, int extra) {
            Log.e("CustomMediaPlayerOnErrorListener", "what:" + what + ", extra:" + extra);
            return true;
        }
    }

    class CustomMediaPlayerInfoListener implements MediaPlayer.OnInfoListener {

        @Override
        public boolean onInfo(MediaPlayer mp, int what, int extra) {
            Log.e("CustomMediaPlayerInfoListener", "what:" + what + ", extra:" + extra);
            return true;
        }
    }

    /**
     * Run when the mediaplayer is 'prepared' - can be used with prepareAsync() to get notification
     * of when Mediaplayer is ready to start playing, e.g.
     *
     * mediaPlayer.prepareAsync();
     *
     * then in onPrepared call mp.start();
     */
    class CustomerMediaPlayerOnPreparedListener implements MediaPlayer.OnPreparedListener {

        @Override
        public void onPrepared(MediaPlayer mp) {
            Log.e("CustomerMediaPlayerOnPreparedListener", mp.toString());
        }
    }

    class CustomerMediaPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mp) {
            Log.e("CustomerMediaPlayerOnCompletionListener", mp.toString());
            play.setEnabled(true);
            pause.setEnabled(false);
            stop.setEnabled(false);
        }
    }

}
