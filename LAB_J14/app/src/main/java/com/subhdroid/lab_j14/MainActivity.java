package com.subhdroid.lab_j14;

//14. Write an application to produce Notification

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "Notification Channel";
    private static final int REQ_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(view -> {
            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            NotificationCompat.Builder nb = new NotificationCompat.Builder(this, CHANNEL_ID);

            Intent intent = new Intent(MainActivity.this, NewActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, REQ_CODE, intent,
                    PendingIntent.FLAG_UPDATE_CURRENT);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                nb.setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentTitle("New Message Title")
                        .setContentText("Context text")
                        .setSubText("Subtext")
                        .setContentIntent(pendingIntent)
                        .setChannelId(CHANNEL_ID)
                        .build();

                nm.createNotificationChannel((new NotificationChannel(CHANNEL_ID, "Channel One",
                        NotificationManager.IMPORTANCE_HIGH)));

            } else {
                nb.setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentTitle("New Message Title")
                        .setContentText("Context text")
                        .setSubText("Subtext")
                        .setContentIntent(pendingIntent)
                        .setChannelId(CHANNEL_ID)
                        .build();
            }

            nm.notify(1, nb.build());
        });
    }
}