package com.sykent.uidemo.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.sykent.uidemo.R;

public class TestService2 extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("TestService2", "onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("TestService2", "onStartCommand()");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            setForegroundService();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void setForegroundService() {
        String channelId = "666666";
        NotificationChannel notificationChannel = new NotificationChannel(channelId, "简拼", NotificationManager.IMPORTANCE_DEFAULT);
        Notification notification = new NotificationCompat.Builder(this.getApplicationContext(), channelId)
                .setContentText("简拼 正在后台运行")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setAutoCancel(true)
                .setWhen(System.currentTimeMillis())
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }

        startForeground(99999, notification);

//        new Handler(Looper.getMainLooper()).postDelayed(TestService2.this::stopSelf,2000);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("TestService2", "onBind()");
        return null;
    }


    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("TestService2", "onUnbind()");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.d("TestService2", "onDestroy()");
        super.onDestroy();
    }
}