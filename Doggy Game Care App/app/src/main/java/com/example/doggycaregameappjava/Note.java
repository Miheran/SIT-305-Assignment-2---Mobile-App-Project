package com.example.doggycaregameappjava;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class Note extends Application {
    public static final String RUN_NOTE_ID = "RunNote";
    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannels();
    }

    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel runNote = new NotificationChannel(
                    RUN_NOTE_ID,
                    "Running Notifiction",
                    NotificationManager.IMPORTANCE_LOW
            );
            runNote.setDescription("Running Notifiction Channel");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(runNote);
        }
    }
}
