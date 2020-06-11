package com.example.doggycaregameappjava;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class RunningService extends Service {


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        long time = intent.getLongExtra("RunTime", 0);

        Intent noteIntent = new Intent(this, MainActivity.class);
        PendingIntent penIntent = PendingIntent.getActivity(this, 0, noteIntent,0);

        Notification noti = new NotificationCompat.Builder(this, Note.RUN_NOTE_ID)
                .setContentTitle("Finished Run")
                .setSmallIcon(R.drawable.box)
                .setContentIntent(penIntent)
                .build();

        startForeground(1, noti);
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
