package com.jjh.android.notificationdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String CHANNEL_ID = "com.jjh.android.notificationdemo";

    private NotificationManager notificationManager;

    public void onButtonClick(View v) {

        Log.d(TAG, "onButtonClick()");

        int notificationID = 101;

        Log.d(TAG, "onButtonClick() - setting up notification");
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("A Title")
                .setContentText("This is an example : Hello There!")
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setChannelId(CHANNEL_ID)
                .setNumber(10)
                .build();

        Log.d(TAG, "onButtonClick() - triggering notification");
        notificationManager.notify(notificationID, notification);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
        setContentView(R.layout.activity_main);

        createNotificationChannel();
    }

    private void createNotificationChannel() {
        Log.d(TAG, "createNotificationChannel()");

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Log.d(TAG, "createNotificationChannel() - setting up channel");

            String name = "Notify Demo Info";
            String description = "EXAMPLE NOTIFICATION CHANNEL";

            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            channel.enableVibration(true);
            channel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 40, 300, 200, 400});
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            notificationManager.createNotificationChannel(channel);
        }
    }
}
