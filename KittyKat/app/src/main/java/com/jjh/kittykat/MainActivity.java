package com.jjh.kittykat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GestureHandler handler = new GestureHandler();

        final GestureDetectorCompat detector = new GestureDetectorCompat(this, handler);
        detector.setOnDoubleTapListener(handler);

        ImageButton image = findViewById(R.id.image);
        image.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent me) {
                return detector.onTouchEvent(me);
            }
        });

        /**
         * Uncomment to try out pinch gesture
         */
//        final ScaleGestureDetector mScaleDetector =
//                new ScaleGestureDetector(this, new MyPinchListener());
//        image.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                mScaleDetector.onTouchEvent(event);
//                return true;
//            }
//        });
    }

    /**
     * SimpleOneGestureListener is a convenience class used to provide default
     * implementations for all methods in the OnGestureListener interface
     * and the onDoubleTapListener interface:
     *
     * OnGestureListener used to notify when gestures occur.
     * OnDoubleTapListener is used to notify when a double-tap occurs.
     *
     */
    class GestureHandler extends GestureDetector.SimpleOnGestureListener {

        /**
         * Notified of a fling event when it occurs with the initial on down
         * MotionEvent and the matching up MotionEvent. true indicates that
         * the app has consumed the event - don't need to pass it on.
         */
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {
            Toast.makeText(MainActivity.this, "Purrr", Toast.LENGTH_SHORT)
                    .show();
            return true;
        }

        /**
         * Invoked when a double-tap gesture occur.
         */
        public boolean onDoubleTap(MotionEvent e) {
            Toast.makeText(MainActivity.this, "Ouch!", Toast.LENGTH_SHORT)
                    .show();
            return true;
        }

    }

    /**
     * Example of Pinch gesture detection
     */
    class MyPinchListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            Toast.makeText(MainActivity.this, "PINCH! OUCH!", Toast.LENGTH_SHORT)
                    .show();
            return true;
        }
    }

}